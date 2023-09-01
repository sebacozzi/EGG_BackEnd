import React, { useContext, useEffect, useRef, useState } from 'react'
import './estilos.css'
import Pieza from './Pieza'
import CTanteador from '../Services/Contextos';
import { eventWrapper } from '@testing-library/user-event/dist/utils';

export default function Juego() {
    const { estadoJuego, actualizaFila, actualizaSegundos, actualizamOver, actualizaEstadoJuego } = useContext(CTanteador)

    // const [nivel, setNivel] = useState(1);

    const filas = 20;
    const columnas = 15;
    const puedeActualizar = useRef(true)
    const filasInicio = 4;
    const [first, setfirst] = useState(true)

    // const [nuevaFila, setNuevaFila] = useState([]);

    const idFicha = useRef(0);
    const disponibleDerecha = useRef(15);
    const disponibleIzquierda = useRef(-1);
    const xActual = useRef(0)
    const posicionMouse = useRef(0)

    const [fichas, setFichas] = useState([]);

    /// crea la cantidad filas
    function creaFicha(fx, fy, maximo) {
        const id = idFicha.current;
        const nPieza = Math.round(Math.random() * maximo) + 1;
        const to = fx + (nPieza - 1);
        idFicha.current = (idFicha.current + 1);
        const puntos = nPieza*nPieza;
        return { id: id, pieza: nPieza, x: fx, y: fy, to: to, puntos: puntos };

    }

    /// crea una copia nueva de fichas
    function getFichas(listaFichas) {
        let tempFichas = [];
        listaFichas.forEach((ficha) => {
            tempFichas = [...tempFichas, getFicha(ficha, 0)];
        })
        return tempFichas;
    }

    function getFicha(ficha, incrementoY = 0) {
        const id = ficha.id;
        const nPieza = ficha.pieza;
        const x = ficha.x;
        const y = ficha.y - incrementoY;
        const to = ficha.to;

        return { id: id, pieza: nPieza, x: x, y: y, to: to };
    }

    function eliminarFilaCompleta(listaFichas) {

        let tempFichas = [];
        for (let index = 0; index < filas; index++) {
            const fila = listaFichas.filter((f) => f.y === index);

            if (fila.length !== 0) {
                let suma = 0;
                fila.forEach(f => {
                    suma += f.pieza;
                });
                if (suma !== 15) {
                    tempFichas = tempFichas.concat(fila);
                } else {
             }
            }
        }
        return tempFichas;
    }

    //// Verifica si la ficha puede bajar
    function puedeBajar(listaFichas,ficha){
        const fichasdebajo = listaFichas.filter((f) => f.y === ficha.y + 1)
        return  fichasdebajo.every((ficha1) => {
            if (ficha.id !== ficha1.id) {
                if (ficha1.y === ficha.y + 1)
                    if (
                        ((ficha1.x <= ficha.x && ficha1.to >= ficha.x) || (ficha1.x <= ficha.x && ficha1.to >= ficha.x)) ||
                        ((ficha.x <= ficha1.x && ficha.to >= ficha1.x) || (ficha.x <= ficha1.x && ficha.to >= ficha1.x))
                    ) {
                        return false;
                    }
            }
            return true;
        })
    }

    ////Crea fichas para iniciar Juego - Se crea una vez
    useEffect(() => {

        if (first) {
            let filasinicio=filasInicio
            let sumaFichas=0;
            let nFichas = [];
            for (let iFilas = 19; iFilas > filas - (filasinicio + 1); iFilas--) {/// recorre las filas
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
                            sumaFichas+=nf.pieza;
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



    /// Hace caer las fichas y elimina fila completa 
    useEffect(() => {
        let min = 20;

        /// Hacer caer fichas
        let tempFichas = getFichas(fichas);
        let actualizo=false;
       
        if (puedeActualizar.current) {

            do {
                actualizo = false;
                tempFichas.map(ficha => {
                    if (ficha.y < 19) {
                        
                        /// modifica ficha para abajo
                        if (puedeBajar(tempFichas,ficha)) {
                            ficha.y = ficha.y + 1;
                            
                           
                           //// Limpia la fila completada
                            if(!puedeBajar(tempFichas,ficha)|| ficha.y===19){
                                tempFichas = eliminarFilaCompleta(tempFichas);
                                setFichas(tempFichas);
                            }else { setFichas(tempFichas)}
                            actualizo = true;
                           
                            
                        }
                    }
                })
            } while (actualizo);
         
    }
        /// Actualiza la cantidad de filas ocupadas
        fichas.forEach(element => {
            if (element.y < min) min = element.y;

        });
        if ((filas - min === 0) && !first) { actualizaEstadoJuego(2) };
        actualizaFila(filas - min);
    }, [fichas]);


    //// Agrega nueva fila pasado un tiempo
    useEffect(() => {

        if (estadoJuego === 0) {
            const intervalo = setInterval(() => {
                /// Sube las fichas en el tablero 1 posición

                if (!first) {
                    let iFilas;
                    let lineaFichas = [];
                    do {
                        iFilas = false;

                        let largoMax = 4;

                        for (let iColumna = 0; iColumna < columnas; iColumna++) { /// recorre las columnas para cargar las fichas

                            if ((columnas - iColumna) < 5) { largoMax = iColumna - columnas } /// ajusta el ancho de la ficha para el final de la fila

                            if (largoMax > 0) {
                                const llevaFicha = Math.round(Math.random()) === 1; ///  Randomiza si va a cargar una ficha en esa columna
                                if (llevaFicha) {
                                    // Crear ficha
                                    idFicha.current = idFicha.current + 1;
                                    const nf = creaFicha(iColumna, 19, largoMax);
                                    iColumna += nf.pieza;
                                    lineaFichas = lineaFichas.concat([nf]);

                                }
                            }
                        }

                        if (lineaFichas.length === 0) {
                            iFilas = true;
                        }
                    } while (iFilas);
                    /// Sube las fichas
                    let tempFichas = [];
                    fichas.forEach((ficha) => {

                        if (ficha.y === 0) {
                            actualizaEstadoJuego(1)
                            return (clearInterval(intervalo));
                            ;
                        }

                        tempFichas = [...tempFichas, getFicha(ficha, 1)];

                    })


                    //// Carga la nueva linea de Fichas
                    setFichas([...tempFichas, ...lineaFichas]);

                    //// Crea la nueva linea de Fichas

                    actualizaSegundos("aniade fila");
                }
            }, 3000);

            return () => { clearInterval(intervalo); }

        }


    }, [fichas])

    function handleMouseDownJuego(e) {
        actualizaSegundos(e.clientX);
        if (!puedeActualizar.current) {

            const dif = Math.trunc((e.clientX - posicionMouse.current) / 30);
            const x = xActual.current.f;
            const i = xActual.current.ind;
            const pieza = xActual.current.p;
            if ((x + dif) >= disponibleIzquierda.current && (x + dif + pieza - 1) <= disponibleDerecha.current) {
                const nFichas = [...fichas];
                nFichas[i].x = x + dif;
                nFichas[i].to = x + dif + pieza - 1;

                setFichas(nFichas);
            }
        }
    }

    function handleMouseMove(e, ficha, i) {
 
        actualizamOver(JSON.stringify(ficha))
    }


    function handleMouseDown(e, ficha, i) {
        let dispIzq = -1;
        let dispDer = 15;
        puedeActualizar.current = false;
        posicionMouse.current = e.clientX;

        actualizamOver(ficha.id + ', ' + ficha.pieza);

        const fizq = fichas.filter((f) => ((f.y === ficha.y) && (f.id !== ficha.id)) && f.to < ficha.x)

        if (fizq.length !== 0) {

            fizq.forEach((f) => { if (f.to >= dispIzq) dispIzq = f.x + f.pieza })
        } else dispIzq = 0;

        const fder = fichas.filter((f) => (f.y === ficha.y) && (f.id !== ficha.id) && f.x > ficha.to);

        if (fder.length !== 0) {

            fder.forEach((f) => { if (f.x <= dispDer) dispDer = f.x - 1 })
        } else dispDer = 14;
        xActual.current = { f: ficha.x, ind: i, p: ficha.pieza };
        disponibleDerecha.current = dispDer;
        disponibleIzquierda.current = dispIzq;
        actualizaSegundos('Izquierda: ' + dispIzq + ' Derecha: ' + dispDer)
    };

    function handleMouseUp(e) { }

    function handleMouseUpJuego(e) {
        puedeActualizar.current = true;
        const d = [...fichas];
        setFichas(d);


    }


    return (
        <div className='juego' onMouseMove={handleMouseDownJuego} onMouseUp={handleMouseUpJuego}>
            {/* Dibuja fichas en tablero */}
            <div className='fichas' >
                {fichas.map((ficha, index) => (
                    <Pieza key={ficha.id} idf={ficha.id} ficha={ficha.pieza} x={ficha.x} y={ficha.y}
                        onMouseMove={(e) => handleMouseMove(e, ficha, index)}
                        onMouseDown={(e) => handleMouseDown(e, ficha, index)}
                        onMouseUp={handleMouseUp} />))}
            </div>
        </div>
    )
}
