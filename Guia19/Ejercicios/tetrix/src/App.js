import logo from './logo.svg';
import './App.css';
import Tablero from './components/public/Tablero';
import Juego from './components/public/Juego';
import Tanteador from './components/public/Tanteador';
import CTanteador from './components/Services/Contextos';
import { useEffect, useState } from 'react';
import { texto } from './components/Constantes/Lenguaje';
import Consola from './components/public/Consola';


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
      lengua:'ar',
      motivoJuegoPerdido:'',
    })
    
    const [textos, setTextos] = useState(texto('es'))
  const actualizaNivel = (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, nivel: nuevoDato })) };
  const actualizaDificultad = (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, dificultad: nuevoDato })) };
  const actualizaFichasRestantes = (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, fichasRestantes: nuevoDato })) };
  const actualizaFila = (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, filasOcupadas: nuevoDato })) };
  const actualizaEstadoJuego = (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, estadoJuego: nuevoDato })) };
  const actualizaPuntuacion = (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, puntuacion: nuevoDato })) };
  const actualizaMouseUp = (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, mouseUp: nuevoDato })) };
  const actualizaLengua = (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, lengua: nuevoDato })) };
  const actualizaMotivoEstadoJuego = (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, motivoJuegoPerdido: nuevoDato })) };

  useEffect(()=>{
    setTextos(texto(datos.lengua))
  },[datos.lengua])
  
  function handleMouseUp(ev) {
    actualizaMouseUp(true);
    
  }
  function handleBotonContinuar(ev){
    actualizaEstadoJuego(0);
  }

  return (
    <CTanteador.Provider value={{
      ...datos,textos,
      actualizaNivel,
      actualizaDificultad,
      actualizaFichasRestantes,
      actualizaFila,
      actualizaEstadoJuego,
      actualizaPuntuacion,
      actualizaMouseUp,
      actualizaLengua,
      actualizaMotivoEstadoJuego,
    }}>
      <div className="App">
        <header className="App-header" onMouseUp={handleMouseUp}>
          {/* Juego Perdido Estado=1 */}
          {(datos.estadoJuego === 1) && (
            <div className='gameOver'>
              <h1>{textos.tx_j_p}!!!</h1>
              {datos.motivoJuegoPerdido!==''&&(<p>{datos.motivoJuegoPerdido}</p>)}
            </div>
          )}

           {/* Juego Ganado Estado=2  */}
          {(datos.estadoJuego === 2) && (
            <div className='gameOver'><h1>{textos.tx_j_g}!!!</h1></div>
          )}
   
          {/* Juego en Pausa Estado=3 */}      
          {(datos.estadoJuego === 3) && (
            <div className='gameOver'><h1>{textos.tx_pausa}!!!</h1> <button onClick={handleBotonContinuar} >{textos.tx_continue}</button></div>
          )}

          <Consola/>{/* 
          <div>
          <Tablero />
          <Tanteador />
          <Juego  />
          </div> */}
        </header>
      </div>
    </CTanteador.Provider>
  );
}

export default App;
