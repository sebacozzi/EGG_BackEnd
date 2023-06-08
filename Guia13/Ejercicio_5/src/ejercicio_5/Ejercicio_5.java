/**Escribir un programa en Java que juegue con el usuario a adivinar un número.
 * La computadora debe generar un número aleatorio entre 1 y 500, y el usuario
 * tiene que intentar adivinarlo. Para ello, cada vez que el usuario introduce 
 * un valor, la computadora debe decirle al usuario si el número que tiene que
 * adivinar es mayor o menor que el que ha introducido el usuario. Cuando consiga
 * adivinarlo, debe indicárselo e imprimir en pantalla el número de veces que el
 * usuario ha intentado adivinar el número. Si el usuario introduce algo que no
 * es un número, se debe controlar esa excepción e indicarlo por pantalla. En
 * este último caso también se debe contar el carácter fallido como un intento.
 */
package ejercicio_5;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Sebastián Cozzi
 */
public class Ejercicio_5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer pregunta = (int) (Math.random() * 501+1);
        Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
        int n=0;
        int cont = 0;
        boolean continua = true;
        System.out.println("Tenes que adivinar el número secreto: " + pregunta);
        do {
            try {
                System.out.print("-> ");
                n = leer.nextInt();
                switch (pregunta.compareTo(n)) {
                    case 1:
                        System.out.println("El numero a adivinar es mayor.");
                        cont++;
                        break;
                    case 0:
                        System.out.println("Felicitaciones Adivinaste el número.");
                        cont++;
                        continua=false;
                        break;
                    case -1:
                        System.out.println("El numero a adivinar es menor.");
                        cont++;
                        break;
                }
            } catch (InputMismatchException e) {
                cont++;
                System.out.println("Ingresaste cualquier cosa... menos un número entero.");
                leer.next();
                
            }
   
        } while (continua);
        System.out.println("Lo intentaste " + cont + " veces.");
        
    }
    
}
