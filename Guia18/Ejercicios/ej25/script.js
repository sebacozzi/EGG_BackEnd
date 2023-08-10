window.onload = function () {
    const url = new URLSearchParams(window.location.search);
    if (typeof (parametros) == "undefined") {
        var parametros = url.get("params");
    }
    document.title = "Ejercicio " + parametros + " - Guia 18";
    document.getElementById("titulo").innerHTML = "Ejercicio " + parametros + " - Guia 18";
    document.getElementById("consigna").innerHTML = decodeURIComponent(atob(sessionStorage.getItem(parametros)));
    document.getElementById("tituloform").innerHTML = `Apriete el botón para resaltar las palabras`;
};


function completarFormulario() {
    const fr = document.getElementById("formulario");
    const texto = document.getElementById("texto");

    const resaltar = (txt) => {
        let palabras = txt.split(" ");
        console.log(txt);
        console.log(palabras);
        palabras = palabras.map((palabra)=>{
            if (palabra.length>8){
                palabra= `<span class=\"resaltado-amarillo\">${palabra}</span>`;
            }
            return palabra;
        });
        return palabras.join(" ");
    };

    if (!fr.resaltado) {
        document.getElementById("tituloform").innerHTML = "Apriete el botón para ocultar el resaltado";
        texto.innerHTML = resaltar(texto.textContent);
    } else {
        document.getElementById("tituloform").innerHTML = "Apriete el botón para resaltar las palabras";
        texto.innerHTML = texto.textContent;
    }

    fr.resaltado = !fr.resaltado;
};
