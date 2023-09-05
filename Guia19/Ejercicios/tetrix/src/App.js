import logo from './logo.svg';
import './App.css';
import Tablero from './components/public/Tablero';
import Juego from './components/public/Juego';
import Tanteador from './components/public/Tanteador';
import CTanteador from './components/Services/Contextos';
import { useEffect, useState, useRef } from 'react';
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
      iniciaJuego:true,
      columnas:15,
      filas:20,
      tiempoJuego:60,
      tiempoJugado:60,
      
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
  const actualizaColumnas = (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, columnas: nuevoDato })) };
  const actualizaFilas = (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, filas: nuevoDato })) };
  const actualizaTiempoJuego = (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, tiempoJuego: nuevoDato })) };
  const actualizaTiempoJugado = (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, tiempoJugado: nuevoDato })) };
  const actualizaIniciaJuego = (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, iniciaJuego: nuevoDato })) };

  const [temporizador, setTemporizador] = useState(15)
  const reiniciaJuego=useRef(null)

  useEffect(()=>{
    setTextos(texto(datos.lengua))

  },[datos.lengua])
  
  function handleMouseUp(ev) {
    actualizaMouseUp(true);
  }
  function handleBotonContinuar(ev){
    actualizaEstadoJuego(0);
  }

  useEffect(() => {
    
    if(datos.estadoJuego===2 || datos.estadoJuego===1){
      reiniciaJuego.current= setInterval(() => {
        setTemporizador(temporizador=> temporizador-1);    
      }, 1000);
    }else{
      setTemporizador(15)
      if(reiniciaJuego.current!== null)
    clearInterval(reiniciaJuego)
      datos.tiempoJugado=60;
    }
  }, [datos.estadoJuego])
  
  useEffect(() => {
    if(temporizador===0){
      clearInterval(reiniciaJuego.current);
      datos.estadoJuego=0;
      datos.iniciaJuego=true;
      datos.tiempoJuego=60;
      datos.tiempoJugado=60;
      datos.puntuacion=0;
    }
  
  }, [temporizador])
  

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
      actualizaColumnas,
      actualizaFilas,
      actualizaTiempoJuego,
      actualizaTiempoJugado,
      actualizaIniciaJuego,
    }}>
      <div className="App" onMouseLeave={handleMouseUp}>
        <header className="App-header" onMouseUp={handleMouseUp}>
          {/* Juego Perdido Estado=1 */}
          {(datos.estadoJuego === 1) && (
            <div className='gameOver'>
              <h1>{textos.tx_j_p}!!!</h1>
              {datos.motivoJuegoPerdido!==-1&&(<p>{datos.motivoJuegoPerdido}</p>)}
              <h2>Reiniciando Juego en {temporizador} {textos.tx_tiempo_det}</h2>
            </div>
          )}

           {/* Juego Ganado Estado=2  */}
          {(datos.estadoJuego === 2) && (
            <div className='gameOver'> 
              <h1>{textos.tx_j_g}!!!</h1> <h2>Tiempo Jugado {datos.tiempoJugado} {textos.tx_tiempo_det}</h2>
              <h2>Reiniciando Juego en {temporizador} {textos.tx_tiempo_det}</h2>
            </div>
          )}
   
          {/* Juego en Pausa Estado=3 */}      
          {(datos.estadoJuego === 3) && (
            <div className='gameOver'><h1>{textos.tx_pausa}!!!</h1> <button onClick={handleBotonContinuar} >{textos.tx_continue}</button></div>
          )}
          <Consola />
          
         
        </header>
      </div>
    </CTanteador.Provider>
  );
}

export default App;
