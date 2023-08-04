package Modelo.DAO;

import Modelo.DTO.Empleado;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import utils.Conexion;

/**
 *
 * @author Almi-
 */
public class LoginDAO {
     public Empleado login (String CI,String password) throws SQLException{
        String sp = "{CALL LoginEmpleado(?,?)}";
        
        try {
            Connection conn = Conexion.getConexion();
            CallableStatement cstmt = conn.prepareCall(sp);
            cstmt.setString(1,CI);
            cstmt.setString(2,password);
            ResultSet result = cstmt.executeQuery();
            Empleado emp = new Empleado();
            
            if(result.next()){
                emp.setCi(result.getString("CI"));
                emp.setNombre(result.getString("Nombre"));
                emp.setApellido(result.getString("Apellido"));                
                //String cargo = result.getString("CARGO");
                return emp;              
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }         
        return null;
    }
}
