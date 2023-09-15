import React from 'react'

export default function Opcion(props) {

  const r= 'star_rate';
const stars=[<div>{r}</div>,
<div>{r}{r}</div>,
<div>{r}<br/>{r}{r}</div>,
<div>{r}{r}<br/>{r}{r}</div>,
]

  function calcularColorOpuesto(colorDeFondo) {
    // Convierte el color de fondo a RGB
    let r = colorDeFondo.slice(1, 3);
    let g = colorDeFondo.slice(3, 5);
    let b = colorDeFondo.slice(5, 7);
    
    r = Math.abs((parseInt(r,16)-255)).toString(16);
    g = Math.abs((parseInt(g,16)-255)).toString(16);
    b =Math.abs((parseInt(b,16)-255)).toString(16);
    return '#'+r+g+b;
  }

  return (
    <div  key={props.id}
      className={`opcion ${props.checked ? 'seleccionada' : ''}`}
      onClick={() => props.onClick(props.value)}
    >
      {props.text && (
      <div >
        {props.bgcolor && (
          <div
            style={{
              backgroundColor: props.bgcolor,
              position: 'absolute',
              top: 0,
              left: 0,
              width: '100%',
              height: '100%',
              zIndex:-1,
            }}
          ></div>
        )}
        {/* { props.text!='star' ? <span 
        style={{ color: `${calcularColorOpuesto(props.bgcolor)}`,
        zIndex:'1',
        transform:`${props.checked ? 'scale(1.7) translate(1px,2px)':'scale(1.7) translate(0px,1px)'}`}}>{props.text}</span> 
        : */}
        <span className="material-symbols-outlined" 
        style={{/* transform:'scale(0.5)', */
        transform:`${props.checked ? 'scale(0.5) translate(1px,2px)':'scale(0.5) '}`,
        top:'0',
        left:'0',
        height:'100%',
        width:'100%',
        position:'absolute',
        
        display:'grid',
        textAlign:'center',
        alignContent:'center',
        alignItems:'center',}}>{stars[props.id]}</span>{/* } */}
      </div>
    )}
      {(props.bgcolor && !props.text)  &&(<img style={{backgroundColor:`${props.bgcolor}`}}/>)} 
      
     {props.img && (<img src={props.img} />)

     } 
    </div>
  )
}
