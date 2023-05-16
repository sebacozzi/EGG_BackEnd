/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Juego;
import Entidades.Jugador;
import Entidades.Revolver;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Sebastián Cozzi
 */
public class JuegoServicios {

    Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");

    public Juego crearJuego() {
        System.out.println("*******************************************");
        System.out.println("** Iniciando el juego de ruleta de agua. **");
        System.out.println("*******************************************");
        System.out.println("");
        System.out.print("Ingresar la cantidad de participantes: ");
        int participantes = leer.nextInt();
        if (participantes < 1 || participantes > 6) {
            participantes = 6;
        }
        ArrayList<Jugador> jugadores = new ArrayList();
        for (int i = 0; i < participantes; i++) {
            jugadores.add(new Jugador(i + 1));
        }
        Revolver r = new Revolver();
        r.llenarRevolver();
        
        Juego juego = new Juego();
        juego.llenarJuego(jugadores, r);
        return juego;
    }
    

    public void ronda(Juego juego) {
       // juego.getRevolver().;
        
    }
    
    public void estadoJugadores(Juego juego){
        for (Jugador jugador : juego.getJugadores()) {
            System.out.println(jugador.toString());
        }
    }
}
