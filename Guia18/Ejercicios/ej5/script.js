const resultado = document.getElementById("resultado");
const tipoCalculo = document.getElementById("tipo");

const calculos = {
    "r": "Resta",
    "s": "Suma",
    "d": "División",
    "m": "Multiplicación"
};

let calcular = "";
/// Eventos
document.getElementById("v1").onchange=cambio;
document.getElementById("v2").onchange=cambio;

tipoCalculo.onkeydown = onKeyDownTipo;
tipoCalculo.onkeyup = onKeyUpTipo;

// uso estetico - si tiene un 0 adelante lo elimina convirtiendo el valor del input a un numero y reasignandolo
function cambio(ev) {
    this.value= parseFloat(this.value);
};

function onKeyDownTipo(ev) {
    console.log(ev.key);
    if ("abcdefghijklsmnñopqrstuvwxyz1234567890.,{[^`~ ´+*¨!#$%&/()=?¡¿/*-_'".includes(ev.key.toLowerCase())) {
        tipoCalculo.value = "";
    }
};

function onKeyUpTipo(ev) {
    calcular=tipoCalculo.value.toLowerCase();
    if (calculos[calcular]) {
        console.log(calculos[tipoCalculo.value]);
        document.getElementById("claseCalculo").innerHTML = "Tipo de calculo: " + calculos[calcular] + ".";
        document.getElementById("bcalculo").disabled = false;
    } else {
        document.getElementById("claseCalculo").innerHTML = "Tipo de calculo: consultar ayuda.";
        document.getElementById("bcalculo").disabled = true;
    };
};
/// Fin Eventos

function calculo(){
    
    const num1 = parseFloat(document.getElementById("v1").value);
    const num2 = parseFloat(document.getElementById("v2").value);
    console.log(num1);
    console.log(num2);
    if (num1===0 && num2===0) {
        document.getElementById("v1").focus();
        return;
    }
    if ((num2===0 )&& calcular=="d") { // División por cero
        alert(`Error de división por "Cero".
        Para realizar una división el segundo número debe ser distinto de 0.`);
        document.getElementById("v2").focus();
        return;
    }
    let resu=0;
    switch (calcular) {
        case "d":
            resu = num1/num2;
            signo ="/";
            break;
        case "m":
            resu = num1*num2;
            signo ="x";
            
            break;
        case "r":
            resu = num1-num2;
            signo ="-";
            break;
        case "s":
            resu = num1+num2;
            signo ="+";
            //resultado.innerHTML=`Resultado de ${num1}+${num2}: ${num1+=num2}.`;
            break;
    
        default:
            alert(`Tipo de calculo invalido...
Debe consultar la ayuda.`);
            tipoCalculo.focus();
            return;
            break;
    }
    // utilizado para redondear division distinta de entero
    if (resu.toFixed(1)==resu) {
        resultado.innerHTML=`Resultado de ${num1} ${signo} ${num2}: ${resu}.`;
    } else {
        resultado.innerHTML=`Resultado de ${num1} ${signo} ${num2}: ${resu.toFixed(3)}.`;
    }
         
};

function reiniciar(){
    resultado.innerHTML="Resultado:";
    document.getElementById("v1").value=0;
    document.getElementById("v2").value=0;
    tipoCalculo.value="";

}