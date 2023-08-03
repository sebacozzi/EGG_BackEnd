const resultado = document.getElementById("resultado");
const sn = document.getElementById("sn");
const valido = "sSnN";
/* Utilizando eventos onkeyup y onkeydown */
/// toma el evento de cuando se suelta la tecla y muestra el mensaje correspondiente - luego borra el valor del input
sn.onkeyup = (ev) => {
    if (valido.includes(ev.key)) {
        resultado.innerHTML = "Resultado del metodo 1: <b>Correcto</b>";

    } else {
        resultado.innerHTML = "Resultado del metodo 1: <b>Incorrecto</b>";
    }
    sn.value = "";
}
/// cambia el valor a "vacio" para que no muestre las repeticiones de tecla
sn.onkeydown = (ev) => {
    sn.value = "";
}
// borra el todo lo impreso en el html
function reiniciar() {
    resultado.innerHTML = "Resultado del metodo 1: (ingresar letras en el input)";
    sn.value = "";
    sn.focus();
}


/* Utilizando eventos onchange */
const resultado1 = document.getElementById("resultado1");
const sn1 = document.getElementById("sn1");
/// Utiliza el evento onkeydowm para borrar el input y deja la carga en el onkeyup para que solo permita ingresar una sola letra
sn1.onkeydown = (ev) => {
    sn1.value = "";
}
/// cambia el valor a "vacio" para que no muestre las repeticiones de tecla
function verifica() {
    if (valido.includes(sn1.value)) {
        resultado1.innerHTML = "Resultado del metodo 2: <b>Correcto</b>";
    } else {
        resultado1.innerHTML = "Resultado del metodo 2: <b>Incorrecto</b>";
    }
    sn1.focus();
}

// borra el todo lo impreso en el html
function reiniciar1() {
        resultado1.innerHTML = "Resultado del metodo 2: (click en verificar)";
    sn1.value = "";
    sn1.focus();
}

