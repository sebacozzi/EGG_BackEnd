/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.Entidades.producto;

import java.util.ArrayList;
import java.util.Collection;
import tienda.persistencia.ProductoDAO;

/**
 *
 * @author Sebastian Cozzi
 */
public class ProductoServicios {

    private ProductoDAO pDAO;

    public ProductoServicios() {
        pDAO = new ProductoDAO();
    }

    public Collection<Producto> obtenerProductos() throws Exception {
        try {
            return pDAO.listaDeProductos();
        } catch (Exception e) {
            throw e;
        }

    }
    
    public Collection<Producto> nombresProductos() throws Exception {
        try {
            return pDAO.nombresProductos();
        } catch (Exception e) {
            throw e;
        }

    }
    public Collection<Producto> nombresYPreciosProductos() throws Exception {
        try {
            return pDAO.nombresYPreciosProductos();
        } catch (Exception e) {
            throw e;
        }

    }

    
    public void mostrarProductos(ArrayList<Producto> prods) {
        try {

            int[] anchos = new int[pDAO.colCount + 1];

            // Define el ancho final de las columnas
            for (int i = 1; i <= pDAO.colCount; i++) {
                if (pDAO.anchos[i] < pDAO.listaColumnas[i].length()) {
                    anchos[i] = pDAO.listaColumnas[i].length();
                } else {
                    anchos[i] = pDAO.anchos[i];
                }
                if (pDAO.tipoColumnas[i].equalsIgnoreCase("s")) {
                    anchos[i] = anchos[i] * -1;
                }
            }

            // Genera encabezado
            String linea = "|";
            for (int i = 1; i <= pDAO.colCount; i++) {
                linea = linea.concat(" %" + (anchos[i]) + "s");
                linea += " |";
                linea = String.format(linea, pDAO.listaColumnas[i]);
            }
            System.out.print(" ");
            int lS=linea.length()-2;
            for (int i = 0; i < lS ; i++) {
                System.out.print("_");
            }
            System.out.println("");
            System.out.println(linea);
            System.out.print("|");
            for (int i = 0; i < lS; i++) {
                System.out.print("-");
            }
            System.out.println("|");
            for (Producto p : prods) {
                linea = "|";
                for (int i = 1; i <= pDAO.colCount; i++) {
                    linea = linea.concat(String.format(" %%%ds", anchos[i]));
                    linea += " |";
                    linea = String.format(linea, p.getValue(pDAO.listaColumnas[i]));
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
}
