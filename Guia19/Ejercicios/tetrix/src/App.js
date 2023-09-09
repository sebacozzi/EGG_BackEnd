import logo from './logo.svg';
import './App.css';
import Tablero from './components/public/Tablero';
import Juego from './components/public/Juego';
import Tanteador from './components/public/Tanteador';
import CTanteador from './components/Services/Contextos';
import { useEffect, useState, useRef } from 'react';
import { getNames, texto } from './components/Constantes/Lenguaje';
import Consola from './components/public/Consola';
import JuegoPerdido from './components/public/JuegoPerdido';
import { useForceUpdate } from './components/Hooks/useForceUpdate';
import FinJuegoForm from './components/public/FinJuegoForm';


function App() {
 
  const forceUpdate= useForceUpdate();
  
  const [datos, setDatosContexto] = useState(
    {
      nivel: 1,
      dificultad: 1,
      fichasRestantes: 0,
      filasOcupadas: 0,
      estadoJuego: 0,
      puntuacion: 0,
      mouseUp: false,
      lengua: 'ar',
      motivoJuegoPerdido: '',
      iniciaJuego: true,
      columnas: 15,
      filas: 20,
      tiempoJuego: 60,
      tiempoJugado: 60,

    })

  const [textos, setTextos] = useState(texto('es'))
  const actualiza = {
    /** Actualiza Nivel de Juego */
    Nivel : (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, nivel: nuevoDato })) },
    /** Actualiza dificultad  de 0 a 3 */
    Dificultad : (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, dificultad: nuevoDato })) },
    /** Actualiza Fichas Restantes del Juego */
    FichasRestantes : (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, fichasRestantes: nuevoDato })) },
    /** Actualiza la cantidad de Filas restantes */
    FilasOcupadas : (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, filasOcupadas: nuevoDato })) },

    EstadoJuego : (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, estadoJuego: nuevoDato })) },
    Puntuacion : (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, puntuacion: nuevoDato })) },
    MouseUp : (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, mouseUp: nuevoDato })) },
    Lengua : (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, lengua: nuevoDato })) },
    MotivoEstadoJuego : (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, motivoJuegoPerdido: nuevoDato })) },
    Columnas : (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, columnas: nuevoDato })) },
    Filas : (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, filas: nuevoDato })) },
    TiempoJuego : (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, tiempoJuego: nuevoDato })) },
    TiempoJugado : (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, tiempoJugado: nuevoDato })) },
    IniciaJuego : (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, iniciaJuego: nuevoDato })) },
  }
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
  const reiniciaJuego = useRef(null)

  useEffect(() => {
    setTextos(texto(datos.lengua))

  }, [datos.lengua])

  function handleMouseUp(ev) {
    actualizaMouseUp(true);
  }
  function handleBotonContinuar(ev) {
    actualizaEstadoJuego(0);
  }

/*   useEffect(() => {

    if (datos.estadoJuego === 2 || datos.estadoJuego === 1) {
      reiniciaJuego.current = setInterval(() => {
        setTemporizador(temporizador => temporizador - 1);
      }, 1000);
    } else {
      setTemporizador(15)
      if (reiniciaJuego.current !== null)
        clearInterval(reiniciaJuego)
      datos.tiempoJugado = 60;
    }
  }, [datos.estadoJuego])

  useEffect(() => {
    if (temporizador === 0) {
      clearInterval(reiniciaJuego.current);
      datos.estadoJuego = 0;
      datos.iniciaJuego = true;
      datos.tiempoJuego = 60;
      datos.tiempoJugado = 60;
      datos.puntuacion = 0;
    }

  }, [temporizador]) */

  const reiniciar=()=>{
   
    datos.estadoJuego = 0;
      datos.iniciaJuego = true;
      datos.tiempoJuego = 60;
      datos.tiempoJugado = 60;
      datos.puntuacion = 0;
      forceUpdate()
  }

  return (
    <CTanteador.Provider value={{
      ...datos, textos, actualiza,
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
      <div className="App" onMouseLeave={handleMouseUp} >
        <header className="App-header" onMouseLeave={handleMouseUp} onMouseUp={handleMouseUp}>
          
         
          
          {/* Juego Ganado Estado=2  */}
        {/*   {(datos.estadoJuego === 2) && (
            <div className='gameOver'>
              <h1>{textos.tx_j_g}!!!</h1> <h2>Tiempo Jugado {datos.tiempoJugado} {textos.tx_tiempo_det}</h2>
              {/* <h2>Reiniciando Juego en {temporizador} {textos.tx_tiempo_det}</h2> 
              <button onClick={reiniciar}>Reiniciar</button>
            </div>
          )}
 */}
          {/* Juego en Pausa Estado=3 */}
          {(datos.estadoJuego === 3) && (
            <div className='gameOver'><h1>{textos.tx_pausa}!!!</h1> <button onClick={handleBotonContinuar} >{textos.tx_continue}</button></div>
          )}
          {/* {console.log('EstadoJuego en app: '+datos.estadoJuego)}
          {datos.estadoJuego===0 &&
          (<Consola />)} */}

          <Consola />
           {/* Juego Perdido Estado=1 */}
           <FinJuegoForm motivo={datos.motivoJuegoPerdido} estado={datos.estadoJuego} reiniciar={reiniciar} texto={textos.tx_titulo_fin[datos.estadoJuego]} />
        </header>
      </div>
    </CTanteador.Provider>
  );
}


export default App;

