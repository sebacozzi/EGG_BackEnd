/**Un cine necesita implementar un sistema en el que se puedan cargar peliculas. Para esto,
tendremos una clase Pelicula con el título, director y duración de la película (en horas).
Implemente las clases y métodos necesarios para esta situación, teniendo en cuenta lo
que se pide a continuación:
En el servicio deberemos tener un bucle que crea un objeto Pelicula pidiéndole al usuario
todos sus datos y guardándolos en el objeto Pelicula.
Después, esa Pelicula se guarda una lista de Peliculas y se le pregunta al usuario si quiere
crear otra Pelicula o no.
Después de ese bucle realizaremos las siguientes acciones:

22

• Mostrar en pantalla todas las películas.
• Mostrar en pantalla todas las películas con una duración mayor a 1 hora.
• Ordenar las películas de acuerdo a su duración (de mayor a menor) y mostrarlo en
pantalla.
• Ordenar las películas de acuerdo a su duración (de menor a mayor) y mostrarlo en
pantalla.
• Ordenar las películas por título, alfabéticamente y mostrarlo en pantalla.
• Ordenar las películas por director, alfabéticamente y mostrarlo en pantalla.
 */
package ejercicio_4;

import Entidades.Pelicula;
import Servicios.PeliculaServicios;
import java.util.ArrayList;

/**
 *
 * @author Sebastian Cozzi
 */
public class Ejercicio_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Pelicula> listaDePeliculas= new ArrayList();
        PeliculaServicios ps= new PeliculaServicios();
        ps.cargarPeliculas(listaDePeliculas);
        System.out.println("");
         System.out.println("---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ----");
        System.out.println("Lista de Peliculas cargadas:");
        System.out.println("-----------------------------");
        ps.mostrarPeliculas(listaDePeliculas);
         System.out.println("---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ----");
        System.out.println("Peliculas con duracion mayor de una hora:");
        System.out.println("------------------------------------------");
        ps.mostrarPeliculas(ps.mayorDeUnaHora(listaDePeliculas));
        System.out.println("---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ----");
        System.out.println("Lista de Peliculas ordenadas por duración de mayor a menor:");
        System.out.println("------------------------------------------------------------");
        ps.mostrarPeliculas(ps.ordenar(listaDePeliculas, false, ps.ORDENA_X_DURACION));
        System.out.println("---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ----");
        System.out.println("Lista de Peliculas ordenadas por duración de menor a mayor:");
        System.out.println("------------------------------------------------------------");
        ps.mostrarPeliculas(ps.ordenar(listaDePeliculas, ps.ORDENA_X_DURACION));
        System.out.println("---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ----");
        System.out.println("Lista de Peliculas ordenadas por Director:");
        System.out.println("-------------------------------------------");
        ps.mostrarPeliculas(ps.ordenar(listaDePeliculas, ps.ORDENA_X_DIRECTOR));
        System.out.println("---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ---- ----");
        System.out.println("Lista de Peliculas ordenadas por Titulo:");
        System.out.println("-----------------------------------------");
        ps.mostrarPeliculas(ps.ordenar(listaDePeliculas, ps.ORDENA_X_TITULO));
    }
    
}
/* Seleccionar, copiar y pegar para cargar todos
El Padrino
Francis Ford Coppola
2:55
s
Ciudadano Kane
Orson Welles
1:59
s
La lista de Schindler
Steven Spielberg
3:15
s
Apocalypse Now
Francis Ford Coppola
2:27
s
El Gran Dictador
Charles Chaplin
2:05
s
El Club de la Pelea
David Fincher
2:19
s
Otra Pelicula malisima
Pesimo Director
0:56
s
Blade Runner
Ridley Scott
1:57
s
El Señor de los Anillos: La Comunidad del Anillo
Peter Jackson
2:58
s
Pulp Fiction
Quentin Tarantino
2:34
s
Forrest Gump
Robert Zemeckis
2:22
s
Pelicula mala
Yo
0:59
n
*/