
import './App.css';
import CTanteador from './components/Services/Contextos';
import { useEffect, useState, useRef } from 'react';
import { getNames, texto } from './components/Constantes/Lenguaje';
import Consola from './components/public/Consola';
import { useForceUpdate } from './components/Hooks/useForceUpdate';
import FinJuegoForm from './components/public/FinJuegoForm';
import BotonesOpcion from './components/public/BotonesOpcion';
import JuegoPausa from './components/public/JuegoPausa';
import FormOpciones from './components/public/configuraciones/FormOpciones';
import ContextoJuego from './components/Services/ContextoJuego';
import { Reglas } from './components/Constantes/Reglas';
import React from 'react';
import Bienvenida from './components/public/Bienvenida';
import { config, juegoGanado, juegoPerdido, jugando, niveles, startApp } from './components/Constantes/Consts';
import Niveles from './components/public/Niveles';
import { getNivel } from './components/Constantes/Levels';

function App() {

  const forceUpdate = useForceUpdate();
  const [opciones, setOpciones] = useState({
    dificultad: 0,
    ln: 'es',
  })
  const [nivelesCompletos, setNivelesCompletos] = useState([
    {
      nivel: 0,
      completado: true
    },
    {
      nivel: 1,
      completado: false
    },])


  const updateOpciones = {
    dificultad: (nuevoDato) => {
      setOpciones((prevData) => ({ ...prevData, dificultad: nuevoDato }));
      updateNivel.tiempoBonifica(Reglas[nuevoDato].tiempoBonifica);
      updateNivel.tiempoLinea(Reglas[nuevoDato].tiempoLinea);
      updateNivel.movimiento(Reglas[nuevoDato].movimiento);
    },
    ln: (nuevoDato) => {
      setOpciones((prevData) => ({ ...prevData, ln: nuevoDato }));
      setTextos(texto(nuevoDato))
    },

  }
  const [nivel, setNivel] = useState({
    nivel: 1,
    filas: 10,
    columnas: 10,
    tiempoLinea: Reglas[opciones.dificultad].tiempoLinea,
    tiempoBonifica: Reglas[opciones.dificultad].tiempoBonifica,
    movimiento: Reglas[opciones.dificultad].movimiento,
  })

  const updateNivel = {
    nivel: (nuevoDato) => { setNivel((prevData) => ({ ...prevData, nivel: nuevoDato })) },
    filas: (nuevoDato) => { setNivel((prevData) => ({ ...prevData, filas: nuevoDato })) },
    columnas: (nuevoDato) => { setNivel((prevData) => ({ ...prevData, columnas: nuevoDato })) },
    tiempoLinea: (nuevoDato) => { setNivel((prevData) => ({ ...prevData, tiempoLinea: nuevoDato })) },
    tiempoBonifica: (nuevoDato) => { setNivel((prevData) => ({ ...prevData, tiempoBonifica: nuevoDato })) },
    movimiento: (nuevoDato) => { setNivel((prevData) => ({ ...prevData, movimiento: nuevoDato })) },


  }

  const [datos, setDatosContexto] = useState(
    {
      nivel: 1,
      dificultad: 1,
      fichasRestantes: 0,
      filasOcupadas: 0,
      estadoJuego: -3,
      puntuacion: 0,
      mouseUp: false,
      lengua: 'ar',
      motivoJuegoPerdido: '',
      iniciaJuego: true,
      columnas: 10,
      filas: 10,
      tiempoJuego: 60,
      tiempoJugado: 60,

    })

  const [textos, setTextos] = useState(texto('es'))
  const actualiza = {
    /** Actualiza Nivel de Juego */
    Nivel: (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, nivel: nuevoDato })) },
    /** Actualiza dificultad  de 0 a 3 */
    Dificultad: (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, dificultad: nuevoDato })) },
    /** Actualiza Fichas Restantes del Juego */
    FichasRestantes: (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, fichasRestantes: nuevoDato })) },
    /** Actualiza la cantidad de Filas restantes */
    FilasOcupadas: (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, filasOcupadas: nuevoDato })) },

    EstadoJuego: (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, estadoJuego: nuevoDato })) },
    Puntuacion: (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, puntuacion: nuevoDato })) },
    MouseUp: (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, mouseUp: nuevoDato })) },
    Lengua: (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, lengua: nuevoDato })) },
    MotivoEstadoJuego: (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, motivoJuegoPerdido: nuevoDato })) },
    Columnas: (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, columnas: nuevoDato })) },
    Filas: (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, filas: nuevoDato })) },
    TiempoJuego: (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, tiempoJuego: nuevoDato })) },
    TiempoJugado: (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, tiempoJugado: nuevoDato })) },
    IniciaJuego: (nuevoDato) => { setDatosContexto((prevData) => ({ ...prevData, iniciaJuego: nuevoDato })) },
  }


  const [temporizador, setTemporizador] = useState(15)
  const reiniciaJuego = useRef(null)

  useEffect(() => {
    setTextos(texto(datos.lengua))

  }, [datos.lengua])

  function handleMouseUp(ev) {
    actualiza.MouseUp(true);
  }
  function handleBotonContinuar(ev) {
    actualiza.EstadoJuego(0);
  }

  const pausar = () => {

    datos.estadoJuego = 3;
    forceUpdate();
  }
  const reiniciar = () => {

    datos.estadoJuego = 0;
    datos.iniciaJuego = true;
    datos.tiempoJuego = 60;
    datos.tiempoJugado = 60;
    datos.puntuacion = 0;
    datos.filasOcupadas = 0;
    forceUpdate()
  }
  /* const [toPlay,setToPlay]= useState({}); */
  const startNivel = (nivel) => {
    /*   setToPlay(getNivel(nivel)); */
    const toPlay = getNivel(nivel);

    if (toPlay) {
      datos.estadoJuego = 0;
      datos.iniciaJuego = true;
      datos.tiempoJuego = 60 + toPlay.tiempo;
      datos.tiempoJugado = datos.tiempoJuego;
      datos.puntuacion = 0;
      datos.filasOcupadas = 0;
      datos.columnas = toPlay.columnas;
      datos.filas = toPlay.filas;
      datos.nivel = nivel+1;
      updateNivel.filas(toPlay.filas);
      updateNivel.columnas(toPlay.columnas);
      updateNivel.nivel(nivel+1);
      console.log('Nivel elegido: ',nivel)
    };

    forceUpdate();
  }



  return (
    <CTanteador.Provider value={{
      ...datos, textos, actualiza,
    }}>
      <ContextoJuego.Provider value={{ ...opciones, updateOpciones }}>
        <div className="App" onMouseLeave={handleMouseUp} >
          <header className="App-header" onMouseLeave={handleMouseUp} onMouseUp={handleMouseUp}>
            {datos.estadoJuego === JuegoPausa ?
              <JuegoPausa
                accion={handleBotonContinuar}
                texto={textos.tx_pausa}
                label={textos.tx_continue} />

              : datos.estadoJuego === jugando ?
                <>
                  <Consola filas={nivel.filas} columnas={nivel.columnas} toPlay={nivel} />
                  <BotonesOpcion className='botonera' accion={pausar} label={textos.tx_pausar} />
                </> :
                datos.estadoJuego === juegoGanado || datos.estadoJuego === juegoPerdido ?
                  <FinJuegoForm
                    motivo={datos.motivoJuegoPerdido}
                    estado={datos.estadoJuego}
                    reiniciar={reiniciar}
                    texto={textos.tx_titulo_fin[datos.estadoJuego]}
                    niveles={() => { actualiza.EstadoJuego(niveles) }}
                    juegoGanado={setNivelesCompletos} />
                  :
                  datos.estadoJuego === startApp ?
                    <Bienvenida estados={actualiza.EstadoJuego} />
                    :
                    datos.estadoJuego === niveles ?
                      <Niveles estados={actualiza.EstadoJuego} startNivel={startNivel} nivel={setNivel.nivel} nivelesCompletos={nivelesCompletos} textos={textos} />
                      : datos.estadoJuego === config ?
                        <FormOpciones accion={actualiza.EstadoJuego} sender={startApp} />
                        : <div>Error de Estado</div>}


          </header>

        </div>
      </ContextoJuego.Provider>
    </CTanteador.Provider>
  );
}


export default App;

