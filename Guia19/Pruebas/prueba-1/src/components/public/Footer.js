import React from 'react';
//import '../../App.css';

const Footer = () => {
    
    const anio= new Date().getFullYear();
    
    const compania= 'Mi compania'


    return (
        <div className='footer'>
            <footer class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top" >
                <div class="col-md-4 d-flex align-items-center">
                    <span class="mb-3 mb-md-0 text-body-secondary">© {anio} {compania} </span>
                </div>
                <ul class="nav col-md-4 justify-content-end list-unstyled d-flex">
                    <li className='ms-3'>Mis redes </li>
                    <li className='ms-3'>Mis redes </li>
                    <li className='ms-3'>Mis redes </li>
                </ul>
            </footer>
        </div>
    )
}

export default Footer
