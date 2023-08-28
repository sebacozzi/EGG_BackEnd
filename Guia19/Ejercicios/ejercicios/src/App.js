import logo from './logo.svg';
import './App.css';
import Navbar from './components/Navbar';
import Main from './components/Main';
import Footer from './components/Footer';
import Back from './components/Back'
import { Route, BrowserRouter as Router, Routes } from 'react-router-dom';

function App() {
  return (
    <div >
      <Router>
      <Navbar/>
      
      <Routes>
      <Route exact path='/' element={<Main/>}/>
      
      </Routes>
      <Back/>
      <Footer/>
      </Router>
    </div>
  );
}

export default App;
