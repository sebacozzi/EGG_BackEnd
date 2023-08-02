const res = "res";
const opcion = document.getElementsByName("clima");

const re= document.getElementById("res");

function estado(opcion){
switch(opcion[0].chequed ? 1: opcion[1].chequed ? 2 : opcion[1].chequed ? 3 : 4  ){
    case 1:
        re.innerHTML="Hoy está <s>soleado</s>.";
        break;
    case 1:
        re.innerHTML="Hoy está soleado</s>.";
        break;
    case 1:
        re.innerHTML="Hoy está soleado</s>.";
        break;
        case 4:
            console.log("Caso no definido.");
}
}
