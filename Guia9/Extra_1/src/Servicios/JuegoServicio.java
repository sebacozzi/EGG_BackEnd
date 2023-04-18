/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Juego;
import java.util.Scanner;

/**
 *
 * @author Sebastian Cozzi
 */
public class JuegoServicio {
    public Juego creaJuego(){
        String[] meses={"enero","febrero","marzo","abril","mayo","junio","julio","agosto","septiembre","octubre","noviembre","diciembre"};
        return new Juego(meses, meses[(int) Math.round(Math.random()*11)]);
    }
    
    
    public void jugar(Juego juego){
        Scanner leer = new Scanner(System.in);
        do{
            System.out.print("Ingresar el mes a descubrir en minusculas: ");
            if (juego.esOculto(leer.nextLine())) {
                break;
            }else{
                System.out.println("No es el mes oculto... intetalo de nuevo.");
            }
        }while (true);
        System.out.println("Felicitaciones!! \""+ juego.getOculto() + "\" era el mes oculto!!");
    }
}
