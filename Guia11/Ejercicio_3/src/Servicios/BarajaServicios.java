/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Baraja;
import Entidades.Carta;

/**
 *
 * @author Sebastián Cozzi
 */
public class BarajaServicios {
    
    public Baraja crearBaraja(){
        Baraja baraja = new Baraja();
        int num =1;
        String[] palos = {"Espada","Basto","Copa","Oro"};
        for (int i = 1; i <= 12; i++) {
            for (int j = 0; j < 4 ; j++) {
                if (i!=8 || i!=9) {
                    baraja.agregaCarta(new Carta(palos[j],i));
                }
            }
        }
        return baraja;
    }
    
}
