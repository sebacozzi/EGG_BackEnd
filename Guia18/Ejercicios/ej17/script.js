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
let cant = 0;
function generar() {
    cant = parseInt(document.getElementById("cant").value);
    for (let i = 0; i < cant; i++) {
        v1[i] = parseInt(Math.random() * 10);
    }
    document.getElementById("a1").innerHTML = generaString(v1);
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
    alert("Se eliminarán los ultimos 2 elementos...");
    v2= v1;
    const v3= v2.splice(v2.length-2,2);
    document.getElementById("a2").innerHTML = generaString(v2) +"&nbsp;&nbsp;&nbsp;&nbsp;Eliminado: "+generaString(v3);
    document.getElementById("a2").innerHTML = generaString(v2) +"&nbsp;&nbsp;&nbsp;&nbsp;Eliminado: "+generaString(v3);
}
function reiniciar() {
    document.getElementById("a1").innerHTML = "[ ]";
    document.getElementById("a2").innerHTML = "";   

    v1 = [];
    v2 = [];
};