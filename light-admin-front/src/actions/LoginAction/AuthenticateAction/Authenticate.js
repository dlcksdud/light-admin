import api from "../Api";
import { SERVER_URL, URI } from "../../../common/Common"

export const refreshtoken  = async (token) => {
    try {
        const response = await api.get(
            SERVER_URL + URI.REFRESH_TOKEN,
            // JSON.stringify(token),
            {
            headers: {
                "Content-Type": `application/json`,
                "Authorization": token.token,
                "refreshtoken": token.refreshtoken,
            }}
        )
        const data = response.data.data;

        return {status : response.status, data};
    } catch(err) {
        return {status : err.response.status, data: err.message};
    }
}