import React, { useEffect, useRef, useState } from 'react'
import Tanteador from './Tanteador'
import Juego from './Juego'
import { creaFila } from '../Services/Metodos'
import Tablero from './Tablero';


export default function Consola(props) {

  /// crear filas de inicio de juego segun nivel
  const idFicha = useRef(0);
  const [anchoFicha, setAnchoFicha] = useState(0)
  const [columnas, setColumnas] = useState(props.columnas);
  const [filas, setFilas] = useState(props.filas);
  function IniciaTablero() {
    const filasInicio = 4;

    let nFichas = [];
    let fff = 0;
    do {
      nFichas = nFichas.concat(creaFila(columnas, idFicha, filas - fff));
      fff++;
    } while (fff < filasInicio); 

    return nFichas;
  }

  useEffect(() => {
    setColumnas(props.columnas);
    setFilas(props.filas);
    console.log('useEffect Consola:', props.columnas)
    console.log('toPlay Consola', props.toPlay)
  }, [])

  return (
    <div className='App'>

      {/* <div className='App-header' > */}
        <div className='contenedorJuego'>
          <Tanteador />
          <div className='consola'>
            <Tablero
              columnas={props.columnas}
              filas={props.filas}
              setAnchoFicha={setAnchoFicha} />
            <Juego
              style={{ position: 'absolute', display: 'flex' }}
              first={false}
              tablero={IniciaTablero()}
              columnas={props.columnas}
              filas={props.filas}
              idFicha={idFicha.current}
              anchoFicha={anchoFicha} />
          </div>
        </div>
     {/*  </div> */}
    </div>
  )
}
