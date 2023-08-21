
/*console.warn("Mensaje desde script.js");

console.log("Mensaje log a consola");


var edad = prompt("que edad tenes?",29);

//alert("Tu edad es: "+edad + " años");
var numero = 123;
//umero = "123";
//mensaje con salto y template string con acento invertido
var msg= `La edad del sujeto es....
    .....
    .....
.....
${edad}`;
alert("El tipo de datos es: " + typeof numero);
alert(msg);*/
/* las fechas son mes - día - año*/
var mascota={
    apodo: "mapodo",
    id: 123,
    fnac: new Date("12-05-2012")
};

var persona ={
    apellido: "Cozzi",
    nombre: "Sebastian",
    edad: 42,
    dni: 12345678,
    mass: mascota
};

class pers {
    nombre;
    apellido;
    dni;
}

var p1 = new pers();

p1.nombre= "sebita";
p1.dni = 123456789;

console.log(persona);
console.log(mascota);
console.log(persona.mass.id);
console.log(p1);

let a= 10;

console.log("Antes del if"+a);
if(true){
    a=15;
console.log("dentro del if"+a);
}
console.log("despues del if"+a);