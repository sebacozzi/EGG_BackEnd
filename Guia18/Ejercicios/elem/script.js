const maxBotones = 25;


const filePath = "elem/datos.json";

fetch(filePath)
  .then(response => response.blob())
  .then(blob => fileReader.readAsText(blob))
  .catch(error => console.error('Error al cargar el archivo:', error));

const fileReader = new FileReader();
fileReader.onload = function (event) {
  const fileContent = event.target.result;
  const jsonData = JSON.parse(fileContent);
  creaBotones(jsonData)
  //document.getElementById('output').textContent = JSON.stringify(jsonData, null, 2);
};

// Cargar el archivo JSON

//Crea botones

const botones = document.getElementsByTagName("a");
function checkFileExists(url) {
    return fetch(url, { method: 'HEAD' })
      .then((response) => {
        if (response.ok) {
          return true; // El archivo existe (código de respuesta 200)
        } else {
          return false; // El archivo no existe (código de respuesta diferente a 200)
        }
      })
      .catch(() => {
        return false; // Ocurrió un error al intentar la petición
      });
  }

function creaBotones (jsonData){ for (let i = 1; i < 25; i++) {
    const urlOrigen = `/Ejercicios/ej${i}/index.html`;
    checkFileExists(urlOrigen).then((exists)=>{
    //checkFileExists("/Ejercicios/ej" + (i+1) + "/index.html").then((exists)=>{
        if (exists){
            const acc = document.createElement("a");
            acc.href=urlOrigen;
            const tit= document.createElement("h2");
            tit.style="text-align: center;";
            tit.innerHTML="Ejercicio "+i;
            const desc=document.createElement("p");
            desc.innerHTML= jsonData["Ejercicio"+i];
            acc.appendChild(tit);
            acc.appendChild(desc);
            acc.hidden=false;
            const main = document.getElementById("lista");
            main.appendChild(acc);
            
    } 
});

}
}

