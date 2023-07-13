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
public final class ServiciosEditorial extends BaseServicios<Editorial> {

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

            do {
                System.out.print("Ingrese el nombre de la editorial (Dejar vacio para salir: ");
                nombre = leer.next();
                if (nombre.trim().isEmpty()) {
                    return null;
                }
            } while (existeEditorial(nombre));
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
        Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
        try {
            List<String> lista = listaDeNombresDeEditoriales();
            lista.add("Volver");
            String respuesta = (String) ServiciosMenu.multipleChoice(lista, "Lista de editoriales: ").values().toArray()[0];
            if (respuesta.equalsIgnoreCase("Volver")) {
                return false;
            }

            Editorial editorial = buscarEditorialPorNombre(respuesta);
            System.out.printf("Nombre actual: %s (Dejar vacio para no cambiar)\nIngrese el nombre nuevo para la editorial: ", editorial.getNombre());
            String nombre = leer.next();
            if (nombre.trim().isEmpty()) {
                return false;
            }
            
            Utils.existe(editorial);
            editorial.setNombre(nombre);
            eDAO.modificar(editorial);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean eliminarEditorial() {
        try {
            Editorial editorial;
        
            boolean r = false;
            List<String> lista = listaDeNombresDeEditoriales();
            lista.add("Volver");
            String respueta = (String) ServiciosMenu.multipleChoice(lista, "Nombres de Autores cargados:").values().toArray()[0];
            editorial = buscarEditorialPorNombre(respueta);
            System.out.println(Utils.tituloSimple("Autor a eliminar", 15));
            mostrar(editorial);

            if (ServiciosMenu.preguntaSNExt("¿Está seguro que quiere eliminar el autor?(s/n)-> ")
                    && ServiciosMenu.preguntaSNExt(" ¿Realmente está seguro? luego de esté paso no se podra revertir.(s/n)-> ")) {
                r = true;
                Utils.existe(editorial);
            Utils.existe(editorial);
            eDAO.eliminar(editorial);
            } 
            return r;
        } catch (Exception e) {
            return false;
        }

    }

    private boolean existeEditorial(String nombre) {
        try {

            return eDAO.EditorialPorNombre(nombre) != null;
        } catch (Exception e) {
            return false;
        }
    }
}
