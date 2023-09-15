import React, { useEffect, useState } from 'react'
import Boton from './Boton'

export default function JuegoGanado({motivo,reiniciar, texto}) {

  return (
    <div>
        
      <div className={`gameOver`} >
              <h1>{texto}!!!</h1>
              <p>Puntos Obtenidos: </p>
              <div className='botones-columnas'>
              <Boton accion={reiniciar} label='Reintentar' clase='reply' />
              <Boton accion={reiniciar} label='Niveles' clase='menu' />
              <Boton  label='Continuar' clase='done' />
              </div>
            </div>
    </div>
  )
}
