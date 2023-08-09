window.onload = function () {
    const url = new URLSearchParams(window.location.search);
    if (typeof (parametros) == "undefined") {
        var parametros = url.get("params");
    }
    document.title = "Ejercicio " + parametros + " - Guia 18";
    document.getElementById("titulo").innerHTML = "Ejercicio " + parametros + " - Guia 18";
    document.getElementById("consigna").innerHTML = decodeURIComponent(atob(sessionStorage.getItem(parametros)));
    document.getElementById("tituloform").innerHTML = `Rellenar arrays`;
}

area = (radio) => {
    return radio * radio * Math.PI;
};

perimetro = (radio) => {
    return radio * 2 * Math.PI;
};
let v1 = [];
let v2 = [];
let v3 = [];
function generar() {
    for (let i = 0; i < 5; i++) {
        v1[i] = parseInt(Math.random() * 10);
        v3[i] = parseInt(Math.random() * 10);
        v2[i] = (Math.random() * 10).toFixed(0);
    }
}

const generaString = (vector) => {
    let temp = "[ ";
    for (let i = 0; i < vector.length; i++) {
        temp += vector[i];
        if (i < (vector.length - 1)) {
            temp += " , ";
        } else { temp += " " };
    }
    temp = temp + "]";
    return temp;
}
function mostrar() {
    document.getElementById("a1").innerHTML = generaString(v1);
    document.getElementById("a2").innerHTML = generaString(v2);
    document.getElementById("a3").innerHTML = generaString(v3);
};

function reiniciar() {
    document.getElementById("a1").innerHTML = "[ ]";
    document.getElementById("a2").innerHTML = "[ ]";
    document.getElementById("a3").innerHTML = "[ ]";
    v1 = [];
    v2 = [];
    v3 = [];
};