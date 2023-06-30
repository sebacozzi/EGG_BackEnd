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

    protected String columnaTipos(int id) {
        switch (id) {
            case 1:// CHARECTER
                return "c";
            case -5:// BIGINT
            case -6:// TINYINT
            case -7:// BIT
            case 4:// INTEGER
            case 5:// SMALLINT
                return "d";
            case 2:// NUMERIC
            case 3:// DECIMAL
            case 6:// FLOAT
            case 7:// REAL
            case 8:// DOUBLE
                return "f";
            case -1:// LONGVARCHAR
            case 12:// VARCHAR
            case 2004:// BLOB
                return "s";
            case 16:// BOOLEAN
                return "b";
            case 91:// TIME
                return "t";
            case 92:// DATE
                return "t";
        }
        return "s";
    }
}
