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
            <Nav.Link href="/">Order</Nav.Link>
            <Nav.Link href="/Select">Select</Nav.Link>
          </Nav>
        </Container>
      </Navbar>

    </>
  );
}
export default Navi