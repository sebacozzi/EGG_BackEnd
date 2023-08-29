import React, { useState } from 'react'
import './estilos.css'

export default function Tablero() {
    const filas = 20;
    const columnas = 15;

    const [casillas, setCasillas] = useState(Array.from({ length: filas }, () => Array(columnas).fill(0)));
    

    return (
        <div>
        
        <div className='tablero'>
            {casillas.map((fila, iFila) =>(
                <div key={iFila} className='fila'> 
                    {fila.map((columna, iColumna) => (
                        
                        <div key={iColumna} className={`casilla ficha-${columna}`} ></div>
                        
                    ))}
                </div>
            ))}

        </div>
        </div>
    )
}
