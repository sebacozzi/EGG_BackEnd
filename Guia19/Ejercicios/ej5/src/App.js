import logo from './logo.svg';
import './App.css';
import Consigna from './components/Consigna';
import Main from './components/Main';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <Consigna/>
        
        <div className='App-Main'><Main/></div>
      </header>
      
    </div>
  );
}

export default App;
