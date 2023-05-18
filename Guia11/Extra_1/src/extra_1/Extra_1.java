/**
 * Ahora se debe realizar unas mejoras al ejercicio de Perro y Persona. Nuestro
 * programa va a tener que contar con muchas personas y muchos perros. El
 * programa deberá preguntarle a cada persona, que perro según su nombre, quiere
 * adoptar. Dos personas no pueden adoptar al mismo perro, si la persona eligió
 * un perro que ya estaba adoptado, se le debe informar a la persona.
 * Una vez que la Persona elige el Perro se le asigna, al final deberemos
 * mostrar todas las personas con sus respectivos perros.
 */
package extra_1;

import Entidades.Perro;
import Entidades.Persona;
import Servicios.PerroServicios;
import Servicios.PersonaServicios;
import java.util.ArrayList;
import menudeopciones.Menu;
import menudeopciones.ServiciosMenu;

/**
 *
 * @author Sebastian Cozzi
 */
public class Extra_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Servicios
        PerroServicios ps = new PerroServicios();
        ServiciosMenu sm = new ServiciosMenu();
        PersonaServicios pS= new PersonaServicios();
        
        // Caracteristicas Menu
        String[] main
                = {"Mascotas",
                    "Personas",
                    "Adopción",
                    "Salir"};

        String[] menuMascotas
                = {"Agregar perro",
                    "Cargar varios perros",
                    "Mostrar todos los perros",
                    "Mostrar los perros adoptados",
                    "Mostrar los perros no adoptados",
                    "Salir"};

        String[] menuPersonas
                = {"Agregar persona",
                    "Agreagar varias Personas",
                    "Mostrar todas las personas",
                    "Mostrar la personas con mascota",
                    "Mostrar las personas sin mascota",
                    "Salir"};

        String[] menuAdopcion
                = {"Adoptar Perro",
                    "Mostrar Familias nuevas",
                    "Mostrar perros disponibles y adoptar",
                    "Salir"};

        // Variables de almasenaje
        ArrayList<Perro> listaDePerros = new ArrayList<>();
        ArrayList<Persona> listaDePersonas = new ArrayList<>();

        /// Menu
        do {
            sm.show(new Menu(main, "# Sistema de adoción de perros #"));
            switch (sm.getResultado()) {
                case 1:
                    // Principal/Mascotas

                    do {
                        sm.show(new Menu(menuMascotas, "Opciones para los perros:"));
                        switch (sm.getResultado()) {
                            case 1:
                                // Principal/Mascotas/Agregar Perro

                                listaDePerros.add(ps.crearPerro());
                                break;
                            case 2:
                                // Principal/Mascotas/Cargar varios Perros

                                ps.crearPerros(listaDePerros);
                                break;
                            case 3:
                                // Principal/Mascotas/Mostrar todos los Perros

                                ps.muestraPerros(listaDePerros);
                                break;
                            case 4:
                                // Principal/Mascotas/Mostrar los perros adoptados

                                ps.muestraPerros(listaDePerros, true);
                                break;
                            case 5:
                                // Principal/Mascotas/Mostrar los perros no adoptados

                                ps.muestraPerros(listaDePerros, false);
                        }

                        if (!sm.esSalir()) {
                            ServiciosMenu.esperaTecla();
                        }
                    } while (!sm.esSalir());

                    break;
                case 2:
                    // Principal/Personas

                    do {
                        sm.show(new Menu(menuPersonas, "Opciones de personas "));
                        switch (sm.getResultado()) {
                            case 1:
                                // Principal/Persona/Agregar persona
                                 
                                    pS.crearPersona();
                                break;
                            case 2:
                                // Principal/Persona/Agreagar varias Personas
                                
                                pS.crearPersonas(listaDePersonas);
                                break;
                            case 3:
                                // Principal/Persona/Mostrar todas las personas

                                
                                break;
                            case 4:
                                // Principal/Persona/Mostrar la personas con mascota

                                break;
                            case 5:
                                // Principal/Persona/Mostrar las personas sin mascota",

                                break;
                        }
                        if (!sm.esSalir()) {
                            ServiciosMenu.esperaTecla();
                        }
                    } while (!sm.esSalir());

                    break;
                case 3:
                // Principal/Adpoción

            }
            if (sm.esSalir()) {
                System.out.println(" ***** GRACIAS POR USAR EL SISTEMA DE ADOPCIÓN *****");
                break;
            }
        } while (true);

//        Perro p1 = ps.crearPerro();
//        
//        ps.crearPerros(listaDePerros);
//        System.out.println("");
//        System.out.println(p1);
//        System.out.println("            **** FIN ****");
//        ps.muestraPerros(listaDePerros);
    }

}
/*
Fernando
Beagle
1
2
Furco
Ovejero Alemán
2
3
Chiquita
Mastin Napolitano
3
1

 */
