const texto = document.getElementById("texto");

document.getElementById("go").addEventListener("click",(ev)=>{
     let valor=texto.value;
    if (valor==="true" || valor==="false"){
        valor=true;
    }else if(!isNaN(parseFloat(valor))){
      valor=parseInt(valor);
    }

    const tipo = (a) => {
        return typeof(a);
    };

    document.getElementById("resultado").style= "";
    document.getElementById("paso1").style= "display: none;";
    document.getElementById("textoresultado").innerHTML=`El tipo es: ${tipo(valor)} <br>`;
},false);

document.getElementById("reiniciar").addEventListener("click",(ev)=>{
    document.getElementById("resultado").style= "display: none;";
    document.getElementById("paso1").style= "";
    document.getElementById("texto").focus();
    document.getElementById("texto").value="";
},false);