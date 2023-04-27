/*1. Diseñar un programa que lea y guarde razas de perros en un ArrayList de tipo String. El
programa pedirá una raza de perro en un bucle, el mismo se guardará en la lista y
después se le preguntará al usuario si quiere guardar otro perro o si quiere salir. Si decide
salir, se mostrará todos los perros guardados en el ArrayList.

2. Continuando el ejercicio anterior, después de mostrar los perros, al usuario se le pedirá
un perro y se recorrerá la lista con un Iterator, se buscará el perro en la lista. Si el perro
está en la lista, se eliminará el perro que ingresó el usuario y se mostrará la lista
ordenada. Si el perro no se encuentra en la lista, se le informará al usuario y se mostrará
la lista ordenada.
 */
package ejercicio_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Sebastián Cozzi
 */
public class Ejercicio_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
        System.out.println(razas.toString());
        System.out.println("--- Fin de Lista ---");
        
        System.out.println("");
        
        System.out.println("---- Ejercicio 2 ----");
        
        System.out.print("ingrese una raza para ver si está en la lista: ");
        String raza = leer.next();
        Iterator<String> iRazas = razas.iterator();
        while (iRazas.hasNext()) {
            if (iRazas.next().equals(raza)){
                System.out.println("La raza ingresada se encuentra en la lista.");
                iRazas.remove();
            }
        }
        Collections.sort(razas);
        System.out.println(String.format("--- Arraylist nuevo sin %s y ordenada ---",raza));
        System.out.println(razas.toString());
        
    }
    
}
