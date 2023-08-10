window.onload = function () {
    const url = new URLSearchParams(window.location.search);
    if (typeof (parametros) == "undefined") {
        var parametros = url.get("params");
    }
    document.title = "Ejercicio " + parametros + " - Guia 18";
    document.getElementById("titulo").innerHTML = "Ejercicio " + parametros + " - Guia 18";
    document.getElementById("consigna").innerHTML = decodeURIComponent(atob(sessionStorage.getItem(parametros)));
    document.getElementById("tituloform").innerHTML = `Apriete el botón para mostrar el mensaje`;
};


function completarFormulario() {
    const fr= document.getElementById("formulario");
 fr.secret= !fr.secret;
 
 if(!fr.secret){
    document.getElementById("tituloform").innerHTML="Apriete el botón para mostrar el mensaje";
 } else{
    document.getElementById("tituloform").innerHTML="Apriete el botón para ocultar el mensaje";
 }
    document.getElementById("secret").classList.toggle("ocultar");
 
};
