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
            return consultaProductos(" * ");
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
            return consultaProductos(" nombre ");
        } catch (Exception e) {
            throw e;
        }
    }

    public Collection<Producto> nombresYPreciosProductos() throws Exception {
        try {
            return consultaProductos(" nombre, precio ");
        } catch (Exception e) {
            throw e;
        }
    }
    
     private Collection<Producto> consultaProductos(String columnas) throws Exception {
        try {
            return consultaProductos(columnas,"");
        } catch (Exception e){
            throw e;
        }
     }
     
    private Collection<Producto> consultaProductos(String columnas,String subConsultas) throws Exception {
        try {
            Collection<Producto> prods = new ArrayList();
            String sql = "SELECT "+columnas+" from producto"+subConsultas+';';
            consulta(sql);
            int cols = resultado.getMetaData().getColumnCount();
            int[] an = new int[cols + 1];
            String[] colD = new String[cols + 1];
            Producto p = null;
            String[] lis = new String[cols + 1];

            for (int i = 1; i <= cols; i++) {
                lis[i] = resultado.getMetaData().getColumnLabel(i);
                colD[i] = columnaTipos(resultado.getMetaData().getColumnType(i));
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
                            p.setValue(lis[i], resultado.getInt(i));
                            break;
                        case 2:// NUMERIC
                        case 3:// DECIMAL
                        case 6:// FLOAT
                        case 7:// REAL
                        case 8:// DOUBLE
                            p.setValue(lis[i], resultado.getDouble(i));
                            break;
                        case -1:// LONGVARCHAR
                        case 12:// VARCHAR
                        case 2004:// BLOB
                            p.setValue(lis[i], resultado.getString(i));
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
