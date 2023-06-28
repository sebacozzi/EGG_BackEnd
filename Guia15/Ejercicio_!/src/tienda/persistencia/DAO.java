/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.persistencia;

import java.sql.*;

/**
 *
 * @author Sebastián Cozzi
 */
public abstract class DAO {

    protected Connection conexion = null;
    protected Statement stmt = null;
    protected ResultSet resultado = null;

    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String DATABASE = "tienda";
    private final String URL = "jdbc:mysql://localhost:3306/%s?useSSL=false";

    protected void conectar() throws ClassNotFoundException, SQLException {
        try {
            Class.forName(DRIVER);
            String URLs = String.format(URL, DATABASE);
            conexion = DriverManager.getConnection(URLs, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        }
    }

    protected void desconectar() throws Exception {
        try {
            if (resultado != null) {
                resultado.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conexion != null) {
                conexion.close();
            }

        } catch (Exception e) {
            throw e;
        }
    }

    protected void iME(String SQL) throws Exception {
        try {
            conectar();
            stmt = conexion.createStatement();
            stmt.execute(SQL);
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;

        } finally {
            desconectar();
        }
    }

    protected void consulta(String SQL) throws Exception {
        try {
            conectar();
            stmt = conexion.createStatement();
            resultado = stmt.executeQuery(SQL);
        } catch (ClassNotFoundException | SQLException ex) {
            throw ex;
        }
    }
}
