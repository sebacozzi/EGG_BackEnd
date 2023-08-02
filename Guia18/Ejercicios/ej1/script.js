const res = "res";
const opcion = document.getElementsByName("clima");

const re= document.getElementById("res");

function estado(opcion){
    switch(opcion[0].checked ? 1: opcion[1].checked ? 2 : opcion[2].checked ? 3 : 4  ){
    case 1:
        re.innerHTML="Hoy está <strong>soleado</strong>.";
        break;
    case 2:
        re.innerHTML="Hoy está <strong>nublado</strong>.";
        break;
    case 3:
        re.innerHTML="Hoy está <strong>lloviendo</strong>.";
        break;
        case 4:
            console.log("Caso no definido.");
}
}
