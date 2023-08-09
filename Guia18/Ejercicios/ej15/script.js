window.onload = function () {
    const url = new URLSearchParams(window.location.search);
    if (typeof (parametros) == "undefined") {
        var parametros = url.get("params");
    }
    document.title = "Ejercicio " + parametros + " - Guia 18";
    document.getElementById("titulo").innerHTML = "Ejercicio " + parametros + " - Guia 18";
    document.getElementById("consigna").innerHTML = decodeURIComponent(atob(sessionStorage.getItem(parametros)));
    document.getElementById("tituloform").innerHTML = `Calcular datos de un circulo`;
}

 area = (radio)=>{
        return radio*radio*Math.PI;
    };
    
perimetro= (radio)=>{
        return radio*2*Math.PI;
    };

function completarFormulario() {
   
    const formulario = document.getElementById("formulario");
    const radio = parseFloat(formulario.radio.value);
    document.getElementById("radioR").innerHTML=parseFloat(radio).toFixed(2);
    document.getElementById("area").innerHTML=parseFloat(area(radio)).toFixed(2);
    document.getElementById("perimetro").innerHTML=parseFloat(perimetro(radio)).toFixed(2);
    formulario.radio.focus();
    
}


document.getElementById("formulario").addEventListener("click", (ev) => {
    if (ev.target.type==="reset") {
    document.getElementById("radio").focus();
    document.getElementById("radioR").innerHTML="0";
    document.getElementById("superficie").innerHTML="0";
    document.getElementById("perimetro").innerHTML="0";
    }
}, false);