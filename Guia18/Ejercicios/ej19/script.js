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


let array50 = [];
let array20 = [];

function generar() {
if(array50.length===0){
    for (let i = 0; i < 50; i++) {
       array50[array50.length]= (Math.random()*25).toFixed(3);
    };
};
    array20=array50.slice(0,20);
    array20=array20.fill(0.5,10,20);

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
};


function mostrar() {
    if(array20.length===0 ||array50.length===0){
        alert("Primero clickea en 'Generar'")
        return;
    };
    document.getElementById("array50").innerHTML = 
        `<u>Array de 50 valores reales:</u><br>${generaString(array50)}`;

    document.getElementById("array20").innerHTML =
        `<u>Array de 20 valores(primeros 10 copiados del de 50 y ultimos 10 con 0.5):</u><br>(${generaString(array20)}`;
};

function reiniciar() {
    document.getElementById("array50").innerHTML = "";
    document.getElementById("array20").innerHTML = "";
    array50=[];
    array20=[];
};