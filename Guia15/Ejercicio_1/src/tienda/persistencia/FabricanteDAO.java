/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.Entidades.fabricante.Fabricante;

/**
 *
 * @author Sebastián Cozzi
 */
public final class FabricanteDAO extends DAO {
    
    public void agregarFabricante(String nombre) throws Exception {
        try {
            existe(nombre);
            String sql = String.format("INSERT INTO fabricante (nombre) VALUES ('%s');",
                    nombre);
            iME(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarFabricante(int codigo) throws Exception {
        try {
            existe(codigo);
            String sql = String.format("DELETE FROM fabricante WHERE codigo = %d;", codigo);
            iME(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public void actualizaFabricante(Fabricante fabricante) throws Exception {
        try {
            existe(fabricante);
            String sql = String.format("UPDATE fabricante SET nombre = '%s' WHERE codigo = %d;", fabricante.getNombre(), fabricante.getCodigo());
            iME(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public Fabricante buscarFabricantePorNombre(String nombre) throws Exception {
        try {
            ArrayList<Fabricante> lista =(ArrayList<Fabricante>)consultaFabricantes(" * "," WHERE nombre = '"+nombre+"'");
            if (lista.isEmpty()) {
                return null;
            }
            return lista.get(0);
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }

    public Collection<Fabricante> listaDeFabricantes() throws Exception {

        return consultaFabricantes("*");

    }

    private Collection<Fabricante> consultaFabricantes(String columnas) throws Exception {

        return consultaFabricantes(columnas, "");

    }
    

    private Collection<Fabricante> consultaFabricantes(String columnas, String subConsultas) throws Exception {
        try {
            Collection<Fabricante> fs = new ArrayList();
            String sql = "SELECT " + columnas + " FROM fabricante " + subConsultas + ';';
            consulta(sql);
            Fabricante f;
            int cols = resultado.getMetaData().getColumnCount();
            int[] an = new int[cols + 1];
            String[] colD = new String[cols + 1];
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

                f = new Fabricante();

                for (int i = 1; i <= cols; i++) {
                    switch (resultado.getMetaData().getColumnType(i)) {
                        case 1:// CHARECTER
                        //return "c";
                        case -5:// BIGINT
                        case -6:// TINYINT
                        case -7:// BIT
                        case 4:// INTEGER
                        case 5:// SMALLINT
                            f.setValue(lis[i], resultado.getInt(i));
                            break;
                        case 2:// NUMERIC
                        case 3:// DECIMAL
                        case 6:// FLOAT
                        case 7:// REAL
                        case 8:// DOUBLE
                            //f.setValue(lis[i], resultado.getDouble(i));
                            break;
                        case -1:// LONGVARCHAR
                        case 12:// VARCHAR
                        case 2004:// BLOB
                            f.setValue(lis[i], resultado.getString(i));
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

                fs.add(f);

            }

            desconectar();
            listaColumnas = lis;
            anchos = an;
            colCount = cols;
            tipoColumnas = colD;

            return fs;
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }

    public int idDelFabricante(String nombre) throws Exception {
        try {
            int id = -1;
            String sql = "SELECT codigo FROM fabricante WHERE nombre = '" + nombre + "';";
            consulta(sql);
            while (resultado.next()) {
                id = resultado.getInt(1);
            }
            desconectar();
            return id;
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }

    
    /// Control de datos pasados
    
    private void existe(String fabricante) throws Exception {
        if (fabricante.trim().isEmpty()) {
            throw new Exception("Debe pasar un fabricante. El nombre está vacio.");
        }
    }
    private void existe(int codigo) throws Exception {
        if (codigo<1) {
            throw new Exception("Debe pasar un fabricante. Codigo o Id incorrecto.");
        }
    }
    private void existe(Fabricante fabricante) throws Exception {
        if (fabricante == null) {
            throw new Exception("Debe pasar un fabricante.");
        }
    }

}
