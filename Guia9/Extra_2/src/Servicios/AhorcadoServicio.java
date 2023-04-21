/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Ahorcado;
//import java.awt.AWTException;
//import java.awt.Robot;
//import java.awt.event.KeyEvent;
import java.util.Scanner;

/**
 *
 * @author Sebastian Cozzi
 */
public class AhorcadoServicio {

// declaración de Scanner y seteo de codificación en el input a ISO-8859-1 (latino)
    private final Scanner leer = new Scanner(System.in, "ISO-8859-1");

    /**
     * Metodo que crea un nuevo <b>objeto Ahorcado</b> solicitandole la palabra
     * a descubrir (acepta una o mas palabras) y la cantidad de veces que va a
     * poder equivocarse.
     *
     * @return <b>Ahorcado</b>
     */
    public Ahorcado crearJuego() {
        String p;
        do {
            System.out.print("Ingrese la palabra secreta: ");
            p = leer.nextLine(); // almacena la o las palabras ingresadas por teclado
        } while (p.trim().isEmpty());
        System.out.print("Ingrese la cantidad de intentos: ");
        int in = leer.nextInt();// almacena la cantidad de intentos para descubrir la palabra
        p = p.trim().toLowerCase(); // elimina espacios al principio y al final, si hay y pasa la palabra a minusculas
        // convierte la palabra ingresada a un array de tipo char
        char[] palabra = new char[p.length()];
        for (int i = 0; i < p.length(); i++) {
            palabra[i] = p.charAt(i);
        }
        return new Ahorcado(palabra, in);
    }

    /**
     * Metodo que gestiona el juego, solicitando las letras y dando respuestas
     * segun corresponda
     *
     * @param a <b>Ahorcado</b> que contiene los datos a jugar
     */
    public void juego(Ahorcado a) {
        // leer.next();
        System.out.println("Inicio de ahorcado:");
        System.out.println("");
        String in;//Almacena el ingreso de la letra y ayuda
        char letra;// Almacena la primera letra de lo ingresado por teclado
        do {
            System.out.println("-----------------------------------");
            System.out.print("Ingrese una letra(para ayuda escribir \"-a\"): ");
            in = leer.next().toLowerCase();
            // ayuda: muestra las letra acertadas ( si las hay) en la posición que corresponde
            // si en una posición no se descubrio la letra, lo reemplaza con "_". Muestra los espacios 
            if (in.charAt(0) == '-' && in.length() > 1) {
                if (in.charAt(1) == 'a') {
                    System.out.println(a.getAyuda());
                    continue;
                }
            }
            letra = in.charAt(0);
            System.out.println("Longitud de la palabra: " + longitud(a));
            // busca si la letra está en la palabra
            if (buscar(a, letra)) {
                System.out.println("La letra pertenece a la palabra.");
                // si ya habia ingresado la letra la agrega como errada. 
                // El mensaje de cantidad de letras acertadas lo maneja "encontradas"
                if (!encontradas(a, letra)) {
                    a.setContadorErradas();
                }
            } else { // mensaje que la letra no pertenece a la palabra e incrementa errada
                System.out.println("La letra no pertenece a la palabra.");
                a.setContadorErradas();
            }

            // sale si llegaste al maximo de intentos
            if (!intentos(a)) {
                System.out.println("Te quedaste sin intentos.\nFin del juego");
                break;
            }
            // sale si completaste la palabra
            if (a.getContadorAcertadas() == longitud(a)) {
                System.out.println("Felicitaciones!!!\nDescubriste la palabra: " + a);
                break;
            }
        } while (true);

    }

    /**
     * Metodo privado que recibe la letra a buscar en la palabra almacenada en
     * Ahorcado y retorna true si está o false si no está
     *
     * @param a <b>Ahorcado</b>
     * @param letra <b>char</b>
     * @return <b>boolean</b>
     */
    private boolean buscar(Ahorcado a, char letra) {
        // convierte el array de char a String
        String s = String.copyValueOf(a.getPalabra());
        //consulta si "s" contiene letra convertida a String
        return s.contains(String.valueOf(letra));
    }

    /**
     * Metodo que permite determinar si la letra ya se habia ingresado, si ya se
     * habia ingresado retorna false, si no se habia ingresado la agrega al
     * array de acertadas perteneciente a <b>Ahorcado</b>
     *
     * @param a <b>Ahorcado</b>
     * @param letra<b>char</b>
     * @return <b>boolean</b>
     */
    private boolean encontradas(Ahorcado a, char letra) {
        // convierte el array de char a String que incluye las letras adivinadas
        //consulta si contiene letra convertida a String y retorna "false" si la letra
        // ya se habia descubierto
        if (String.copyValueOf(a.getAcertadas()).contains(String.valueOf(letra))) {
            System.out.println("Letra repetida, desperdiciaste una chance...");
            System.out.printf("Se encontraron %d letras de %d.\n", a.getContadorAcertadas(), longitud(a));
            return false;
        }
        int cont = 0; // contador para almacenar la cantidad de letras encontradas (letras repetidas)
        // recorre la palabra, agrega la letra a "acertadas e incrementa el contador
        for (char caracter
                : a.getPalabra()) {
            if (caracter == letra) {
                a.setAcertadas(letra);
                cont++;
            }
        }
        // mensaje informando la cantidad de letras encontradas en total y cuantas faltan
        System.out.printf(
                "Se encontraron %d letra/s, faltan %d letra/s.\n", a.getContadorAcertadas(), longitud(a) - a.getContadorAcertadas());
        // retorna "true" porque la letra no estaba entre las que se habian adivinado
        return true;
    }

    /**
     * MEtodo que devuelve la cantidad de letras contiene la palabra almacenada
     * en
     * <b>Ahorcado</b> omitiendo los espacios en blanco
     *
     * @param a<b>Ahorcado</b>
     * @return <b>int</b>
     */
    private int longitud(Ahorcado a) {
        // convierte el array de char que contiene la palabra, reemplaza los
        //espacios con "vacio" y retorna la longitud sin espacios
        // Ej:  a.getPalabra() = ['j','a','v','a',' ','b','a','c','k','e','n','d']
        //      Retorno de "copyValueOf(a.getPalabra()) = "java backend"
        //      Retorno de replaceAll(" ","") = "javabackend"
        //      Retorno de length() = 11
        return String.copyValueOf(a.getPalabra()).replaceAll(" ", "").length();
    }

    /**
     * Metodo que verifica si hay intentos disponibles después de ingresar una
     * letra incorrecta, si no quedan mas intentos devuelve false, sino devuelve
     * true. Muestra mensajes de cuantos intetos quedan o si no quedan mas
     * intentos
     *
     * @param a <b>Ahorcado</b>
     * @return <b>boolean</b>
     */
    private boolean intentos(Ahorcado a) {
        // verifica que queden intentos disponibles, retorna "true" si hay intentos
        if ((a.getContadorIntentos() - a.getContadorErradas()) != 0) {
            System.out.println(String.format("Quedan %d de %d intentos.", a.getContadorIntentos() - a.getContadorErradas(), a.getContadorIntentos()));
            return true;
        }
        System.out.println("Lo sentimos, no quedan más oportunidades...");
        return false;
    }

//    public void dibujaOrca(Ahorcado a) {
//        String[][] orca = {
//            {"___________  ", "___________  ", "___________  ", "___________  ", "___________  ", "___________  ", "___________  "},
//            {"|         |  ", "|         |  ", "|         |  ", "|         |  ", "|         |  ", "|         |  ", "|         |  "},
//            {"|            ", "|         O  ", "|         O  ", "|         O  ", "|         O  ", "|         O  ", "|         O  "},
//            {"|            ", "|            ", "|         |  ", "|        /|  ", "|        /|\\", "|        /|\\", "|        /|\\"},
//            {"|            ", "|            ", "|         |  ", "|         |  ", "|         |  ", "|         |  ", "|         |  "},
//            {"|            ", "|            ", "|            ", "|            ", "|            ", "|        /   ", "|        / \\"},
//            {"|            ", "|            ", "|            ", "|            ", "|            ", "|            ", "|            "},
//            {"=============", "=============", "=============", "=============", "=============", "=============", "============="}};
//        for (int i = 0; i < 8; i++) {
//            System.out.println(orca[i][a.getContadorErradas()]);
//        }
//        System.out.println(intentos(a));
//    }
//
//    public static void cls() {
//        try {
//            Robot robot = new Robot();
//            robot.keyPress(KeyEvent.VK_CONTROL);
//            robot.keyPress(KeyEvent.VK_L);
//            robot.keyRelease(KeyEvent.VK_L);
//            robot.keyRelease(KeyEvent.VK_CONTROL);
//            robot.delay(100);
//        } catch (AWTException e) {
//        }
//    }
//
//    public static void esperaTecla() {
//        Scanner leer = new Scanner(System.in);
//        System.out.println("Presione Intro/Enter para continuar...");
//        leer.nextLine();
//    }
}
