import React, { useEffect, useLayoutEffect, useRef, useState } from 'react'
import JuegoPerdido from './JuegoPerdido';
import { createPortal } from 'react-dom';
import JuegoGanado from './JuegoGanado';

export default function FinJuegoForm({motivo,estado,reiniciar, texto}) {

    const [mostrar, setMostrar] = useState('maximiza');
    useEffect(() => {
      setMostrar('');
      console.log(mostrar)
        }, [])
    

    return (
    <div >    
     {estado===1 && (createPortal(<div className={`modal ${mostrar}`}><JuegoPerdido motivo={motivo} reiniciar={reiniciar} texto={texto} /></div>,document.body))}
     {estado===2 && (createPortal(<div className={`modal ${mostrar}`}><JuegoGanado  reiniciar={reiniciar} texto={texto} /></div>,document.body))}
    
    </div>

  )
}
