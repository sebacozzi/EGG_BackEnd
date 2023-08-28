import React from 'react'
import {Link} from 'react-router-dom'

export default function Navbar() {


  return (
    <nav>
      <header className="p-3 text-bg-dark">
        <div className="container">
          <div className="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">

            <ul className="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
              <li><Link href="#" className="nav-link px-2 text-secondary">Inicio</Link></li>
              <li><Link href="#" className="nav-link px-2 text-white">Ejercicio 1</Link></li>
              <li><Link href="#" className="nav-link px-2 text-white">Ejercicio 2</Link></li>
              <li><Link href="#" className="nav-link px-2 text-white">Ejercicio 3</Link></li>
              <li><Link href="#" className="nav-link px-2 text-white">Ejercicio 4</Link></li>
              <li><Link href="#" className="nav-link px-2 text-white">Ejercicio 5</Link></li>
              <li><Link href="#" className="nav-link px-2 text-white">Ejercicio 6</Link></li>
            </ul>

           {/*  <form className="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
              <input type="search" className="form-control form-control-dark text-bg-dark" placeholder="Search..." aria-label="Search"/>
            </form>

            <div className="text-end">
              <button type="button" className="btn btn-outline-light me-2">Login</button>
              <button type="button" className="btn btn-warning">Sign-up</button>
            </div> */}
          </div>
        </div>
      </header>
    </nav>
  )
}
