import './App.css';
import { Routes, Route } from 'react-router-dom'
import SelectDate from "./component/SelectDate"
import Order from "./component/Order"
import OrderList from "./component/OrderList"
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';

function App() {
  return (
    <>
    <Navbar bg="light" variant="light">
        <Container>
          <Navbar.Brand href="#home">Marin.Soft</Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link href="/">Order</Nav.Link>
            <Nav.Link href="/Select">Select</Nav.Link>
          </Nav>
        </Container>
      </Navbar>

    <Routes>
      <Route path='/' element={<Order/>} />
      <Route path='/Order' element={<OrderList/>} />
      <Route path='/Select' element={<SelectDate/>} />
    </Routes>      
    </>
  );
}

export default App;
