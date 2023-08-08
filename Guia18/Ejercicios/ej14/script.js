window.onload = function () {
    const url = new URLSearchParams(window.location.search);
    if (typeof (parametros) == "undefined") {
        var parametros = url.get("params");
    }
    document.title = "Ejercicio " + parametros + " - Guia 18";
    document.getElementById("titulo").innerHTML = "Ejercicio " + parametros + " - Guia 18";
    document.getElementById("consigna").innerHTML = decodeURIComponent(atob(sessionStorage.getItem(parametros)));
    document.getElementById("tituloform").innerHTML = `Datos del Libro (ID:  ${libros.length + 1})`;
}

class Libro {
    constructor(isbn, titulo, autor, cantidadPaginas) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.cantidadPaginas = cantidadPaginas;
    }
    mostrar() {
        alert(`Libro ${this.titulo}.
Autor: ${this.edad}.
ISBN: ${this.isbn}
Cantidad de páginas: ${this.cantidadPaginas}`);
    }
}
var libros = [];
function completarFormulario() {
    const formulario = document.getElementById("formulario");
    const isbn = formulario.isbn.value;
    const titulo = formulario.titulo.value;
    const autor = formulario.autor.value;
    const paginas = parseInt(formulario.paginas.value);
    libros[libros.length] = new Libro(isbn, titulo, autor, paginas);
    formulario.reset();
    formulario.isbn.focus();
    document.getElementById("tituloform").innerHTML = `Datos del Libro (ID:  ${libros.length + 1})`;
    document.getElementById("listar").disabled = false;
    document.getElementById("reiniciar").disabled = false;

}

document.getElementById("listar").addEventListener("click", (ev) => {
    const div = document.getElementById("tabla");
    div.innerHTML = "";
    const tabla = document.createElement("table");
    /// titulos de columnas
    const titulos = ["ID", "ISBN", "Titulo", "Autor", "Paginas"];
    var fila = document.createElement("tr");
    for (let i = 0; i < titulos.length; i++) {
        let celda = document.createElement("th");

        celda.textContent = titulos[i];
        fila.appendChild(celda);
    }
    tabla.appendChild(fila);
    /// datos de filas

    for (let i = 0; i < libros.length; i++) {
        fila = document.createElement("tr");

        let celda = document.createElement("td");
        celda.textContent = `${i + 1}`;
        fila.appendChild(celda);
        celda = document.createElement("td");
        celda.textContent = `${libros[i].isbn}`;
        fila.appendChild(celda);
        celda = document.createElement("td");
        celda.textContent = `${libros[i].titulo}`;
        fila.appendChild(celda);
        celda = document.createElement("td");
        celda.textContent = `${libros[i].autor}`;
        fila.appendChild(celda);
        celda = document.createElement("td");
        celda.textContent = `${libros[i].cantidadPaginas}`;
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
    document.getElementById("isbn").focus();
}, false);

document.getElementById("reiniciar").addEventListener("click", (ev) => {
    libros = [];
    document.getElementById("resultado").style = "display: none;";
    document.getElementById("paso1").style = "";
    document.getElementById("isbn").focus();
    document.getElementById("listar").disabled = true;
    document.getElementById("reiniciar").disabled = true;
    document.getElementById("tituloform").innerHTML = `Datos de la persona (ID:  ${libros.length + 1})`;
}, false);