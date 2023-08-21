import React from 'react'

const Carta = ({ carta , id}) => {
    const altmsg=`Imagen de ${carta.name}`;
    
    return (
        <div className="card" >
            <img className="card-img-top" style={{"width":"80%","margin-left":"10%","margin-top":"2%"}} src={carta.image} alt={altmsg}/>
        <div className="card-body">
            <h4 className="card-title">{carta.name} ({id})</h4>
            <p className="card-text">Origen: {carta.origin.name}</p>
            <p className="card-text">Localización: {carta.location.name}</p>
            <p className="card-text">Creado: {new Date(carta.created).getFullYear()}</p>
            
        <a href="#" className="btn btn-primary">ver Perfil completo</a>
        <span style={{"align-text":"rigth"}}>{id}</span>
  </div>
</div>
      
    )
}

export default Carta
