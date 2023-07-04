/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libreria.Persistencias;

import Libreria.Entidades.Autor;
import java.util.List;

/**
 *
 * @author Sebastian Cozzi
 */
public class AutorDAO extends DAO<Autor> {

    /**
     * Metodo encargado de guardar Autor
     *
     * @param autor objeto de tipo Autor
     */
    @Override
    public void guardar(Autor autor){
        super.guardar(autor);
    }

    /**
     * Metodo encargado de actulizar los datos de Autor
     *
     * @param autor objeto de tipo Autor
     */
    @Override
    public void modificar(Autor autor) {
        super.modificar(autor);
    }

    /**
     * Metodo encargado de eliminar el Autor pasado por parametro
     *
     * @param autor objeto de tipo Autor
     */
    @Override
    public void eliminar(Autor autor) {
        super.eliminar(autor);
    }

    public Autor buscarAutor(String id){
        try {
            conectar();
            Autor a= em.find(Autor.class, id);
            desconectar();
            return a;
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }

    /**
     * Metodo que recibe un nombre de Autor para buscarlo en la base de datos
     *
     * @param nombre String
     * @return Autor
     * @throws Exception
     */
    public Autor autorPorNombre(String nombre) throws Exception {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new Exception("Debe pasar un nombre de autor para buscar.");
        }
        conectar();
        Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre ").setParameter("nombre", nombre).getSingleResult();
        desconectar();
        return autor;
    }

    @Override
    public List<String> listaUnCampo() {
        try {
            Autor a = new Autor();
            conectar();
            List<String> l = em.createQuery("SELECT e."+a.campoListaSimple()+" FROM Editorial e ORDER BY e."+a.campoListaSimple()).getResultList();
            desconectar();
            return l;
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }
    
    /**
     * Metodo encargado de listar los Autores recibidos de la base de datos
     *
     * @return List de tipo Autor con los objetos obtenidos
     * @throws java.lang.Exception
     */
    @Override
    public List<Autor> listaCompleta() throws Exception {
         try {
            conectar();
            List<Autor> lista = em.createQuery("SELECT a FROM Autor a").getResultList();
            desconectar();
            if (lista.isEmpty()) {
                throw new Exception("La tabla de autores esta vacia.");
            }
            return lista;
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }
}
