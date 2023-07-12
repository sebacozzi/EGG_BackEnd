/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Libreria.Servicios;

import Libreria.Entidades.Autor;
import Libreria.Persistencias.AutorDAO;
import Utilidades.Menu.ServiciosMenu;
import Utilidades.Utils.Utils;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

/**
 *
 * @author Sebastian Cozzi
 */
public final class ServiciosAutor extends BaseServicios<Autor> {

    private Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");
    private final AutorDAO aDAO;

    public ServiciosAutor() {
        aDAO = new AutorDAO();
    }

    public Autor crearAutor() throws Exception {
        try {
            String nombre = "";
            boolean mensaje = true;

            do {
                if (mensaje) {
                    System.out.print("Ingresar el nombre completo del autor (Dejar vacio para volver): ");
                } else {
                    System.out.print("El autor " + nombre + " ya existe, Ingrese otro (Dejar vacio para volver): ");
                }
                nombre = leer.next();
                if (nombre.trim().isEmpty()) {
                    return null;
                }
                mensaje = false;
            } while (aDAO.existeAutor(nombre));
            System.out.println(aDAO.existeAutor(nombre));

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

    public Boolean modificaAutor() throws Exception {
        try {
            String nombre;
            Autor tempAutor;
            String respueta = (String) ServiciosMenu.multipleChoice(nombresDeAutores(), "Nombres de Autores cargados:").values().toArray()[0];
            tempAutor = buscarAutorPorNombre(respueta);
            System.out.printf("Nombre actual: %1$s. Dejar vacio para no modificar.\nIngrese el nuevo nombre para autor %1$s: ", tempAutor.getNombre());
            nombre = leer.next();
            if (!nombre.trim().isEmpty()) {
                tempAutor.setNombre(nombre);
                aDAO.modificar(tempAutor);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean eliminarAutor() throws Exception {
        try {
            Autor autor;
            boolean r = false;
            String respueta = (String) ServiciosMenu.multipleChoice(nombresDeAutores(), "Nombres de Autores cargados:").values().toArray()[0];
            autor = buscarAutorPorNombre(respueta);
            System.out.println(Utils.tituloSimple("Autor a eliminar", 15));
            mostrar(autor);

            if (ServiciosMenu.preguntaSNExt("¿Está seguro que quiere eliminar el autor?(s/n)-> ")
                    && ServiciosMenu.preguntaSNExt(" ¿Realmente está seguro? luego de esté paso no se podra revertir.(s/n)-> ")) {
                r = true;
                Utils.existe(autor);
                aDAO.eliminar(autor);
            }

            return r;
        } catch (Exception e) {
            return false;
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

    public List<String> nombresDeAutores() {
        return aDAO.listaUnCampo();
    }

//    public List<Libro> listaDeLibrosDelAutor(Autor a){
//        List<Libro> l = aDAO.librosDeAutor(a);
//        
//        return l;
//    }
}
