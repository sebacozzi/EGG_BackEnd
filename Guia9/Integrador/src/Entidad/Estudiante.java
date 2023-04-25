/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author Sebastián Cozzi
 */
public class Estudiante {
    private String nombre;
    private int nota;
/**Constructor con parametros
 * 
 * @param nombre String con el nombre del estudiante
 * @param nota int con nota recibida del estudiante
 */
    public Estudiante(String nombre, int nota) {
        this.nombre = nombre;
        this.nota = nota;
    }
/**
 * Contructor sin paramentros
 */
    public Estudiante() {
    }
    
/// GETTERS AND SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
    
}
