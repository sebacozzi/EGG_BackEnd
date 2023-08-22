import React, { useEffect, useState } from 'react'
import RickAndMortyService from '../../services/RM_Service';
import { useParams, Link } from 'react-router-dom';


const Detalle = () => {

  const { id } = useParams();

  const [detalle, setDetalle] = useState(null);

  
  

  useEffect(() => {
   
    RickAndMortyService.getPersonaje(id)
      .then((data) =>
        setDetalle(data))
      .catch((error) => console.log('Hola: '+error));
  }, [detalle]);
  if(detalle == null){ return null};
  //const altmsg=`Imagen de ${detalle.name}`; 
  //const altmsg=`Imagen de `;
  
  
  return (
   
    <div className='cuerpo-scroll'>
      
      <h1>Detalle de personaje {detalle.name}</h1>
      
       <div className="card" >
       <img className="card-img-top" style={{ "width": "30%", "margin-left": "10%", "margin-top": "2%" }} src={detalle.image} alt='altmsg' />
        <div className="card-body">
          <h4 className="card-title">{detalle.name} ({id})</h4>
          <p className="card-text">Origen: {detalle.origin.name}</p>
          <p className="card-text">Localización: {detalle.location.name}</p>
          <p className="card-text">Creado: {new Date(detalle.created).getFullYear()}</p>
        </div>
      </div>

      
    </div> 
  )
}

export default Detalle
