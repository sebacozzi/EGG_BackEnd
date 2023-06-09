/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.Fabricante;

import java.util.ArrayList;
import java.util.Collection;
import tienda.persistencia.FabricanteDAO;

/**
 *
 * @author Sebastián Cozzi
 */
public class FabricanteServicios {

    private FabricanteDAO fDAO;

    public FabricanteServicios() {
        this.fDAO = new FabricanteDAO();
    }

    public Fabricante crearFabricante(String nombre) throws Exception {
        try {
            if (fDAO.buscarFabricantePorNombre(nombre) != null) {
                throw new Exception(String.format("El fabricante %s ya existe. Ingrese otro.", nombre));
            }
            fDAO.agregarFabricante(nombre);
            return fDAO.buscarFabricantePorNombre(nombre);
        } catch (Exception e) {
            throw e;
        }
    }

    public Fabricante modificaFabricante(Fabricante fabricante) throws Exception {
        try {
            return fDAO.actualizaFabricante(fabricante);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void mostrarFabricantes(Collection<Fabricante> fs) {
        try {

            int[] anchos = new int[fDAO.colCount + 1];

            // Define el ancho final de las columnas
            for (int i = 1; i <= fDAO.colCount; i++) {
                if (fDAO.anchoColumnas[i] < fDAO.listaColumnas[i].length()) {
                    anchos[i] = fDAO.listaColumnas[i].length();
                } else {
                    anchos[i] = fDAO.anchoColumnas[i];
                }
                if (fDAO.tipoColumnas[i].equalsIgnoreCase("s")) {
                    anchos[i] = anchos[i] * -1;
                }
            }

            // Genera encabezado
            String linea = "|";
            for (int i = 1; i <= fDAO.colCount; i++) {
                linea = linea.concat(" %" + (anchos[i]) + "s");
                linea += " |";
                linea = String.format(linea, fDAO.listaColumnas[i]);
            }
            System.out.print(" ");
            int lS = linea.length() - 2;
            for (int i = 0; i < lS; i++) {
                System.out.print("_");
            }
            System.out.println("");
            System.out.println(linea);
            System.out.print("|");
            for (int i = 0; i < lS; i++) {
                System.out.print("-");
            }
            System.out.println("|");
            for (Fabricante f : fs) {
                linea = "|";
                for (int i = 1; i <= fDAO.colCount; i++) {
                    linea = linea.concat(String.format(" %%%ds", anchos[i]));
                    linea += " |";
                    linea = String.format(linea, f.getValue(fDAO.listaColumnas[i]));
                }
                linea += "\n";
                System.out.print(linea);
            }
            System.out.print(" ");
            for (int i = 0; i < lS; i++) {
                System.out.print("-");
            }
            System.out.println("");
        } catch (Exception e) {
            throw e;
        }
    }

    public void mostrarFabricantes(Fabricante f) {
        try {
            Collection<Fabricante> cf = new ArrayList();
            cf.add(f);
            mostrarFabricantes(cf);
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Fabricante> obtenerFabricantes() throws Exception {
        try {
            return fDAO.listaDeFabricantes();
        } catch (Exception e) {
            throw e;
        }
    }

    public Fabricante obtenerFabricantePorNombre(String nombre) throws Exception {
        try {
            return fDAO.buscarFabricantePorNombre(nombre);
        } catch (Exception e) {
            throw e;
        }
    }
    public Fabricante fabricantePorCodigo(int codigo) throws Exception {
        try {
            return fDAO.fabricanteDelCodigo(codigo);
        } catch (Exception e) {
            throw e;
        }
    }

    
    
}
