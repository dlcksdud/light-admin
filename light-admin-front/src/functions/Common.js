import { loginActions } from "../reducers/LoginReducer";
import store from "../redux/store";
import { AdminDataActions } from "../reducers/AdminDataReducer";
import { userActions } from "../reducers/UserReducer";
import { loadingActions } from "../reducers/LoadingReducer";


export function logout() {
    store.dispatch(loginActions.setLogout());
    store.dispatch(AdminDataActions.setClear());
    store.dispatch(userActions.setClear());

    localStorage.clear();
    localStorage.removeItem("token");
    localStorage.removeItem("refreshtoken");
    localStorage.removeItem("persist:root");
}

// 로딩 on
export function setLoadingDisplay() {
    store.dispatch(loadingActions.setLoadingDisplay());
}
// 로딩 off
export function setLoadingNoneDisplay() {
    store.dispatch(loadingActions.setLoadingNoneDisplay());
}