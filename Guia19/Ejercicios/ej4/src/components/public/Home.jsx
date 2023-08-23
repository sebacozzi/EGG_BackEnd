import imagen from '../../imagen1.PNG';
import imagen2 from '../../imagen2.PNG';

const Home = () => {
  const estiloLista = {
    alignItems: "center",
    justifyContent: "center",
    display: "flex",
    marginTop: "0px",
    padding: "0px",
  };

  const estiloImagen = {
    padding: " 5px 40px 5px 5px ",

  }
  const img60 = {
    maxWidth: "60%"
  }
  const img95 = {
    maxWidth: "95%"
  }
  const estiloContenedor = {
    margin: "5px",
    padding: "5px",
    border: " 2px solid black",
    borderRadius: "20px",
    color: "white",
    backgroundColor: "#282c28",
  }
  const centrar = {
    alignItems: "center",
    justifyContent: "center",
    display: "flex",

  }

  return (
    <div style={estiloContenedor}>
      <h2>Ejercicio 4</h2>
      <h4>Consigna:</h4>


      <span>
        Crear un proyecto compuesto por 4 componentes bajo la siguiente jerarquía.
      </span>
      <div style={estiloLista}>
        <ul>
          <li>Index.js</li>
          <ul>
            <li>App</li>
            <ul>
              <li>Navbar</li>
              <li>Main1 o Main2</li>
              <li>Footer</li>
            </ul>
          </ul>
        </ul>
      </div>
      <span>
        Al hacer click sobre las dos posibles opciones en el NavBar, se deberá cambiar entre
        Main1 y Main2 dependiendo de la navegación. Para lograrlo se deberá instalar y usar
        React Router Dom.<br /><br /></span>
      <span>A continuación, se propone como será la jerarquía de los componentes </span>
      <span style={centrar}><img src={imagen} alt='Imagen de Ejemplo' style={{ estiloImagen, img95 }} />
      </span>
      <span style={centrar}>(Switch es obsoleto, se debe utilizar Routes)<br /><br /></span>
      <span>En la siguiente imagen se vera como establecer la navegación. Se sugiere ver los videos
        explicativos que encontrarán en el canal de Youtube de Egg.</span>
      <span style={centrar}><img src={imagen2} alt='Imagen de Ejemplo' style={{ estiloImagen, img60 }} /></span>

    </div>
  )
}

export default Home
