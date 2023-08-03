/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Modelo.DTO.Cliente;
import Modelo.DTO.Vehiculo;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import utils.Conexion;

/**
 *
 * @author Almi-
 */
public class VehiculoDAO {
    
    //getVehiculo
    public List<Vehiculo> getVehiculos() throws SQLException{
        String query = "SELECT * FROM VEHICULO";
        ArrayList<Vehiculo> vehiculo = new ArrayList();
        try {
            Connection conn = Conexion.getConexion();
            CallableStatement cstmt = conn.prepareCall(query);
            ResultSet result = cstmt.executeQuery();
            while(result.next()){
                Vehiculo emp = new Vehiculo();
                emp.setMatricula(result.getString("MATRICULA"));
                emp.setMarca(result.getString("MARCA"));
                emp.setAnio(result.getString("AÑO"));
                vehiculo.add(emp);
            }            
            conn.close();
            return vehiculo;
            //cstmt.setString(1, query);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se encontro nada...!");
        }
        return null;
    }
    //leer Vehiculo por id
    public List<Vehiculo> getVehiculoByRuc(String ruc){
        String query = "{CALL ObtenerVehiculo(?)}";
        ArrayList<Vehiculo> vehiculo = new ArrayList();
        try {
            Connection conn = Conexion.getConexion();
            CallableStatement cstmt = conn.prepareCall(query);
            cstmt.setString(1, ruc);
            ResultSet result = cstmt.executeQuery();
            while(result.next()){
                Vehiculo emp = new Vehiculo();
                emp.setMatricula(result.getString("MATRICULA"));
                emp.setMarca(result.getString("MARCA"));
                emp.setAnio(result.getString("AÑO"));
                emp.setTipo(result.getString("TIPO"));
                emp.setDispon(result.getString("DISPONIBILIDAD"));
                vehiculo.add(emp);
            }            
            conn.close();
            return vehiculo;
        } catch (SQLException ex) {
            System.out.println("Error> "+ex);
        }        
        return null;
    }
    
    //crear Vehiculo
    public boolean crearVehiculo(Vehiculo emp)throws SQLException{
        String query = "{CALL CrearVehiculo(?,?,?,?)}";
        try {
            Connection conn = Conexion.getConexion();
            CallableStatement cstmt = conn.prepareCall(query);
            cstmt.setString(1, emp.getMatricula());
            cstmt.setString(2, emp.getMarca());
            cstmt.setString(3, emp.getAnio());
            cstmt.setString(4, emp.getTipo());
            cstmt.executeUpdate();
            conn.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error> "+ex);
        }
        
        return false;
    }
    
    //editar Vehiculo
    public boolean editarCliente(Vehiculo emp){
        String query = "{CALL ModificarVehiculo(?,?,?,?,?)}";
        try {
            Connection conn = Conexion.getConexion();
            CallableStatement cstmt = conn.prepareCall(query);
            cstmt.setString(1, emp.getMatricula());
            cstmt.setString(2, emp.getMarca());
            cstmt.setString(3, emp.getAnio());
            cstmt.setString(4, emp.getTipo());
            cstmt.setString(5, emp.getDispon());           
            cstmt.executeUpdate();
            conn.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error> "+ex);
        }
        return false;
    }
    
    //borrar Vehiculo
    public boolean eliminarVehiculo(String matricula){
        String query = "{CALL EliminarVehiculo(?)}";
        try {
            Connection conn = Conexion.getConexion();
            CallableStatement cstmt = conn.prepareCall(query);
            cstmt.setString(1, matricula);
            cstmt.executeUpdate();
            conn.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error> "+ex);
        } 
        
        return false;
    }
}