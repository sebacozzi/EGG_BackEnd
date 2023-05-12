/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Sebastián Cozzi
 */
public class Revolver {
    private int posicion;
    private int carga;

    public Revolver() {
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    public void llenarRevolver(){
        posicion=(int)(Math.random()*6);
        carga = (int)(Math.random()*6);
    }
    
    public boolean mojar(Revolver gun){
        return carga== posicion;
    }
    
    public void siguienteChorro(){
        if (posicion==6){
            posicion=1;
        } else
            posicion++;
    }
   
    @Override
    public String toString() {
        return "Revolver:\n" + "posición del tambor: " + posicion + ".\n La carga está en la posición: " + carga + '.';
    }
}
