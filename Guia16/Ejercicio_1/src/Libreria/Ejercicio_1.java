package Libreria;

import Libreria.Servicios.ServiciosAutor;
import Libreria.Servicios.ServiciosEditorial;
import Libreria.Servicios.ServiciosLibro;
import Utilidades.Menu.Menu;
import Utilidades.Menu.ServiciosMenu;
import Utilidades.Utils.Utils;
import java.util.Scanner;

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
            "Cargar nueva editorial",
            "Editar editorial",
            "Eliminar Editorial",
            "Mostrar nombres de Editoriales",
            "Mostrar información completa de las Editoriales",
            "Mostrar libros de una editorial",
            "Volver"};
        String[] menuAutor = {
            "Cargar Autor nuevo",
        "Editar Autor",
        "Eliminar Autor",
        "Mostrar Autores",
        "Mostrar información completa de los autores",
        "Mostrar libros de un Autor",
        "Volver"};
        String[] menuLibro={
            "Cargar un nuevo Libro",
        "Editar un libro",
        "Eliminar un Libro",
        "Mostrar titulos de los libros",
        "Mostrar información completa de los libros",
        "Mostrar libros de un autor",
        "Mostrar libros de una editorial",
        "Volver"};
        /// Test ///
        se.mostrar1(se.listaDeNombresDeEditoriales(), "Nombres de Editoriales");
        se.mostrar(se.listaDeEditoriales());
        sa.mostrar(sa.listaDeAutores());
        sl.mostrar(sl.listaDeLibros());

    }
    private static void menuEditorial(ServiciosAutor sa,String[] opciones,ServiciosMenu sm){
        try {
            Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
            do {
                sm.show(new Menu(opciones,"Menu de Autor"));
                switch (sm.getResultado()) {
                    case 1://       "Cargar Autor nuevo"
                        
                        break;
                    case 2://       "Editar Autor"
                        
                        break;
                    case 3://       "Eliminar Autor"
                        
                        break;
                    case 4://       "Mostrar Autores"
                        
                        break;
                    case 5://       "Mostrar información completa de los autores"
                        
                        break;
                    case 6://       "Mostrar libros de un Autor",

                }
                if (sm.esSalir()) {
                    break;
                    
                } 
                Utils.esperaTecla();
            } while (true);
            
        } catch (Exception e) {
        }
    }
}
