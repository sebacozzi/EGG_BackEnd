import React from 'react'
import { Link } from 'react-router-dom';

export default function Navbar() {
  return (
    <nav class="navbar navbar-expand navbar-dark bg-dark" aria-label="Second navbar example">
    <div class="container-fluid">
      <span class="navbar-brand" href="#">Ejercicio 4 - Guia 19</span>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarsExample02" aria-controls="navbarsExample02" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExample02">
        <ul class="navbar-nav me-auto">
          <li class="nav-item">
            <Link class="nav-link active" to='/'>Inicio</Link>
          </li>
          <li class="nav-item">
            <Link class="nav-link" to='main1'>Main 1</Link>
          </li>
          <li class="nav-item">
            <Link class="nav-link" to='main2'>Main 2</Link>
          </li>
        </ul>
      </div>
    </div>
  </nav>
  )
}
