window.onload = function(){
    const titulo = document.title;
    document.getElementById("titulo").innerHTML = titulo;
}
const texto = document.getElementById("texto");

document.getElementById("go").addEventListener("click",(ev)=>{
    
    const palabraLarga = (a) => {
        let lista=a.split(" ");
        if (lista.length ===1 ){ return a};
        let resu="";
        let max =0;
        let cont=0;
        let resu2=[];
        for (let i=0; i<lista.length;i++){
            if(resu.length<lista[i].length){
                resu = lista[i];
                max=resu.length;
            }
        };
        for (let i=0; i<lista.length;i++){
            if(max===lista[i].length){
                resu2[cont]=lista[i];
                cont++;
            };
        };
        if (cont>1){
            resu = `${resu2}.`;
        }
        return resu;
    };
    document.getElementById("resultado").style= "";
    document.getElementById("paso1").style= "display: none;";
    document.getElementById("textoresultado").innerHTML=`La/s palabra/s mas larga/s: ${palabraLarga(texto.value)} <br>`;
},false);

document.getElementById("reiniciar").addEventListener("click",(ev)=>{
    document.getElementById("resultado").style= "display: none;";
    document.getElementById("paso1").style= "";
    document.getElementById("texto").focus();
    document.getElementById("texto").value="";
},false);