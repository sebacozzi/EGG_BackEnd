
import './App.css';
import Home from './components/public/Home';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Main1 from './components/public/Main1';
import Main2 from './components/public/Main2';
import Navbar from './components/public/Navbar';
import Footer from './components/public/Footer';
import { useEffect, useState } from 'react';

function App() {
  const [alturaMain, setAlturaMain] = useState(0);


  useEffect(() => {

    const alturaNav = parseFloat(getComputedStyle(document.querySelector('nav')).height);
    const alturaFooter = parseFloat(getComputedStyle(document.querySelector("Footer")).height);

    if (alturaMain === 0) {
      setAlturaMain(parseFloat(window.innerHeight) - (alturaFooter + alturaNav ));
    }

    const handleRedim = () => {
      setAlturaMain(parseFloat(window.innerHeight) - (alturaFooter + alturaNav ));
    }

    window.addEventListener('resize', handleRedim);


    return () => {
      window.removeEventListener('resize', handleRedim)

    };
  }, []);


  const estiloCuerpo = {
    display: 'block',
    overflowY: 'auto',
    scrollBehavior: 'smooth',
    height: `${alturaMain}px`,
  };
  return (
    <div >
      <Router>
        <Navbar />

        <span style={estiloCuerpo}>

          <Routes>
            <Route exact path={'main1'} Component={Main1} />
            <Route exact path={'main2'} Component={Main2} />
            <Route exact path='/' Component={Home} />
          </Routes>

        </span>

        <Footer />
      </Router>
    </div>
  );
}

export default App;
