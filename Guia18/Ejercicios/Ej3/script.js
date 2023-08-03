const resultado= document.getElementById("resultado");
const edad = document.getElementById("edad");

function verificar(){
    if(edad.value == "0"){
        alert("La edad ingresada es 0... o no naciste o no la cambieaste.");
        return;
    }
    if (edad.value>=18) {
        resultado.innerHTML="<strong>Sos mayor de edad!!!!!</strong>";
    }else{
        resultado.innerHTML="<strong>Sos menor de edad!!!!!</strong>";
    }
}

function reiniciar(){
    resultado.innerHTML="";
    edad.value = "0";
}