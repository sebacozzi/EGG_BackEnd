import React, { useContext, useEffect, useRef, useState } from 'react'
import './estilos.css'
import Pieza from './Pieza'
import CTanteador from '../Services/Contextos';
import { eventWrapper } from '@testing-library/user-event/dist/utils';

export default function Juego() {
    const { mOver, segundos, filasOcupadas, actualizaFila, actualizaSegundos, actualizamOver } = useContext(CTanteador)

    // const [nivel, setNivel] = useState(1);

    const filas = 20;
    const columnas = 15;
    const puedeActualizar= useRef(true)
    const filasInicio = 4;
    const [first, setfirst] = useState(true)

    // const [nuevaFila, setNuevaFila] = useState([]);

    const idFicha = useRef(0);
    const disponibleDerecha= useRef(15);
    const disponibleIzquierda= useRef(-1);
    const xActual =useRef(0)
    const posicionMouse=useRef(0)

    const [fichas, setFichas] = useState([]);

    /// crea la cantidad filas
    function creaFicha(fx, fy, maximo) {
        const id = idFicha.current;
        const nPieza = Math.round(Math.random() * maximo) + 1;
        const to = fx + (nPieza - 1);
        idFicha.current = (idFicha.current + 1);
        return { id: id, pieza: nPieza, x: fx, y: fy, to: to };

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
                            idFicha.current = (lineaFichas.length + nFichas.length + 1);
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

        /// Hacer caer fichas
        let tempFichas = fichas.slice();
        let actualizo;


        if(puedeActualizar){
        do {
            actualizo = false;
             tempFichas.map(ficha => {
                if (ficha.y < 19) {
                    const fichasdebajo= tempFichas.filter((f)=>f.y === ficha.y+1)
                    const noTieneAbajo = fichasdebajo.every((ficha1) => {
                        if (ficha.id !== ficha1.id) {
                                if(ficha1.y === ficha.y + 1)
                                if ( 
                                    ((ficha1.x <= ficha.x && ficha1.to >= ficha.x) || (ficha1.x <= ficha.x && ficha1.to >= ficha.x)) ||
                                    ((ficha.x <=ficha1.x && ficha.to>= ficha1.x) || (ficha.x<=ficha1.x && ficha.to >= ficha1.x))
                                    ) {
                                    return false;
                                }
                        }
                        return true;
                    })
                    if (noTieneAbajo) {
                        ficha.y = ficha.y + 1;
                        actualizo = true;
                    }
                }
            })
        } while (actualizo);
        }
        fichas.forEach(element => {
            if (element.y < min) min = element.y;

        });
        actualizaSegundos(fichas.length)
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
      
    function handleMouseMove(e, ficha,i) {
      if (!puedeActualizar.current){  
        const dif = Math.trunc(ficha.x)+(e.clientX -posicionMouse.current )/30;

        console.log(dif);
        
        const nFichas=[...fichas];

        nFichas[i].x=  dif;
        nFichas[i].to= nFichas.x + nFichas.pieza;

        setFichas(nFichas);
       
       
       
       
        /*  
       
       if(dif === 0){
            ficha.x = xActual.current;

        } else if(dif<0){ficha.x = xActual.current-dif}else{ficha.x=xActual.current+dif} */
       // console.log(disponibleIzquierda.current + " dddd "+ disponibleDerecha.current)
      }
    }


    function handleMouseDown(e,ficha){
        let dispIzq=-1;
        let dispDer=15;
        puedeActualizar.current=false;
        posicionMouse.current=e.clientX;
       
        actualizamOver(ficha.id + ', ' + ficha.pieza);
        
        const fizq =fichas.filter((f)=> ((f.y === ficha.y) && (f.id!==ficha.id)) && f.to<ficha.x)
        
        if(fizq.length!==0){
            
            fizq.forEach((f)=>{if(f.to >= dispIzq) dispIzq=f.x+f.pieza})
        } else dispIzq=0;
        
        const fder=fichas.filter((f)=> (f.y === ficha.y) && (f.id!==ficha.id) && f.x>ficha.to);
        
        if(fder.length!==0){
            
            fder.forEach((f)=>{if(f.x <= dispDer) dispDer=f.x-1})
        } else dispDer=14;
        xActual.current=ficha.x;
        disponibleDerecha.current=dispDer;
        disponibleIzquierda.current=dispIzq;
    };

    function handleMouseUp(e){
        puedeActualizar.current= true;
        console.log(puedeActualizar.current);
    }


    return (
        <div className='juego'>
            {/* Dibuja fichas en tablero */}
            <div className='fichas'>
                {fichas.map((ficha, index) => (
                    <Pieza key={ficha.id} idf={ficha.id} ficha={ficha.pieza} x={ficha.x} y={ficha.y}
                        onMouseMove={(e)=>handleMouseMove(e,ficha,index)} 
                        onMouseDown={(e)=>handleMouseDown(e,ficha)}
                        onMouseUp={handleMouseUp}/>))}
            </div>
        </div>
    )
}