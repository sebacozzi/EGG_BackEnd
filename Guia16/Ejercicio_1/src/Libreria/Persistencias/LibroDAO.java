/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libreria.Persistencias;

import Libreria.Entidades.Libro;
import java.util.List;

/**
 *
 * @author Sebastian Cozzi
 */
public class LibroDAO extends DAO {

    public void guardar(Libro libro) {
        super.guardar(libro);
    }

    public void eliminar(Libro libro) {
        super.eliminar(libro);
    }

    public void modificar(Libro libro) {
        super.modificar(libro);
    }

    public Libro buscarLibro(String id) {
        try {
            conectar();
            Libro l = em.find(Libro.class, id);
            desconectar();
            return l;
        } catch (Exception e) {
            desconectar();
            throw e;
        }

    }

    public Libro libroPorTitulo(String titulo) throws Exception {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new Exception("No se a pasado ningun titulo.");
        }
        conectar();
        Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.titulo = :titulo").setParameter("titulo", titulo).getSingleResult();
        desconectar();
        return libro;
    }

    public Libro libroPorISBN(Long isbn) throws Exception {
        if (isbn == null || isbn == 0) {
            throw new Exception("No se a pasado ningun ISBN.");
        }
        conectar();
        Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.isbn = :isbn").setParameter("isbn", isbn).getSingleResult();
        desconectar();
        return libro;
    }

    @Override
    public List<String> listaUnCampo() {
        try {
            conectar();
            Libro o = new Libro();
            List<String> lista = em.createQuery(String.format("SELECT l.%1$s FROM Libro l ORDER BY l.%1$s",o.nombreCampoListaSimple())).getResultList();
            desconectar();
            return lista;
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }

    @Override
    public List<Libro> listaCompleta() throws Exception {
        try {
            conectar();
            List<Libro> lista = em.createQuery("SELECT l FROM Libro l").getResultList();
            desconectar();
            return lista;
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }
    public List<Libro> listaLibrosAutor(String nombre){
        try {
            conectar();
            List<Libro> lista= em.createQuery("SELECT l FROM Libro l WHERE l.autor.nombre = :nombre").setParameter("nombre", nombre).getResultList();
            desconectar();
            return lista;
        } catch (Exception e) {
            throw e;
        }
    }
}
