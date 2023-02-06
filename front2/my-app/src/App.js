import './App.css';
import { Routes, Route } from 'react-router-dom'

import SelectDate from "./component/SelectDate"
import Order from "./component/Order"
import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';

function App() {
  return (
    <>
    <Navbar bg="light" variant="light">
        <Container>
          <Navbar.Brand href="#home">Navbar</Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link href="/">order</Nav.Link>
            <Nav.Link href="/Select">Select</Nav.Link>
          </Nav>
        </Container>
      </Navbar>

    <Routes>
      <Route path='/' element={<Order/>} />
      <Route path='/Select' element={<SelectDate/>} />
    </Routes>      
    </>
  );
}

export default App;
