const superficie= document.getElementById("superficie");
const perimetro= document.getElementById("perimetro");

const pi = Math.PI;
let sup = (a)=> Math.pow(a,2)* pi;
let per = (a)=> a*2*pi;

function calcular(){
    const itemRadio = document.getElementById("radio");
    const radio = itemRadio.value;
    const perim = "El perimetro del circulo es de "+ per(radio).toFixed(3);
    const superf= "La superficie es "+ sup(radio).toFixed(3);
superficie.innerHTML=`Datos del circulo: <br> Radio ${radio}<br>Diametro: ${radio*2}<br>${perim}<br>${superf}`;
}
function cambioRango(valor){
    const escala= document.getElementById("num");
    escala.innerHTML=valor;
}
resultados();