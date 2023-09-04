import React, { useContext, useEffect, useRef, useState } from 'react'
import CTanteador from '../Services/Contextos'
import './estilos.css'
import Idioma from '../Constantes/Lenguaje';


export default function Tanteador() {
    const {nivel,
      dificultad,
      fichasRestantes,
      filasOcupadas,
      estadoJuego,
      puntuacion,
    lengua} = useContext(CTanteador);
    const [tiempo, setTiempo] = useState(0);
    const time = useRef(null);


    /// Temporizador
    useEffect(()=>{
      if ((estadoJuego===2 || estadoJuego===1 )&& time.current!==null) {
        
        clearInterval(time.current)
      }

    },[estadoJuego])
    
    useEffect(() => {
      

         time.current = setInterval(() => { 
         /*  console.log('Estado: '+ estadoJuego)
          console.log(time.current)
          console.log('Estado juego: '+((estadoJuego!==0 && time.current!==null) ? 'Juego terminado':'Jugando'))
           */
            if(estadoJuego!==3){
              setTiempo(tiempo=>tiempo + 1)
            }
            }, 1000);
        return ()=>clearInterval(time.current);
    }, [])
    
  return (
    <div>
      {/* Tablero de Puntos */}
      <div className='tanteador'>
                <p>{Idioma.get(lengua).tx_nivel}/{Idioma.get(lengua).tx_dif}: {nivel}/{Idioma.get(lengua).tx_dificultad[dificultad]}</p>
                <p>{Idioma.get(lengua).tx_filas}: {filasOcupadas}</p>
                <p>{Idioma.get(lengua).tx_f_rest}: {fichasRestantes}</p>
                <p>{Idioma.get(lengua).tx_tiempo}: {tiempo} {Idioma.get(lengua).tx_tiempo_det}.</p>
                <p>{Idioma.get(lengua).tx_puntos}: {puntuacion}</p>
                </div>
    </div>
  )
}
