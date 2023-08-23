import './App.css';
import Ejemplo from './components/public/Ejemplo';

function App() {
  return (
    <div >
      <h1>Ejercicio 1 - Guia 18</h1>
      <h3>Consigna:</h3>
      <p>Crear un proyecto compuesto de un solo Functional Component. En dicho componente
        mostrar al menos dos datos, como por ejemplo titulo y subtitulo.
        El componente debe ser llamado desde App, a continuación, se propondrá la jerarquía
        del árbol de componentes y de como es el llamado desde index.js
        • Index.js
        o App
        § Ejemplo</p>
      <hr />
      <Ejemplo />
    </div>
  );
}

export default App;

