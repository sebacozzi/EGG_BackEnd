import React, { useEffect, useLayoutEffect, useReducer, useRef, useState } from 'react'
import Tanteador from './Tanteador'
import Juego from './Juego'
import { creaFila } from '../Services/Metodos'

export default function Consola(props) {
const [tableroInicial, setTableroInicial] = useState([])
/// crear filas de inicio de juego segun nivel
const idFicha=useRef(0);

useLayoutEffect(()=>{setTableroInicial(IniciaTablero())},[])
function IniciaTablero(){
  const filasInicio =4;
  const columnas = props.columnas;
  const filas= props.filas;
let nFichas = [];
let fff = 0;
do {
    nFichas = nFichas.concat(creaFila(columnas, idFicha, filas - fff));
    fff++;
} while (fff < filasInicio);

return nFichas;
}


  return (
    <div className='App'> 
      
      <div className='App-header'>
      <Tanteador/>
        <Juego first={false} tablero={IniciaTablero()} />
      </div>
    </div>
  )
}
