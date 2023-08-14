
import './App.css';

import NavBar from './components/public/NavBar';
import Footer from './components/public/Footer';
import Main from './components/public/Main';

function App() {
  const h = 10;
  return (
    <div>
      <NavBar />
      {/* cuerpo */}
      
      <Main />

      <Footer />
    </div>
  );
}

export default App;
