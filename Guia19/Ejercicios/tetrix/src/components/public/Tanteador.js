import React, { useContext, useEffect, useRef, useState } from 'react'
import CTanteador from '../Services/Contextos'
import './estilos.css'




export default function Tanteador(props) {
  const { nivel,
    dificultad,
    fichasRestantes,
    filasOcupadas,
    estadoJuego,
    puntuacion,
    tiempoJuego,

    actualiza,
    textos } = useContext(CTanteador);
  const [tiempo, setTiempo] = useState(60);
  const time = useRef(null);


  /// Temporizador


  useEffect(() => {
    if ((estadoJuego === 2 || estadoJuego === 1) && time.current !== null) {

      clearInterval(time.current)
      actualiza.TiempoJugado(tiempoJuego - tiempo)
      setTiempo(tiempoJuego)
    } else {
      time.current = setInterval(() => {
        setTiempo(tiempo => tiempo - 1)
      }, 10000);
      return () => clearInterval(time.current);
    }

  }, [estadoJuego])

  useEffect(() => {
    if (tiempo < 1) {
      actualiza.EstadoJuego(1);
      actualiza.MotivoEstadoJuego(textos.tx_fin_perdio[0])
    }
  }, [tiempo])

  return (
    <div className='listaTanteador'>
      {/* Tablero de Puntos */}

      <div className='tanteador'>
        <span	>
          {textos.tx_nivel}: {nivel}<br />
          {textos.tx_dif}: {textos.tx_dificultad[dificultad]}
        </span>
      </div>
      <div className='tanteador'>
        <span>
          {textos.tx_filas}: {filasOcupadas}
        </span>
      </div>
      <div className='tanteador'>
        <span>
          {textos.tx_f_rest}: {fichasRestantes}
        </span>
      </div>
      <div className='tanteador'>
        <span>
          {textos.tx_tiempo}: {tiempo} {textos.tx_tiempo_det}. <br />
          {textos.tx_puntos}: {puntuacion}
        </span>

      </div>
    </div>
  )
}
