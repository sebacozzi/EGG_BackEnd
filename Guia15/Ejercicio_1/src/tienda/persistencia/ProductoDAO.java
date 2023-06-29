/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.Entidades.producto.Producto;

/**
 *
 * @author Sebastián Cozzi
 */
public final class ProductoDAO extends DAO {

    public String[] listaColumnas;
    public int[] anchos;
    public int colCount;
    public String[] tipoColumnas;

    public void agregarProducto(Producto producto) throws Exception {
        try {
            existe(producto);
            String sql = String.format("INSERT INTO producto (codigo,nombre,precio,codigo_fabricante) VALUES (%d,'%s',%f,%d);",
                    producto.getCodigo(), producto.getNombre(), producto.getPrecio(), producto.getCodigoFabricante());
            iME(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarProducto(Producto producto) throws Exception {
        try {
            existe(producto);
            String sql = String.format("DELETE FROM producto WHERE codigo = %d;", producto.getCodigo());
            iME(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public void actualizaProducto(Producto producto) throws Exception {
        try {
            existe(producto);
            String sql = String.format("UPDATE fabricante SET nombre = '%s', precio = %d, codigo_fabricante = '%d' WHERE codigo = %d;",
                    producto.getNombre(), producto.getPrecio(), producto.getCodigoFabricante(), producto.getCodigo());
        } catch (Exception e) {
            throw e;
        }
    }

    public Producto buscarProductoPorCodigo(int codigo) throws Exception {
        try {
            Producto prod = null;
            String sql = String.format("SELECT * FROM producto WHERE codigo = %d;", codigo);
            consulta(sql);
            int cols = resultado.getMetaData().getColumnCount();
            int[] an = new int[cols + 1];
            String[] colD = new String[cols + 1];

            while (resultado.next()) {
                prod = new Producto(resultado.getInt(1), resultado.getString(2), resultado.getDouble(3), resultado.getInt(4));

            }
            desconectar();

            return prod;
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }

    public Collection<Producto> listaDeProductos() throws Exception {
        try {
            Collection<Producto> prods = new ArrayList();

            String sql = "SELECT * FROM producto;";

            consulta(sql);
            int cols = resultado.getMetaData().getColumnCount();
            int[] an = new int[cols + 1];
            String[] colD = new String[cols + 1];
            Producto p = null;
            while (resultado.next()) {
                for (int i = 1; i <= cols; i++) {
                    if (resultado.getString(i).length() > an[i]) {
                        an[i] = resultado.getString(i).length();
                    }
                }

                p = new Producto(resultado.getInt(1), resultado.getString(2), resultado.getDouble(3), resultado.getInt(4));

                prods.add(p);
            }

            String[] lis = new String[cols + 1];

            for (int i = 1; i <= cols; i++) {
                lis[i] = resultado.getMetaData().getColumnLabel(i);
                colD[i] = columnaTipos(resultado.getMetaData().getColumnType(i));
            }
            desconectar();
            listaColumnas = lis;
            anchos = an;
            colCount = cols;
            tipoColumnas = colD;
            return prods;
        } catch (Exception e) {
            throw e;
        }
    }

    private void existe(Producto producto) throws Exception {
        if (producto != null) {
            throw new Exception("Debe pasar un fabricante.");
        }
    }

    public Collection<Producto> nombresProductos() throws Exception {
        try {
            Collection<Producto> prods = new ArrayList();
            String sql = "SELECT nombre from producto;";
            consulta(sql);
            int cols = resultado.getMetaData().getColumnCount();
            int[] an = new int[cols + 1];
            String[] colD = new String[cols + 1];
            Producto p = null;
            while (resultado.next()) {
                for (int i = 1; i <= cols; i++) {
                    if (resultado.getString(i).length() > an[i]) {
                        an[i] = resultado.getString(i).length();
                    }
                }

                p = new Producto(0, resultado.getString(1),0d,0);

                prods.add(p);
            }

            String[] lis = new String[cols + 1];

            for (int i = 1; i <= cols; i++) {
                lis[i] = resultado.getMetaData().getColumnLabel(i);
                colD[i] = columnaTipos(resultado.getMetaData().getColumnType(i));
            }
            desconectar();
            listaColumnas = lis;
            anchos = an;
            colCount = cols;
            tipoColumnas = colD;
            return prods;
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> nombresYPreciosProductos() throws Exception {
        try {
            Collection<Producto> prods = new ArrayList();
            String sql = "SELECT nombre, precio from producto;";
            consulta(sql);
            int cols = resultado.getMetaData().getColumnCount();
            int[] an = new int[cols + 1];
            String[] colD = new String[cols + 1];
            Producto p = null;
            while (resultado.next()) {
                for (int i = 1; i <= cols; i++) {
                    if (resultado.getString(i).length() > an[i]) {
                        an[i] = resultado.getString(i).length();
                    }
                }
                
                p = new Producto(0, resultado.getString(1),resultado.getDouble(2),0);

                prods.add(p);
            }

            String[] lis = new String[cols + 1];

            for (int i = 1; i <= cols; i++) {
                lis[i] = resultado.getMetaData().getColumnLabel(i);
                colD[i] = columnaTipos(resultado.getMetaData().getColumnType(i));
            }
            desconectar();
            listaColumnas = lis;
            anchos = an;
            colCount = cols;
            tipoColumnas = colD;
            return prods;
        } catch (Exception e) {
            throw e;
        }
    }
    
}
