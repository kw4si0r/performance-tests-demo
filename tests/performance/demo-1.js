import http from 'k6/http';

export const options = {
    iterations: 5,
};

export default function (data) {
    const params = {
        headers: {
            'Content-Type': 'application/json',
        }
    }
    http.get("http://localhost:8080/user?user-id=user3@pm.me", params);
}