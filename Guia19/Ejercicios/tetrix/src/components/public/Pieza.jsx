import React, { useEffect, useLayoutEffect, useState } from 'react'
import './estilos.css'

export default function Pieza(props) {
/* const[ancho,setAncho] = useState(0)
    
    useLayoutEffect(()=>{
    const sty = getComputedStyle(document.documentElement);
     setAncho(  parseInt(sty.getPropertyValue('--dim-width'))/parseInt(sty.getPropertyValue('--count-cols')));
     console.log(ancho)
    },[]); */


   

    return (
        <div className='ficha'>
                <div key={props.idf} 
                    className={`casilla ficha ficha-${props.ficha}`} 
                    style={{top:(props.y)*props.anchoFicha+1,left:((props.x)*props.anchoFicha)+1,width:(props.anchoFicha*props.ficha)-2, height: props.anchoFicha-2 }} 
                    onMouseMove={props.onMouseMove}
                    onMouseDown={props.onMouseDown}
                    onMouseUp={props.onMouseUp}>
                   
                </div>
 
        </div>
    )
}

