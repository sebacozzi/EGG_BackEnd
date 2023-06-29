/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.Entidades.fabricante;

import java.util.Collection;
import java.util.Scanner;
import tienda.persistencia.FabricanteDAO;

/**
 *
 * @author Sebastián Cozzi
 */
public class FabricanteServicios {
    
    private Scanner leer = new Scanner(System.in, "ISO-8859-1").useDelimiter("\n");

    private FabricanteDAO fDAO;

    public FabricanteServicios() {
        this.fDAO = new FabricanteDAO();
    }

    public void crearFabricante(Fabricante fabricante) throws Exception {
        try {
            String nombre;
            do {
                System.out.print("Ingrese el nombre del fabricante->");
                nombre = leer.next();
                if (fDAO.buscarFabricantePorNombre(nombre) != null) {
                    System.out.printf("El fabricante %s ya existe. Ingrese otro.",nombre);
                } else break;
            } while (true);
            Fabricante f = new Fabricante();
            f.setNombre(nombre);
            f.setCodigo(fDAO.idDelFabricante(nombre));
            fabricante = fDAO.buscarFabricantePorNombre(nombre);
        } catch (Exception e) {
            throw e;
        }
    }

    public void mostrarFabricantes(Collection<Fabricante> fs) {
        System.out.println(" ___________________________");
        System.out.println("|   ID   |     Nombre       |");
        System.out.println("|---------------------------|");
        for (Fabricante f : fs) {
            System.out.printf("|   %2d   | %-17s|\n", f.getCodigo(), f.getNombre());
            
        }
        System.out.println(" ---------------------------");
    }
    public Collection<Fabricante> obtenerFabricantes() throws Exception {
       try {
            return fDAO.listaDeFabricantes();
        } catch (Exception e) {
            throw e;
            
        }
        
    }
}
