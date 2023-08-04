package Modelo.DAO;
import Modelo.DTO.Chofer;
import Modelo.DTO.Empleado;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import utils.Conexion;
/**
 *
 * @author Almi-
 */
public class ChoferDAO{
    //leer empleados
    public List<Chofer> getChofer() throws SQLException{
        String query = "exec dbo.ObtenerChofer '';";
        ArrayList<Chofer> chofer = new ArrayList();
        try {
            Connection conn = Conexion.getConexion();
            CallableStatement cstmt = conn.prepareCall(query);
            ResultSet result = cstmt.executeQuery();
            //System.out.println("Choferes res call: "+result.getString("CEDULA"));
            while(result.next()){
                Chofer cho = new Chofer();
                cho.setCi(result.getString("CEDULA"));
                cho.setNombre(result.getString("NOMBRE"));
                cho.setApellido(result.getString("APELLIDO"));
                cho.setCelular(result.getString("CELULAR"));
                cho.setFecha(result.getString("FECHA DE NACIMIENTO")); 
                cho.setCorreo(result.getString("CORREO"));
                cho.setDireccion(result.getString("DIRECCION"));
                cho.setDisponibilidad(result.getString("DISPONIBILIDAD"));
                chofer.add(cho);
            }            
            conn.close();
            return chofer;
            //cstmt.setString(1, query);
        } catch (SQLException e) {
            /*JOptionPane.showMessageDialog(null, "No hay choferes...!");*/
            System.out.println("Ex: "+e);
        }
        return null;
    }
    //leer empleado por id
     public List<Chofer> getVehiculoByRuc(String ruc){
        String query = "{CALL ObtenerVehiculo(?)}";
        ArrayList<Chofer> vehiculo = new ArrayList();
        try {
            Connection conn = Conexion.getConexion();
            CallableStatement cstmt = conn.prepareCall(query);
            /*cstmt.setString(1, ruc);*/
            ResultSet result = cstmt.executeQuery();
            while(result.next()){
                Chofer cho = new Chofer();
                cho.setCi(result.getString("CEDULA"));
                cho.setNombre(result.getString("NOMBRE"));
                cho.setApellido(result.getString("APELLIDO"));
                cho.setCelular(result.getString("CELULAR"));
                cho.setFecha(result.getString("FECHA_DE_NACIMIENTO")); 
                cho.setCorreo(result.getString("CORREO"));
                cho.setDireccion(result.getString("DIRECCION"));
                cho.setDisponibilidad(result.getString("DISPONIBILIDAD"));
                Chofer.add(cho);
            }            
            conn.close();
            return vehiculo;
        } catch (SQLException ex) {
            System.out.println("Error> "+ex);
        }        
        return null;
    }
    //crear empleado
    public boolean crearChofer(Chofer emp)throws SQLException{
        String query = "{CALL CrearEmpleado(?,?,?,?,?,?,?,?,?)}";
        try {
            Connection conn = Conexion.getConexion();
            CallableStatement cstmt = conn.prepareCall(query);
            cstmt.setString(1, emp.getCi());
            cstmt.setString(2, emp.getNombre());
            cstmt.setString(3, emp.getApellido());
            cstmt.setString(4, emp.getCelular());
            cstmt.setString(5, emp.getFecha());
            cstmt.setString(6, emp.getCorreo());
            cstmt.setString(7, emp.getDireccion());
            cstmt.setString(8, emp.getContrasenia());
            cstmt.setString(9, "Chofer");
            cstmt.executeUpdate();
            conn.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error> "+ex);
        }
        
        return false;
    }
    
    //editar empleado
    public boolean editarChofer(Chofer emp){
        String query = "{CALL ModificarChofer(?,?,?,?,?,?,?,?)}";
        try {
            Connection conn = Conexion.getConexion();
            CallableStatement cstmt = conn.prepareCall(query);
            cstmt.setString(1, emp.getCi());
            cstmt.setString(2, emp.getNombre());
            cstmt.setString(3, emp.getApellido());
            cstmt.setString(4, emp.getCelular());
            cstmt.setString(5, emp.getFecha());
            cstmt.setString(6, emp.getCorreo());
            cstmt.setString(7, emp.getDireccion());
            cstmt.setString(8, emp.getDisponibilidad());            
            cstmt.executeUpdate();
            conn.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error> "+ex);
        }
        return false;
    }
    
    //borrar empleado
    public boolean eliminarChofer(String ci){
        String query = "{CALL EliminarEmpleado(?)}";
        try {
            Connection conn = Conexion.getConexion();
            CallableStatement cstmt = conn.prepareCall(query);
            cstmt.setString(1, ci);
            cstmt.executeUpdate();
            conn.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error> "+ex);
        } 
        
        return false;
    }
}