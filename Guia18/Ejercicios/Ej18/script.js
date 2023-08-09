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


let bool = [];
let str = [];
let num = [];
var valores = [true, 5, false, 'hola', 'adios', 2]

function generar() {
    const f = (valor) => {
        return typeof (valor);
    };

    for (let i = 0; i < valores.length; i++) {
        switch (f(valores[i])) {
            case "string":
                str[str.length] = valores[i];
                break;
            case "number":
                num[num.length] = valores[i];
                break;
            case "boolean":
                bool[bool.length] = valores[i];
                break;
        }
    }
    document.getElementById("analisis").innerHTML = "[ " + generaString(str) + " , " + generaString(num) + " , " + generaString(bool) + " ]";
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

const fmayorL = (v1, v2) => {
    if (v2.length > v1.length) {
        return v2;
    } else {
        return v1;
    };
};

const fmayorV = (v1, v2) => {
    if (v2 > v1) {
        return v2;
    } else {
        return v1;
    };
};

function mostrar() {
    if(bool.length===0 ||num.length===0 ||str.length===0){
        alert("Primero clickea en 'Generar'")
        return;
    };
    document.getElementById("textomayor").innerHTML = 
        `<u>Texto mayor:</u><br>&nbsp;&nbsp;logitud: ${fmayorL(str[0], str[1])}<br>
        &nbsp;&nbsp;Comparador (>/<): ${fmayorV(str[0], str[1])}`;

    document.getElementById("booleanos").innerHTML =
        `<u>Comparación Booleana:</u><br>
        &nbsp;&nbsp;Resultado true: (${bool[0]} != ${bool[1]}) = ${bool[0] != bool[1]}<br>
        &nbsp;&nbsp;Resultado false:(${bool[0]} == ${bool[1]}) = ${bool[0] === bool[1]} `;

    document.getElementById("calculos").innerHTML = 
        `<u>Calculos Matemáticos:</u><br>
        &nbsp;&nbsp;Suma: (${num[0]} + ${num[1]}) = ${num[0] + num[1]}<br>
        &nbsp;&nbsp;Resta: (${num[0]} - ${num[1]}) = ${num[0] - num[1]}<br>
        &nbsp;&nbsp;Multiplicación: (${num[0]} x ${num[1]}) = ${num[0] * num[1]}<br>
        &nbsp;&nbsp;División: (${num[0]} / ${num[1]}) = ${num[0] / num[1]}<br>
        &nbsp;&nbsp;Comparación mayor que:(${num[0]} > ${num[1]}) = ${num[0] > num[1]}`;
};

function reiniciar() {
    document.getElementById("textomayor").innerHTML = "";
    document.getElementById("booleanos").innerHTML = "";
    document.getElementById("calculos").innerHTML = "";
    bool=[];
    str=[];
    num=[];

};