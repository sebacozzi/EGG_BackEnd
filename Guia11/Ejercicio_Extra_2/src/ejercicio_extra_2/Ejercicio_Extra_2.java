/**Nos piden hacer un programa sobre un Cine, que tiene una sala con un conjunto de asientos
(8 filas por 6 columnas). De Cine nos interesa conocer la película que se está reproduciendo, la
sala con los espectadores y el precio de la entrada. Luego, de las películas nos interesa saber
el título, duración, edad mínima y director. Por último, del espectador, nos interesa saber su
nombre, edad y el dinero que tiene disponible.
Para representar la sala con los espectadores vamos a utilizar una matriz. Los asientos son
etiquetados por una letra y un número la fila A1 empieza al final del mapa como se muestra en
la tabla. También deberemos saber si el asiento está ocupado por un espectador o no, si esta
ocupado se muestra una X, sino un espacio vacío.
8 A X | 8 B X | 8 C X | 8 D | 8 E X | 8 F X
7 A X | 7 B X | 7 C X | 7 D X | 7 E | 7 F X
6 A X | 6 B X | 6 C | 6 D X | 6 E X | 6 F
5 A X | 5 B X | 5 C X | 5 D X | 5 E X | 5 F X
4 A X | 4 B X | 4 C X | 4 D X | 4 E X | 4 F X
3 A X | 3 B X | 3 C X | 3 D | 3 E X | 3 F X
2 A X | 2 B | 2 C X | 2 D X | 2 E X | 2 F
1 A X | 1 B X | 1 C X | 1 D X | 1 E X | 1 F X
Se debe realizar una pequeña simulación, en la que se generen muchos espectadores y se los
ubique en los asientos aleatoriamente (no se puede ubicar un espectador donde ya este
ocupado el asiento).
Los espectadores serán ubicados de uno en uno y para ubicarlos tener en cuenta que sólo se
podrá sentar a un espectador si tiene el dinero suficiente para pagar la entrada, si hay espacio
libre en la sala y si tiene la edad requerida para ver la película. En caso de que el asiento este
ocupado se le debe buscar uno libre.
Al final del programa deberemos mostrar la tabla, podemos mostrarla con la letra y numero de
cada asiento o solo las X y espacios vacíos.
 */
package ejercicio_extra_2;

import Entidades.Cine;
import Entidades.Expectador;
import Entidades.Pelicula;
import Servicios.CineServicios;
import java.util.ArrayList;
import menudeopciones.Menu;
import menudeopciones.ServiciosMenu;

/**
 *
 * @author Sebastián Cozzi
 */
public class Ejercicio_Extra_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] menu = {"Crear Personas","Llenar Sala","Vaciar Sala","Mostrar Personas","Mostrar Expectadores","Mostrar Sala","Mostrar Pelicula","Salir"};
        ServiciosMenu sm = new ServiciosMenu();
        CineServicios cs = new CineServicios();
        Cine cine= new Cine(new Pelicula(),Math.random()*400);
        ArrayList<Expectador> expectadores = new ArrayList();
        
        do {
            sm.show(new Menu(menu,"                    *****************************\n"
                                + "                     *****************************\n"
                                + "                     **  BIENVENIDOS A CINEEGG  **\n"
                                + "                     *****************************\n"
                                + "                     *****************************\n"));
            switch (sm.getResultado()) {
                case 1: // CrearPersonas
                    cs.crearExpectadores(expectadores);
                    break;
                case 2: // LLenarSala
                    cs.LlenarSala(expectadores, cine);
                    break;
                case 3: // Vaciar Sala
                    cs.vaciarSala(cine,expectadores);
                    break;
                case 4: //Mostrar Personas
                    cs.mostrarPersonas(expectadores);
                    break;
                case 5: //Mostrar Expectadores
                    cs.listarExpectadoresEnSala(cine);
                    break;
                case 6: //Mostrar Sala
                    cs.mostrarSala(cine);    
                    break;
                case 7: //Mostrar Pelicula
                cs.mostrarPelicula(cine);
            }
            if (sm.esSalir()) {
                System.out.println("\nGracias por utilizar el cine EGG!!\n");
                break;
            }else{
               ServiciosMenu.esperaTecla();
            }
        } while (true);
    }
    
}
