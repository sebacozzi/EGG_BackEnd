import React, { useState } from 'react'
import Opcion from './Opcion'


export default function Opciones(props) {
  const [valor, setVal] = useState(props.default);

  const handleOnClick = (val) => {
    props.setValor(val)
    setVal(val);
  }

  return (
    <div >
      <div className='opciones'>
        <div style={{
          top: '50%',
          transform: 'translateY(30%)',
        }}>{props.titulo}</div>
        {
          props.disp.map((d,i) => 
            <Opcion
            key={i}
            id={i}
            nombre={d.nombre}
            value={d.value}
            onClick={() => handleOnClick(d.value)}
            checked={d.value === valor}
            img={d.img}
            bgcolor={d.bgcolor}
            text={d.text}
            />
          )
        }

      </div>
    </div>

  )
}
