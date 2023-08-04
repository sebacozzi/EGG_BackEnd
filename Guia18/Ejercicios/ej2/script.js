const superficie= document.getElementById("superficie");
const perimetro= document.getElementById("perimetro");
document.getElementById("radio").onkeyup=(ev) => { 
    if(ev.key=="Enter"){
        calcular();
    }
}

const pi = Math.PI;
let sup = (a)=> Math.pow(a,2)* pi;
let per = (a)=> a*2*pi;

function calcular(){
    const itemRadio = document.getElementById("radio");
    const radio = itemRadio.value;
    if  (itemRadio.value=="0"){
        alert("Debe ingresar el radio.");
        return;
    };
    const perim = "El perimetro del circulo es de "+ per(radio).toFixed(3);
    const superf= "La superficie es "+ sup(radio).toFixed(3);
superficie.innerHTML=`Datos del circulo: <br> Radio ${radio}<br>Diametro: ${radio*2}<br>${perim}<br>${superf}`;
}
//resultados();
function reiniciar(){
    document.getElementById("radio").value=0;
    superficie.innerHTML="";
}