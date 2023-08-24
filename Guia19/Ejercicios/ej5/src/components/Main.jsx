import React, { useState } from 'react'

export default function Main() {
    const [clicks, setClicks]= useState(0);
    function handleClick(ev) {
        setClicks(clicks+1);
    }
    function handleAuxClick(ev) {
        setClicks(clicks-1)
    }
    function handleContextMenu(ev) {
        ev.preventDefault()
    }
    const sr={
        padding:'10px',
        border:'1px solid beige',
        borderRadius:'15px',
        cursor:'grab',
    }
  return (

    <div>
        <div style={sr}
        onClick={handleClick} onAuxClick={handleAuxClick} onContextMenu={handleContextMenu}>
      <span >
        Haga click en esté recuadro para modificar el contador de abajo<br/>
        (botón izquierdo para aumentar - botón derecho para disminuir)
        </span>
        </div>
      <p >Clicks realizados: {clicks}</p>
      

    </div>
  )
}
