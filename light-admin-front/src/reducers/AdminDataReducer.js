import {createSlice} from '@reduxjs/toolkit';

const initialState = {
    data:{}
};
const AdminDataReducer = createSlice({
    name: 'AdminData',
    initialState,
    reducers: {
        setAdminData(state, _) {
            state.data = _.payload;
        },
        setClear(state) {
            state.data = {};
        }
    },
});

// Action creators are generated for each case reducer function
export const AdminDataActions = AdminDataReducer.actions;

export default AdminDataReducer.reducer;