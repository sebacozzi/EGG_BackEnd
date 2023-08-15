import React from 'react'
import Carta from './Carta'

const Cartas = (props) => {
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

export default Cartas
