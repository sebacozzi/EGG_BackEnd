const texto= document.getElementById("texto");
texto.focus();


document.getElementById("go").addEventListener("click",()=>{
    let tx=texto.value;
    let resu="<i>Por indice: </i>";
    for (let i = 0; i < tx.length; i++) {
     resu = resu + tx[i]+"&nbsp;";
    };
    resu=resu + "<br><br><i>Por SubString(): </i>";
    for (let i=0;i< tx.length;i++){
        resu = resu + tx.substring(i,i+1) + "&nbsp;";
    }
    resu=resu + "<br><br><i>Por charat(): </i>";
    for (let i=0;i< tx.length;i++){
         resu = resu + tx.charAt(i)+ "&nbsp;";
     }
    
    document.getElementById("paso1").style="display: none;";
    document.getElementById("resultado").style="";
    document.getElementById("textoresultado").innerHTML=resu;
},false);


document.getElementById("reiniciar").addEventListener("click",(ev)=>{
    document.getElementById("resultado").style="display: none;";
    document.getElementById("paso1").style="";
    texto.value="";
    texto.focus();
},false);