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
public abstract class Edificio {
    protected Double ancho;
    protected Double alto;
    protected Double largo;

    public Edificio() {
    }

    
    /**
     * Metodo encargado de calcular la superficie del edificio
     * @return Double con el valor de la superficie
     */
    public abstract Double calcularSuperficie();
    
    /**
     * Metodo encargado de calcular el volumen del edificio
     * @return Double con el calculo del volumen
     */
    public abstract Double calcularVolumen();    
    
    
}
