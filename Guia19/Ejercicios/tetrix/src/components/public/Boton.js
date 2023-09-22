import React from 'react'

export default function Boton(props) {

  return (
    <div className='contendorBoton'>
      <button
        className={`boton ${props.tipo ? props.tipo : 'redondo'} ${props.desactivado ? 'disabled' : ''}`}
        style={props.bloqueado ? {pointerEvents:'none'}:{}}
        onClick={props.accion}  >
        {props.bloqueado && (
        <div
        className={`material-symbols-outlined disabled-text`}
        style={{position:'absolute',transform:'scale(0.7)',userSelect:'none', pointerEvents:'none',}}>
        lock
      </div>
      )}
        <span
          className={`material-symbols-outlined ${props.desactivado ? 'disabled-text' : ''}`}>
          {props.clase}
        </span>
      </button>
      <div
        className={` ${props.desactivado ? 'disabled-text' : ''}`}
        style={{ userSelect: 'none' }}
        onClick={props.accion}>
        {props.label}
      </div>
      


    </div >
  )
}
