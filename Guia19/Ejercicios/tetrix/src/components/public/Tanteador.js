import React, { useContext, useEffect, useRef, useState } from 'react'
import CTanteador from '../Services/Contextos'
import './estilos.css'

export default function Tanteador() {
    const {mOver,
      segundos,
      filasOcupadas,
      estadoJuego,
      puntuacion} = useContext(CTanteador);
    const [tiempo, setTiempo] = useState(0);
    const time = useRef(null);

    /// Temporizador
    useEffect(() => {
      
      
        
        
      if (estadoJuego!==0 && time.current!==null){
        console.log('Juego Terminado')
        clearInterval(time.current)
      };

         time.current = setInterval(() => { 
         /*  console.log('Estado: '+ estadoJuego)
          console.log(time.current)
          console.log('Estado juego: '+((estadoJuego!==0 && time.current!==null) ? 'Juego terminado':'Jugando'))
           */
            setTiempo(tiempo=>tiempo + 1)
        }, 1000);
        return ()=>clearInterval(time.current);
    }, [])
    
  return (
    <div>
      {/* Tablero de Puntos */}
      <div className='tanteador'>
                <p>rectOver: {mOver}</p>
                <p>Filas: {filasOcupadas}</p>
                <p>{segundos}</p>
                <p>Tiempo: {tiempo} seg.</p>
                <p>Puntos: {puntuacion}</p>
                </div>
    </div>
  )
}
