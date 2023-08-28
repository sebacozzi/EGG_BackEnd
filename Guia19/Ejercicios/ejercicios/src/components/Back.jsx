import React from 'react'
import { Link } from 'react-router-dom'

export default function Back() {
  const estiloAtras={
    borderRadius:'50%',
    position: 'fixed',
    botton:'20px',
    right:'20px',
    padding:'15px 10px',
    color: 'white',
    border:'2px solid #0e72ed',
    backgroundColor: '#0e72ed',
    zindex:9999,

  }
  return (
    <div  >
        <button type="button"  style={estiloAtras}>Atras</button>
        
    </div>
  )
}
