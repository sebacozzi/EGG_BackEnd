import React, { useContext, useEffect, useRef, useState } from 'react'
import CTanteador from '../Services/Contextos'
import './estilos.css'




export default function Tanteador() {
    const {nivel,
      dificultad,
      fichasRestantes,
      filasOcupadas,
      estadoJuego,
      puntuacion,
    lengua,textos, actualizaEstadoJuego,actualizaMotivoEstadoJuego,} = useContext(CTanteador);
    const [tiempo, setTiempo] = useState(50);
    const time = useRef(null);


    /// Temporizador
    useEffect(()=>{
      if ((estadoJuego===2 || estadoJuego===1 )&& time.current!==null) {
        
        clearInterval(time.current)
      } else{
         time.current = setInterval(() => { 
         
            if(estadoJuego!==3){
              setTiempo(tiempo=>tiempo - 1)
            }
            }, 1000);
        return ()=>clearInterval(time.current);
      }

    },[estadoJuego])
    
    useEffect(()=>{
      if (tiempo<1){
        actualizaEstadoJuego( 1);
        actualizaMotivoEstadoJuego(textos.tx_fin_tiempo)
      }
    },[tiempo])
   
  return (
    <div>
      {/* Tablero de Puntos */}
      <div className='tanteador'>
                <p>{textos.tx_nivel}/{textos.tx_dif}: {nivel}/{textos.tx_dificultad[dificultad]}</p>
                <p>{textos.tx_filas}: {filasOcupadas}</p>
                <p>{textos.tx_f_rest}: {fichasRestantes}</p>
                <p>{textos.tx_tiempo}: {tiempo} {textos.tx_tiempo_det}.</p>
                <p>{textos.tx_puntos}: {puntuacion}</p>
                </div>
    </div>
  )
}
