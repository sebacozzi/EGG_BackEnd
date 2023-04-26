/**Diseñar un programa que lea y guarde razas de perros en un ArrayList de tipo
 * String. El programa pedirá una raza de perro en un bucle, el mismo se
 * guardará en la lista y después se le preguntará al usuario si quiere guardar
 * otro perro o si quiere salir. Si decide salir, se mostrará todos los perros
 * guardados en el ArrayList.
 */
package ejercicio_1;

import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Sebastian Cozzi
 */
public class Ejercicio_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code aplication logic here
       Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
       ArrayList<String> razas= new ArrayList<>();
        do {            
            System.out.print("Ingresar un nombre de raza de perros: ");
            razas.add(leer.next());
            System.out.println("");
            System.out.print("¿Desea ingresar otra raza? (s/n) ");
            if (leer.next().toLowerCase().charAt(0)=='n') {
                break;
            }
            System.out.println("");
        } while (true);
        System.out.println("");
        System.out.println(" Lista de Razas:");
        System.out.println("-----------------");
        for (String raza : razas) {
            System.out.println(raza);
        }
        System.out.println("--- Fin de Lista ---");
    }
    
}
