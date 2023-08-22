import React, { Component, useEffect, useState } from 'react'
import Cartas from './Cartas';
import RickAndMortyService from '../../services/RM_Service'


function Main () {

  /* componentDidMount(){
    RickAndMortyService.getTodosLosPersonajes()
    .then((data)=>
    this.setState({ cartas : data.results}));
  } */

   {
    return (
      <div>
        <div /* className='cuerpo-scroll' */>
          <Cartas />

        </div>
      </div>
    )
  }
}

export default Main
