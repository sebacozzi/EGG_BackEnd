import React, { useContext, useEffect, useRef, useState } from 'react'
import CTanteador from '../Services/Contextos'
import './estilos.css'

export default function Tanteador() {
    const {mOver,segundos,filasOcupadas,estadoJuego} = useContext(CTanteador);
    const [tiempo, setTiempo] = useState(0);
    const time = useRef(null);

    /// Temporizador
    useEffect(() => {
      console.log('Temporizador:'+estadoJuego===0 && time.current!==null)
      if (estadoJuego===0 && time.current!==null){
        console.log('clear intervalo')
        clearInterval(time.current)};
      if (!estadoJuego){
        
         time.current = setInterval(() => { 
            setTiempo(tiempo=>tiempo + 1)
        }, 1000);
        return ()=>clearInterval(time.current);
      }
    }, [])
    
  return (
    <div>
      {/* Tablero de Puntos */}
      <div className='tanteador'>
                <p>rectOver: {mOver}</p>
                <p>Filas: {filasOcupadas}</p>
                <p>{segundos}</p>
                <p>Tiempo: {tiempo} seg.</p>
                
                </div>
    </div>
  )
}
