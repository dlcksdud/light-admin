import { Routes, Route } from 'react-router-dom';
import './App.css';
import FullLayout from './components/LayoutComponent/FullLayout';
import Homepage from './pages/Homepage';

function App() {
  return (
      <Routes>
        <Route path='/' element={<FullLayout/>}>
          <Route index element={<Homepage/>} />
        </Route>
      </Routes>
  );
}

export default App;
