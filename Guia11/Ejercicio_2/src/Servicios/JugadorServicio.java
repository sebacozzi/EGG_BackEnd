/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Jugador;
import java.util.Scanner;

/**
 *
 * @author Sebastián Cozzi
 */
public class JugadorServicio {
    Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
    
    public Jugador crearJugador() {
        String nombre;
        int id;
        System.out.print("Ingresar el id del jugador: ");
        id=leer.nextInt();
        if (id>6 || id<1){
        id=6;
        }
        System.out.print("Ingresar el nombre del jugador: ");
        nombre = leer.next();
        
        return new Jugador(id, nombre);
    }
    
}
