/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enums;

/**
 *
 * @author Sebastián Cozzi
 */
public enum Color {
    BLANCO,ROJO,AZUL,VIOLETA,NEGRO,AMARILLO,VERDE,ROSADO,MARRON,FUCSIA;
    
   
    public Color getPorId(int id){
        return Color.values()[id+1];
    }
}
