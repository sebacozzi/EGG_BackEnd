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
        nombres = new HashSet();
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
    
    public boolean aniadeNombre(String nombre){
        return this.nombres.add(nombre);
    }
   public String getNombreID(int id){
       if (id>nombres.size() ) {
           return "fuera de rango.";
       }
       return (String) nombres.toArray()[id-1];
   }
  
}
