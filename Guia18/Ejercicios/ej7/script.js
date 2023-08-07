/* sessionStorage.setItem("Limite", "1000");

console.log(sessionStorage); */

/// Listener
let inicio = document.getElementById("inicio");
let paso1 = document.getElementById("paso1");
let paso2 = document.getElementById("paso2");
let intento = 0;

paso2.addEventListener("animationend", llamada, false);

paso1.addEventListener("animationend", llamada, false);


function llamada(event) {
    if (event.animationName == "fadeout") {
        if (event.type == "animationend") {
            switch (event.srcElement.id) {
                case "paso1":
                    paso1.style = "display:none;";
                    paso2.style = "";
                    paso2.className = "form centrar fadein";
                    break;
                case "paso2":
                    paso2.style = "display:none;";
                    paso3.style = "";
                    paso3.className = "form centrar fadein";
                    break;
                case "paso3":
                    paso3.style = "display:none;";
                    paso1.style = "";
                    paso1.className = "form centrar fadein";
                    break;
            };
        };
    };
};

document.getElementById("go").addEventListener("click", () => {
    const limite = parseInt(document.getElementById("num1").value);
    if (/* limite<=0 || */ isNaN(limite)) {
        alert("Debe ingresar un número mayor que 0!!");
        document.getElementById("num1").focus();
    } else {
        localStorage.setItem("limite", limite);
        localStorage.setItem("sumado", "0");
        paso1.className = "form centrar fadeout";
    };
}, false);

document.getElementById("sumar").addEventListener("click", () => {
    const sumar = parseInt(document.getElementById("num2").value);
    const limite = parseInt(localStorage.getItem("limite"));
    let sumado = parseInt(localStorage.getItem("sumado"));
    sumado += sumar;
    document.getElementById("num2").value = 0;
    if (limite > sumado) {

        document.getElementById("ingresar").innerHTML = "Ingresa otro." + intentos();
        document.getElementById("num2").focus();
        localStorage.setItem("sumado", sumado);
    } else {
        paso2.className = "form centrar fadeout";
        document.getElementById("textoPaso3").innerHTML = `limite alcanzado o superado: <br>Limite= ${limite}<br>Sumatoria= ${sumado}`;
        localStorage.clear;
    };
},
    false);

document.getElementById("reiniciar").addEventListener("click", () => {
    localStorage.clear;
    paso3.style = "display:none;";
    paso1.className = "form centrar fadein";
    document.getElementById("num1").value = 0;
    paso1.style = "";
}, false);

function intentos() {
    intento++;
    let res = "";
    for (let i = 0; i < intento; i++) {
        res = res + ".";
    };
    return res;
}
