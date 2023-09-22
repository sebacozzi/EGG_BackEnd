import React, { useLayoutEffect, useState } from 'react'
import './estilos.css'

export default function Tablero(props) {
    
    const [filas,setFilas] = useState(props.filas);
    const [columnas,setColumnas] = useState(props.columnas);
    useLayoutEffect(() => {
        const w= window.innerWidth;
        const ancho= 30;
        document.documentElement.style.setProperty('--dim-width',`${(ancho*columnas)}px`)
        document.documentElement.style.setProperty('--count-cols',columnas);
        document.documentElement.style.setProperty('--count-rows',filas);
        props.setAnchoFicha(ancho)

        console.log('Ancho Ventana: ', w)
      console.log(columnas)
      
    }, [])

     const [casillas, setCasillas] = useState(Array.from({ length: filas }, (v, f) => Array.from({ length: columnas }, (v, i) => {
        if (f === filas) { return 1 } return 0
    })));

    return (
        <div>
            
            {/* Dibuja base tablero */}
            <div className='baseConsola tablero'>
                {casillas.map((fila, iFila) => (
                    <div key={iFila} className='fila'>
                        {fila.map((columna, iColumna) => (

                            <div key={iColumna + iFila * columnas} className={`casilla`} ></div>

                        ))}
                    </div>
                ))}
                {/* Fin Dibuja Base Tablero */}

                
            </div>

        </div>
    )
}
