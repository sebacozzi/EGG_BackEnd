import React, { useContext, useEffect, useRef, useState } from 'react'

import Pieza from './Pieza'
import CTanteador from '../Services/Contextos';
import { puedeBajar,  getFichas, eliminarFilaCompleta, creaFila, generateCombinations } from '../Services/Metodos';
import Tablero from './Tablero';
import Test from './Test';
import { useForceUpdate } from './../Hooks/useForceUpdate';
import { juegoGanado, juegoPerdido, jugando } from '../Constantes/Consts';


export default function Juego(props) {
    const { filas, columnas, estadoJuego, puntuacion, mouseUp, iniciaJuego, textos,
        actualiza } = useContext(CTanteador)

        const forceUpdate = useForceUpdate();
    // const [nivel, setNivel] = useState(1);
    const [combinations, setCombinations] = useState([]);


    const filasInicio = 4;
    const [first, setfirst] = useState(props.first)

    // const [nuevaFila, setNuevaFila] = useState([]);

    const idFicha = useRef(0);
    const disponibleDerecha = useRef(15);
    const disponibleIzquierda = useRef(-1);
    const xActual = useRef(0)
    const posicionMouse = useRef(0)

    const [fichas, setFichas] = useState(props.tablero);
        /// agrega fila cuando se suelta el mouse
    useEffect(() => {
       
        console.log('mouseUp: ' + JSON.stringify(fichas))
        const nuevaFila = creaFila(columnas, idFicha);
        const tempFichas = getFichas(fichas, 1);

        //// Carga la nueva linea de Fichas salvo que 
        if (fichas.length !== 0 && mouseUp) {
            setFichas([...tempFichas, ...nuevaFila]);
        }
       

    }, [mouseUp])

    useEffect(()=>{
        setFichas(props.tablero);
    },[])
    ////Crea fichas para iniciar Juego - Se crea una vez
    useEffect(() => {
        console.log('iniciaJuego: '+iniciaJuego)
        

            let nFichas = [];
            let fff = 0;
            do {
                nFichas = nFichas.concat(creaFila(columnas, idFicha, filas - fff));
                fff++;
            } while (fff < filasInicio);
            console.log('props.tablero: '+ JSON.stringify(props.tablero))
            setFichas(props.tablero);
            setfirst(false);
            actualiza.IniciaJuego(false)
        

    }, [])
 

    const bajaFicha=(ficha)=>{
        ficha.y=ficha.y+1;
    }

    /// Hace caer las fichas y elimina fila completa 
    useEffect(() => {
       
        console.log('useEffect Fichas: '+ JSON.stringify(fichas));
        /// Hacer caer fichas
        
        
        if (mouseUp) {
            let tempFichas = getFichas(fichas);
            let actualizo = false;
            do {
                actualizo = false;
                tempFichas.map(ficha => {
                    if (ficha.y < filas - 1) {
                       
                        if (puedeBajar(tempFichas, ficha)) {
                            bajaFicha(ficha);
                            
                            if (!puedeBajar(tempFichas, ficha) || ficha.y === filas - 1) {
                                setFichas(tempFichas)
                                setTimeout(() => {

                                    const [Fichas, puntos] = eliminarFilaCompleta(tempFichas, filas, columnas);
                                    setFichas(Fichas)
                                    actualiza.Puntuacion(puntuacion + puntos)
                                }, 400);
                            } else {
                                setTimeout(() => { setFichas(tempFichas) }, 200)
                            }
                            actualizo = true;
                        }
                    }
                })
            } while (actualizo);

        }
        let min = filas;
        /// Actualiza la cantidad de filas ocupadas
        fichas.forEach(element => {
            if (element.y < min) min = element.y;

        });
        /* setCombinations(generateCombinations(sumaFichas(fichas) % 15, [1, 2, 3, 4, 5])); */
      
        if ((filas - min === 0 && !first)) { actualiza.EstadoJuego(juegoGanado)};

        actualiza.FichasRestantes(fichas.length)

        if (filas - min === filas) {
            actualiza.EstadoJuego(juegoPerdido);
            actualiza.MotivoEstadoJuego(textos.tx_fin_perdio[1]);
        }
        actualiza.FilasOcupadas(filas - min);
  
        //// Agrega nueva fila pasado un tiempo
   
        if (estadoJuego === jugando && !first) {
            const intervalo = setInterval(() => {

                const nuevaFila = creaFila(columnas, idFicha, filas);

                //idFicha.current = idFicha.current + nuevaFila.length;
                const tempFichas = getFichas(fichas, 1);
                //// Carga la nueva linea de Fichas salvo que 
                if (fichas.length !== 0) {
                    setFichas([...tempFichas, ...nuevaFila]);
                } else {
                    if (fichas.length === 0 && estadoJuego === jugando) {
                        actualiza.EstadoJuego(juegoGanado)
                        return (clearInterval(intervalo));
                    }
                }

            }, 1000);

            return () => { clearInterval(intervalo); }

        }

    }, [fichas]);




  
    function handleMouseDownJuego(e) {
        if (!mouseUp) {

            const dif = Math.trunc((e.clientX - posicionMouse.current) / 40);
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

        /* actualizamOver(JSON.stringify(ficha)) */
    }


    function handleMouseDown(e, ficha, i) {

        actualiza.MouseUp(false)
        let dispIzq = -1;
        let dispDer = columnas;

        posicionMouse.current = e.clientX;

        const fizq = fichas.filter((f) => ((f.y === ficha.y) && (f.id !== ficha.id)) && f.to < ficha.x)

        if (fizq.length !== 0) {

            fizq.forEach((f) => { if (f.to >= dispIzq) dispIzq = f.x + f.pieza })
        } else dispIzq = 0;

        const fder = fichas.filter((f) => (f.y === ficha.y) && (f.id !== ficha.id) && f.x > ficha.to);

        if (fder.length !== 0) {

            fder.forEach((f) => { if (f.x <= dispDer) dispDer = f.x - 1 })
        } else dispDer = columnas - 1;
        xActual.current = { f: ficha.x, ind: i, p: ficha.pieza };
        disponibleDerecha.current = dispDer;
        disponibleIzquierda.current = dispIzq;

    };

    function handleMouseUp(e) { }

    function handleMouseUpJuego(e) {

        actualiza.MouseUp(true);
    }

    useEffect(() => {
        if (mouseUp) {
            const d = [...fichas];
            setFichas(d);
        }

    }, [mouseUp])


    return (
        <div className='App-header'>
            <Tablero columnas={columnas} filas={filas} />
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
            <Test combinaciones={combinations} />
        </div>
    )
}
