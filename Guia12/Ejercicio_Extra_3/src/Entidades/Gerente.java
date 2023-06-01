/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Sebastián Cozzi
 */
public class Gerente {

    private String nombre;
    private long dni;
    private int edad;

    public Gerente() {
    }

    public Gerente(String nombre, long dni, int edad) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    private final String[] nombres = {"Juan", "María", "Carlos", "Ana", "Luis", "Laura", "Pedro",
        "Gabriela", "Diego", "Silvia", "Javier", "Valentina", "Santiago", "Mariana",
        "Andrés", "Florencia", "Emilio", "Victoria", "Hugo", "Julia"};

    private final String[] apellidos = {"González", "Rodríguez", "Fernández", "López", "Martínez",
        "Gómez", "Pérez", "Sánchez", "Romero", "Torres", "Díaz", "Morales", "Vargas",
        "Rojas", "Acosta", "Molina", "Suárez", "Ramos", "Silva", "Cabrera"};

    public void crearAzar() {

        this.nombre = randNombre() + " " + randApellido();
        this.dni = Math.round(Math.random()*28000000)+12000000;
        this.edad = 70-Math.round(dni/1000000);
        System.out.println(Math.round(dni/1000000));
    }

    private String randNombre() {
        return nombres[(int) Math.round(Math.random() * (nombres.length - 1))];
    }

    private String randApellido() {
        return apellidos[(int) Math.round(Math.random() * (nombres.length - 1))];
    }

    @Override
    public String toString() {
        return "Gerente{" + "nombre=" + nombre + ", dni=" + dni + ", edad=" + edad + '}';
    }
}
