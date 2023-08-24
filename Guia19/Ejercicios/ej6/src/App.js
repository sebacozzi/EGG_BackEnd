import "./App.css";
import Consigna from "./components/public/Consigna";
import Main from "./components/public/Main";

function App() {
  const estiloEncabezado={
    position:'sticky',
    padding: '10px',
    zIndex:100,
    top: 0,
    backgroundColor: 'lightgray',
    boxShadow:'1px 1px 5px 1px black, 10px 10px 40px 20px gray, inset 0px -10px 10px gray'
    
  }
  const estiloCuerpo={
    heigth:'70%',
    paddingTop:'15px',
  }
	return (
		<div>
      <div style={estiloEncabezado}>
			<Consigna />
      </div>
			<div style={estiloCuerpo}>
      <Main />
      </div>
		</div>
	);
}

export default App;
