
document.getElementById("go").addEventListener("click",(ev)=>{
    
    const tx = (a) => {
        let resu="";
        for (let i=a.length-1; i>-1;i--){
            resu = resu + a[i];
        };
        return resu;
    };

    const invsrj=(a)=>{
        return a.split("").reverse().join("");
    };
    document.getElementById("resultado").style= "";
    document.getElementById("paso1").style= "display: none;";
    document.getElementById("textoresultado").innerHTML=`La frase al reves con "for": ${tx(document.getElementById("texto").value)} <br>
                                                         La frase al reves con "Split,reverse y join": ${invsrj(document.getElementById("texto").value)}`;
},false);


document.getElementById("reiniciar").addEventListener("click",(ev)=>{
    document.getElementById("resultado").style= "display: none;";
    document.getElementById("paso1").style= "";
    document.getElementById("texto").focus();
    document.getElementById("texto").value="";

},false);