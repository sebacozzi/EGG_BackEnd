
import './App.css';
import {  BrowserRouter as Router, Route, Routes } from 'react-router-dom';

import NavBar from './components/public/NavBar';
import Footer from './components/public/Footer';
import Main from './components/public/Main';
import E404 from './components/public/E404';
import Detalle from './components/Detalle';

function App() {
  const h = 10;

  return (
    <div>
      <NavBar />
      {/* cuerpo */}
      <Router>
        <Routes>
          
            <Route exact path='/' Component={Main} />
            <Route exact path='/detalle/:id' Component={Detalle} />
            <Route Component={E404} />
         
        </Routes>
      </Router>
      <Footer />
    </div>
  );
}

export default App;
