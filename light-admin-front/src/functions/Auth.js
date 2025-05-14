
import {RefreshtokenAction} from '../actions/LoginAction';
import api from '../actions/LoginAction/Api';

export async function refreshtoken() {
    const token = localStorage.getItem("token");
    const refreshtoken = localStorage.getItem("refreshtoken");
    const tokenObj = {token, refreshtoken};
    const res = await RefreshtokenAction(tokenObj);
    let resObj = {};
    if(res.status === 204) { // 토큰만료: X, 리플리쉬토큰 만료: X
        resObj= {
            status: res.status,
            data: {
                token: tokenObj.token,
                refreshtoken: tokenObj.refreshtoken,
            },
            isGoLogin: false,
        };
    } else if(res.status === 200) { // 토큰만료: O, 리플리쉬토큰 만료: X
        localStorage.setItem("token", `Bearer ${res.data.jwttoken}`);
        localStorage.setItem("refreshtoken", res.data.refreshtoken);
        // api.defaults.headers.common['Authorization'] = `Bearer ${res.data.jwttoken}`;
        // api.defaults.headers.common['refreshtoken'] = res.data.refreshtoken;
        resObj= {
            status: res.status,
            data: {
                token: `Bearer ${res.data.jwttoken}`,
                refreshtoken: res.data.refreshtoken,
            },
            isGoLogin: false,
        };
    } else if(res.status === 400) {
        console.log('refreshtoken 400 err');
        resObj= {
            status: res.status,
            isGoLogin: true,
        };
    } else if(res.status === 401) {
        console.log('refreshtoken 401 err');
        resObj= {
            status: res.status,
            isGoLogin: true,
        };
    }

    return resObj;
    // return res;
}