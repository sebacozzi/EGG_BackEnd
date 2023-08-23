import logo from './logo.svg';
import './App.css';
import Navbar from './components/public/Navbar';
import Main from './components/public/Main';
import Footer from './components/public/Footer';
import { useEffect, useState } from 'react';

function App() {
  
  ///////////////// Esto es para que ponga el scroll solo al main ///////////////////
  const [alturaMain, setAlturaMain] = useState(0);


  useEffect(() => {

    const alturaNav = parseFloat(getComputedStyle(document.querySelector('nav')).height);
    const alturaFooter = parseFloat(getComputedStyle(document.querySelector("Footer")).height);

    if (alturaMain === 0) {
      setAlturaMain(parseFloat(window.innerHeight) - (alturaFooter + alturaNav + 30));
    }

    const handleRedim = () => {
      setAlturaMain(parseFloat(window.innerHeight) - (alturaFooter + alturaNav + 30));
    }

    window.addEventListener('resize', handleRedim);


     return()=>{
       window.removeEventListener('resize',handleRedim)
       
     };
  }, []);


  const estiloCuerpo = {
    display: 'block',
    overflowY: 'auto',
    scrollBehavior: 'smooth',
    height: `${alturaMain}px`,
  };
///////////////// Esto es para que ponga el scroll solo al main ///////////////////
  return (
    <div className='App'>
      <Navbar />
      <div style={estiloCuerpo}>
        <Main />
        
      </div>
      <Footer />
    </div>
  );
}

export default App;
