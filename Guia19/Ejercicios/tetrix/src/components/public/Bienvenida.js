import React from 'react'
import BotonesOpcion from './BotonesOpcion'
import { config,niveles } from '../Constantes/Consts';

export default function Bienvenida(props) {

    const opciones =()=>{ props.estados(config)};
    const nivels =()=>{ props.estados(niveles)};
    const acerca =()=>{};

  return (
    <div className='App App-header' >
      <div style={{width:'75%',display:'grid',gridTemplateColumns:'calc(4,400px)'}}>
        <h1>Bienvenidos al Puzzle</h1>
         <BotonesOpcion 
         accion={[opciones,nivels,acerca]} 
         clase={['settings','list','info']} 
         label={['Opciones','Niveles','Acerca']} 
         desactivado={[false,false,true]} />
      </div>
    </div>
  )
}
