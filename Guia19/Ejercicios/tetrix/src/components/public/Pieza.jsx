import React from 'react'
import './estilos.css'

export default function Pieza({idf, ficha,x,y,onMouseMove, onMouseDown, onMouseUp}) {
    
    const sty = getComputedStyle(document.documentElement);
const ancho =  parseInt(sty.getPropertyValue('--dim-width'))/parseInt(sty.getPropertyValue('--count-cols'))
;



    return (
        <div className='ficha'>
                <div key={idf} 
                    className={`casilla ficha ficha-${ficha}`} 
                    style={{top:(y)*ancho+1,left:((x)*ancho)+1,width:(ancho*ficha)-2, height: ancho-2 }} 
                    onMouseMove={onMouseMove}
                    onMouseDown={onMouseDown}
                    onMouseUp={onMouseUp}>
                    
                </div>
 
        </div>
    )
}

