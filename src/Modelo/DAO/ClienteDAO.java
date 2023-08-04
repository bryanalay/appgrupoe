package Modelo.DAO;
import Modelo.DTO.*;
import java.sql.Array;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import utils.Conexion;

/**
 *
 * @author Almi-
 */
public class ClienteDAO {
    
    //getClientes
    public List<Cliente> getClientes() throws SQLException{
        String query = "SELECT * FROM CLIENTE";
        ArrayList<Cliente> clientes = new ArrayList();
        try {
            Connection conn = Conexion.getConexion();
            CallableStatement cstmt = conn.prepareCall(query);
            ResultSet result = cstmt.executeQuery();
            while(result.next()){
                Cliente emp = new Cliente();
                emp.setRuc(result.getString("RUC"));
                emp.setNombre(result.getString("NOMBRE"));
                emp.setTelefono(result.getString("TELEFONO"));
                emp.setCorreo(result.getString("CORREO"));
                emp.setDireccion(result.getString("DIRECCION"));
                clientes.add(emp);
            }            
            conn.close();
            return clientes;
            //cstmt.setString(1, query);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se encontro nada...!");
        }
        return null;
    }
    //leer cliente por id
    public Array egetClienteByRuc(String ruc){
        String query = "{CALL ObtenerCliente(?)}";
        try {
            Connection conn = Conexion.getConexion();
            CallableStatement cstmt = conn.prepareCall(query);
            cstmt.setString(1, ruc);
            ResultSet result = cstmt.executeQuery();
            Array arr = result.getArray(0);
            System.out.println("Este es el clietne por ruc: "+arr);
            conn.close();
            return arr;
        } catch (SQLException ex) {
            System.out.println("Error> "+ex);
        }        
        return null;
    }
    
    //crear cliente
    public boolean crearCliente(Cliente emp)throws SQLException{
        String query = "{CALL CrearCliente(?,?,?,?,?)}";
        try {
            Connection conn = Conexion.getConexion();
            CallableStatement cstmt = conn.prepareCall(query);
            cstmt.setString(1, emp.getRuc());
            cstmt.setString(2, emp.getNombre());
            cstmt.setString(3, emp.getTelefono());
            cstmt.setString(4, emp.getCorreo());
            cstmt.setString(5, emp.getDireccion());
            cstmt.executeUpdate();
            conn.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error> "+ex);
        }
        
        return false;
    }
    
    //editar cliente
    public boolean editarCliente(Cliente emp){
        String query = "{CALL ModificarCliente(?,?,?,?,?)}";
        try {
            Connection conn = Conexion.getConexion();
            CallableStatement cstmt = conn.prepareCall(query);
            cstmt.setString(1, emp.getRuc());
            cstmt.setString(2, emp.getNombre());
            cstmt.setString(3, emp.getTelefono());
            cstmt.setString(4, emp.getCorreo());
            cstmt.setString(5, emp.getDireccion());           
            cstmt.executeUpdate();
            conn.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error> "+ex);
        }
        return false;
    }
    
    //borrar cliente
    public boolean eliminarCliente(String ruc){
        String query = "{CALL EliminarCliente(?)}";
        try {
            Connection conn = Conexion.getConexion();
            CallableStatement cstmt = conn.prepareCall(query);
            cstmt.setString(1, ruc);
            cstmt.executeUpdate();
            conn.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error> "+ex);
        } 
        
        return false;
    }
}
