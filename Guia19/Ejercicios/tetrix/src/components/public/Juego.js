import React, { useContext, useEffect, useState } from 'react'
import './estilos.css'
import Pieza from './Pieza'
import CTanteador from '../Services/Contextos';

export default function Juego() {
    const { mOver, segundos, filasOcupadas, actualizaFila, actualizaSegundos, actualizamOver } = useContext(CTanteador)

    // const [nivel, setNivel] = useState(1);

    const filas = 20;
    const columnas = 15;

    const filasInicio = 4;
    const [first, setfirst] = useState(true)

    // const [nuevaFila, setNuevaFila] = useState([]);

    let idFicha = 1;
    const [fichas, setFichas] = useState(
        [/* { id: 1, pieza: 1, x: 2, y: 19 },
        { id: 2, pieza: 3, x: 12, y: 19 },
        { id: 3, pieza: 4, x: 4, y: 18 },
        { id: 4, pieza: 4, x: 7, y: 19 },
        { id: 5, pieza: 3, x: 4, y: 19 }, */
        ]
    )

    /// crea la cantidad filas
    function creaFicha(fx, fy, maximo) {
        const id = idFicha;
        const nPieza = Math.round(Math.random() * maximo) + 1;
        const to=fx + (nPieza-1);

        idFicha++;
        return { id: id, pieza: nPieza, x: fx, y: fy ,to:to};
    }

    useEffect(() => {
        if (first) {
            let nFichas = [];
            for (let iFilas = 19; iFilas > filas - (filasInicio + 1); iFilas--) {/// recorre las filas
                let largoMax = 4;
                let lineaFichas = [];
                for (let iColumna = 0; iColumna < columnas; iColumna++) { /// recorre las columnas para cargar las fichas

                    if ((columnas - iColumna) < 5) { largoMax = iColumna - columnas } /// ajusta el ancho de la ficha para el final de la fila

                    if (largoMax > 0) {
                        const llevaFicha = Math.round(Math.random()) === 1; ///  Randomiza si va a cargar una ficha en esa columna
                        if (llevaFicha) {
                            // Crear ficha
                            const nf = creaFicha(iColumna, iFilas, largoMax);
                            iColumna += nf.pieza;
                            lineaFichas = lineaFichas.concat([nf]);
                        }
                    }
                }

                if (lineaFichas.length === 0) {
                    iFilas++;
                } else {
                    nFichas = nFichas.concat(lineaFichas);
                }


            }
            setFichas((nFichas));
            setfirst(false);
        }

    }, [])


    /// actualiza filas ocupadas
    useEffect(() => {
        let min = 20;
        let cambio = false;
        /// Hacer caer fichas
        let pf = Array.from({ length: 20 }, () => Array(15).fill(0))

        fichas.forEach(element => {
            if (element.y < min) min = element.y;
            for (let i = element.x; i < element.x + element.pieza; i++) {
                pf[element.y][i] = element.id;
            }
        });
        let salir = true;

        salir = true;
        /* for (let i = 0; i < 19; i++) {
            let vacio = true;
            let l = 0;
            for (let j = 0; j < 15; j++) {
                if (pf[i][j] !== 0) {
                    vacio = true;
                    l = 0;
                    const ficha = pf[i][j];
                    for (let k = j; k < 15; k++) {
                        if (pf[i][k] === 0) { break };
                        if (!((pf[i][k] === ficha) && (pf[i + 1][k] === 0))) {
                            vacio = false;
                            break;
                        }
                        l++;
                    }
                    if (vacio) {
                        for (let k = j; k < j + l; k++) {
                            pf[i + 1][k] = pf[i][k];
                            pf[i][k] = 0;
                        }
                        j += l;
                        cambio = true;
                        salir = false;
                    }
                }
            }
        } */

        const tempFichas = fichas;

        tempFichas.map(ficha => {
            
            if (ficha.y < 19) {
                console.log(ficha)
                tempFichas.forEach((ficha1)=>{
                    
                    if(ficha.id !== ficha1.id){
                        if(ficha1.y===ficha.y+1){
                            
                            if(((ficha1.x<=ficha.x && 
                                ficha1.to>=ficha.x) || (ficha1.x<=ficha.to && ficha1.to<=ficha.to)) ){
                                /*  console.log('ficha1.x>=ficha.x'+ficha1.x>=ficha.x)
                                 console.log('ficha1.to<=ficha.x'+ficha1.to<=ficha.x)  */  
                                console.log('Puede bajar: '+JSON.stringify(ficha)+ ':: ficha debajo: '+JSON.stringify(ficha1))
                            } 

                        }
                    }
                })
            }
            //return ficha;
        })
        console.log(tempFichas)
        /// pasar del array a fichas
        if (cambio) {
            let MFichas = [];

            pf.forEach((fila, i) => {
                for (let j = 0; j < fila.length; j++) {
                    let Ficha = {};
                    if (fila[j] !== 0) {
                        let tipo = 0;
                        const id = fila[j];
                        let k = j;
                        do {
                            tipo++;
                            k++;
                        } while (fila[k] === 0);
                        Ficha = { id: id, pieza: tipo, x: j, y: i }
                        j += tipo + 1;
                        MFichas = MFichas.concat([Ficha])
                    }



                }
            })
           
            // setFichas(fichas=>MFichas);

        }
        

        actualizaFila(filas - min);

    }, [fichas])

    /*  useEffect(() => {
         if (nuevaFila.length !== 0) {
             const subeFichas = fichas.map((ficha) => {
                 ficha.y--
                 return ficha
             });
             setFichas(fichas => [...subeFichas, ...nuevaFila])
             console.log('sube fila ' + nuevaFila.length)
         }
         console.log('Nueva fila')
         console.log(fichas)
     }, [nuevaFila]) */
    /*    useEffect(() => {
     
           const intervalo = setInterval(() => {
               /// Sube las fichas en el tablero 1 posición
     
     
               //// Crea la nueva linea de Fichas
     
               actualizaSegundos(segundos + 1);
     
           }, 1000);
     
           return () => { clearInterval(intervalo) }
     
       }, []) */

    function handleMouseMove(indice, ficha) {
        actualizamOver(ficha + ', ' + indice);
    }

    /*   const handleOnClick = (e) => {
          let nFichas = [];
          let largoMax = 4;
     
          for (let index = 0; index < columnas; index++) {
     
              if ((columnas - index) < 5) { largoMax = index - columnas }
     
              if (largoMax > 0) {
                  const llevaFicha = Math.round(Math.random());
                  if (llevaFicha === 1) {
                      const tipoFicha = Math.round(Math.random() * largoMax) + 1;
                      const nPieza = tipoFicha;
                      const y = 19;
                      const x = index;
                      index += tipoFicha;
                      nFichas = nFichas.concat([{ pieza: nPieza, x: x, y: y }]);
                  }
              }
          }
          setNuevaFila(nFichas);
     
      }
    */



    return (
        <div className='juego'>
            {/* Dibuja fichas en tablero */}
            <div className='fichas'>
                {fichas.map((ficha, index) => (
                    <Pieza key={ficha.id} ficha={ficha.pieza} x={ficha.x} y={ficha.y}
                        onMouseMove={() => handleMouseMove(ficha.id, ficha.pieza)} />))}
            </div>
        </div>
    )
}
