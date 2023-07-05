/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libreria.Servicios;

import Libreria.Entidades.Autor;
import Libreria.Persistencias.AutorDAO;
import Utilidades.Utils.Utils;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Sebastian Cozzi
 */
public class ServiciosAutor extends BaseServicios<Autor> {

    private AutorDAO aDAO;

    public ServiciosAutor() {
        aDAO = new AutorDAO();
    }

    public Autor crearAutor(String nombre) throws Exception{
        try {
            Utils.existe(nombre);
            Autor a = new Autor();
            a.setNombre(nombre);
            a.setId(UUID.randomUUID().toString());
            a.setAlta(true);
            aDAO.guardar(a);
            return aDAO.autorPorNombre(nombre);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Autor modificaAutor(Autor autor) throws Exception{
        try {
            Utils.existe(autor);
            aDAO.modificar(autor);
            return aDAO.buscarAutor(autor.getId());
        } catch (Exception e) {
            throw e;
        }
    }
    public void eliminarAutor(Autor autor) throws Exception{
        try {
            Utils.existe(autor);
            aDAO.eliminar(autor);
            
        } catch (Exception e) {
            throw e;
        }
    }
    
    
    public Autor buscarAutorPorNombre(String nombre) throws Exception {
        try {
            Utils.existe(nombre);
            return aDAO.autorPorNombre(nombre);
        } catch (Exception e) {
            throw e;
        }
    }

    public Autor buscarAutor(String idAutor) throws Exception {
        try {
            Utils.existe(idAutor);
            return aDAO.buscarAutor(idAutor);
        } catch (Exception e) {
            throw e;
        }
        
    }

    public List<Autor> listaDeAutores() throws Exception {
        return aDAO.listaCompleta();
    }

    public List<String> NombresDeAutores() {
        return aDAO.listaUnCampo();
    }
}
