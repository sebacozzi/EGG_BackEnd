// contador de botones de ejercicios
const maxBotones = 26;
document.addEventListener("DOMContentLoaded", (ev) => {
  var posReloj = JSON.parse(localStorage.getItem("reloj"));

  reloj.style.top = posReloj["posx"];
  reloj.style.left = posReloj["posy"];
  creaBotones();
}, false);
// cierra el loader
window.onload = function () {
  // fecha fin Guia con hora que termina la clase
  const fin = new Date(2023, 7, 15, 22);
  // fecha actual
  let hoy = new Date();
  /// obtiene la diferencia de dias habiles
  let faltan = faltanDias(hoy, fin);

  if (faltan === 0) {
    document.getElementById("faltan").innerHTML = `Hoy es el ultimo día para terminar la Guia`;
  } else {
    document.getElementById("faltan").innerHTML = `Faltan ${faltan} días para finalizar la Guia`;
  }

};


// RELOJ
function actualizaReloj() {

  let tiempo = new Date();
  const hora = tiempo.getHours();
  const minutos = tiempo.getMinutes();
  const segundos = tiempo.getSeconds();

  const hs = hora.toString().padStart(2, "0");
  const ms = minutos.toString().padStart(2, "0");
  const ss = segundos.toString().padStart(2, "0");

  document.getElementById("h").style = `rotate:${hora * 30 + 180 + (30 / (60 / minutos))}deg`;
  document.getElementById("m").style = `rotate:${minutos * 6 + 180 + (6 / (60 / segundos))}deg`;
  document.getElementById("s").style = `rotate:${segundos * 6 + 180}deg`;

  document.getElementById("relojminimizado").innerHTML = `${hs}:${ms}:${ss}`;
};

actualizaReloj();

setInterval(actualizaReloj, 1000);

let click = false;
let posX, posY;
const reloj = document.getElementById("reloj");
const rd = document.getElementById("relojdigital");


reloj.addEventListener("mousemove", (ev) => {

  if (click) {
    document.getElementById("reloj").style = `left:${ev.clientX - posX}px; top:${ev.clientY - posY}px;`;

  };
  x = Math.abs(ev.offsetX - 85);
  y = Math.abs(ev.offsetY - 85);
  dis = Math.sqrt(x * x + y * y);
  if (dis < 84) {
    reloj.style.cursor = "grab";
  } else { reloj.style.cursor = "" }

  /*  posiblemente se pueda cambiar el tamaño!!! para revisar
  x=Math.abs(ev.offsetX-85);
  y=Math.abs(ev.offsetY-85);
  dis =Math.sqrt(x*x +y*y);
  {
    
    console.log (Math.abs(ev.offsetY-75)+";"+ Math.abs(ev.offsetY-75) +"::::"+Math.sqrt(x*x+y*y));} */
}, false);
const minimizaRelojes = (ev) => {
  if (ev.target.id == "minimizar") {
    reloj.classList.toggle("hidden");
    rd.classList.toggle("hidden");
  }
}
reloj.addEventListener('click', minimizaRelojes, false);
rd.addEventListener("click", minimizaRelojes, false);

reloj.addEventListener("mousedown", (ev) => {
  click = true
  xp = ev.clientX;
  yp = ev.clientY;
  if (yp < (80 + 65)) {
    console.log(yp)
  }

  posX = xp - reloj.getBoundingClientRect().left;
  posY = yp - reloj.getBoundingClientRect().top;
  //reloj.style.cursor= "grabbing";
}, false);

reloj.addEventListener("mouseup", (ev) => {
  click = false
  /// guardar posición para proximo inicio
  const x = reloj.style.top;
  const y = reloj.style.left;
  const jso = {

    posx: x,
    posy: y

  };
  localStorage.setItem("reloj", JSON.stringify(jso));

}, false);
//// FIN RELOJ

/// post NO FUNCIONA ---- Investigar
async function guardar(url, datos) {
  fetch(url, {
    method: "POST",
    headers: {
      'Content-Type': 'application/json'
    },
    body: datos
  }).then(reponse => reponse.json())
    .then(data => console.log(data))
    .catch(error, console.log("mensaje:" + error));
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
async function abrir(url) {
  return fetch(url)
    .then(response => response.json())
    //.then(data => data)
    .catch(error => console.error('Error al cargar el archivo(' + url + '):', error));
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
  const div = document.createElement("div");
  div.className = "lista scroll-parte";
  const jsonData = await abrir("elem/datos.json");
  for (let i = 1; i < maxBotones; i++) {
    const urlOrigen = `/Ejercicios/ej${i}/index.html`;
    await checkFileExists(urlOrigen).then((exists) => {
      if (exists) {
        // Crea elemento "a"
        const acc = document.createElement("a");
        //Crear parametros
        let p1 = encodeURIComponent("Ejercicio " + i);
        let p2 = encodeURIComponent(jsonData["Ejercicio" + i]);

        let parametros = btoa(p1 + "|" + p2);
        sessionStorage.setItem(i, btoa(p2));
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
  document.getElementById("load").hidden = true;
}

