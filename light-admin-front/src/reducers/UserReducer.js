import {createSlice} from '@reduxjs/toolkit';

const initialState = {
    // id: '',
    // name: '',
    jwttoken: '',
    refreshtoken: '',
    role:'',
    userInfo: {},
    sidebarMenu:[],
};
const userReducer = createSlice({
    name: 'user',
    initialState,
    reducers: {
        // setUser(state) {
        //     return { id : state.id, name : state.name };
        // },
        setJwtToken(state, _) {
            state.jwttoken = _.payload;
        },
        setRefreshToken(state, _) {
            state.refreshtoken = _.payload;
        },
        setUserInfo(state, _) {
            state.userInfo = _.payload;
        },
        setRole(state, _) {
            state.role = _.payload;
        },
        setSidebarMenu(state, _) {
            state.sidebarMenu = _.payload;
        },
        setClear(state, _) {
            state.jwttoken = '';
            state.refreshtoken = '';
            state.role = '';
            state.userInfo = {};
            state.sidebarMenu = [];
        },
    },
});

// Action creators are generated for each case reducer function
export const userActions = userReducer.actions;

export default userReducer.reducer;