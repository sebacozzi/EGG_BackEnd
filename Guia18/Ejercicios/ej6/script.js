const resultado= document.getElementById("resultado");

function verificar(){
    
    const num =parseFloat(document.getElementById("num1").value);
    if ( num !=0 ) {
        if (num % 2 === 0) {
            resultado.innerHTML="\"El número es Par\"";
        } else {
            resultado.innerHTML="\"El número es Impar\"";
        }
    } else {
        resultado.innerHTML="\"El número no es Par ni Impar\"";
    }
    


}