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
        System.out.println(editorial);
        super.eliminar(editorial);
    }

    @Override
    public void modificar(Editorial editorial) {
        super.modificar(editorial);
    }

    public Editorial EditorialPorNombre(String nombre) throws Exception {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new Exception("No se a pasado ningun nombre");
        }
        conectar();
        Editorial ed = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.nombre LIKE :nombre").setParameter("nombre", nombre).getSingleResult();
        desconectar();
        return ed;
    }

    public List<Editorial> ListaCompleta() {
        try {
            conectar();
            List<Editorial> lista = em.createQuery("SELECT e FROM Editorial e").getResultList();
            desconectar();
            return lista;
        } catch (Exception e) {
            throw e;
        }
    }
}
