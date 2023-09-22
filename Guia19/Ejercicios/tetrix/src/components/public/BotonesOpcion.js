import React from 'react'
import Boton from './Boton'

export default function BotonesOpcion(props) {
 
  const listaBotones=()=>{
    let lista=[];
    for (let i = 0; i < props.accion.length; i++) {
      lista=[...lista,<Boton key={i} accion={props.accion[i]} desactivado={props.desactivado ? props.desactivado[i]:''}  label={props.label[i]} clase={props.clase[i]} />];
    }
    return lista;
  };
  return (
    <div className=''>
      <div className='botones-columnas' style={{zIndex:500}}>
        {listaBotones()}
           </div>
    </div>
  )
}
