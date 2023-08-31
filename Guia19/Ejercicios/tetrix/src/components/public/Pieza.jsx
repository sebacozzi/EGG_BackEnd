import React from 'react'
import './estilos.css'

export default function Pieza({idf, ficha,x,y,onMouseMove, onMouseDown, onMouseUp}) {
    

    return (
        <div className='ficha'>
                <div key={idf} 
                    className={`casilla ficha ficha-${ficha}`} 
                    style={{top:(y)*30+1,left:((x)*30)+1,width:(30*ficha)-2, height: 28 }} 
                    onMouseMove={onMouseMove}
                    onMouseDown={onMouseDown}
                    onMouseUp={onMouseUp}>
                    
                </div>
 
        </div>
    )
}

