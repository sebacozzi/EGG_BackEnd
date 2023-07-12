/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades.Utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

/**
 *
 * @author Sebastián Cozzi
 */
public class Utils {
    private static final String BLACK_BACK = "\u001B[40m";
    private static final String RED_BACK = "\u001B[41m";
    private static final String GREEN_BACK = "\u001B[42m";
    private static final String YELLOW_BACK = "\u001B[43m";
    private static final String BLUE_BACK = "\u001B[44m";
    private static final String PURPLE_BACK = "\u001B[45m";
    private static final String CYAN_BACK = "\u001B[46m";
    private static final String WHITE_BACK = "\u001B[47m";
    
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";

    public static void esperaTecla() {
        System.out.println("Precione Enter/Intro para continuar.");
        try {
            if (System.console() != null) { // CMD
                System.console().reader().read();
                return;
            }
            System.in.read();
        } catch (IOException e) {
        } catch (Exception ex) {
        }
    }

    public static void cls() {
        if (System.console() != null) {// en CMD
            try {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } catch (IOException | InterruptedException e) {

            }
        } else {// En consola de netbeans
            try {
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_L);
                robot.keyRelease(KeyEvent.VK_L);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                robot.delay(120);
            } catch (AWTException e) {

            }
        }
    }

    public static String tituloDoble(String texto, int margen) {
        int maxLargo = texto.length() + 6;
        int maxAlto = 5 + (texto.length() - texto.replace("\n", "").length());
        String t = "";
        for (int i = 0; i < maxAlto; i++) {
            for (int j = 0; j < maxLargo + margen; j++) {
                if (j < margen) {
                    t += " ";
                } else if (i < 2 || i > maxAlto - 3 || j < margen + 2 || j > margen + maxLargo - 3) {
                    t += GREEN_BACK +ANSI_PURPLE+ "*"+ BLACK_BACK;
                } else if (i < 3 && j < 3 + margen) {

                    t += GREEN_BACK + ANSI_BLUE + " " + texto + ANSI_PURPLE+ " **" + BLACK_BACK;
                    break;
                }
            }
            t += "\n"+ANSI_WHITE;
        }
        return t;
    }

    public static String tituloSimple(String texto, int margen) {
        int maxLargo = texto.length() + 4;
        int maxAlto = 3 + (texto.length() - texto.replace("\n", "").length());
        String t = "";
        for (int i = 0; i < maxAlto; i++) {
            for (int j = 0; j < maxLargo + margen; j++) {
                if (j < margen) {
                    t += " ";
                } else if (i < 1 || i > maxAlto - 2 || j < margen + 1 || j > margen + maxLargo - 2) {
                    t += "*";
                } else if (i < 2 && j < 2 + margen) {

                    t += " " + texto + " *";
                    break;
                }
            }
            t += "\n";
        }
        return t;
    }

    public static String doubleAFormatoInglesString(Double numero) {
        try {
            String s = String.valueOf(numero);
            if (s.contains(",")) {
                s = s.replace(',', '.');
            }
            return s;
        } catch (Exception e) {
            throw e;
        }
    }

    public static String mChar(char c, int largo) {
        String r = " ";
        for (int i = 0; i < largo; i++) {
            r = r + c;
        }
        return r;
    }

    public static void existe(String texto) throws Exception {
        if (texto == null || texto.trim().isEmpty()) {
            throw new Exception("Debe pasar un valor. String vacio o nulo.");
        }
    }

    public static void existe(Integer integer) throws Exception {
        if (integer == null || integer == 0) {
            throw new Exception("Debe pasar un valor. integer vacio o igual a 0.");
        }
    }

    public static void existe(Object entidad) throws Exception {
        if (entidad == null) {
            throw new Exception("La entidad está vacia.");
        }
    }

    public static void muestraExcepcion(Exception e) {
        Utils.cls();
        System.out.println("Se produjo una falla.\n Detalles: ");
        e.printStackTrace();
        Utils.esperaTecla();
    }
}
