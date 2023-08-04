package utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Almi-
 */
public class Query {
    public ResultSet executeSP(String query, Map<String, Object> params) throws SQLException {
    Connection connection = null;
    CallableStatement cstmt = null;
    ResultSet resultSet = null;

    try {
        connection = Conexion.getConexion();
        cstmt = connection.prepareCall(query);

        // Asignar los parámetros al CallableStatement
        if (params != null) {
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                System.out.println("este es el entry: "+entry.getValue().getClass());
                cstmt.setObject(entry.getKey(), entry.getValue().toString());
            }
        }

        // Ejecutar el procedimiento almacenado
        boolean isResultSet = cstmt.execute();

        // Si hay un resultado, lo almacenamos en el ResultSet
        if (isResultSet) {
            resultSet = cstmt.getResultSet();
        }
    } catch (SQLException ex) {
        // Manejar errores
        throw ex;
    } finally {
        // Cerrar los recursos
        if (resultSet != null) {
            resultSet.close();
        }
        if (cstmt != null) {
            cstmt.close();
        }
        if (connection != null) {
            connection.close();
        }
    }

    return resultSet;
    }
}
