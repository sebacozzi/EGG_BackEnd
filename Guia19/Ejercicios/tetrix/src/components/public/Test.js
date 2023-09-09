import React, { useContext, useEffect, useRef, useState } from 'react'
import CTanteador from '../Services/Contextos'
import './estilos.css'




export default function Test({combinaciones}) {
   const comb = useRef(combinaciones);
   let detalle = combinaciones.map((c)=>{
    return <span>{c.join(' + ')} <br/> </span>
  })
  const [l,setL]= useState(0)
  
   useEffect(() => {
     comb.current=combinaciones;
     setL(comb.current.length)
   }, [combinaciones])
   

  return (
    <div>
      {/* Tablero de Puntos */}
      <div className='tanteador' style={{left:'68%',top:'15px', width:'400px'}}>
                <p>Combinaciones: {l} <br/></p>
                {detalle}
                </div>
    </div>
  )
}
