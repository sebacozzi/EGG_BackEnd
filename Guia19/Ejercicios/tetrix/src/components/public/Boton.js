import React from 'react'

export default function Boton(props) {
  return (
    <div className='contendorBoton'>
        <button className='botonRedondo' onClick={props.accion}><span className="material-symbols-outlined">{props.clase}</span></button>
        <div>{props.label}</div>
    </div>
  )
}
