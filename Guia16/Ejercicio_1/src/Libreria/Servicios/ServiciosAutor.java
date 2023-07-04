/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libreria.Servicios;

import Libreria.Entidades.Autor;
import Libreria.Persistencias.AutorDAO;
import java.util.List;

/**
 *
 * @author Sebastian Cozzi
 */
public class ServiciosAutor extends BaseServicios<Autor>{
private AutorDAO aDAO;
    public ServiciosAutor() {
        aDAO = new AutorDAO();
    }

    public Autor buscarAutor(String idAutor) {
        return aDAO.buscarAutor(idAutor);
    }
    public List<Autor> listaDeAutores() throws Exception{
        return aDAO.listaCompleta();
    }
    public List<String> NombresDeAutores(){
        return aDAO.listaUnCampo();
    }
}
