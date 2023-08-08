window.onload = function () {
    const url = new URLSearchParams(window.location.search);
    if (typeof (parametros) == "undefined") {
        var parametros = url.get("params");
    }
    document.title = "Ejercicio " + parametros + " - Guia 18";
    document.getElementById("titulo").innerHTML = "Ejercicio " + parametros + " - Guia 18";
    document.getElementById("consigna").innerHTML = decodeURIComponent(atob(sessionStorage.getItem(parametros)));
    document.getElementById("tituloform").innerHTML = `Datos de la persona (ID:  ${personas.length + 1})`;
}

class persona {

    constructor(nombre, edad, sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
    }
    getsexo() {
        switch (this.sexo) {
            case "h":
                return "(h) Masculino";
            case "m":
                return "(m) Femenino";
            case "o":
                return "(o) Otro/Prefiero no decirlo"

            default:
                break;
        }
        return
    }
    mostrar() {
        alert(`Hola ${this.nombre},
tenes ${this.edad} y
el sexo es ${this.getsexo()}`);
    }
}
var personas = [];
function completarFormulario() {
    const formulario = document.getElementById("formulario");
    const datosform = new FormData(formulario);
    const opciones = formulario.elements["sexo"];

    if (validar(datosform, opciones)) {
        for (let i = 0; i < opciones.length; i++) {
            if (opciones[i].checked) {
                var sexo = opciones[i].id;
                break;
            }
        };
        personas[personas.length] = new persona(datosform.get("nombre"), parseInt(datosform.get("edad")), sexo);
        formulario.reset();
        formulario.nombre.focus();
        document.getElementById("tituloform").innerHTML = `Datos de la persona (ID:  ${personas.length + 1})`;
        document.getElementById("listar").disabled = false;
        document.getElementById("reiniciar").disabled = false;
    };

}

function validar(form, op) {
    let check = 3;
    let msg = "Falta completar el formulario\n";
    if (form.get("nombre").trim() == "") {
        msg += "- Tiene que cargar el nombre\n"
        check--;
    }
    if (parseInt(form.get("edad")) === 0) {
        msg += "- Tiene que cargar la edad\n";
        check--;
    }
    let ops = false;
    for (let i = 0; i < op.length; i++) {

        if (op[i].checked) {
            ops = true;
            break;
        };
    };

    if (!ops) {
        msg += "- Tiene que cargar el sexo"
        check--;
    }

    if (!(check === 3)) {
        alert(msg);
        return false;
    };
    
    return true;
};

document.getElementById("listar").addEventListener("click", (ev) => {
    const div = document.getElementById("tabla");
    div.innerHTML = "";
    const tabla = document.createElement("table");
    /// titulos de columnas
    const titulos = ["ID", "Nombre", "Edad", "Sexo"];
    var fila = document.createElement("tr");
    for (let i = 0; i < titulos.length; i++) {
        let celda = document.createElement("th");

        celda.textContent = titulos[i];
        fila.appendChild(celda);
    }
    tabla.appendChild(fila);
    /// datos de filas

    for (let i = 0; i < personas.length; i++) {
        fila = document.createElement("tr");

        let celda = document.createElement("td");
        celda.textContent = `${i + 1}`;
        fila.appendChild(celda);
        celda = document.createElement("td");
        celda.textContent = `${personas[i].nombre}`;
        fila.appendChild(celda);
        celda = document.createElement("td");
        celda.textContent = `${personas[i].edad}`;
        fila.appendChild(celda);
        celda = document.createElement("td");
        celda.textContent = `${personas[i].getsexo()}`;
        fila.appendChild(celda);

        tabla.appendChild(fila);
    }
    div.appendChild(tabla)

    document.getElementById("paso1").style = "display: none;";
    document.getElementById("resultado").style = "";

}, false);


document.getElementById("volver").addEventListener("click", (ev) => {
    document.getElementById("resultado").style = "display: none;";
    document.getElementById("paso1").style = "";
    document.getElementById("nombre").focus();
}, false);

document.getElementById("reiniciar").addEventListener("click", (ev) => {
    personas = [];
    document.getElementById("resultado").style = "display: none;";
    document.getElementById("paso1").style = "";
    document.getElementById("nombre").focus();
    document.getElementById("listar").disabled = true;
    document.getElementById("reiniciar").disabled = true;
    document.getElementById("tituloform").innerHTML = `Datos de la persona (ID:  ${personas.length + 1})`;
}, false);