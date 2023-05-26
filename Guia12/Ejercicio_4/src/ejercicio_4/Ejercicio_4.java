/*Se plantea desarrollar un programa que nos permita calcular el área y el perímetro de formas
geométricas, en este caso un círculo y un rectángulo. Ya que este cálculo se va a repetir en las
dos formas geométricas, vamos a crear una Interfaz, llamada calculosFormas que tendrá, los
dos métodos para calcular el área, el perímetro y el valor de PI como constante.
Desarrollar el ejercicio para que las formas implementen los métodos de la interfaz y se
calcule el área y el perímetro de los dos. En el main se crearán las formas y se mostrará el
resultado final.
Área circulo: PI * radio ^ 2 / Perímetro circulo: PI * diámetro.
Área rectángulo: base * altura / Perímetro rectángulo: (base + altura) * 2.
 */
package ejercicio_4;

import Entidades.Circulo;
import Entidades.Rectangulo;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Sebastian Cozzi
 */
public class Ejercicio_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n").useLocale(Locale.US);
        System.out.print("Ingrese el radio del circulo: ");
        Circulo c1 = new Circulo(leer.nextDouble());
        
        System.out.println("");
        System.out.print("Ingrese la base del rectangulo: ");
        Double base = leer.nextDouble();
        System.out.print("Ingrese la altura del rectangulo: ");
        Rectangulo r1 = new Rectangulo(leer.nextDouble(), base);
        System.out.println("Calculos: ");
        System.out.printf("Superficie del Circulo: %.3f.\n", c1.calcularSuperficie());
        System.out.printf("Perimetro del Circulo: %.3f.\n", c1.calcularPerimetro());
        System.out.println("");
        System.out.printf("Superficie del Rectangulo: %.3f.\n", r1.calcularSuperficie());
        System.out.printf("Perimetro del Rectangulo: %.3f.\n", r1.calcularPerimetro());
        System.out.println("");
        
        
    }
    
}
