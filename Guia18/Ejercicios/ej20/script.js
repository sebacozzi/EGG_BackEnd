window.onload = function () {
    const url = new URLSearchParams(window.location.search);
    if (typeof (parametros) == "undefined") {
        var parametros = url.get("params");
    }
    document.title = "Ejercicio " + parametros + " - Guia 18";
    document.getElementById("titulo").innerHTML = "Ejercicio " + parametros + " - Guia 18";
    document.getElementById("consigna").innerHTML = decodeURIComponent(atob(sessionStorage.getItem(parametros)));
    document.getElementById("tituloform").innerHTML = `Rellenar arrays`;
};


let arraydoble = [];
let arraysimple = [];

function generar() {
    let arr = [];
    if (arraydoble.length === 0) {
        for (let i = 1; i < 6; i++) {
            arr = [i * 3];
            console.log(i);
            arraydoble[arraydoble.length] = arr;
        };
    };
    arraysimple = arraydoble.flat(1);
};

const generaStringMatriz = (matriz) => {
    let temp = "";
    const filas = matriz.length;

    for (let i = 0; i < filas; i++) {
        if (typeof (matriz[i].length) === "undefined") {
            temp += matriz[i];
        } else {
            temp += generaStringMatriz(matriz[i]);
        };
    };
    return "[" + temp + "]";
};



function mostrar() {
    if (arraydoble.length === 0 || arraysimple.length === 0) {
        alert("Primero clickea en 'Generar'")
        return;
    };
    document.getElementById("arraydoble").innerHTML =
        `<u>Matriz:</u><br>${generaStringMatriz(arraydoble)}`;

    document.getElementById("arraysimple").innerHTML =
        `<u>Array concatenado:</u><br>[ ${arraysimple.join(" , ")} ]`;
};

function reiniciar() {
    document.getElementById("array50").innerHTML = "";
    document.getElementById("array20").innerHTML = "";
    array50 = [];
    array20 = [];
};