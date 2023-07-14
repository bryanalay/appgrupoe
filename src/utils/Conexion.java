/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Almi-
 */
public class Conexion {
    public static Connection getConexion(){
        String connectionString = "jdbc:sqlserver://almidbone.mssql.somee.com:"
                + "1433;databaseName=almidbone;user=almidev_SQLLogin_1;password="
                + "ameo4brmgg;loginTimeout=30;encrypt=false;";
        try {
            Connection conn = DriverManager.getConnection(connectionString);
            return conn;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            return null;
        }
    }
}
