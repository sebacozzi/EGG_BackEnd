/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_1;

import java.util.Scanner;

/**
 *
 * @author Sebastián Cozzi
 */
public class Ejercicio_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Persona p = null;
        int i = 0;
        Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
        try {
            i = leer.nextInt();
            System.out.println(p.esMayor(i));
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName());
        }
    }

}
