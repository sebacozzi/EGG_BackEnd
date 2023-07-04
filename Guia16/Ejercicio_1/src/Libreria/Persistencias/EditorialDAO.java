/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libreria.Persistencias;

import Libreria.Entidades.Editorial;
import java.util.List;

/**
 *
 * @author Sebastian Cozzi
 */
public class EditorialDAO extends DAO<Editorial> {

    /**
     * Metodo encargado de guardar la editorial
     *
     * @param editorial
     */
    @Override
    public void guardar(Editorial editorial) {
        super.guardar(editorial);
    }

    @Override
    public void eliminar(Editorial editorial) {
        super.eliminar(editorial);
    }

    @Override
    public void modificar(Editorial editorial) {
        super.modificar(editorial);
    }
    public Editorial buscarEditorial(String id){
        try {
            conectar();
            Editorial e = em.find(Editorial.class, id);
            desconectar();
            return e;
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }
    
    
    public Editorial EditorialPorNombre(String nombre) throws Exception {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new Exception("No se a pasado ningun nombre");
        }
        conectar();
        Editorial ed = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.nombre = :nombre").setParameter("nombre", nombre).getSingleResult();
        desconectar();
        return ed;
    }

    public List<String> listaDeNombres(){
        try {
            conectar();
            List<String> l = em.createQuery("SELECT e.nombre FROM Editorial e ORDER BY e.nombre").getResultList();
            desconectar();
            return l;
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }

    @Override
    public List<String> listaUnCampo() {
        try {
            Editorial e = new Editorial();
            conectar();
            List<String> l = em.createQuery("SELECT e."+e.campoListaSimple()+" FROM Editorial e ORDER BY e."+e.campoListaSimple()).getResultList();
            desconectar();
            return l;
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }

    @Override
    public List<Editorial> listaCompleta() throws Exception {
        try {
            conectar();
            List<Editorial> lista = em.createQuery("SELECT e FROM Editorial e").getResultList();
            desconectar();
            return lista;
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }
}
