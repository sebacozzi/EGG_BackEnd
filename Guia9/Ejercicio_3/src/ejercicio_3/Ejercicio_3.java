/** Crear en el Main dos arreglos. El arreglo A de 50 números reales y el arreglo
 * B de 20 números reales. Crear la clase ArregloService, en el paquete servicio
 * , con los siguientes métodos:
 *  a) Método inicializarA recibe un arreglo por parámetro y lo inicializa con
 * números aleatorios.
 *  b) Método mostrar recibe un arreglo por parámetro y lo muestra por pantalla.
 *  c) Método ordenar recibe un arreglo por parámetro y lo ordena de mayor a menor.
 *  d) Método inicializarB copia los primeros 10 números del arreglo A en el
 * arreglo B. Luego llenar las últimas 10 posiciones del arreglo B con 0.5.
 * En el Main nuevamente: inicializar A, mostrar A, ordenar A, inicializar B, mostrar A y B.
 *
 */
package ejercicio_3;

import Servicios.ArregloService;

/**
 *
 * @author Sebastian Cozzi
 */
public class Ejercicio_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Double[] A = new Double[50];
        Double[] B = new Double[20];
        ArregloService as = new ArregloService();
        System.out.println(" a) Método inicializarA recibe un arreglo por parámetro y lo inicializa con\n"
                         + "    números aleatorios.");
        A = as.inicializarA(A);
        System.out.println("");
        System.out.println("Mostrar Arreglo A:");
        as.mostrar(A);
        System.out.println("");
        System.out.println("Ordenar Arreglo A.");
        A= as.ordenar(A);
        System.out.println("");
        System.out.println("Inicializar arreglo B.");
        B= as.inicializarB(A, B);
        System.out.println("");
        System.out.println("Mostrar Arreglo A:");
        as.mostrar(A);
        System.out.println("");
        System.out.println("Mostrar Arreglo B:");
        as.mostrar(B);
    }

}
