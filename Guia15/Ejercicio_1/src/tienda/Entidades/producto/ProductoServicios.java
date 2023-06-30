/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.Entidades.producto;

import java.util.ArrayList;
import java.util.Collection;
import tienda.Emuns.Precio;
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

    public Producto nuevoProducto(String nombre, Double precio, int codigo_fabricante) throws Exception {
        try {
            if (pDAO.buscarProductoPorNombre(nombre) != null) {
                throw new Exception("Ya existe un producto con ese nombre.");
            }
            
            pDAO.agregarProducto(nombre, precio, codigo_fabricante);

            return pDAO.buscarProductoPorNombre(nombre);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Producto ActualizaProducto(int codigo,String nombre,Double precio, int codigo_fabricante)throws Exception{
        try {
            pDAO.actualizaProducto(codigo,nombre,precio,codigo_fabricante);
            return pDAO.buscarProductoPorCodigo(codigo);
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> obtenerProductos() throws Exception {
        try {
            return pDAO.listaDeProductos();
        } catch (Exception e) {
            throw e;
        }

    }
    
    public Producto productoPorCodigo(int codigo) throws Exception{
        try {
            return pDAO.buscarProductoPorCodigo(codigo);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Collection<Producto> productosConRangoDePrecios(Double minPrecio, Double maxPrecio) throws Exception {
        try {

            return pDAO.buscarRangoPrecios(minPrecio, maxPrecio);
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

    public Producto productoMasBarato() throws Exception {
        try {
            return ((ArrayList<Producto>) pDAO.productosOrdenadosPor("precio", Precio.MENOR,"nombre, precio")).get(0);
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> productosPorFiltroEnNombre(String filtroNombre) throws Exception {
        try {
            return pDAO.productosFiltroLike("nombre", filtroNombre);
        } catch (Exception e) {
            throw e;
        }

    }

    /**
     * Metodo encargado de mostrar la información de la tabla representado por
     * titulos y detalles
     *
     * @param prods Colección de Productos
     * @throws Exception
     */
    public void mostrarProductos(Collection<Producto> prods) throws Exception {
        try {
            if (prods == null) {
                throw new Exception("La colección no fue iniciada.");
            }
            if (prods.isEmpty()) {
                throw new Exception("La coleccíon está vacia.");
            }
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

    public void mostrarProducto(Producto producto) throws Exception{
        try {
            Collection<Producto> ps = new ArrayList();
            ps.add(producto);
            mostrarProductos(ps);
        } catch (Exception e) {
            throw e;
        }
    }
}
