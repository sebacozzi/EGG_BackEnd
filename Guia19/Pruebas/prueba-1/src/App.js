
import './App.css';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';

import NavBar from './components/public/NavBar';
import Footer from './components/public/Footer';
import Main from './components/public/Main';
import E404 from './components/public/E404';
import Detalle from './components/public/Detalle';
import Acerca from './components/public/Acerca';

function App() {
  return (
    <div>

      {/* cuerpo */}
      
      <Router>
      
        <NavBar />
        <div className='cuerpo-scroll'>
        <Routes  >
          <Route exact path='/' Component={Main} />
          <Route exact path='/detalle/:id' Component={Detalle} />
          <Route exact path='/acerca/' Component={Acerca} />

          <Route path='*' Component={E404} />
        </Routes>
        </div>
        <Footer />
      </Router >
      
    </div >
  );
}

export default App;
