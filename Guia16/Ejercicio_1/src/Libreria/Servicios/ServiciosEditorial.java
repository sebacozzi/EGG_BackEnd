/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libreria.Servicios;

import Libreria.Entidades.Editorial;
import Libreria.Persistencias.EditorialDAO;
import Utilidades.Menu.ServiciosMenu;
import Utilidades.Utils.Utils;
import java.util.List;
import java.util.UUID;
import java.lang.reflect.Field;
import java.util.Scanner;

/**
 *
 * @author Sebastian Cozzi
 */
public class ServiciosEditorial extends BaseServicios<Editorial>{

    private final EditorialDAO eDAO;

    public ServiciosEditorial() {
        eDAO = new EditorialDAO();
    }

    public Editorial buscarEditorial(String idEditorial) {
        return eDAO.buscarEditorial(idEditorial);
    }

    public List<Editorial> listaDeEditoriales() throws Exception {
        return eDAO.listaCompleta();
    }

    public List<String> listaDeNombresDeEditoriales() {
        return eDAO.listaDeNombres();
    }

    public Editorial buscarEditorialPorNombre(String nombre) throws Exception {
        return eDAO.EditorialPorNombre(nombre);
    }

    public Editorial crearEditorial() throws Exception {
        Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
        String nombre;
        try {
            
            Editorial e = new Editorial();
            
            do{
            System.out.print("Ingrese el nombre de la editorial (Dejar vacio para salir: ");
            nombre=leer.next();
                if (nombre.trim().isEmpty()) {
                    return null;
                }
            }while(existeEditorial(nombre));
            e.setId(UUID.randomUUID().toString());
            e.setNombre(nombre);
            e.setAlta(true);
            eDAO.guardar(e);
            return eDAO.EditorialPorNombre(nombre);
        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean modificarEditorial() throws Exception {
        try {
            List<String> lista = listaDeNombresDeEditoriales();
            lista.add("Volver");
            String respuesta = (String) ServiciosMenu.multipleChoice(lista, "Lista de editoriales: ").values().toArray()[0];
            if (respuesta.equalsIgnoreCase("Volver")) {
                return false;
            }
            
            Editorial editorial = buscarEditorialPorNombre(respueta);
                        System.out.printf("Nombre actual: %s (Dejar vacio para no cambiar)\nIngrese el nombre nuevo para la editorial: ",tempEditorial.getNombre());
                        nombre = leer.next();
                        Utils.existe(editorial);
            eDAO.modificar(editorial);
        } catch (Exception e) {
            return false;
        }
    }
    
    public void eliminarEditorial(Editorial editorial) throws Exception {
        try {
            Utils.existe(editorial);
            eDAO.eliminar(editorial);
        } catch (Exception e) {
            throw e;
        }

    }
    private boolean existeEditorial(String nombre){
        try {
            
            return eDAO.EditorialPorNombre(nombre)!=null;
        } catch (Exception e) {
            return false;
        }
    }
}