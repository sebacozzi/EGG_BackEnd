/**Se requiere un programa que lea y guarde países, y para evitar que se ingresen repetidos
usaremos un conjunto. El programa pedirá un país en un bucle, se guardará el país en el
conjunto y después se le preguntará al usuario si quiere guardar otro país o si quiere salir,
si decide salir, se mostrará todos los países guardados en el conjunto. (Recordemos hacer
los servicios en la clase correspondiente)
Después deberemos mostrar el conjunto ordenado alfabéticamente: para esto recordar
cómo se ordena un conjunto.
Por último, al usuario se le pedirá un país y se recorrerá el conjunto con un Iterator, se
buscará el país en el conjunto y si está en el conjunto se eliminará el país que ingresó el
usuario y se mostrará el conjunto. Si el país no se encuentra en el conjunto se le informará
al usuario.
*
 */
package ejercicio_5;

import Entidades.Pais;
import Servicios.PaisServicios;

/**
 *
 * @author Sebastian Cozzi
 */
public class Ejercicio_5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Pais pais= new Pais();
       PaisServicios ps = new PaisServicios();
       ps.cargarPaises(pais);
        System.out.println("");
        System.out.println("Lista de Paises:");
        System.out.println("-----------------");
       ps.mostrar(pais);
        System.out.println("---- ---- ---- ---- ---- ---- ---- ----");
        System.out.println("Lista de Paises ordenados:");
        System.out.println("---------------------------");
       ps.ordenarYMostrar(pais);
       ps.buscarYBorrar(pais);
    }
    
    
    
}
/*
México
s
Rusia
s
Sudáfrica
s
Japón
s
Italia
s
Colombia
s
Canadá
s
España
s
Argentina
s
China
s
Australia
s
Francia
s
India
s
Reino Unido
s
Brasil
s
Corea del Sur
s
Turquía
s
Alemania
s
Perú
s
Estados Unidos
n
*/