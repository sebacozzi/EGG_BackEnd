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
    private boolean adpotado;
    private Persona adoptadoPor;

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

    public boolean getAdpotado() {
        return adpotado;
    }

    public void setAdpotado(boolean adpotado) {
        this.adpotado = adpotado;
    }

    public Persona getAdoptadoPor() {
        return adoptadoPor;
    }

    public void setAdoptadoPor(Persona adoptadoPor) {
        this.adoptadoPor = adoptadoPor;
    }

    @Override
    public String toString() {
        
        String estado = "Adpotado: Aun no lo adoptaron";
        if (adpotado) {
            estado = "Adpotado por:\n"
                    + "   Nombre y Apellido: " + adoptadoPor.getNombre() + " " + adoptadoPor.getApellido() + ".\n"
                    + "   Documento: " + adoptadoPor.getDocumento() + ".\n"
                    + "   Edad: " + adoptadoPor.getEdad() + ".\n";;
        }
        return "Perro:\n"
                + "   Nombre: " + nombre + ".\n"
                + "   Raza: " + raza + ".\n"
                + "   Tamaño: " + tamaño + ".\n"
                + "   Edad: " + edad + ".\n"
                + "   " + estado + ".";

      
    }

}
