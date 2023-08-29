import React, { useEffect, useState } from 'react'
import './estilos.css'
import Pieza from './Pieza';

export default function Tablero() {
    const dificultad = 2;
    const pieza1 =
        [1, 1];
    const pieza2 =
        [2, 2];
    const pieza3 =
        [3, 3]
    const pieza4 =
        [4, 4]

    const filas = 20;
    const columnas = 15;
    const [mOver, setMOver] = useState('NN');
    const [casillas, setCasillas] = useState(Array.from({ length: filas }, (v, f) => Array.from({ length: columnas }, (v, i) => {
        if (f === filas) { return 1 } return 0
    })));

    const [segundos, setSegundos] = useState(0);

    const [fichas, setFichas] = useState(
        [{ pieza: pieza1, x: 2, y: 19 },
        { pieza: pieza3, x: 12, y: 19 },
        { pieza: pieza4, x: 4, y: 18 },
        { pieza: pieza4, x: 7, y: 19 },
        { pieza: pieza3, x: 4, y: 19 },
        ]
    )

    useEffect(() => {
        
        const intervalo = setInterval(() => {
            /// Sube las fichas en el tablero 1 posición
            setFichas(fichas=>fichas.map((ficha) => {
                ficha.y--;
                return ficha;
            }) )
           
            //// Crea la nueva linea de Fichas
            let nFichas = [];
            let largoMax = 4;
           /*  do { */
                
            
            for (let index = 0; index < columnas; index++) {
               
                if ( (columnas-index) < 4) { largoMax = index - columnas }
                
                if(largoMax>0){
                    const llevaFicha=Math.round(Math.random());
                if (llevaFicha === 1) {
                    const tipoFicha = Math.round(Math.random() * largoMax) + 1;
                    const nPieza = [tipoFicha, tipoFicha];
                    const y = 19;
                    const x = index;
                    index += tipoFicha;
                    nFichas = nFichas.concat([{ pieza:  nPieza , x: x , y:  y  }]);
                }}
            }
            console.log('Longitud nFicha: '+nFichas.length)
       /*  } while (nFichas.length===0);  */
       if(segundos>10){ clearInterval(intervalo);}
       console.log(nFichas)
            setFichas(fichas => fichas.concat(nFichas)); 
            setSegundos(segundos=>segundos+1);
        },5000); 
        return ()=>{ clearInterval(intervalo)}
    },[])
    function handleMouseMove(indice, ficha) {

        setMOver('Tipo ficha: ' + ficha[0] + ' Indice: ' + indice);
    }
    console.log(fichas)
    return (
        <div>
            {/* Tablero de Puntos */}
            <div className='tanteador' style={{ position: 'absolute', left: '10px', height: '150px', width: '150px' }}><p>{mOver}</p><p>{segundos}</p></div>
            {/* Dibuja base tablero */}
            <div className='tablero' >
                {casillas.map((fila, iFila) => (
                    <div key={iFila} className='fila'>
                        {fila.map((columna, iColumna) => (

                            <div key={iColumna + iFila*columna} className={`casilla`} ></div>

                        ))}
                    </div>
                ))}
                {/* Fin Dibuja Base Tablero */}

                {/* Dibuja fichas en tablero */}
                <div className='fichas'>
                    {fichas.map((ficha, index) => (
                        <Pieza key={index+1} ficha={ficha.pieza} x={ficha.x} y={ficha.y}
                            onMouseMove={() => handleMouseMove(index, ficha.pieza)} />))}
                </div>
            </div>

        </div>
    )
}
