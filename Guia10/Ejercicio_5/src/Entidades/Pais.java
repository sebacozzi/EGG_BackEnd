/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.HashSet;

/**
 *
 * @author Sebastian Cozzi
 */
public class Pais {
    private HashSet<String> nombres;

    public Pais() {
    }

    public Pais(HashSet<String> nombres) {
        this.nombres = nombres;
    }

    public HashSet<String> getNombres() {
        return nombres;
    }

    public void setNombres(HashSet<String> nombre) {
        this.nombres = nombre;
    }
    
    public void aniadeNombre(String nombre){
        this.nombres.add(nombre);
    }
  
}
