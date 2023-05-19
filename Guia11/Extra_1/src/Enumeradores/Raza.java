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
public enum Raza {
    BEAGLE("Beagle"), MASTIN_NAPOLITANO("Mastin Napolitano"), COCKER("Cocker"), PEQUINES("Pequines"), OVEJERO_ALEMAN("Ovejero Alemán");

    private String nombre;

    private Raza(String nombre) {
        this.nombre = nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

}
