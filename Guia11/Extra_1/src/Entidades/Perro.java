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
public class Perro {

    private String nombre;
    private String raza;
    private String tamaño;
    private Integer edad;
    private Boolean adpotado;

    public Perro() {
    }

    public Perro(String nombre, String raza, String tamaño, Integer edad) {
        this.nombre = nombre;
        this.raza = raza;
        this.tamaño = tamaño;
        this.edad = edad;
        this.adpotado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Boolean getAdpotado() {
        return adpotado;
    }

    public void setAdpotado(Boolean adpotado) {
        this.adpotado = adpotado;
    }

    @Override
    public String toString() {
        String estado =  "Aun no lo adoptaron";
        if (adpotado) {
            estado = "Ya fue adoptado";
        }
        return "Perro:\n"
                + "   Nombre: " + nombre + ".\n"
                + "   Raza: " + raza + ".\n"
                + "   Tamaño: " + tamaño + ".\n"
                + "   Edad: " + edad + ".\n"
                + "   Adpotado: " + estado + ".";
    }

}
