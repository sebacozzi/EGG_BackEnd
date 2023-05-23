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
import Servicios.AdopcionServicios;
import Servicios.PerroServicios;
import Servicios.PersonaServicios;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
        PersonaServicios perServicios = new PersonaServicios();

        // Caracteristicas Menu
        String[] main
                = {"Mascotas",
                    "Personas",
                    "Adopción",
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

                    menuMascotas(listaDePerros, ps);
                    break;
                case 2:
                    // Principal/Personas

                    menuPersonas(listaDePersonas, perServicios);
                    break;
                case 3:
                    // Principal/Adpoción

                    menuAdopcion(listaDePersonas, listaDePerros, ps, perServicios);
            }
            if (sm.getResultado() == 4) {
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

    private static void menuMascotas(List<Perro> listaDePerros, PerroServicios ps) {
        String[] opcionesMenu
                = {"Agregar perro",
                    "Cargar varios perros",
                    "Mostrar todos los perros",
                    "Mostrar los perros adoptados",
                    "Mostrar los perros no adoptados",
                    "Volver"};
        ServiciosMenu sm = new ServiciosMenu();
        do {
            sm.show(new Menu(opcionesMenu, "Opciones para los perros:"));
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

            if (sm.getResultado() == 6) {
                break;
            } else {
                ServiciosMenu.esperaTecla();
            }
        } while (!sm.esSalir());
    }

    private static void menuPersonas(List<Persona> listaDePersonas, PersonaServicios perServicios) {
        String[] opcionesMenu
                = {"Agregar persona",
                    "Agreagar varias Personas",
                    "Mostrar todas las personas",
                    "Mostrar la personas con mascota",
                    "Mostrar las personas sin mascota",
                    "Volver"};
        ServiciosMenu sm = new ServiciosMenu();
        do {
            sm.show(new Menu(opcionesMenu, "Opciones de personas "));
            switch (sm.getResultado()) {
                case 1:
                    // Principal/Persona/Agregar persona

                    perServicios.crearPersona();
                    break;
                case 2:
                    // Principal/Persona/Agreagar varias Personas

                    perServicios.crearPersonas(listaDePersonas);
                    break;
                case 3:
                    // Principal/Persona/Mostrar todas las personas

                    perServicios.mostrarPersonasYMascotas(listaDePersonas, false);
                    break;
                case 4:
                    // Principal/Persona/Mostrar la personas con mascota

                    perServicios.mostrarPersonasYMascotas(listaDePersonas, true);
                    break;
                case 5:
                    // Principal/Persona/Mostrar las personas sin mascota",

                    perServicios.mostrarPersonasSinMascotas(listaDePersonas);
                    break;
            }
            if (sm.getResultado() == 6) {
                break;
            } else {
                ServiciosMenu.esperaTecla();
            }
        } while (true);
    }

    private static void menuAdopcion(List<Persona> listaDePersonas, List<Perro> listaDePerros, PerroServicios ps, PersonaServicios perServicios) {
        Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
        String[] opcionesMenu
                = {"Adoptar Perro",
                    "Mostrar Familias nuevas",
                    "Mostrar perros disponibles y adoptar",
                    "Volver"};
        String nombre;
        AdopcionServicios as= new AdopcionServicios();
        ServiciosMenu sm = new ServiciosMenu();
        do {
            sm.show(new Menu(opcionesMenu, "Opciones de adopción:"));
            switch (sm.getResultado()) {
                case 1://"Adoptar Perro"
                    System.out.println("Adopción:");
                        for (Persona persona : listaDePersonas) {
                            if (persona.getPerro()==null){
                                as.personaAdoptaPerro(persona, listaDePerros);
                    } 
                        }
                    break;
                case 2:
                    perServicios.mostrarPersonasYMascotas(listaDePersonas, true);
                    break;
                    
                case 3:
                    break;
                    
          
            }
            if (sm.esSalir()) {
                break;
            } else {
                ServiciosMenu.esperaTecla();

            }
        } while (true);
    }
}

/*

Personas

Perros

Fernando
Beagle
2
Furco
Ovejero Alemán
3
Chiquita
Mastin Napolitano
1

 */
