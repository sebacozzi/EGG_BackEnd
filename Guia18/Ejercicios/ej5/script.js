const resultado = document.getElementById("resultado");
const tipoCalculo = document.getElementById("tipo");
let calcular ="";
tipoCalculo.onkeydown = onKeyDownTipo;
tipoCalculo.onkeyup = onKeyUpTipo;

function onKeyDownTipo(ev) {
    console.log(ev)
    if(ev.key=="Tab" || ev.key =="Shift"){
        console.log("tab o Shift")
    }else{
    tipoCalculo.value = "";
    };
};

function onKeyUpTipo(ev) {
    
    switch (tipoCalculo.value) {
        case "r":
        case "R":
            document.getElementById("claseCalculo").innerHTML = "Tipo de calculo: Resta.";
            break;
        case "s":
        case "S":
            document.getElementById("claseCalculo").innerHTML = "Tipo de calculo: Suma.";
            break;
        case "m":
        case "M":
            document.getElementById("claseCalculo").innerHTML = "Tipo de calculo: Multiplicación.";
            break;
        case "d":
        case "D":
            document.getElementById("claseCalculo").innerHTML = "Tipo de calculo: División.";
            break;
        default:
            document.getElementById("claseCalculo").innerHTML = "Tipo de calculo: consultar ayuda.";
            break;
    };
};