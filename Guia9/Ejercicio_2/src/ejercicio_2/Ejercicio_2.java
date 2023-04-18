/** Realizar una clase llamada ParDeNumeros que tenga como atributos dos números
 * reales con los cuales se realizarán diferentes operaciones matemáticas. La
 * clase debe tener un constructor vacío, getters y setters.  En el constructor
 * vacío se usará el Math.random para generar los dos números. Crear una clase
 * ParDeNumerosService, en el paquete Servicios, que deberá además implementar
 * los siguientes métodos:
 *  a) Método mostrarValores que muestra cuáles son los dos números guardados.
 *  b) Método devolverMayor para retornar cuál de los dos atributos tiene el
 * mayor valor
 *  c) Método calcularPotencia para calcular la potencia del mayor valor de la
 * clase elevado al menor número. Previamente se deben redondear ambos valores.
 *  d) Método calculaRaiz, para calcular la raíz cuadrada del menor de los dos
 * valores. Antes de calcular la raíz cuadrada se debe obtener el valor absoluto
 * del número.

 */
package ejercicio_2;

import Entidades.ParDeNumeros;
import Servicios.ParDeNumerosServicio;

/**
 *
 * @author Usuario
 */
public class Ejercicio_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ParDeNumeros nss=new ParDeNumeros((Math.random()*20),(Math.random()*20));
        ParDeNumerosServicio ps= new ParDeNumerosServicio();
        System.out.println("");
        System.out.println("a) Método mostrarValores que muestra cuáles son los dos números guardados.");
        ps.mostrarValores(nss);
        System.out.println("");
        System.out.println("b) Método devolverMayor para retornar cuál de los dos atributos tiene el mayor valor.");
        System.out.println(String.format("El mayor de los dos números es %f.",ps.devolverMayor(nss)));
        System.out.println("");
        System.out.println("c) Método calcularPotencia para calcular la potencia del mayor valor de la\n" +
                           "   clase elevado al menor número. Previamente se deben redondear ambos valores.");
        System.out.println(String.format("La potencia Metodo v1: %d.", ps.calcularPotencia(nss)));
        System.out.println(String.format("La potencia Metodo v2: %d.", ps.calcularPotenciaV2(nss)));
        System.out.println("");
        System.out.println("d) Método calculaRaiz, para calcular la raíz cuadrada del menor de los dos\n" +
                           "   valores. Antes de calcular la raíz cuadrada se debe obtener el valor absoluto\n" +
                           "   del número.");
        System.out.println(String.format("La raiz cuadrada del número menor V1: %f.", ps.calculaRaiz(nss)));
        System.out.println(String.format("La raiz cuadrada del número menor V2: %f.", ps.calculaRaizV2(nss)));
    }
    
}
