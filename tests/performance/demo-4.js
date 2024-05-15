import http from 'k6/http';
import { check } from 'k6';
import {isEmpty, randomItem} from './libs/utils.js';

//----------------------------------------------------------------------------------------------------------------------

export const options = {
    thresholds: {
        http_req_failed: ['rate<0.01'], // http errors should be less than 1%
        http_req_duration: ['p(95)<200'], // 95% of requests should be below Xms
    },

  scenarios: {
    ramping_arrival_rate_scenario: {
             executor: 'ramping-arrival-rate',
             startRate: 1,
             timeUnit: '1s',
             preAllocatedVUs: 50,
             stages: [
               { target: 5, duration: '20s' },
               { target: 20, duration: '160s' },
               { target: 1, duration: '10s' }
             ]
       },
  }

}

const users = JSON.parse(open('./data/users.json')).users;
const appUrl = __ENV.app;

//----------------------------------------------------------------------------------------------------------------------

export default function (data) {
    let user = randomItem(users);

    const params = {
        headers: {
            'Content-Type': 'application/json',
        }
    }

    const url = appUrl + "/user?user-id=" + user.login;

    const rsp = http.get(url, params);
    check(rsp, {
        'is status 200': (r) => r.status === 200,
    });
}