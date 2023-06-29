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

    public void agregarFabricante(Fabricante fabricante) throws Exception {
        try {
            existe(fabricante);
            String sql = String.format("INSERT INTO fabricante (nombre) VALUES ('%s');",
                    fabricante.getNombre());
            iME(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public void eliminarFabricante(Fabricante fabricante) throws Exception {
        try {
            existe(fabricante);
            String sql = String.format("DELETE FROM fabricante WHERE codigo = %d;", fabricante.getCodigo());
            iME(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public void actualizaFabricante(Fabricante fabricante) throws Exception {
        try {
            existe(fabricante);
            String sql = String.format("UPDATE fabricante SET nombre = '%s' WHERE codigo = %d;", fabricante.getNombre(), fabricante.getCodigo());
        } catch (Exception e) {
            throw e;
        }
    }

    public Fabricante buscarFabricantePorNombre(String nombre) throws Exception {
        try {
            String sql = String.format("SELECT * FROM fabricante WHERE nombre = '%s'", nombre);
            consulta(sql);
            Fabricante f = null;
            while (resultado.next()) {
                f = new Fabricante(resultado.getInt(1), resultado.getString(2));
            }
            desconectar();
            return f;
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }

    public Collection<Fabricante> listaDeFabricantes() throws Exception {
        try {
            Collection<Fabricante> fs = new ArrayList();
            String sql = String.format("SELECT * FROM fabricante;");
            consulta(sql);
            Fabricante f;
            while (resultado.next()) {
                f = new Fabricante(resultado.getInt(1), resultado.getString(2));
                fs.add(f);
            }
            desconectar();
            return fs;
        } catch (Exception e) {
            desconectar();
            throw e;
        }
    }

    public int idDelFabricante(String fabricante) throws Exception {
        try {
            int id = -1;
            String sql = "SELECT codigo FROM fabricante WHERE nombre = '" + fabricante + "';";
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

    private void existe(Fabricante fabricante) throws Exception {
        if (fabricante != null) {
            throw new Exception("Debe pasar un fabricante.");
        }
    }

}
