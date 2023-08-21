import React, { useEffect, useState } from 'react'
import Carta from './Carta'
import RickAndMortyService from '../../services/RM_Service'

const Cartas = () => {

    // Inicialización del useState
    const [cartas, setCartas]= useState([]);

    // Obtiene los datos del API
    useEffect(()=>{
      RickAndMortyService.getTodosLosPersonajes()
      .then((data)=>
      setCartas( data.results))
      .catch((error)=>console.log(error));
    },[cartas]);
    
    // Crea la lista de cartas
    const lista = cartas.map((c)=><Carta carta={c} id={c.id}/>);

    return (
        <div className='album py-5 bg-light'>
            <div className="container">
                <div className='row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3'>
                    {lista}
                </div>
            </div>
            
        </div>
    )
}

/// Pasados los parametros por props
/* const Cartas = (props) => {
    const lista = props.datos.map((c)=><Carta cart={c} key={c.id}/>);
    console.log(props);
    return (
        <div className='album py-5 bg-light'>
            <div className="container">
                <div className='row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3'>
                    {lista}
                </div>
            </div>
            
        </div>
    )
}
 */
export default Cartas
