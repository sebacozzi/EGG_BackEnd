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
    const [nuevaFila, setNuevaFila] = useState([]);
    

    const [fichas, setFichas] = useState(
        [{ pieza: 1, x: 2, y: 19 },
        { pieza: 3, x: 12, y: 19 },
        { pieza: 4, x: 4, y: 18 },
        { pieza: 4, x: 7, y: 19 },
        { pieza: 3, x: 4, y: 19 },
        ]
    )

    useEffect(()=>{
        if(nuevaFila.length!== 0){
            const subeFichas= fichas.map((ficha)=>{ficha.y--
            return ficha});
            setFichas(fichas=>[...subeFichas,...nuevaFila] )
        console.log('sube fila '+nuevaFila.length)}
        console.log('Nueva fila')
        console.log(fichas)
    },[nuevaFila])
     useEffect(() => {
        
        const intervalo = setInterval(() => {
            /// Sube las fichas en el tablero 1 posición
            
           
            //// Crea la nueva linea de Fichas
         
            setSegundos(segundos+1);
            
            
            
            
        
        },1000); 
        
        return ()=>{ clearInterval(intervalo)}
        
    },[]) 
    function handleMouseMove(indice, ficha) {
        setMOver('Tipo ficha: ' + ficha + ' Indice: ' + indice);
    }
    
    const handleOnClick=(e)=>{
        let nFichas = [];
        let largoMax = 4;

        for (let index = 0; index < columnas; index++) {
               
            if ( (columnas-index) < 5) { largoMax = index - columnas  }
            
            if(largoMax>0){
                const llevaFicha=Math.round(Math.random());
            if (llevaFicha === 1) {
                const tipoFicha = Math.round(Math.random() * largoMax) + 1;
                const nPieza = tipoFicha;
                const y = 19;
                const x = index;
                index += tipoFicha;
                nFichas = nFichas.concat([{ pieza:  nPieza , x: x , y:  y  }]);
            }}
        }
        setNuevaFila(nFichas);
        
    }

   
    return (
        <div>
            {/* Tablero de Puntos */}
            <div className='tanteador' style={{ position: 'absolute', left: '10px', height: '150px', width: '150px' }}><p>{mOver}</p><p>{segundos}</p></div>
            {/* Dibuja base tablero */}
            <div className='tablero' onClick={handleOnClick}>
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
