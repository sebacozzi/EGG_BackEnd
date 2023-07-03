/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.Emuns.Precio;
import tienda.Producto.Producto;

/**
 *
 * @author Sebastián Cozzi
 */
public final class ProductoDAO extends DAO {
    
    ///         INSERT DELETE UPDATE        ///
    public void agregarProducto(String nombre, Double precio, int codigo_fabricante) throws Exception {
        try {
            existe(nombre);
            existe(precio);
            existe(codigo_fabricante);
            String sql = String.format("INSERT INTO producto (nombre,precio,codigo_fabricante) VALUES ('%s',%s,%d);",
                    nombre, nD(precio), codigo_fabricante);
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

    public void actualizaProducto(int codigo,String nombre,Double precio, int codigo_fabricante) throws Exception {
        try {
            existe(codigo);
            existe(nombre);
            existe(precio);
            existe(codigo_fabricante);
            String sql = String.format("UPDATE producto SET nombre = '%s', precio = %s, codigo_fabricante = '%d' WHERE codigo = %d;",
                    nombre, nD(precio), codigo_fabricante,codigo);
            iME(sql);
            
        } catch (Exception e) {
            throw e;
        }
    }

    public void actualizaPrecioProducto(String nombre, Double precio) throws Exception {
        try {
            existe(nombre);
            String sql = String.format("UPDATE producto SET precio = %s WHERE nombre = '%s';",nD(precio), nombre);
            iME(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public void actualizaPrecioProducto(int codigo, Double precio) throws Exception {
        try {
            existe(codigo);
            String sql = String.format("UPDATE producto SET precio = %s WHERE codigo = %d;", nD(precio), codigo);
            iME(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    ///         INSERT DELETE UPDATE        ///
    
    ///                SELECT               ///
    public Producto buscarProductoPorCodigo(int codigo) throws Exception {
        try {
            
            String filtro = String.format("WHERE codigo = %d;", codigo);
            ArrayList<Producto> lista = (ArrayList<Producto>) consultaProductos("*","WHERE codigo = "+codigo);
            if (lista.isEmpty()) {
                return null;
            }
            return lista.get(0);
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }

    public Collection<Producto> listaDeProductos() throws Exception {
        try {
            return consultaProductos("*");
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> nombresProductos() throws Exception {
        try {
            return consultaProductos("nombre");
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> nombresYPreciosProductos() throws Exception {
        try {
            return consultaProductos("nombre, precio");
        } catch (Exception e) {
            throw e;
        }
    }

    
    private Collection<Producto> consultaProductos(String columnas) throws Exception {
        try {
            return consultaProductos(columnas, "");
        } catch (Exception e) {
            throw e;
        }
    }

    private Collection<Producto> consultaProductos(String columnas, String subConsultas) throws Exception {
        try {
            Collection<Producto> prods = new ArrayList();
            String sql = "SELECT " + columnas + " FROM producto " + subConsultas + ';';
            consulta(sql);
            int cols = resultado.getMetaData().getColumnCount();
            int[] an = new int[cols + 1];
            String[] tiposCols = new String[cols + 1];
            Producto p = null;
            String[] listaTitulos = new String[cols + 1];

            for (int i = 1; i <= cols; i++) {
                listaTitulos[i] = resultado.getMetaData().getColumnLabel(i);
                tiposCols[i] = columnaTipos(resultado.getMetaData().getColumnType(i));
            }
            while (resultado.next()) {
                for (int i = 1; i <= cols; i++) {
                    if (resultado.getString(i).length() > an[i]) {
                        an[i] = resultado.getString(i).length();
                    }
                }

                p = new Producto();
                for (int i = 1; i <= cols; i++) {
                    switch (resultado.getMetaData().getColumnType(i)) {
                        case 1:// CHARECTER
                        //return "c";
                        case -5:// BIGINT
                        case -6:// TINYINT
                        case -7:// BIT
                        case 4:// INTEGER
                        case 5:// SMALLINT
                            p.setValue(listaTitulos[i], resultado.getInt(i));
                            break;
                        case 2:// NUMERIC
                        case 3:// DECIMAL
                        case 6:// FLOAT
                        case 7:// REAL
                        case 8:// DOUBLE
                            p.setValue(listaTitulos[i], resultado.getDouble(i));
                            break;
                        case -1:// LONGVARCHAR
                        case 12:// VARCHAR
                        case 2004:// BLOB
                            p.setValue(listaTitulos[i], resultado.getString(i));
                            break;
                        case 16:// BOOLEAN
                        //return "b";
                        case 91:// TIME
                        //return "t";
                        case 92:// DATE
                            //p.setValue(lis[i], resultado.getDate(i));
                            break;
                    }

                }
                prods.add(p);
            }

            desconectar();
            listaColumnas = listaTitulos;
            anchoColumnas = an;
            colCount = cols;
            tipoColumnas = tiposCols;
            return prods;
        } catch (Exception e) {
            throw e;
        }
    }

    public Producto buscarProductoPorNombre(String nombre) throws Exception {
        try {
            ArrayList<Producto> lista = (ArrayList<Producto>) consultaProductos("*", "WHERE nombre = '" + nombre + "'");
            if (lista.size()==0) {
                return null;
            }
            return lista.get(0);
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> buscarRangoPrecios(Double minPrecio, Double maxPrecio) throws Exception {
        try {
            if (minPrecio > maxPrecio) {
                Double temp = maxPrecio;
                maxPrecio = minPrecio;
                minPrecio = temp;
            }

            return consultaProductos("*", String.format("WHERE precio > %s AND precio < %s", nD(minPrecio), nD(maxPrecio)));
        } catch (Exception e) {
            throw e;
        }
    }

    
    public Collection<Producto> productosFiltroLike(String columna, String filtro) throws Exception {
        try {
            return consultaProductos("*","WHERE "+columna + " LIKE '%"+filtro+"%'");
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> productosOrdenadosPor(String columna,Precio orden, String columnasParaMostrar) throws Exception {
        try {
            return consultaProductos(columnasParaMostrar, "ORDER BY " + columna+" " +orden.getValor());
        } catch (Exception e) {
            throw e;
        }
    }
    
    ///                SELECT               ///
    
    ///             VALIDACIONES            ///
    private void existe(Producto producto) throws Exception {
        if (producto != null) {
            throw new Exception("Debe pasar un fabricante.");
        }
    }

    private void existe(int codigo_fabricante) throws Exception {
        if (codigo_fabricante < 1) {
            throw new Exception("Codigo de fabricante invalido.");
        }
    }

    private void existe(String nombre) throws Exception {
        if (nombre.trim().isEmpty()) {
            throw new Exception("El nombre del producto está vacio.");
        }
    }
    
    private void existe(Double precio) throws Exception {
        if ((precio == null)|| (precio == 0 )) {
            throw new Exception("El precio del producto está vacio.");
        }
    }

    ///             VALIDACIONES            ///
    
    ///          CONVERSION DECIMAL         ///
    private String nD(Double num) {
        try {
            String s = num.toString();
            if (s.contains(",")) {
                s = s.replace(',', '.');
            }
            return s;
        } catch (Exception e) {
            throw e;
        }
    }

    
}
