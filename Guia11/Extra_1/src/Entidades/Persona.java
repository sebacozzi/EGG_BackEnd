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

    private String nombre;
    private String apellido;
    private Long documento;
    private Integer edad;
    private Perro perro;

    public Persona() {
    }

    public Persona(String nombre, String apellido, Long documento, Integer edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.edad = edad;
        this.perro = null;
    }

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

    public String getNombreCompleto() {
        return nombre + " " + apellido;
    }

    public Long getDocumento() {
        return documento;
    }

    public void setDocumento(Long documento) {
        this.documento = documento;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Perro getPerro() {
        return perro;
    }

    public void setPerro(Perro perro) {
        this.perro = perro;
    }

    @Override
    public String toString() {
        String resultado = "Datos de la persona:\n"
                + "   Nombre y Apellido: " + nombre + " " + apellido + ".\n"
                + "   Documento: " + documento + ".\n"
                + "   Edad: " + edad + ".\n";
        if (perro == null) {
            resultado = resultado.concat("Perro:\n   Aun no adopto ningun perro.");
        } else {
            String estado = "Aun no lo adoptaron";
            if (perro.getAdpotado()) {
                estado = "Ya fue adoptado";
            }
            resultado = resultado.concat("Perro:\n"
                    + "   Nombre: " + perro.getNombre() + ".\n"
                    + "   Raza: " + perro.getRaza() + ".\n"
                    + "   Tamaño: " + perro.getTamaño() + ".\n"
                    + "   Edad: " + perro.getEdad() + ".\n"
                    + "   Adpotado: " + estado + ".");
        }
        return resultado;
    }

    public String datosPersona() {
        String resultado = "Datos de la persona:\n"
                + "   Nombre y Apellido: " + nombre + " " + apellido + ".\n"
                + "   Documento: " + documento + ".\n"
                + "   Edad: " + edad + ".\n";
        if (perro == null) {
            resultado = resultado.concat("Perro:\n   Aun no adopto ningun perro.");
        } else {
            resultado = resultado.concat("Perro:\n   Ya adopto un perro.");
        }
        return resultado;
    }
}
