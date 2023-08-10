
window.onload = function () {
    const url = new URLSearchParams(window.location.search);
        let parametros;
    if ( url.get("params")==null) {
        parametros =sessionStorage.getItem("activo");
        } else{
       sessionStorage.setItem("activo", url.get("params"));
       parametros =sessionStorage.getItem("activo");
    }
    document.title = "Ejercicio " + parametros + " - Guia 18";
    document.getElementById("titulo").innerHTML = "Ejercicio " + parametros + " - Guia 18";
    document.getElementById("consigna").innerHTML = decodeURIComponent(atob(sessionStorage.getItem(parametros)));
    document.getElementById("tituloform").innerHTML = `Obtener datos del formulario`;
    
    
};

document.getElementById("form1").addEventListener("submit",(ev)=>{
    
    const fr= document.getElementById("form1");
    alert(`Nombre: ${fr.nombre.value}
Apellido: ${fr.apellido.value}`);
},false);
