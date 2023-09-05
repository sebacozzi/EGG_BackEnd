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
      tiempoJuego,
      tiempoJugado,
    lengua,textos, actualizaEstadoJuego,actualizaMotivoEstadoJuego,actualizaTiempoJugado} = useContext(CTanteador);
    const [tiempo, setTiempo] = useState(60);
    const time = useRef(null);


    /// Temporizador
    
    
    useEffect(()=>{
      if ((estadoJuego===2 || estadoJuego===1 )&& time.current!==null) {
        
        clearInterval(time.current)
        actualizaTiempoJugado(tiempoJuego - tiempo)
        setTiempo(tiempoJuego)
      } else{
         time.current = setInterval(() => { 
         
            
              
              setTiempo(tiempo=>tiempo - 1)
           
           
            }, 1000);
        return ()=>clearInterval(time.current);
      }

    },[estadoJuego])
    
    useEffect(()=>{
      if (tiempoJugado<1){
        actualizaEstadoJuego(1);
        actualizaMotivoEstadoJuego(textos.tx_fin_tiempo)
      }
    },[tiempoJugado])
   
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
