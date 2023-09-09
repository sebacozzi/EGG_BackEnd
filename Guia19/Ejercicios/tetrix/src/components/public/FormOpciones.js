import React from 'react'

export default function FormOpciones() {
    const modal= {
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
        boxShadow: 'rgba(100, 100, 111, 0.3) 0px 7px 29px 0px',
        backgroundColor: '#0f0f0fbe',
        border: '2px solid rgb(240, 240, 240)',
        borderRadius: '18px',
        position:  'absolute',
        padding:'00px',
        top: '50%',
        left:'50%',
        transform:'translate(-50%,-50%)',
        //left: 'calc(20%)',
        //bottom: '70px',
        zIndex:'1000',
        
      };
  return (
    <div style={modal}>
      
    </div>
  )
}
