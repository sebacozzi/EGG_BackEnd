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
import Utilidades.Utils.Inputs;
import Utilidades.Utils.Utils;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

/**
 *
 * @author Sebastian Cozzi
 */
public class ServiciosLibro extends BaseServicios<Libro> {
    private LibroDAO lDAO;
    private ServiciosAutor sa;
    private ServiciosEditorial se;
    
    public ServiciosLibro(){
        lDAO = new LibroDAO();
        sa = new ServiciosAutor();
        se = new ServiciosEditorial();
    }
    
    public Libro crearLibro(Long isbn,String titulo,Boolean alta,Integer anio,Integer ejemplares,Integer ejemplaresPrestados,String idAutor, String idEditorial) throws Exception{
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
    
    public Libro fabricarLibro(){
        Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
        Long isbn;
        String titulo, idAutor, idEditorial, nombreAutor,nombreEditorial;
        Boolean alta;
        Integer anio, ejemplares, ejemplaresPrestados;
        List<Autor> autores;
        List<Editorial> editoriales;
        try {
            isbn = Inputs.inputLong("Ingrese el ISBN del libro: ");
                        while (ExisteISBN(isbn)) {
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
            return crearLibro(isbn, titulo,alta, anio, ejemplares, ejemplaresPrestados, idAutor, idEditorial);
        } catch (Exception e) {
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
