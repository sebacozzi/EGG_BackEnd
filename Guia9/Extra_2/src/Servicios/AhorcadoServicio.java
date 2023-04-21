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

    private Scanner leer = new Scanner(System.in);

    public void dibujaOrca(Ahorcado a) {
        String[][] orca = {
            {"___________  ", "___________  ", "___________  ", "___________  ", "___________  ", "___________  ", "___________  "},
            {"|         |  ", "|         |  ", "|         |  ", "|         |  ", "|         |  ", "|         |  ", "|         |  "},
            {"|            ", "|         O  ", "|         O  ", "|         O  ", "|         O  ", "|         O  ", "|         O  "},
            {"|            ", "|            ", "|         |  ", "|        /|  ", "|        /|\\", "|        /|\\", "|        /|\\"},
            {"|            ", "|            ", "|         |  ", "|         |  ", "|         |  ", "|         |  ", "|         |  "},
            {"|            ", "|            ", "|            ", "|            ", "|            ", "|        /   ", "|        / \\"},
            {"|            ", "|            ", "|            ", "|            ", "|            ", "|            ", "|            "},
            {"=============", "=============", "=============", "=============", "=============", "=============", "============="}};
        for (int i = 0; i < 8; i++) {
            System.out.println(orca[i][a.getErrados()]);
        }
        System.out.println(intentos(a));
    }

    public Ahorcado crearJuego() {
        System.out.print("Ingrese la palabra secreta: ");
        String p = leer.nextLine();
        System.out.print("Ingrese la cantidad de intentos: ");
        int in = leer.nextInt();
        return new Ahorcado(p, in);
    }

    public void juego(Ahorcado a) {
       // leer.next();
        System.out.println("Inicio de ahorcado:");
        System.out.println("");
        char letra;
        do{
            System.out.println("-----------------------------------");
            System.out.print("Ingrese una letra: ");
            letra = leer.next().charAt(0);
            System.out.println("Longitud de la palabra: " + longitud(a));
            if (buscar(a, letra)) {
                System.out.println("La letra pertenece a la palabra.");
            } else {
                System.out.println("La letra no pertenece a la palabra.");
            }
            if (!encontradas(a, letra)) {
                a.setErrados();
            }
            System.out.println(intentos(a));
        }while (a.getErrados()<a.getContIntentos());
        
        System.out.println("Te quedaste sin intentos.\nFin del juego");
    }

    private boolean buscar(Ahorcado a, char letra) {
        for (char letras : a.getPalabra()) {
            if (letras == letra) {
                return true;
            }
        }
        return false;
    }

    private boolean encontradas(Ahorcado a, char letra) {
        if (!buscar(a, letra)) {
            return false;
        }
        int cont = 0;
        for (char caracter : a.getPalabra()) {
            if (caracter == letra) {
                cont++;
            }
        }
        System.out.printf("Se encontraron %d letras de %d.\n", cont, longitud(a));
        return true;
    }

    private int longitud(Ahorcado a) {
        return a.getPalabra().length;
    }

    private  String intentos(Ahorcado a) {
        return String.format("Quedan %d de %d intentos.", a.getContIntentos()-a.getErrados(), a.getContIntentos());
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

    public static void esperaTecla() {
        Scanner leer = new Scanner(System.in);
        System.out.println("Presione Intro/Enter para continuar...");
        leer.nextLine();
    }
}
