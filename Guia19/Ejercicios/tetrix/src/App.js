import logo from './logo.svg';
import './App.css';
import Tablero from './components/public/Tablero';
import Juego from './components/public/Juego';
import Tanteador from './components/public/Tanteador';
import CTanteador from './components/Services/Contextos';
import { useState } from 'react';
import Idioma from './components/Constantes/Lenguaje';


function App() {

  const [datos, setDatosContexto] = useState(
    {
      nivel: 1,
      dificultad:1,
      fichasRestantes: 0,
      filasOcupadas: 0,
      estadoJuego: 3,
      puntuacion: 0,
      mouseUp: false,
      lengua:'es',
    })

  const actualizaNivel = (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, nivel: nuevoDato })) };
  const actualizaDificultad = (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, dificultad: nuevoDato })) };
  const actualizaFichasRestantes = (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, fichasRestantes: nuevoDato })) };
  const actualizaFila = (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, filasOcupadas: nuevoDato })) };
  const actualizaEstadoJuego = (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, estadoJuego: nuevoDato })) };
  const actualizaPuntuacion = (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, puntuacion: nuevoDato })) };
  const actualizaMouseUp = (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, mouseUp: nuevoDato })) };
  const actualizaLengua = (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, lengua: nuevoDato })) };

  function handleMouseUp(ev) {
    actualizaMouseUp(true);
    
  }
  function handleBotonContinuar(ev){
    actualizaEstadoJuego(0);
  }

  return (
    <CTanteador.Provider value={{
      ...datos,
      actualizaNivel,
      actualizaDificultad,
      actualizaFichasRestantes,
      actualizaFila,
      actualizaEstadoJuego,
      actualizaPuntuacion,
      actualizaMouseUp,
      actualizaLengua,
    }}>
      <div className="App">
        <header className="App-header" onMouseUp={handleMouseUp}>
          
          {(datos.estadoJuego === 1) && (
            <div className='gameOver'><h1>{Idioma.get(datos.lengua).tx_j_p}!!!</h1></div>
          )}

          {(datos.estadoJuego === 2) && (
            <div className='gameOver'><h1>{Idioma.get(datos.lengua).tx_j_g}!!!</h1></div>
          )}
          
          {(datos.estadoJuego === 3) && (
            <div className='gameOver'><h1>{Idioma.get(datos.lengua).tx_pausa}!!!</h1> <button onClick={handleBotonContinuar} >Continuar</button></div>
          )}

          <Tablero />
          <Tanteador />
          <Juego  />

        </header>
      </div>
    </CTanteador.Provider>
  );
}

export default App;
