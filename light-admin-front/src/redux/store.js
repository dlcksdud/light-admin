import { configureStore } from '@reduxjs/toolkit';

const store = configureStore({
  reducer: {}  // 일단 reducer 없이도 동작합니다
});

export default store;