/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Hairex
 */
public class GenericaDb {
    String driver, url, ip, bd, usr, pass;
    public Connection conexion;

    public GenericaDb() {
        driver = "oracle.jdbc.driver.OracleDriver";
        this.bd = "oracle";
        this.usr = "system";
        this.pass = "root";
        this.ip="localhost";
        url = "jdbc:oracle:thin:@" + ip + ":1521:" + bd;
        try {
            Class.forName(driver).newInstance();
            conexion = DriverManager.getConnection(url, usr, pass);
            System.out.println("Conexion a Base de Datos " + bd + " Ok");
        } catch (Exception exc) {
            System.out.println("Error al tratar de abrir la base de Datos" + bd + " : " + exc);
        }
    }

    public Connection getConexion() {
        return conexion;
    }

    public Connection CerrarConexion() throws SQLException {
        conexion.close();
        conexion = null;
        System.out.println("Conexion Cerrada");
        return conexion;
        
    }
}
