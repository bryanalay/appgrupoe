package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Almi-
 */
public class Conexion {
    public static Connection getConexion() {
        String connectionString = "jdbc:sqlserver://almidbone.mssql.somee.com:"
                + "1433;databaseName=almidbone;user=almidev_SQLLogin_1;password="
                + "ameo4brmgg;loginTimeout=30;encrypt=false;";
        try {
            Connection conn = DriverManager.getConnection(connectionString);
            System.out.println("Conexión establecida correctamente.");
            return conn;
        } catch (SQLException ex) {
            System.err.println("Error al conectar a la base de datos: " + ex.toString());
            return null;
        }
    }
}