import React, { useEffect, useState } from 'react'
import Boton from './Boton'
import { startApp } from '../Constantes/Consts';
import { NivelMaximo } from '../Constantes/Levels';

export default function Niveles(props) {
    const [min, setMin] = useState(0)
    const [max, setMax] = useState(16)
    const [desactibados, setDesactivados] = useState({ bBack: true, bNext: false, })

    const niveles = NivelMaximo;

    const nivelCompleto=(nivel)=>{
       if (nivel>=niveles){ return false}
        const niv = props.nivelesCompletos.filter((dato)=> (dato.nivel===nivel ))
        
       return niv.length===0;
    };

    const botonesNiveles = (min, max) => {
        let l = []
        for (let i = min; i < max; i++) {
            l[i] = <Boton key={i} tipo='redondeado' accion={()=>props.startNivel(i)} label={'nivel ' + (i + 1)} bloqueado= {nivelCompleto(i)} desactivado={i>=niveles} clase={'checklist'} />
        }
        return l
    }
    useEffect(() => {
        setDesactivados({ bNext: (max >= 64)||(max>=niveles), bBack: min <= 0, });
       
    }, [min, max])

    const handleBack = () => {
        setMin(min => min - 16);
        setMax(max => max - 16);

    };
    const handleNext = () => {
        setMin(min => min + 16);
        setMax(max => max + 16);


    };
    const atras = () => { props.estados(startApp) };

    return (
        <div className='App App-header'>
            <div style={{ position: 'absolute', display: '', top: '20px', right: '20px' }}>
                <Boton style={{ borderRadius: '5px' }} accion={atras} label={props.textos.tx_back} clase='arrow_back' />
            </div>

            <div className='modal' style={{ padding: '10px' }} >
                <Boton label={'back'} clase='arrow_back_ios' accion={handleBack} desactivado={desactibados.bBack} />
                <div className='grid grid-4' style={{ transform: 'scale(0.9)' }}>
                    {botonesNiveles(min, max)}
                </div>
                <Boton label={'next'} accion={handleNext} clase='arrow_forward_ios' desactivado={desactibados.bNext} />
            </div>


        </div>
    )
}
