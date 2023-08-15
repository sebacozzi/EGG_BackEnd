import React from 'react'

const Carta = ({ cart }) => {

    console.log(cart)
    return (
        <div class="card" >
            <img class="card-img-top" src={cart.image} alt="Card image"/>
        <div class="card-body">
            <h4 class="card-title">{cart.name}</h4>
            <p class="card-text">Origen: {cart.origin.name}</p>
            <p class="card-text">Localización: {cart.location.name}</p>
            <p class="card-text">Creado: {new Date(cart.created).getFullYear()}</p>
        <a href="#" class="btn btn-primary">ver Perfil completo</a>
  </div>
</div>
      
    )
}

export default Carta
