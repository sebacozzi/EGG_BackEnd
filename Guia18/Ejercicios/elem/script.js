// contador de botones de ejercicios
const maxBotones = 26;
document.addEventListener("DOMContentLoaded",(ev)=>{
  var posReloj=JSON.parse(localStorage.getItem("reloj"));
  
  reloj.style.top = posReloj["posx"];
  reloj.style.left = posReloj["posy"];
  console.log("inicia caraga")
},false);
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


// RELOJ
function actualizaReloj(){
 let tiempo= new Date();
  const hora= tiempo.getHours()-12;
  const minutos = tiempo.getMinutes();
  let segundos= tiempo.getSeconds();

  document.getElementById("h").style= `rotate:${hora*30+180}deg`;
  document.getElementById("m").style= `rotate:${minutos*6+180}deg`;
  document.getElementById("s").style= `rotate:${segundos*6+180}deg`;
 // document.getElementById("hora").innerHTML= `${hora}:${minutos}:${segundos}`;


};

actualizaReloj();
setInterval(actualizaReloj, 1000);
let click =false;
let posX,posY;
const reloj= document.getElementById("reloj");
reloj.addEventListener("mousemove",(ev)=>{
  if (click){
  document.getElementById("reloj").style=`left:${ev.clientX-posX}px; top:${ev.clientY-posY}px;`;

  }

},false);

reloj.addEventListener("mousedown",(ev)=>{
  click = true 
  posX=ev.clientX - reloj.getBoundingClientRect().left;
  posY=ev.clientY- reloj.getBoundingClientRect().top;
  console.log(posY);

},false);

reloj.addEventListener("mouseup",(ev)=>{
  click = false 
  /// guardar posición para proximo inicio
  const x = reloj.style.top;
  const y = reloj.style.left;
  const jso={
    
      posx: x,
      posy: y
    
  };
 localStorage.setItem("reloj", JSON.stringify(jso));

},false);
//// FIN RELOJ

/// post NO FUNCIONA ---- Investigar
async function guardar(url,datos){
fetch(url,{
  method:"POST",
  headers:{
    'Content-Type' : 'application/json'},
    body: datos
  }).then(reponse=> reponse.json())
  .then(data=> console.log(data))
  .catch(error, console.log("mensaje:"+error));
};
/// post


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
};


// instruccion encargada de abrir el archivo con los datos y llamar a la funcion para crear los botones
async function abrir (url)
{ return fetch(url)
        .then(response => response.json())
        //.then(data => data)
        .catch(error => console.error('Error al cargar el archivo('+url+'):', error));
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
async function creaBotones() {
  
  const main = document.getElementById("lista");
  const div =document.createElement("div");
  div.className="lista scroll-parte";
  const jsonData = await abrir("elem/datos.json");
  console.log("jsonData: "+jsonData);
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
        div.appendChild(acc);
      }
    });
  }
main.appendChild(div);
  document.getElementById("load").hidden=true;
}
creaBotones();
