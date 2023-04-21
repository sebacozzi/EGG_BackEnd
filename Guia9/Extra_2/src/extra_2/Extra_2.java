/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package extra_2;

import Entidades.Ahorcado;
import Servicios.AhorcadoServicio;

/**
 *
 * @author Sebastian Cozzi
 */
public class Extra_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
       AhorcadoServicio as=new AhorcadoServicio();
       Ahorcado a=as.crearJuego();
       as.juego(a);
    }
    
}
