import './App.css';
import { Routes, Route } from 'react-router-dom'
import SelectMain from "./Page/Select/SelectMain"
import Log from "./Page/Log/Log"
import Order from "./Page/Order/OrderMain"
import OrderList from "./Page/Order/OrderList"
import Navi from "./component/Navi"

function App() {

  const express = require('express')
  const cors = require('cors');
   
  const app = express();
   
  app.use(cors({
      origin: 'http://3.35.179.46:8080"', // 모든 출처 허용 옵션 = *, true 를 써도 된다.
  }));
  return (
    <>
    <header>
      <Navi/>
    </header>
    <Routes>
      <Route path='/' element={<SelectMain/>} />
      <Route path='/log' element={<Log/>} />
      <Route path='/Order' element={<OrderList/>} />
      <Route path='/OrderMain' element={<Order/>} />
    </Routes>      
    </>
  );
}

export default App;
