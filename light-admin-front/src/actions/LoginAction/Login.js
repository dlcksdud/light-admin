import { SERVER_URL, URI } from "../../common/Common";
import api from './Api';
import {logout, setLoadingNoneDisplay} from "../../functions/Common";
import { refreshtoken } from '../../functions/Auth';

export const login = async (account) => {
    try {
        const response = await api.post(
            SERVER_URL + URI.LOGIN,
            JSON.stringify(account), {
            headers: {
                "Content-Type": `application/json`,
            }}
        )
        if(response.status !== 200) {
            return {status : false, data: response.data.data};
        }
        const token = 'Bearer ' + response.data.data.jwttoken;
        const refresh_token = response.data.data.refreshtoken;

        localStorage.setItem("token", token);
        localStorage.setItem("refreshtoken", refresh_token);
        return {status : true, data: response.data.data};
    } catch(err) {
        return {status : false, err};
    }
}

export const userLogout  = async (adminId) => {
    try {
        const tokenObj = await refreshtoken();
        if(tokenObj.status === 200 || tokenObj.status === 204) {
            // const param = updatedObjectToUriParams(adminId);
            api.defaults.headers.common['Authorization'] = tokenObj.data.token;
            api.defaults.headers.common['refreshtoken'] = tokenObj.data.refreshtoken;
            const response = await api.get(
                SERVER_URL + URI.LOGOUT,
                JSON.stringify(adminId), {
                headers: {
                    "Content-Type": `application/json`,
                    "Authorization": tokenObj.data.token,
                    "refreshtoken": tokenObj.data.refreshtoken,
                }}
            )
            setLoadingNoneDisplay();
            return {status : response.status,
                data: response.data.data,
                isGoLogin: tokenObj.isGoLogin,
                rowTotCount: response.data.rowTotCount,
            }; 
        } else {
            logout();
            setLoadingNoneDisplay();
            return {status : -1, data: [], isGoLogin: tokenObj.isGoLogin}; 
        }
    } catch(err) {
        setLoadingNoneDisplay();
        return {status : err.response.status, data: err.message};
    }
}