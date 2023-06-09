/** Todas estas operaciones puede tirar excepciones a manejar, el ingreso por teclado puede
 * causar una excepción de tipo InputMismatchException, el método Integer.parseInt() si la cadena
 * no puede convertirse a entero, arroja una NumberFormatException y además, al dividir un
 * número por cero surge una ArithmeticException. Manipule todas las posibles excepciones
 * utilizando bloques try/catch para las distintas excepciones
 */
package ejercicio_4;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Sebastián Cozzi
 */
public class Ejercicio_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DivisionNumero dn = new DivisionNumero();
        Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
        String n1 = "", n2 = "";

        try {

            System.out.print("Ingrese el primer número: ");
            n1 = leer.next();

            System.out.print("Ingrese el segundo número: ");
            n2 = leer.next();
           // int n4=leer.nextInt();
            dn.setN1(Integer.parseInt(n1));
            dn.setN2(Integer.parseInt(n2));
            //double n3 = dn.getN1()/dn.getN2();
            System.out.println(dn.division());

        } catch (InputMismatchException e) {
            System.out.println(e.getMessage());
            System.out.println("Error al ingresar el valor.");
            

        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            System.out.println(n1 + " o " + n2 + " no son números enteros.");
            e.printStackTrace();

        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
            System.out.println("Error de división por 0.");
        } finally {
            System.out.println(dn);
        }
        
        
    }
    

}
