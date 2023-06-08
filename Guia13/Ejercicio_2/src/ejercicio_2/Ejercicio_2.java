/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio_2;

/**
 *
 * @author Sebastián Cozzi
 */
public class Ejercicio_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] lista1 = new int[3];
        try {
            for (int i = 0; i < 10; i++) {
                lista1[i] = i+1;
                System.out.print("["+lista1[i]+"] ");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nError de indice.");
        } finally {
            System.out.println("\n Programa finalizado");
    }
    }
    
}
