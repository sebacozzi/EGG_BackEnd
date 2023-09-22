import React, { useContext, useEffect, useState } from 'react'
import ContextoJuego from '../../Services/ContextoJuego'

import BotonesOpcion from '../BotonesOpcion'
import Opciones from './opcionLeng/Opciones'
import { getNombresIdiomas, texto } from '../../Constantes/Lenguaje'

export default function FormOpciones(props) {
  // constantes de uso privado
  const colorDificultad=['#008000','#ffff00','#ffa500','#ff0000'];
  
  const { dificultad, ln, updateOpciones } = useContext(ContextoJuego)

  const [te, setTe] = useState(texto(ln))
  const [idiomas, setIdiomas] = useState([]);
  const [traduc, setTraduc] = useState(ln);
  const [difi,setDifi] = useState(0);
  const [opDificultad,setOpDificultad]=useState([]);
  /*  console.log('Idiomas en FormOpciones')
   console.log(idiomas) */

   const mString=(i)=>{let r='*'; for(let j=0;j<i;j++){r+='*'}; return r;}

  useEffect(() => {
    setTe(texto(traduc));
    setOpDificultad(te.tx_dificultad.map((d,i)=>{return {text:mString(i),bgcolor:colorDificultad[i],value:i}}));
  }, [traduc])
  
  /// establece los valores iniciales
  useEffect(()=>{
    setIdiomas(getNombresIdiomas())
  },[])
  
  const guardar = () => {
    updateOpciones.ln(traduc);
    updateOpciones.dificultad(difi);
  props.accion(props.sender) };

  const cancelar = () => {props.accion(props.sender)};

  return (
    <div className='modal' style={{ backgroundColor: 'ActiveCaption', padding: '10px', display: 'block', minWidth:'400px' }}>
      <div style={{ display: 'grid', gridAutoFlow: 'column' }}>
        <div style={{ display: 'flex' }}>
          <div style={{ padding: '10px' }}>
            <Opciones titulo={te.tx_dif} disp={opDificultad} setValor={setDifi} default={dificultad} />
            <p>Detalle de dificultad: <br/>
              <div style={{textAlign:'justify'}}><b>{te.tx_dificultad[difi]}</b>: {te.tx_detalle_dificultad[difi]}</div></p>
          </div>
        </div>
      </div>
      <div>
        <Opciones titulo={te.tx_idioma} disp={idiomas} setValor={setTraduc} default={ln} />
      </div>

      <div className='contenedor-derecha'>
        <div style={{  fontSize: '0.7em' }}>
          <BotonesOpcion accion={[guardar, cancelar]} label={[te.tx_guarda, te.tx_cancelar]} clase={['save', 'cancel']} />
        </div>
      </div>
    </div>
  )
}
