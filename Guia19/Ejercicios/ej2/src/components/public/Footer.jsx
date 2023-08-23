import React from 'react'
import { useState } from 'react';

export default function Footer() {

    const [arriba,setArriba]= useState(0);
    const anio= new Date().getFullYear();
    
    const compania= 'Mi compania'
    const handleOver=()=>{
        setArriba(arriba+1);
    }
  return (
    <div>
       <div className='footer'>
            <footer className="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top" >
                <div className="col-md-4 d-flex align-items-center">
                    <span className="mb-4 mb-md-0 text-body-secondary">
                        &copy; {anio}  <span className='m-4'>{compania} Arriba= {arriba}</span>  </span>
                </div>
                <ul className="nav col-md-4 justify-content-end list-unstyled d-flex">
                    <li className='ms-2' onMouseOver={handleOver}>Instagram </li>
                    <li className='ms-2'>Facebook </li>
                    <li className='ms-2'>Discord </li>
                </ul>
            </footer>
        </div>
    </div>
  )
}
