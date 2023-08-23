import React from 'react'
import '../../App.css';

const Main = () => {
    return (
        <div >
            <h1>Este es el Main</h1>
            <h3 style={{ textAlign: "center" }}>Consigna:</h3>
            <p style={{ textAlign: "center" }}>Crear un proyecto compuesto por tres componentes bajo la misma jerarquía. Crear un
                Navbar, Main y Footer.</p>
            <div className='detalle'>
                <ul>
                    <li>Index.js</li>
                    <ul>
                        <li>App</li>
                        <ul>
                            <li>
                                Navbar
                            </li>
                            <li>
                                Main
                            </li>
                            <li>
                                Footer
                            </li>
                        </ul>
                    </ul>
                </ul>
            </div>
            <p className='text-center'>Necesitamos hacer que Footer, Main y Navbar muestren al menos un dato, de la misma
                manera que el ejercicio anterior.</p>
        </div>
    )
}

export default Main
