/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;

/**
 *
 * @author Sebastian Cozzi
 */

public class Perro {
    private String nombre, raza, tamanio;
    private int edad;

    public Perro() {
    }

    public Perro(String nombre, String raza, String tamanio, int edad) {
        this.nombre = nombre;
        this.raza = raza;
        this.tamanio = tamanio;
        this.edad = edad;
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

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Datos del Perro:\n  Nombre: " + nombre + ".\n  Raza: " + raza + ".\n  Tamaño: " + tamanio + ".\n  Edad: " + edad + " años.";
    }
    
}
