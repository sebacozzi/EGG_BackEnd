import React, { useEffect,  useState } from 'react'
import JuegoPerdido from './JuegoPerdido';
import { createPortal } from 'react-dom';
import JuegoGanado from './JuegoGanado';

export default function FinJuegoForm(props) {

  const [mostrar, setMostrar] = useState('maximiza');
  useEffect(() => {
    setMostrar('');
  }, [])


  return (
    <div className='App' style={{ zIndex: '1000' }}>
      {props.estado === 1 ? (
        createPortal(
          <div className='bloqueo'>
            <div className={`modal ${mostrar} `}>
              <JuegoPerdido motivo={props.motivo} reiniciar={props.reiniciar} niveles={props.niveles} texto={props.texto} />
            </div>
          </div>,
          document.body)) : 
        props.estado === 2 ?
        createPortal(
          <div className='bloqueo'>
            <div className={`modal ${mostrar} `}>
              <JuegoGanado reiniciar={props.reiniciar} niveles={props.niveles} texto={props.texto} />
            </div>
          </div>,
          document.body) : <div></div>}

    </div>

  )
}
