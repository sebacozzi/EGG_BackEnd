/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.persistencia;

import tienda.Entidades.fabricante.Fabricante;

/**
 *
 * @author Sebastián Cozzi
 */
public final class FabricanteDAO extends DAO {

    public void agregarFabricante(Fabricante fabricante) throws Exception {
        try {
            existe(fabricante);
            String sql = String.format("INSERT INTO fabricante (codigo,nombre) VALUES (%d,'%s');",
                    fabricante.getCodigo(), fabricante.getNombre());
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
    public void actualizaFabricante(Fabricante fabricante)throws Exception{
        try {
            existe(fabricante);
            String sql= String.format("UPDATE fabricante SET nombre = '%s' WHERE codigo = %d;", fabricante.getNombre(),fabricante.getCodigo());
        } catch (Exception e) {
            throw e;
        }
       
    }
    
    private void existe(Fabricante fabricante) throws Exception {
        if (fabricante != null) {
            throw new Exception("Debe pasar un fabricante.");
        }
    }
}
