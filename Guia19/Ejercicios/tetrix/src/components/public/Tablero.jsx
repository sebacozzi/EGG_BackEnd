import React, { useState } from 'react'
import './estilos.css'

export default function Tablero() {
    
    const filas = 20;
    const columnas = 15;
     const [casillas, setCasillas] = useState(Array.from({ length: filas }, (v, f) => Array.from({ length: columnas }, (v, i) => {
        if (f === filas) { return 1 } return 0
    })));

    return (
        <div>
            
            {/* Dibuja base tablero */}
            <div className='tablero'>
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
