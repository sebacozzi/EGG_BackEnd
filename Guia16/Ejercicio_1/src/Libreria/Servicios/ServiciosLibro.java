/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libreria.Servicios;

import Libreria.Entidades.Autor;
import Libreria.Entidades.Editorial;
import Libreria.Entidades.Libro;
import Libreria.Persistencias.LibroDAO;
import Utilidades.Menu.ServiciosMenu;
import Utilidades.Utils.Inputs;
import Utilidades.Utils.Utils;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

/**
 *
 * @author Sebastian Cozzi
 */
public final class ServiciosLibro extends BaseServicios<Libro> {

    private final LibroDAO lDAO;
    private final ServiciosAutor sa;
    private final ServiciosEditorial se;

    public ServiciosLibro() {
        lDAO = new LibroDAO();
        sa = new ServiciosAutor();
        se = new ServiciosEditorial();
    }

    public Libro crearLibro(Long isbn, String titulo, Boolean alta, Integer anio, Integer ejemplares, Integer ejemplaresPrestados, String idAutor, String idEditorial) throws Exception {
        try {
            Libro l = new Libro();
            l.setAlta(alta);
            l.setAnio(anio);
            l.setAutor(sa.buscarAutor(idAutor));
            l.setEditorial(se.buscarEditorial(idEditorial));
            l.setEjemplares(ejemplares);
            l.setEjemplaresPrestados(ejemplaresPrestados);
            l.setIsbn(isbn);
            l.setTitulo(titulo);
            l.setId(UUID.randomUUID().toString());
            return l;
        } catch (Exception e) {
            throw e;
        }
    }

    public Libro fabricarLibro() throws Exception {
        Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
        Libro libro;
        Long isbn;
        String titulo, nombreAutor, nombreEditorial;
        Autor autor=null;
        Editorial editorial=null;
        Boolean alta;
        Integer anio, ejemplares, ejemplaresPrestados;
        List<String> autores;
        List<String> editoriales;
        try {
            isbn = Inputs.inputLong("Ingrese el ISBN del libro: ");
            while (ExisteISBN(isbn)) {
                isbn = Inputs.inputLong("Ya existe el ISBN. Ingrese otro: ");
            }

            System.out.print("Ingresar el nombre del libro(Dejar vacio para salir): ");
            titulo = leer.next();
            if (titulo.trim().isEmpty()) {
                throw new Exception("No se va a cargar ningun libro. Salida...");
            }

            anio = Inputs.inputInteger("Ingrese el año de edición: ");

            ejemplares = Inputs.inputInteger("Ingrese la cantidad de ejemplares: ");

            /// opcion de autores
            autores = sa.nombresDeAutores();
            autores.add("Agregar nuevo Autor");
            autores.add("Salir");
            nombreAutor = (String) ServiciosMenu.multipleChoice(autores, "Nombres de Autores:").values().toArray()[0];
            switch (nombreAutor) {
                case "Agregar nuevo Autor":
                    //// Agrega nuevo autor
                    do {
                        autor = sa.crearAutor();
                        if (autor != null) {
                            break;
                        }
                    } while (true);
                    // si nombre existe preguntar si 

                    break;
                case "Salir":
                    return null;
                default:
                    autor= sa.buscarAutorPorNombre(nombreAutor);
            }
            /// opcion de autores
            editoriales = se.listaDeNombresDeEditoriales();
            editoriales.add("Agregar nueva Editorial");
            editoriales.add("Salir");
            nombreEditorial = (String) ServiciosMenu.multipleChoice(autores, "Nombres de las Editoriales:").values().toArray()[0];
            switch (nombreEditorial) {
                case "Agregar nueva Editorial":
                    //// Agrega nuevo autor
                    do {
                        editorial = se.crearEditorial();
                        if (autor != null) {
                            break;
                        }
                    } while (true);
                    // si nombre existe preguntar si 

                    break;
                case "Salir":
                    return null;
                default:
                    editorial=se.buscarEditorialPorNombre(nombreEditorial);
            }

            libro = new Libro();
            libro.setId(UUID.randomUUID().toString());
            libro.setIsbn(isbn);
            libro.setTitulo(titulo);
            libro.setEjemplares(ejemplares);
            libro.setAnio(anio);
            libro.setAlta(true);
            libro.setAutor(autor);
            libro.setEditorial(editorial);
            
            
       return crearLibro(libro.getIsbn(), libro.getTitulo(), libro.getAlta(), 
               libro.getAnio(), libro.getEjemplares(), libro.getEjemplaresPrestados(), 
               libro.getAutor().getId(), libro.getEditorial().getId());
    }
    catch (Exception e) {
            throw e;
    }

}

public List<Libro> listaDeLibros() throws Exception{
     return lDAO.listaCompleta();
    }

    public List<String> listaNombresDeLibros() {
        return lDAO.listaUnCampo();
    }

    public boolean ExisteISBN(Long isbn) {
        try {
            Boolean r = lDAO.libroPorISBN(isbn) !=null;
            System.out.println(r);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public List<Libro> listaDeLibrosDelAutor(String nombre){
        return lDAO.listaLibrosAutor(nombre);
    }
}
