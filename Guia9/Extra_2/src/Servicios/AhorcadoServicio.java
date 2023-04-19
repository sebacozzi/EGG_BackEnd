/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Ahorcado;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;

/**
 *
 * @author Sebastian Cozzi
 */
public class AhorcadoServicio {

    public Ahorcado crearJuego(){
        Scanner leer = new Scanner(System.in);
        System.out.print("Ingresar la palabra a descubrir: ");
     return new Ahorcado(leer.next());   
    }
    
    public boolean ingresaLetra(Ahorcado ahorcado, char letra) {
        if (letra == ' ') {
            return true;
        }
        if (ahorcado.letraEnPalabra(letra)) {
            for (int i = 0; i < ahorcado.getLetrasAcertadas().length; i++) {
                if (ahorcado.getLetrasAcertadas()[i] == letra) {
                    cls();
                    System.out.println("Letra Repetida!!");
                    esperaTecla();
                    return ahorcado.getFallos() < 6;
                }
                if (ahorcado.getLetrasAcertadas()[i] == ' ') {
                    ahorcado.getLetrasAcertadas()[i] = letra;
                    break;
                }
            }
        } else {
            for (int i = 0; i < ahorcado.getLetras().length; i++) {
                if (ahorcado.getLetras()[i] == letra) {
                    cls();
                    System.out.println("Letra repetida!!");
                    esperaTecla();
                    return ahorcado.getFallos() < 6;
                }
                if (ahorcado.getLetras()[i] == ' ') {
                    ahorcado.getLetras()[i] = letra;
                    break;
                }
            }
            ahorcado.incFallos();
        }
        return ahorcado.getFallos() < 6;
    }
    
    public boolean esGanador(Ahorcado ahorcado){
        char[] palabraCompletar= new char[ahorcado.getPalabra().length()];
        for (int i = 0; i < ahorcado.getPalabra().length(); i++) {
            palabraCompletar[i]=ahorcado.letraEnPosicion(ahorcado.getPalabra(),i);
        }
        return ahorcado.getPalabra().equalsIgnoreCase(String.copyValueOf(palabraCompletar));
    }
    
    public static void cls() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(100);
        } catch (AWTException e) {
        }
    }
    public static void esperaTecla(){
        Scanner leer=new Scanner(System.in);
        System.out.println("Presione Intro/Enter para continuar...");
        leer.nextLine();
    }
}
