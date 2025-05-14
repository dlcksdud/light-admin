import {createSlice} from '@reduxjs/toolkit';

const initialState = false;

const loadingReducer = createSlice({
    name: 'isLoading',
    initialState,
    reducers: {
        setLoadingDisplay() {
            return true;
        },
        setLoadingNoneDisplay() {
            return false;
        }
    }
});

export const loadingActions = loadingReducer.actions;

export default loadingReducer.reducer;