/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libreria.Servicios;

import Libreria.Entidades.Libro;
import Libreria.Persistencias.LibroDAO;
import java.util.List;
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
    
    public Libro crearLibro(Long isbn,String titulo,Boolean alta,Integer anio,Integer ejemplares,Integer ejemplaresPrestados,String idAutor, String idEditorial){
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
    public List<Libro> listaDeLibros() throws Exception{
     return lDAO.listaCompleta();
    }
}
