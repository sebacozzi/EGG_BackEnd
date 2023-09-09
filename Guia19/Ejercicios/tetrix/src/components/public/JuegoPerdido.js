import React from 'react'
import Boton from './Boton'

export default function JuegoPerdido({motivo,reiniciar, texto}) {
    return (
    <div >
           <div className='gameOver' >
              <h1>{texto}!!!</h1>
              {motivo !== '' && (<p>{motivo}</p>)}
              {/* <h2>Reiniciando Juego en {temporizador} {textos.tx_tiempo_det}</h2> */}
              <Boton accion={reiniciar} label='Reiniciar' clase='Refresh'/>
              
            </div>
    </div>
  )
}
