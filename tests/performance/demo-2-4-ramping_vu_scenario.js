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
      ramping_vu_scenario: {
        executor: 'ramping-vus',
        startVUs: 0,
        stages: [
            { duration: '10s', target: 2 },
            { duration: '20s', target: 10 },
            { duration: '10s', target: 1 },
        ],
      }
    },

}
const users = JSON.parse(open('./data/users.json')).users;

//----------------------------------------------------------------------------------------------------------------------

export default function (data) {
    let user = randomItem(users);

    const params = {
        headers: {
            'Content-Type': 'application/json',
        }
    }

    const url = "http://localhost:8080/user?user-id=" + user.login;

    const rsp = http.get(url, params);
    check(rsp, {
        'is status 200': (r) => r.status === 200,
    });
}