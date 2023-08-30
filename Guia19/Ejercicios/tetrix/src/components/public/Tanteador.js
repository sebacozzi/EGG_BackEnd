import React, { useContext, useEffect, useState } from 'react'
import CTanteador from '../Services/Contextos'
import './estilos.css'

export default function Tanteador() {
    const {mOver,segundos,filasOcupadas} = useContext(CTanteador);
    const [tiempo, setTiempo] = useState(0);
   
    /// Temporizador
    useEffect(() => {
        const time = setInterval(() => { 
            setTiempo(tiempo=>tiempo + 1)
        }, 1000);
        return ()=>clearInterval(time);
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
