package Libreria;

import Libreria.Entidades.Autor;
import Libreria.Entidades.Editorial;
import Libreria.Entidades.Libro;
import Libreria.Servicios.ServiciosAutor;
import Libreria.Servicios.ServiciosEditorial;
import Libreria.Servicios.ServiciosLibro;
import Utilidades.Menu.Menu;
import Utilidades.Menu.ServiciosMenu;
import Utilidades.Utils.Inputs;
import Utilidades.Utils.Utils;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

/*
1) Crear base de datos Librería
2) Crear unidad de persistencia
3) Crear entidades previamente mencionadas (excepto Préstamo) 
4) Generar las tablas con JPA
5) Crear servicios previamente mencionados.
6) Crear los métodos para persistir entidades en la base de datos librería
7) Crear los métodos para dar de alta/bajo o editar dichas entidades.
8) Búsqueda de un Autor por nombre.
9) Búsqueda de un libro por ISBN.
10) Búsqueda de un libro por Título. 
11) Búsqueda de un libro/s por nombre de Autor.
12) Búsqueda de un libro/s por nombre de Editorial.
13) Agregar las siguientes validaciones a todas las funcionalidades de la aplicación: 
• Validar campos obligatorios.
• No ingresar datos duplicados.
 */
/**
 *
 * @author Sebastian Cozzi
 */
public class Ejercicio_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        ServiciosMenu sm = new ServiciosMenu();

        ServiciosEditorial se = new ServiciosEditorial();
        ServiciosAutor sa = new ServiciosAutor();
        ServiciosLibro sl = new ServiciosLibro();

        //// Opciones para los menues///
        String[] menuPrincipal = {
            "Menu Editorial",
            "Menu Autor",
            "Menu Libro",
            "Salir"};
        String[] menuEditorial = {
            "Crear nueva editorial",
            "Editar editorial",
            "Eliminar Editorial",
            "Mostrar nombres de Editoriales",
            "Mostrar información completa de las Editoriales",
            "Volver"};
        String[] menuAutor = {
            "Crear Autor nuevo",
            "Editar Autor",
            "Eliminar Autor",
            "Mostrar Autores",
            "Mostrar información completa de los autores",
            "Volver"};
        String[] menuLibro = {
            "Crear un nuevo Libro",
            "Editar un libro",
            "Eliminar un Libro",
            "Mostrar titulos de los libros",
            "Mostrar información completa de los libros",
            "Mostrar libros de un autor",
            "Mostrar libros de una editorial",
            "Volver"};
        /// Test ///
//        String respuetaMChoice = (String) sm.multipleChoice(sa.NombresDeAutores(), "Nombres de Autores cargados:").values().toArray()[0];
//        Autor tempAutor = sa.buscarAutorPorNombre(respuetaMChoice);
//        String[] columnas ={"titulo","ejemplares"};
//                        sl.mostrarSegunTitulos(sa.listaDeLibrosDelAutor(tempAutor),columnas);
//                       Utils.esperaTecla();
    String ni=null;
        try {
            if (!ni.equals(null)) {
                System.out.println("Nombre = null");
            }
            System.out.println("Nombre vacio");
            
        } catch (Exception e) {
            System.out.println("Nombre no puede ser nulo");
            
        }
        Utils.esperaTecla();
        try {
            do {
                sm.showMenu(menuPrincipal, "Menu Principal de Libreria");
                switch (sm.getResultado()) {
                    case 1://            "Menu Editorial"
                        menuEditorial(se, menuEditorial);
                        break;
                    case 2://            "Menu Autor"
                        menuAutor(sa, menuAutor);
                        break;
                    case 3://            "Menu Libro"
                        menuLibro(sl,sa ,se , menuLibro);
                        break;
                }
                if (sm.esSalir()) {//            "Salir"
                    break;
                }
            } while (true);
        } catch (Exception e) {
            Utils.muestraExcepcion(e);
        }
        
        
        
        
        //System.out.println(sm.multipleChoice(sl.listaNombresDeLibros(), "Lista de Autores:").values().toArray()[0]);
//        se.mostrar1(se.listaDeNombresDeEditoriales(), "Nombres de Editoriales");
//        se.mostrar(se.listaDeEditoriales());
//        sa.mostrar(sa.listaDeAutores());
//        sl.mostrar(sl.listaDeLibros());

    }
    
    
    private static void menuEditorial(ServiciosEditorial se, String[] opciones) {
        try {
            Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
            String nombre;
            String mensaje;
            String respuetaMChoice;
            Editorial editorial;
            ServiciosMenu sm = new ServiciosMenu();
            do {
                sm.showMenu(opciones, "Menu de manejo de Editoriales");
                switch (sm.getResultado()) {
                    case 1://            "Crear nueva editorial"
                        System.out.println(Utils.tituloSimple(opciones[sm.getResultado()-1], 15));
                        
                        editorial = se.crearEditorial();
                        if (editorial== null) {
                            System.out.println("No se cargo ninguna Editorial. Volviendo al menu.");
                        } else{
                        System.out.println(Utils.tituloSimple("Editorial creada con exito", 15));
                        se.mostrar(editorial);
                        }
                        break;
                    case 2://            "Editar editorial"
                        
                        System.out.println(Utils.tituloSimple(opciones[sm.getResultado()-1], 15));
                        
                        if (se.modificarEditorial()) {
                            mensaje = "La editorial se modifico correctamente.";
                        } else{
                            mensaje  = "La editorial no se nodifico.";
                        }
                        System.out.println(Utils.tituloSimple(mensaje, 15));
                        break;
                        
                    case 3://            "Eliminar Editorial"
                        
                        System.out.println(Utils.tituloSimple(opciones[sm.getResultado()-1], 15));
                        
                        if (se.eliminarEditorial()) {
                            mensaje = "Eliminaste definitivamente la Editorial.";
                            
                        } else {
                            mensaje = "Por suerte no eliminaste la editorial.";
                        }
                        
                        System.out.println(Utils.tituloSimple(mensaje, 15)
                        );
                        break;
                        
                    case 4://            "Mostrar nombres de Editoriales"

                        System.out.println(Utils.tituloSimple(opciones[sm.getResultado()-1], 15));
                        se.mostrar1(se.listaDeNombresDeEditoriales(), "Nombres");
                        break;
                    case 5://            "Mostrar información completa de las Editoriales"
                        
                        System.out.println(Utils.tituloSimple(opciones[sm.getResultado()-1], 15));
                        se.mostrar(se.listaDeEditoriales());
                }
                if (sm.esSalir()) {//            "Volver"
                    break;
                } else {
                    Utils.esperaTecla();
                }
            } while (true);

        } catch (Exception e) {
            Utils.muestraExcepcion(e);
        }
    }

    private static void menuAutor(ServiciosAutor sa, String[] opciones) {
        try {
            Autor autor;
            String mensaje;
            ServiciosMenu sm = new ServiciosMenu();
            do {
                sm.showMenu(opciones, "Menú de manjejo de Autores");
                switch (sm.getResultado()) {
                    case 1://       "Cargar Autor nuevo"

                        System.out.println(Utils.tituloSimple("Carga de un nuevo Autor", 20));
                        System.out.println("");
                        autor=sa.crearAutor();
                        
                        if(autor != null){
                        System.out.print(Utils.tituloSimple("Se cargo correctamente el nuevo autor.", 15));
                            sa.mostrar(sa.buscarAutorPorNombre(autor.getNombre()));
                        } else{
                            System.out.print(Utils.tituloSimple("No se cargó ningún autor.", 15));
                        }
                        break;
                    case 2://       "Editar Autor"

                        System.out.println(Utils.tituloSimple(opciones[sm.getResultado()-1], 15));
                        System.out.println("");
                        
                        if (sa.modificaAutor()) {
                            mensaje = Utils.tituloSimple("Se modifico el autor.", 15);
                        } else {
                            mensaje = Utils.tituloSimple("No se modifico el autor.", 15);
                        }

                        System.out.println(Utils.tituloSimple(mensaje, 15));
                        System.out.println("");
                        
                        break;
                    case 3://       "Eliminar Autor"

                        System.out.println(Utils.tituloSimple("Eliminar Autor", 20));
                        System.out.println("");


                        if (sa.eliminarAutor()){
                            mensaje = "Eliminaste definitivamente el autor.";
                            
                        } else {
                            mensaje = "Por suerte no eliminaste el autor.";
                        }

                        System.out.println(Utils.tituloSimple(mensaje, 15));
                        break;
                    case 4://       "Mostrar Autores"
                        
                        sa.mostrar1(sa.nombresDeAutores(),"Nombres de Autores");
                        break;
                    case 5://       "Mostrar información completa de los autores"
                        
                        sa.mostrar(sa.listaDeAutores());
                        break;
                    case 6://       "Mostrar el/los Autor/es de los haya un libro"
                        
                        System.out.println(Utils.tituloSimple(opciones[sm.getResultado()-1]+", Falta Preparar!!!", 10));
                }
                if (sm.esSalir()) {
                    break;
                } else {
                    Utils.esperaTecla();
                }
            } while (true);

        } catch (Exception e) {
            Utils.muestraExcepcion(e);
        }
    }
    
    private static void menuLibro(ServiciosLibro sl,ServiciosAutor sa,ServiciosEditorial se, String[] opciones){
        try {
            Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
            String titulo;
            Long isbn;
            Integer ejemplares;
            Integer anio;
            List<String> autores;
            List<String> editoriales;
            //Autor autor;
            String mensaje;
            String respuetaMChoice;
            String nombreEditorial;
            String nombreAutor="";
            Libro tempLibro;
            ServiciosMenu sm = new ServiciosMenu();
            do {
                sm.showMenu(opciones,"Menú de manejo de Libros");
                switch (sm.getResultado()) {
                    case 1://            "Cargar un nuevo Libro"
                        
                        System.out.println(Utils.tituloSimple(opciones[sm.getResultado()-1], 15));
                        
                        tempLibro = sl.fabricarLibro();
                        mensaje = "No se creo ningún libro.";
                        if (tempLibro!=null) {
                            mensaje = "Libro cargado con exito.";
                        }
                         System.out.println(Utils.tituloSimple(mensaje, 15));
                        break;
                        
                    case 2://            "Editar un libro"
                        
                        System.out.println(Utils.tituloSimple(opciones[sm.getResultado()-1]+", Falta Preparar!!!", 10));
                        break;
                    case 3://            "Eliminar un Libro"
                        
                        System.out.println(Utils.tituloSimple(opciones[sm.getResultado()-1]+", Falta Preparar!!!", 10));
                        break;
                    case 4://            "Mostrar titulos de los libros"
                        
                        System.out.println(Utils.tituloSimple(opciones[sm.getResultado()-1], 15));
                        sl.mostrarSegunTitulos(sl.listaDeLibros(),"titulo");
                        break;
                    case 5://            "Mostrar información completa de los libros"

                        System.out.println(Utils.tituloSimple(opciones[sm.getResultado()-1], 15));
                        sl.mostrar(sl.listaDeLibros());
                        
                        break;
                    case 6://            "Mostrar libros de un autor"
                        
                        System.out.println(Utils.tituloSimple(opciones[sm.getResultado()-1], 15));
                        nombreAutor = (String) sm.multipleChoice(sa.nombresDeAutores(), "Lista de Autores").values().toArray()[0];
                        System.out.println("");
                        System.out.println(Utils.tituloSimple("Libros de "+ nombreAutor+"...", 10));
                        sl.mostrarSegunTitulos(sl.listaDeLibrosDelAutor(nombreAutor),"titulo","ejemplares","ejemplaresRestantes","autor");
                        
                        break;
                    case 7://            "Mostrar libros de una editorial"
                        
                        System.out.println(Utils.tituloSimple(opciones[sm.getResultado()-1]+", Falta Preparar!!!", 10));
                }
                if (sm.esSalir()) {//            "Volver"
                    break;
                }else{
                    Utils.esperaTecla();
                }
            } while (true);
            
        } catch (Exception e) {
            Utils.muestraExcepcion(e);
        }
    }
}
