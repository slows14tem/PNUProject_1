import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import logo from '../Img/mlogo.png'

//페이지 상당의 네비게이션바 
function Navi(){
  return(
    <>
      <Navbar bg="light" variant="light">
        <Container>
          <Navbar.Brand><img src = {logo}/></Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link href="/">Select</Nav.Link>
            <Nav.Link href="/Log">Log</Nav.Link>
            <Nav.Link href="/OrderMain">Order</Nav.Link>
            <Nav.Link href="/Order">OrderList</Nav.Link>
          </Nav>
        </Container>
      </Navbar>

    </>
  );
}
export default Navi