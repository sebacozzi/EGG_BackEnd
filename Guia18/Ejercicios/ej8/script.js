const numero = document.getElementById("num");
let lista=[];
numero.addEventListener("keyup",(ev)=>{
    if (ev.key=="Enter") {
        if (isNaN(parseInt(numero.value))) {
            alert("Debe ingresar un número.");
            numero.focus();
            return;
        }
        if (numero.value!=0){
        agregar(parseInt(numero.value));
        numero.value="";
        } else{
            mostrarResultados();
            numero.value="";
            //numero.setAttribute("disabled","true");
        }
    }
},false);

function agregar(num){

    lista[lista.length]=num;
};

function mostrarResultados(){
    document.getElementById("paso1").style="display:none;";
    document.getElementById("resultado").style="";
    const resu=document.getElementById("textoresultado");
    let max=lista[0],min=lista[0],suma=0;
    lista.forEach(l => {
        if (l>max) {
            max=l;
        }
        if(l<min){ min=l;}
        suma+=l;
    }); 
const prom= (suma/lista.length);
    resu.innerHTML=`Ingresados: ${lista.length}<br>
                    Mayor ingresado: ${max}<br>
                    Menor ingresado: ${min}<br>
                    Promedio: ${prom.toFixed(2)}`;
};

function reinicia(){
    lista=[];
    document.getElementById("resultado").style="display:none;";
    document.getElementById("paso1").style="";
    numero.value=0;    
    numero.focus();
};