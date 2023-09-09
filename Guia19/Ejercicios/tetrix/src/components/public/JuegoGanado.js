import React, { useEffect, useState } from 'react'
import Boton from './Boton'

export default function JuegoGanado({motivo,reiniciar, texto}) {

  return (
    <div>
        
      <div className={`gameOver maximiza`} >
              <h1>{texto}!!!</h1>
              <div style={{display:'grid', gridAutoFlow:'column'}}>
              <Boton accion={reiniciar} label='Reintentar' clase='reply' />
              <Boton accion={reiniciar} label='Niveles' clase='menu' />
              <Boton  label='Continuar' clase='done' />
              </div>
            </div>
    </div>
  )
}
