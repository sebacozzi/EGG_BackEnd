/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Sebastian Cozzi
 */
public class Persona {
    private String nombre, apellido;
    private int edad;
    private long documento;
    private Perro perro;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public long getDocumento() {
        return documento;
    }

    public void setDocumento(long documento) {
        this.documento = documento;
    }

    public Perro getPerro() {
        return perro;
    }

    public void setPerro(Perro perro) {
        this.perro = perro;
    }

    public Persona(String nombre, String apellido, int edad, long documento, Perro perro) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.documento = documento;
        this.perro = perro;
    }

    public Persona() {
    }

    @Override
    public String toString() {
        if (perro==null){
            return "Datos de la persona:" + "\n  Nombre y Apellido: " + nombre + " " + apellido + ".\n  Edad: " + edad + " años.\n  Documento=" + documento + ".\nNo tiene ningún perro";
        }else
        return "Datos de la persona:" + "\n  Nombre y Apellido: " + nombre + " " + apellido + ".\n  Edad: " + edad + " años.\n  Documento=" + documento + ".\n" + perro;
    }
}
