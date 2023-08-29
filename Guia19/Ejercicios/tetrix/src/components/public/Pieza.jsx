import React from 'react'
import './estilos.css'

export default function Pieza({ficha,x,y,onMouseMove}) {
    

    return (
        <div className='ficha'>
                <div key={1} className={`casilla ficha ficha-${ficha[0]}`} style={{top:(y)*30+1,left:((x)*30)+1,width:(30*ficha[1])-2, height: 28 }} onMouseMove={onMouseMove}></div>
 
        </div>
    )
}

