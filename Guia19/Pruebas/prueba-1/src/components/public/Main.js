import React, { Component, useState } from 'react'
import Cartas from './Cartas';
import RickAndMortyService from '../../services/RM_Service'

class Main extends Component {
  constructor(props){
    super(props);
    this.state= {cartas:[]};
  }

  componentDidMount(){
    RickAndMortyService.getTodosLosPersonajes()
    .then((data)=>
    this.setState({ cartas : data.results}));
  }

  render() {
    return (
      <div>
        <div className='cuerpo-scroll'>
          <Cartas datos={this.state.cartas} />

        </div>
      </div>
    )
  }
}

export default Main
