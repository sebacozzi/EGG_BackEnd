/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.persistencia;

import tienda.Entidades.producto.Producto;

/**
 *
 * @author Sebastián Cozzi
 */
public final class ProductoDAO extends DAO {
    
    

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

    private void existe(Producto producto) throws Exception {
        if (producto != null) {
            throw new Exception("Debe pasar un fabricante.");
        }
    }
}
