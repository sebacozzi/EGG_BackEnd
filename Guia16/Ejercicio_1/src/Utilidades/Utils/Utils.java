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

    public static String titulo(String texto, int margen) {
        int maxLargo = texto.length() + 6;
        int maxAlto = 5 + (texto.length() - texto.replace("\n", "").length());
        String t = "";
        for (int i = 0; i < maxAlto; i++) {
            for (int j = 0; j < maxLargo + margen; j++) {
                if (j < margen) {
                    t += " ";
                } else if (i < 2 || i > maxAlto - 3 || j < margen + 2 || j > margen + maxLargo - 3) {
                    t += "*";
                } else if (i < 3 && j < 3 + margen) {

                    t += " " + texto + " **";
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
}
