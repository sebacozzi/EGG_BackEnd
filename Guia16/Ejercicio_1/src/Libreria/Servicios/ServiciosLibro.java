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
    private Libro ultimoCreado;
    private Libro ultimoAEditar;
    private Libro ultimoEditado;
    private Libro ultimoEliminado;

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
        Autor autor = null;
        Editorial editorial = null;
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

            /// elegir autor
            autor = seleccionarAutor(autor);
            /// elegir editorial
            editorial = seleccionarEditorial(editorial);

            libro = new Libro();
            libro.setId(UUID.randomUUID().toString());
            libro.setIsbn(isbn);
            libro.setTitulo(titulo);
            libro.setEjemplares(ejemplares);
            libro.setEjemplaresPrestados(0);
            libro.setAnio(anio);
            libro.setAlta(true);
            libro.setAutor(autor);
            libro.setEditorial(editorial);

            ultimoCreado = libro;
            lDAO.guardar(ultimoCreado);
            return ultimoCreado;
        } catch (Exception e) {
            throw e;
        }

    }

    private Editorial seleccionarEditorial(Editorial ed) {
        Editorial editorial = null;
        List<String> editoriales;
        String nombreEditorial;
        do {
            try {
                editoriales = se.listaDeNombresDeEditoriales();
                editoriales.add("Agregar nueva editorial");
                if (e != null) {
                    editoriales.add("Actual: \"" + ed.getNombre() + "\"");
                }
                editoriales.add("Salir");
                nombreEditorial = (String) ServiciosMenu.multipleChoice(editoriales, "Nombres de Editoriales:").values().toArray()[0];
                if (nombreEditorial.compareToIgnoreCase("Agregar nueva editorial") == 0) {
                    editorial = se.crearEditorial();
                } else if (nombreEditorial.compareToIgnoreCase("Actual: \"" + ed.getNombre() + "\"") == 0) {
                    editorial = ed;
                } else if (nombreEditorial.compareToIgnoreCase("Salir") == 0) {
                    return null;
                } else {
                    editorial = se.buscarEditorialPorNombre(nombreEditorial);
                }
            } catch (Exception e) {
            }
        } while (editorial == null);
        return editorial;
    }

    private Autor seleccionarAutor(Autor a) {
        List<String> autores;
        Autor autor = null;
        String nombreAutor;
        do {

            try {
                autores = sa.nombresDeAutores();
                autores.add("Agregar nuevo Autor");
                if (a != null) {
                    autores.add("Actual: \"" + a.getNombre() + "\"");
                }
                autores.add("Salir");
                nombreAutor = (String) ServiciosMenu.multipleChoice(autores, "Nombres de Autores:").values().toArray()[0];

                if (nombreAutor.compareToIgnoreCase("Agregar nuevo Autor") == 0) {                    //// Agrega nuevo autor
                    do {
                        autor = sa.crearAutor();
                        if (autor != null) {
                            break;
                        } else {
                        }
                    } while (true);
                    // si nombre existe preguntar si
                } else if (nombreAutor.compareToIgnoreCase("Actual \"" + a.getNombre() + "\"") == 0) {
                    autor = a;
                } else if (nombreAutor.compareToIgnoreCase("Salir") == 0) {
                    return null;
                } else {
                    autor = sa.buscarAutorPorNombre(nombreAutor);
                }
            } catch (Exception e) {
            }
        } while (autor == null);
        return autor;

    }

    public boolean editarLibro() {
        try {
            List<String> lista = listaNombresDeLibros();
            lista.add("Salir");
            String respuesta = (String) ServiciosMenu.multipleChoice(lista, "Lista de Libros a Editar:").values().toArray()[0];
            if (respuesta.equalsIgnoreCase("Salir")) {
                ultimoEditado = null;
                return false;
            }
            ultimoAEditar = lDAO.libroPorTitulo(respuesta);
            ultimoEditado = ultimoAEditar;

            Long isbn = Inputs.inputLong("ISBN actual:" + ultimoEditado.getIsbn() + ".\nIngrese el nuevo isbn: ");

            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public List<Libro> listaDeLibros() throws Exception {
        return lDAO.listaCompleta();
    }

    public List<String> listaNombresDeLibros() {
        return lDAO.listaUnCampo();
    }

    public boolean ExisteISBN(Long isbn) {
        try {
            Boolean r = lDAO.libroPorISBN(isbn) != null;
            System.out.println(r);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Libro> listaDeLibrosDelAutor(String nombre) {
        return lDAO.listaLibrosAutor(nombre);
    }
}
