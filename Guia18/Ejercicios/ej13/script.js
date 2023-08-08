window.onload = function(){
    const titulo = document.title;
    document.getElementById("titulo").innerHTML = titulo;
}

document.getElementById("reiniciar").addEventListener("click",(ev)=>{
    document.getElementById("resultado").style= "display: none;";
    document.getElementById("paso1").style= "";
    document.getElementById("texto").focus();
    document.getElementById("texto").value="";
},false);