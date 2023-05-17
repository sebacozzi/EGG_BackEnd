/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Baraja;
import Entidades.Carta;
import java.util.Collections;
import menudeopciones.Menu;
import menudeopciones.ServiciosMenu;

/**
 *
 * @author Sebastián Cozzi
 */
public class BarajaServicios {

    public void juego(Baraja baraja) {
        String[] items = {"Barajar", "Siguiente Carta", "Cartas Disponibles", "Dar Cartas", "Cartas del montón", "Mostrar Maso", "Salir"};

        ServiciosMenu menu = new ServiciosMenu();

        baraja = crearBaraja();
        
        do {
            menu.show(new Menu(items, "Juego de Baraja Españolas"));
            switch (menu.getResultado()) {
                case 1://Barajar
                    System.out.println("Mesclando la baraja....");
                    barajar(baraja);
                    break;
                case 2: // Siguiente carta
                    System.out.println("Carta dada: " + siguienteCarta(baraja));
                    break;
                case 3: //Cartas disponibles
                    System.out.printf("Tiene %d cartas disponibles.\n", baraja.getmaso().size());
                    break;
                case 4:// Dar Cartas
                    darCartas(baraja,menu.preguntaInt("Ingresar la cantidad de cartas a repartir->"));
                    break;
                case 5: // Cartas del Monton
                    System.out.println(baraja.toStringMonton());
                    break;
                case 6: // Mostrar Maso
                    System.out.println(baraja.toStringMaso());
                    break;
            }
            if (!menu.esSalir()){
                menu.esperaTecla();
            }
        } while (!menu.esSalir());
    }


public Baraja crearBaraja(){
        Baraja baraja = new Baraja();
        int num =1;
        String[] palos = {"Espada","Basto","Copa","Oro"};
        for (int i = 1; i <= 12; i++) {
            for (int j = 0; j < 4 ; j++) {
                if (i!=8 && i!=9) {
                    baraja.agregaCarta(new Carta(palos[j],i));
                }
            }
        }
        return baraja;
    }
    
    public void barajar(Baraja baraja){
       Collections.shuffle(baraja.getmaso());
    }
    
    public Carta siguienteCarta(Baraja baraja){
        Carta carta= baraja.darCarta(baraja.getmaso().get(0));
       if (carta == null){
           System.out.println("Se termino el maso. No hay mas cartas para repartir.");
           return null;
       }
       return carta;
    }
    
    public boolean darCartas(Baraja baraja,int dar){
        if (baraja.getmaso().size()<dar){
            dar=baraja.getmaso().size();
            System.out.printf("*** La cantidad de cartas disponibles es %d, solo se entragaran esas. ***",dar);   
        }
        System.out.println("Lista de cartas entregadas: ");
        for (int i = 0; i < dar; i++) {
            System.out.println(baraja.getmaso().get(0));
            baraja.darCarta(baraja.getmaso().get(0));
        }
        return true;
    }
}
