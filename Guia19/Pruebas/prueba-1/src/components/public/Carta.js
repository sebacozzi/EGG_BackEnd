import React from 'react'
import { Link } from 'react-router-dom';

const Carta = ({ carta , id}) => {
   //const id = key;
    const altmsg=`Imagen de ${carta.name}`;
    const enlace=`/detalle/${id}`;
    return (
        <div className="card" >
            <img className="card-img-top" margintop={'2%'} marginleft={'10%'} style={{"width":"80%"}} src={carta.image} alt={altmsg}/>
        <div className="card-body">
            <h4 className="card-title">{carta.name} ({id})</h4>
            <p className="card-text">Origen: {carta.origin.name}</p>
            <p className="card-text">Localización: {carta.location.name}</p>
            <p className="card-text">Creado: {new Date(carta.created).getFullYear()}</p>
            
        <Link to={enlace} className="btn btn-primary">ver Perfil completo</Link>
        
  </div>
</div>
      
    )
}

export default Carta
