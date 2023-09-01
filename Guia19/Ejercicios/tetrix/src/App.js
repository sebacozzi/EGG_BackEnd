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
      mOver: 0,
      segundos: 0,
      filasOcupadas: 0,
      estadoJuego: 0,
    })

  const actualizaFila = (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, filasOcupadas: nuevoDato })) }
  const actualizaSegundos = (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, segundos: nuevoDato })) }
  const actualizamOver = (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, mOver: nuevoDato })) }
  const actualizaEstadoJuego = (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, estadoJuego: nuevoDato })) }



  return (
    <CTanteador.Provider value={{ ...datos, actualizaFila, actualizaSegundos, actualizamOver, actualizaEstadoJuego }}>
      <div className="App">
        <header className="App-header">


          <Tablero />
          <Tanteador />
          <Juego />
          {(datos.estadoJuego === 1) && (

            <div className='gameOver'><h1>Juego Terminado!!!</h1></div>
          )}
          {(datos.estadoJuego === 2) && (

            <div className='gameOver'><h1>Juego Ganado!!!</h1></div>
          )}
        </header>
      </div>
    </CTanteador.Provider>
  );
}

export default App;
