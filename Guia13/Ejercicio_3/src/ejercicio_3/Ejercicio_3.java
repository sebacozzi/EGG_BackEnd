/**
 * Defina una clase llamada DivisionNumero. En el método main utilice un Scanner para leer dos
números en forma de cadena. A continuación, utilice el método parseInt() de la clase Integer,
para convertir las cadenas al tipo int y guardarlas en dos variables de tipo int. Por ultimo realizar
una división con los dos numeros y mostrar el resultado.
 */
package ejercicio_3;

import java.util.Scanner;

/**
 *
 * @author Sebastián Cozzi
 */
public class Ejercicio_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DivisionNumero dn=new DivisionNumero();
        Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
        
        System.out.print("Ingrese el primer número: ");
        String n1 = leer.next();
        System.out.print("Ingrese el segundo número: ");
        String n2 = leer.next();
        
        dn.setN1(Integer.parseInt(n1));
        dn.setN2(Integer.parseInt(n2));
        
        System.out.println(dn.division());
        
    }
    
}
