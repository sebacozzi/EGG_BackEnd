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
            "Mostrar las Editoriales de las haya algún libro",
            "Mostrar las Editoriales de las que no haya ningún libro",
            "Volver"};
        String[] menuAutor = {
            "Crear Autor nuevo",
            "Editar Autor",
            "Eliminar Autor",
            "Mostrar Autores",
            "Mostrar información completa de los autores",
            "Mostrar el/los Autor/es de los haya un libro",
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
            Editorial tempEditorial;
            ServiciosMenu sm = new ServiciosMenu();
            do {
                sm.showMenu(opciones, "Menu de manejo de Editoriales");
                switch (sm.getResultado()) {
                    case 1://            "Crear nueva editorial"
                        System.out.println(Utils.tituloSimple(opciones[sm.getResultado()-1], 15));
                        
                        System.out.print("Ingresar el nombre de la Editorial (Dejar vacio para volver): "); 
                        nombre = leer.next();
                        if (nombre.trim().isEmpty()) {
                            System.out.println(" se cargo ninguna Editorial. Volviendo al menu.");
                        } else{
                        se.crearEditorial(nombre);
                        System.out.println(Utils.tituloSimple("Editorial creada con exito", 10));
                        se.mostrar(se.buscarEditorialPorNombre(nombre));
                        }
                        //System.out.println(Utils.tituloSimple("Cargar nueva editorial, Falta Preparar!!!", 10));
                        break;
                    case 2://            "Editar editorial"
                        
                        System.out.println(Utils.tituloSimple(opciones[sm.getResultado()-1], 15));
                        respuetaMChoice = (String) sm.multipleChoice(se.listaDeNombresDeEditoriales(), "Lista de editoriales: ").values().toArray()[0];
                        tempEditorial = se.buscarEditorialPorNombre(respuetaMChoice);
                        System.out.printf("Nombre actual: %s (Dejar vacio para no cambiar)\nIngrese el nombre nuevo para la editorial: ",tempEditorial.getNombre());
                        nombre = leer.next();
                        if (!nombre.trim().isEmpty()) {
                            tempEditorial.setNombre(nombre);
                            se.modificarEditorial(tempEditorial);
                            se.mostrar(se.buscarEditorialPorNombre(nombre));
                        } else{
                            System.out.println(Utils.tituloSimple("No se modifico la editorial "+respuetaMChoice, 15));
                        }
                        break;
                        
                    case 3://            "Eliminar Editorial"
                        
                        System.out.println(Utils.tituloSimple(opciones[sm.getResultado()-1], 15));
                        respuetaMChoice = (String) sm.multipleChoice(se.listaDeNombresDeEditoriales(), "Lista de editoriales: ").values().toArray()[0];
                        tempEditorial = se.buscarEditorialPorNombre(respuetaMChoice);
                        se.mostrar(tempEditorial);
                        if (sm.preguntaSN("¿Está seguro que quiere eliminar el autor?(s/n)-> ")
                                && sm.preguntaSN(" ¿Realmente está seguro? luego de esté paso no se podra revertir.(s/n)-> ")) {
                            mensaje = "Eliminaste definitivamente el autor " + tempEditorial.getNombre() + ".";
                            se.eliminarEditorial(tempEditorial);
                        } else {
                            mensaje = "Por suerte no eliminaste el autor.";
                        }
                        break;
                        
                    case 4://            "Mostrar nombres de Editoriales"

                        System.out.println(Utils.tituloSimple(opciones[sm.getResultado()-1], 15));
                        se.mostrar1(se.listaDeNombresDeEditoriales(), "Nombres");
                        break;
                    case 5://            "Mostrar información completa de las Editoriales"
                        
                        System.out.println(Utils.tituloSimple(opciones[sm.getResultado()-1], 15));
                        se.mostrar(se.listaDeEditoriales());
                        break;
                        
                    case 6://            "Mostrar las Editoriales de las haya algún libro"
                        
                        System.out.println(Utils.tituloSimple(opciones[sm.getResultado()-1]+", Falta Preparar!!!", 10));
                        break;
                    case 7://            "Mostrar las Editoriales de las que no haya ningún libro"
                        
                        System.out.println(Utils.tituloSimple(opciones[sm.getResultado()-1]+", Falta Preparar!!!", 10));
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
            Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
            String nombre;
            String mensaje;
            String respuetaMChoice;
            Autor tempAutor;
            ServiciosMenu sm = new ServiciosMenu();
            do {
                sm.showMenu(opciones, "Menú de manjejo de Autores");
                switch (sm.getResultado()) {
                    case 1://       "Cargar Autor nuevo"

                        System.out.println(Utils.tituloSimple("Carga de un nuevo Autor", 20));
                        System.out.println("");
                        System.out.print("Ingresar el nombre completo del autor (Dejar vacio para volver): ");
                        nombre = leer.next();
                        if (nombre.trim().isEmpty()) {
                            System.out.print(Utils.tituloSimple("No se va a cargar ningun autor.", 15));
                        } else {
                            sa.crearAutor(nombre);
                            System.out.print(Utils.tituloSimple("Se cargo correctamente el nuevo autor.", 15));
                            sa.mostrar(sa.buscarAutorPorNombre(nombre));
                        }
                        break;
                    case 2://       "Editar Autor"

                        System.out.println(Utils.tituloSimple("Modificar Autor", 20));
                        System.out.println("");

                        respuetaMChoice = (String) sm.multipleChoice(sa.NombresDeAutores(), "Nombres de Autores cargados:").values().toArray()[0];
                        tempAutor = sa.buscarAutorPorNombre(respuetaMChoice);
                        System.out.printf("Nombre actual: %1$s. Dejar vacio para no modificar.\nIngrese el nuevo nombre para autor %1$s: ", tempAutor.getNombre());
                        nombre = leer.next();
                        if (!nombre.trim().isEmpty()) {
                            tempAutor.setNombre(nombre);
                            sa.modificaAutor(tempAutor);
                            mensaje = Utils.tituloSimple("Se modifico el autor.", 15);

                        } else {
                            mensaje = Utils.tituloSimple("No se modifico el autor.", 15);
                        }

                        System.out.println(mensaje);
                        System.out.println("");
                        sa.mostrar(sa.buscarAutor(tempAutor.getId()));
                        break;
                    case 3://       "Eliminar Autor"

                        System.out.println(Utils.tituloSimple("Eliminar Autor", 20));
                        System.out.println("");

                        respuetaMChoice = (String) sm.multipleChoice(sa.NombresDeAutores(), "Nombres de Autores cargados:").values().toArray()[0];
                        tempAutor = sa.buscarAutorPorNombre(respuetaMChoice);
                        System.out.println(Utils.tituloSimple("Autor a eliminar", 15));
                        sa.mostrar(tempAutor);
                        if (sm.preguntaSN("¿Está seguro que quiere eliminar el autor?(s/n)-> ")
                                && sm.preguntaSN(" ¿Realmente está seguro? luego de esté paso no se podra revertir.(s/n)-> ")) {
                            mensaje = "Eliminaste definitivamente el autor " + tempAutor.getNombre() + ".";
                            sa.eliminarAutor(tempAutor);
                        } else {
                            mensaje = "Por suerte no eliminaste el autor.";
                        }

                        System.out.println(Utils.tituloSimple(mensaje, 15));
                        break;
                    case 4://       "Mostrar Autores"
                        
                        sa.mostrar1(sa.NombresDeAutores(),"Nombres de Autores");
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
                        try{
                        isbn = Inputs.inputLong("Ingrese el ISBN del libro: ");
                        while (sl.ExisteISBN(isbn)) {
                            isbn = Inputs.inputLong("Ya existe el ISBN. Ingrese otro: ");
                        }
                        
                        System.out.print("Ingresar el nombre del libro(Dejar vacio para salir): ");
                        titulo=leer.next();
                        if (titulo.trim().isEmpty()) {
                            throw new Exception("No se va a cargar ningun libro. Salida...");
                        }
                        
                        anio = Inputs.inputInteger("Ingrese el año de edición: ");
                        
                        ejemplares = Inputs.inputInteger("Ingrese la cantidad de ejemplares: ");
                        
                        /// opcion de autores
                        autores = sa.NombresDeAutores();
                        autores.add("Agregar nuevo Autor");
                        autores.add("Salir");
                        nombreAutor = (String) sm.multipleChoice(autores, "Nombres de Autores:").values().toArray()[0];
                        switch (nombreAutor) {
                            case "Agregar nuevo Autor":
                                //// Agrega nuevo autor
                                System.out.print("Ingrese el nombre del autor: ");
                                nombreAutor = leer.next();
                                if (sa.buscarAutorPorNombre(nombreAutor) !=null) {
                                    System.out.println("Ya existe un autor con ese nombre.");
                                    
                                }
                                sa.crearAutor(nombreAutor);
                                // si nombre existe preguntar si 
                                
                                break;
                            case "Salir":
                              throw new Exception("No se va crear un libro porque no se cargo un autor.");
                        }
                        
                        
                        tempLibro = new Libro();
                        tempLibro.setId(UUID.randomUUID().toString());
                        tempLibro.setIsbn(isbn);
                        tempLibro.setTitulo(titulo);
                        tempLibro.setEjemplares(ejemplares);
                        tempLibro.setAnio(anio);
                        tempLibro.setAlta(true);
                        tempLibro.setAutor(sa.buscarAutorPorNombre(nombreAutor));
                        //tempLibro.setEditorial(se.buscarEditorialPorNombre(nombreEditorial));
                        }catch (Exception e){
                            System.out.println(Utils.tituloSimple(e.getMessage(),10));
                        }
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
                        nombreAutor = (String) sm.multipleChoice(sa.NombresDeAutores(), "Lista de Autores").values().toArray()[0];
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
