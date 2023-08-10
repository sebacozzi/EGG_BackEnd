window.onload = function () {
    const url = new URLSearchParams(window.location.search);
    if (typeof (parametros) == "undefined") {
        var parametros = url.get("params");
    }
    document.title = "Ejercicio " + parametros + " - Guia 18";
    document.getElementById("titulo").innerHTML = "Ejercicio " + parametros + " - Guia 18";
    document.getElementById("consigna").innerHTML = decodeURIComponent(atob(sessionStorage.getItem(parametros)));
    document.getElementById("tituloform").innerHTML = `Rellenar arrays`;
};

class Persona {
    nombre;
    edad;
    sexo;
    peso;
    altura;
    mostrar() {
        return `{Persona}\nNombre: ${this.nombre}.\nEdad: ${this.edad}.\nSexo: ${this.sexo}.\nPeso: ${this.peso}.\naltura: ${this.altura}`;
    }
};
let per1 = new Persona;
function completarFormulario() {
    let datosForm = new FormData(document.getElementById("formulario"));
    const cargar = (ob,datos) => {
        /* const ob = new Persona; */
        for (const atrib in ob) {
            if (Object.hasOwnProperty.call(ob, atrib)) {

                if (atrib == "sexo") {
                    ob[atrib] = datos.get(atrib);
                } else {
                    ob[atrib] = datos.get(atrib);
                };
            };
        };
        /* return ob; */
    };
     cargar(per1,datosForm);  
    document.getElementById("listar").disabled=false;
};


const generaStringMatriz = (matriz) => {
    let temp = "";
    const filas = matriz.length;

    for (let i = 0; i < filas; i++) {
        if (typeof (matriz[i].length) === "undefined") {
            temp += matriz[i];
        } else {
            temp += generaStringMatriz(matriz[i]);
        };
    };
    return "[" + temp + "]";
};

const generarString=(vector)=>{
    let temp="[";
for (let i = 0; i < vector.length; i++) {
     temp += vector[i];
    if(i<vector.length-1){temp +=", ";};
};
return temp+"]";
};

document.getElementById("listar").addEventListener("click",()=> {

    let arraypersona= [];
    Object.keys(per1).map((valor)=>{
        arraypersona[arraypersona.length]= per1[valor];
    });
    
    document.getElementById("paso1").style="display: none;";
    document.getElementById("resultado").style="";

     document.getElementById("arr").innerHTML =
        `<u>Info Persona:</u><br>${generarString(arraypersona)}`;

},false);

document.getElementById("reiniciar").addEventListener("click",(ev)=>{
    document.getElementById("arr").innerHTML = "";
    document.getElementById("resultado").style = "display: none";
    document.getElementById("paso1").style="";
    document.getElementById("listar").disabled=true;
    per1 = new Persona;
},false);

document.getElementById("volver").addEventListener("click",(ev)=>{
    document.getElementById("resultado").style = "display: none";
    document.getElementById("paso1").style="";
},false);
