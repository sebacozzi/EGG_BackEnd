import React from 'react'
import Tablero from './Tablero'
import Tanteador from './Tanteador'
import Juego from './Juego'

export default function Consola() {
  return (
    <div className='App'> 
      
      <div className='App-header'>
      <Tanteador/>
        <Juego/>
      </div>
    </div>
  )
}
