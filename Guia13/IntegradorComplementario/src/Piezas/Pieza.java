/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Piezas;

/**
 *
 * @author Sebastián Cozzi
 */
abstract class Pieza {
    private Integer consumo;
    private Integer dureza;
    private Double salud;

    public Pieza() {
    }
    
    public abstract void cargar();
    public abstract void inicializarPieza();
}
