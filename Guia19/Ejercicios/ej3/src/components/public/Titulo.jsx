import imagen from '../../imagenejemplo.PNG';
const estiloLista={
    alignItems:"center",
    justifyContent:"center",
    display:"flex",
    marginTop:"0px",
    padding:"0px",
  };
  
  const estiloImagen={
    padding:" 5px 40px 5px 5px ",
    width:"30%",
  }

   const estiloContenedor={
   margin:"5px",
   padding :"5px",
    border:" 2px solid black",
    borderRadius:"20px",
    color:"white",
    backgroundColor:"#282c28",
   }
const Titulo = () => {
  return (
    <div style={estiloContenedor}>
      <h2>Ejercicio 3</h2>
      <h4>Consigna:</h4>
      <div style={{ "display": "flex" }}>
        <div><span>Crear un Componente Main el cual llame dos veces a un mismo componente, es decir,
          que Main anide a Hijo e Hijo.</span>
          <div /* className='App-header' */ style={estiloLista}>
          <ul>
            <li>Index.js</li>
            <ul>
              <li>App</li>
              <ul>
                <li>Main</li>
                <ul>
                  <li>Hijo</li>
                  <li>Hijo</li>
                </ul>
              </ul>
            </ul>
          </ul>
          </div>
          <span>Al primer Componente anidado pasarle como props el nombre Chiquito y al segundo el
            nombre Filomena. Desde los componentes Hijos atrapar los valores mediante las props.</span>
        </div>
        <img src={imagen} alt='Imagen de Ejemplo' style={estiloImagen}/>
      </div>
    </div>
  )
}

export default Titulo
