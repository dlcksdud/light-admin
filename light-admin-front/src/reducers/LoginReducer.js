import {createSlice} from '@reduxjs/toolkit';

const initialState = false;

const loginReducer = createSlice({
    name: 'isLogin',
    initialState,
    reducers: {
        setLogin() {
            return true;
        },
        setLogout() {
            return false;
        }
    }
});

// Action creators are generated for each case reducer function
export const loginActions = loginReducer.actions;

export default loginReducer.reducer;