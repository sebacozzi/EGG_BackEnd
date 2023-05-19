/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enumeradores;

/**
 *
 * @author Sebastian Cozzi
 */
public enum Tamaño {
    PEQUEÑO(1,"Pequeño"),MEDIANO(2,"Mediano"),GRANDE(3,"Grande");
    private Integer id;
    private String descripcion;
    
    private Tamaño(Integer id, String descripcion){
        this.id= id;
        this.descripcion = descripcion;
    }
    public Integer getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "Tama\u00f1o{" + "id=" + id + ", descripcion=" + descripcion + '}';
    }
    
}
