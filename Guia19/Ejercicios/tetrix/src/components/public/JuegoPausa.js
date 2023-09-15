import React from 'react'
import Boton from './Boton'

export default function JuegoPausa( props ) {
  return (
    <div className='modal' >
           <div className='gameOver' >
              <h1>{props.texto}!!!</h1>
              
              <Boton accion={props.accion} label={props.label} clase='resume'/>
              
            </div>
    </div>
  )
}
