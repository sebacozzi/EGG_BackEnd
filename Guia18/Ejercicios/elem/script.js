// contador de botones de ejercicios
const maxBotones = 26;
// cierra el loader
window.onload = function () {
  // fecha fin Guia con hora que termina la clase
  const fin = new Date(2023,7,15,22);
  // fecha actual
  let hoy= new Date();
  /// obtiene la diferencia de dias habiles
  let faltan=faltanDias(hoy,fin);
 
  if(faltan===0){
    document.getElementById("faltan").innerHTML=`Hoy es el ultimo día para terminar la Guia`;
  } else{
    document.getElementById("faltan").innerHTML=`Faltan ${faltan} días para finalizar la Guia`;
  }
};

function faltanDias(fechaInicio, fechaFin) {
  const dia = 86400000;
  let dias = 0;

  while (fechaInicio <= fechaFin) {
      const diaSemana = fechaInicio.getDay();
      if (diaSemana !== 0 && diaSemana !== 6) { 
          dias++;
      }
      fechaInicio.setTime(fechaInicio.getTime() + dia);
  }

  return dias;
}
// url del archivo con el texto de descripcion de los ejercicios
const datos = "elem/datos.json";
// instruccion encargada de abrir el archivo con los datos y llamar a la funcion para crear los botones
fetch(datos)
  .then(response => response.blob())
  .then(blob => fileReader.readAsText(blob))
  .catch(error => console.error('Error al cargar el archivo:', error));

const fileReader = new FileReader();
fileReader.onload = function (event) {
  const fileContent = event.target.result;
  const jsonData = JSON.parse(fileContent);
  creaBotones(jsonData);
  
};



// Funcion encargada de verificar si existe el index del ejercicio
function checkFileExists(url) {
    return fetch(url, { method: 'HEAD' })
      .then((response) => {
        if (response.ok) {
          // El archivo existe (código de respuesta 200)
          return true;
        } else {
          // El archivo no existe (código de respuesta diferente a 200)
          return false;
        }
      })
      .catch(() => {
        // Ocurrió un error al intentar la petición
        return false;
      });
  }

//Crea botones asincronico, para mantener el orden llama check... con espera de resultado 
async function creaBotones(jsonData) {
  const main = document.getElementById("lista");
  for (let i = 1; i < maxBotones; i++) {
    const urlOrigen = `/Ejercicios/ej${i}/index.html`;
    await checkFileExists(urlOrigen).then((exists) => {
      if (exists) {
        // Crea elemento "a"
        const acc = document.createElement("a");
        //Crear parametros
        let p1= encodeURIComponent("Ejercicio " +i);
        let p2= encodeURIComponent(jsonData["Ejercicio" + i]);

        let parametros = btoa(p1+"|"+p2);
        sessionStorage.setItem(i,btoa(p2));
        // añade url de destino
        acc.href = `${urlOrigen}?params=${i}`;
        // Crea el elemnto de titulo
        const tit = document.createElement("h2");
        tit.style = "text-align: center;";
        tit.innerHTML = "Ejercicio " + i;
        // Crea el elemento "p" donde va la descripcion del ejercicio
        const desc = document.createElement("p");
        desc.innerHTML = jsonData["Ejercicio" + i];
        // agrega el titulo y la descripcion a "a"
        acc.appendChild(tit);
        acc.appendChild(desc);
        acc.hidden = false;
        // agrega el "a" al cuerpo del html
        main.appendChild(acc);
      }
    });
  }
  document.getElementById("load").hidden=true;
}
