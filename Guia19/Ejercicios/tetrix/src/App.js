import logo from './logo.svg';
import './App.css';
import Tablero from './components/public/Tablero';
import Juego from './components/public/Juego';
import Tanteador from './components/public/Tanteador';
import CTanteador from './components/Services/Contextos';
import { useState } from 'react';

function App() {
  
  const [datos, setDatosContexto] = useState(
    {
      mOver:0,
      segundos:0,
      filasOcupadas:0,
    })
    const actualizaFila=(nuevoDato)=>{ setDatosContexto((prevData)=>({...prevData,filasOcupadas:nuevoDato}))}
    const actualizaSegundos=(nuevoDato)=>{ setDatosContexto((prevData)=>({...prevData,segundos:nuevoDato}))}
    const actualizamOver=(nuevoDato)=>{ setDatosContexto((prevData)=>({...prevData,mOver:nuevoDato}))}
    
  return (
    <CTanteador.Provider value={{...datos,actualizaFila,actualizaSegundos,actualizamOver}}>
    <div className="App">
      <header className="App-header">
        <Tablero/>
        <Tanteador/>
        <Juego/>
      </header>
    </div>
    </CTanteador.Provider>
  );
}

export default App;
