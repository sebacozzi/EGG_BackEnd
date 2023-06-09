/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libreria.Persistencias;

import Libreria.Entidades.Entidad;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Sebastian Cozzi
 */
public abstract class DAO<T> {

    protected final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("LibreriaPU");
    protected EntityManager em = EMF.createEntityManager();

    /**
     * Metodo encargado de conectar el EntityManager a la base de datos.
     * Previamente verifica que no se encuentre conectado.
     */
    protected void conectar() {
        if (!em.isOpen()) {
            em = EMF.createEntityManager();
        }
    }

    /**
     * Metodo encargado de desconectar la base de datos. Primero verifica que se
     * encuentre conectado.
     */
    protected void desconectar() {
        if (em.isOpen()) {
            em.close();
        }
    }

    protected void guardar(T ob) {

        conectar();
        em.getTransaction().begin();
        em.persist(ob);
        em.getTransaction().commit();
        desconectar();
    }

    protected void modificar(T ob) {

        conectar();
        em.getTransaction().begin();
        em.merge(ob);
        em.getTransaction().commit();
        desconectar();
    }

    protected void eliminar(T ob) {
        conectar();
        em.getTransaction().begin();
        T d = em.merge(ob);
        //System.out.println("Eliminando:\n"+d);
        em.remove(d);
        em.getTransaction().commit();
        desconectar();
    }

    protected Integer eliminarMultiple(List<T> ob) {
        try {
            Integer cont = 0;
            conectar();
            em.getTransaction().begin();
            for (T t : ob) {
                T d = em.merge((T) ob);
                em.remove(d);
                cont++;
            }
            em.getTransaction().commit();
            desconectar();
            return cont;
        } catch (Exception e) {
            em.getTransaction().rollback();
            desconectar();
            throw e;
        }
    }

    public abstract List<String> listaUnCampo();

    public abstract List<T> listaCompleta() throws Exception;

}
