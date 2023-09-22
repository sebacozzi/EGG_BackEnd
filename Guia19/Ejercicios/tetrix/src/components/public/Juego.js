import React, { useContext, useEffect, useRef, useState } from 'react'

import Pieza from './Pieza'
import CTanteador from '../Services/Contextos';
import { puedeBajar,  getFichas, eliminarFilaCompleta, creaFila} from '../Services/Metodos';
import Tablero from './Tablero';
import Test from './Test';
import { juegoGanado, juegoPerdido, jugando } from '../Constantes/Consts';


export default function Juego(props) {
    const {columnas,filas,estadoJuego, puntuacion, mouseUp, iniciaJuego, textos, ClienteX,
        actualiza } = useContext(CTanteador)
    
 
    // const [nivel, setNivel] = useState(1);
    


        
    const [first, setfirst] = useState(props.first)


    const idFicha = useRef(props.idFicha);
    const disponibleDerecha = useRef(props.columnas+1);
    const disponibleIzquierda = useRef(-1);
    const xActual = useRef(0)
    const posicionMouse = useRef(0)

    const [fichas, setFichas] = useState(props.tablero);
        /// agrega fila cuando se suelta el mouse
    useEffect(() => {
        
        const nuevaFila = creaFila(columnas, idFicha);
        const tempFichas = getFichas(fichas, 1);

        //// Carga la nueva linea de Fichas salvo que 
        if (fichas.length !== 0 && mouseUp) {
            setFichas([...tempFichas, ...nuevaFila]);
        }
       

    }, [mouseUp])
 
    const bajaFicha=(ficha)=>{
        ficha.y=ficha.y+1;
    }

    /// Hace caer las fichas y elimina fila completa 
    useEffect(() => {
              
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

        if (min === -1) {
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

            }, 10000);

            return () => { clearInterval(intervalo); }

        }

    }, [fichas]);




  
    function handleMouseDownJuego(e) {
       
        if (!mouseUp) {
            console.log('Ancho Ficha: ',props.anchoFicha)
            const dif = Math.trunc((e.clientX - posicionMouse.current) / props.anchoFicha);
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
        
        <div >
            
            
            <div className='baseConsola juego'  onMouseMove={handleMouseDownJuego} onMouseUp={handleMouseUpJuego}>
                {/* Dibuja fichas en tablero */}
                <div className='fichas'  >
                    {fichas.map((ficha, index) => (
                        <Pieza key={ficha.id} idf={ficha.id} ficha={ficha.pieza} x={ficha.x} y={ficha.y} anchoFicha={props.anchoFicha}
                            onMouseMove={(e) => handleMouseMove(e, ficha, index)}
                            onMouseDown={(e) => handleMouseDown(e, ficha, index)} 
                            onMouseUp={handleMouseUp} />))}
                </div>
            </div>
            
        </div>
        
    )
}
