window.onload = function () {
    const url = new URLSearchParams(window.location.search);
    if (typeof (parametros) == "undefined") {
        var parametros = url.get("params");
    }
    document.title = "Ejercicio " + parametros + " - Guia 18";
    document.getElementById("titulo").innerHTML = "Ejercicio " + parametros + " - Guia 18";
    document.getElementById("consigna").innerHTML = decodeURIComponent(atob(sessionStorage.getItem(parametros)));
    document.getElementById("tituloform").innerHTML = `Calculo de radio`;

};
document.getElementById("formulario").addEventListener("change", (ev) => {
    if (ev.target.name == "por") {
        if (ev.target.value == 1) {
            document.getElementById("dato").placeholder = "Ingresar Perimetro";
        } else {
            document.getElementById("dato").placeholder = "Ingresar area";
        };
    };
}
    , false);

function completarFormulario() {
    const fr = document.getElementById("formulario");
    const dato = fr.dato.value;
    let resultado = 0;
    console.log(fr.por.value);
    if (fr.por.value == 1) {
        resultado = dato / 2 / Math.PI;
    } else {
        resultado = Math.sqrt(dato / Math.PI);
    };
    document.getElementById("radio").innerHTML = resultado.toFixed(3);
};
