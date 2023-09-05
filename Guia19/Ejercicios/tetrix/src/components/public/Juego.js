import React, { useContext, useEffect, useRef, useState } from 'react'
import './estilos.css'
import Pieza from './Pieza'
import CTanteador from '../Services/Contextos';
import { puedeBajar, getFicha, creaFicha, getFichas, sumaFichas, eliminarFilaCompleta } from '../Services/Metodos';
import Tablero from './Tablero';


export default function Juego() {
    const { filas, columnas, estadoJuego, puntuacion, mouseUp, iniciaJuego,
        actualizaFila,
        actualizaIniciaJuego,
        actualizaEstadoJuego,
        actualizaPuntuacion,
        actualizaMouseUp,
        actualizaFichasRestantes,
        actualizaMotivoEstadoJuego, } = useContext(CTanteador)

    // const [nivel, setNivel] = useState(1);



    const filasInicio = 4;
    const [first, setfirst] = useState(true)

    // const [nuevaFila, setNuevaFila] = useState([]);

    const idFicha = useRef(0);
    const disponibleDerecha = useRef(15);
    const disponibleIzquierda = useRef(-1);
    const xActual = useRef(0)
    const posicionMouse = useRef(0)

    const [fichas, setFichas] = useState([]);


    ////Crea fichas para iniciar Juego - Se crea una vez
    useEffect(() => {

        //setfirst(true)

        if (iniciaJuego) {
            let filasinicio = filasInicio
            let sumaFichas = 0;
            let nFichas = [];
            let fff = 20;
            let idFila = 19;
            do {


                let largoMax = 4;
                let lineaFichas = [];
                for (let iColumna = 0; iColumna < columnas; iColumna++) { /// recorre las columnas para cargar las fichas

                    if ((columnas - iColumna) < 5) { largoMax = iColumna - columnas } /// ajusta el ancho de la ficha para el final de la fila

                    if (largoMax > 0) {
                        const llevaFicha = Math.round(Math.random()) === 1; ///  Randomiza si va a cargar una ficha en esa columna
                        if (llevaFicha) {
                            // Crear ficha
                            idFicha.current = (lineaFichas.length + nFichas.length + 1);
                            const nf = creaFicha(iColumna, fff - 1, largoMax, idFicha);
                            iColumna += nf.pieza;
                            sumaFichas += nf.pieza;
                            lineaFichas = lineaFichas.concat([nf]);

                        }
                    }
                }

                if (lineaFichas.length !== 0) {

                    nFichas = nFichas.concat(lineaFichas);
                    nFichas.forEach(element => {
                        if (element.y < fff) fff = element.y;
                    });

                }


            } while (fff >= (20 - filasInicio));
            setFichas(nFichas);
            setfirst(false);
            actualizaIniciaJuego(false)
            actualizaEstadoJuego(0)
        }

    }, [iniciaJuego])



    /// Hace caer las fichas y elimina fila completa 
    useEffect(() => {
        let min = 20;

        /// Hacer caer fichas
        let tempFichas = getFichas(fichas);
        let actualizo = false;

        if (mouseUp) {

            do {
                actualizo = false;
                tempFichas.map(ficha => {
                    if (ficha.y < 19) {
                        /// modifica ficha para abajo
                        if (puedeBajar(tempFichas, ficha)) {
                            ficha.y = ficha.y + 1;
                            //// Limpia la fila completada
                            if (!puedeBajar(tempFichas, ficha) || ficha.y === 19) {
                                setFichas(tempFichas)
                                setTimeout(() => {
                                    setFichas(tempFichas)
                                    const [Fichas, puntos] = eliminarFilaCompleta(tempFichas, filas);
                                    setFichas(Fichas)
                                    actualizaPuntuacion(puntuacion + puntos)
                                }, 200);
                            } else {
                                setTimeout(()=>{setFichas(tempFichas)},200)
                            }
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


        if ((filas - min === 0)) { actualizaEstadoJuego(2) };
        actualizaFichasRestantes(fichas.length)
        if (filas - min === 20) {
            actualizaEstadoJuego(1);
            actualizaMotivoEstadoJuego(0);
        }
        actualizaFila(filas - min);
    }, [fichas, first]);



    //// Agrega nueva fila pasado un tiempo
    useEffect(() => {

        if (estadoJuego === 0 && !first) {
            const intervalo = setInterval(() => {
                /// Sube las fichas en el tablero 1 posición


                let reintentos = 0
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
                                const nf = creaFicha(iColumna, 19, largoMax, idFicha);
                                iColumna += nf.pieza - 1;
                                lineaFichas = lineaFichas.concat([nf]);

                            }
                        }
                    }

                    if (lineaFichas.length === 0) {
                        iFilas = true;
                    } else if ((sumaFichas([...fichas, ...lineaFichas]) % 15 !== 0)) {
                        reintentos++;
                        if (reintentos !== 11) {
                            lineaFichas = [];
                            iFilas = true;
                        }
                    }
                } while (iFilas);
                /// Sube las fichas
                const tempFichas = getFichas(fichas, 1);


                //// Carga la nueva linea de Fichas salvo que 
                if (fichas.length !== 0) {
                    setFichas([...tempFichas, ...lineaFichas]);
                } else {
                    if (fichas.length === 0 && estadoJuego === 0) {
                        actualizaEstadoJuego(2)
                        return (clearInterval(intervalo));
                    }
                }

            }, 1500);

            return () => { clearInterval(intervalo); }

        }


    }, [fichas])

    function handleMouseDownJuego(e) {


        if (!mouseUp) {

            const dif = Math.trunc((e.clientX - posicionMouse.current) / 30);
            const x = xActual.current.f;
            const i = xActual.current.ind;
            const pieza = xActual.current.p;
            if ((x + dif) >= disponibleIzquierda.current && (x + dif + pieza - 1) <= disponibleDerecha.current) {
                const nFichas = [...fichas];
                nFichas[i].x = x + dif;
                nFichas[i].to = x + dif + pieza - 1;

                //setFichas(nFichas);
            }
        }
    }

    function handleMouseMove(e, ficha, i) {

        /* actualizamOver(JSON.stringify(ficha)) */
    }


    function handleMouseDown(e, ficha, i) {

        actualizaMouseUp(false)
        let dispIzq = -1;
        let dispDer = 15;

        posicionMouse.current = e.clientX;

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

    };

    function handleMouseUp(e) { }

    function handleMouseUpJuego(e) {

        actualizaMouseUp(true);
    }

    useEffect(() => {
        if (mouseUp) {
            const d = [...fichas];
            setFichas(d);
        }

    }, [mouseUp])


    return (
        <div className='App-header'>
            <Tablero />
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
        </div>
    )
}
