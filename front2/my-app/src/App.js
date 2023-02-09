import './App.css';
import { Routes, Route } from 'react-router-dom'
import SelectMain from "./Page/Select/SelectMain"
import Order from "./Page/Order/OrderMain"
import OrderList from "./Page/Order/OrderList"
import Navi from "./component/Navi"

function App() {
  return (
    <>
    <Navi/>
    <Routes>
      <Route path='/' element={<SelectMain/>} />
      <Route path='/Order' element={<OrderList/>} />
      <Route path='/OrderMain' element={<Order/>} />
    </Routes>      
    </>
  );
}

export default App;
