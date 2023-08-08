/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Modelo.DTO.Envio;
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
public class EnvioDAO {
    public List<Envio> getEnvios() throws SQLException{
        String query = "Exec ObtenerPedidoEnvio2 '';";
        ArrayList<Envio> envios = new ArrayList();
        try {
            Connection conn = Conexion.getConexion();
            CallableStatement cstmt = conn.prepareCall(query);
            ResultSet result = cstmt.executeQuery();
            while(result.next()){
                Envio env = new Envio();
                env.setId(result.getString("ID"));
                env.setFecha(result.getString("FECHA"));
                env.setRucCliente(result.getString("RUC CLIENTE"));
                env.setDetalles(result.getString("DETALLES"));
                env.setPeso(result.getString("PESO"));
                env.setEnvioInterprov(result.getString("ENVIO INTRAPROVINCIAL"));
                env.setCosto(result.getString("COSTO"));
                env.setDireccion(result.getString("DIRECCION DESTINATARIO"));
                env.setCiDestinatario(result.getString("CI DESTINATARIO"));
                env.setTelefono(result.getString("TELEFONO DESTINATARIO"));
                env.setEstado(result.getString("ESTADO"));
                env.setFechaEntrega(result.getString("FECHA FINALIZACION"));
                env.setCiChofer(result.getString("CI CHOFER"));
                
                envios.add(env);
            }            
            conn.close();
            System.out.println("estos son los envios: "+envios);
            return envios;
            //cstmt.setString(1, query);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se encontro nada...!");
        }
        return null;
    }
    //leer cliente por id
    public Array getEnvioPorId(String id){
        String query = "{CALL ObtenerPedidoEnvioParticular(?)}";
        try {
            Connection conn = Conexion.getConexion();
            CallableStatement cstmt = conn.prepareCall(query);
            cstmt.setString(1, id);
            ResultSet result = cstmt.executeQuery();
            Array arr = result.getArray(0);
            System.out.println("Este es el envio por id: "+arr);
            conn.close();
            return arr;
        } catch (SQLException ex) {
            System.out.println("Error> "+ex);
        }        
        return null;
    }
    
    //crear cliente
    public boolean crearEnvio(Envio env)throws SQLException{
        String query = "{CALL CrearPedidoEnvio(?,?,?,?,?,?,?,?)}";
        try {
            Connection conn = Conexion.getConexion();
            CallableStatement cstmt = conn.prepareCall(query);
            cstmt.setString(1, env.getFecha());
            cstmt.setString(2, env.getRucCliente());
            cstmt.setString(3, env.getDetalles());
            cstmt.setString(4, env.getPeso());
            cstmt.setString(5, env.getEnvioInterprov());
            cstmt.setString(6, env.getDireccion());
            cstmt.setString(7, env.getCiDestinatario());
            cstmt.setString(8, env.getTelefono());
            
            ResultSet res = cstmt.executeQuery();
            System.out.println("Envio creado: "+res);
            
            conn.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error> "+ex);
        }
        
        return false;
    }
    
    //editar cliente
    public boolean editarEnvio(Envio env){
        String query = "{CALL ModificarPedidoEnvio(?,?,?,?,?,?,?)}";
        try {
            Connection conn = Conexion.getConexion();
            CallableStatement cstmt = conn.prepareCall(query);
            cstmt.setString(1, env.getId());
            cstmt.setString(2, env.getDetalles());
            cstmt.setString(3, env.getPeso());
            cstmt.setString(4, env.getEnvioInterprov());
            cstmt.setString(5, env.getDireccion());
            cstmt.setString(6, env.getTelefono());
            cstmt.setString(7, env.getEstado());
            
            cstmt.executeUpdate();
            conn.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error> "+ex);
        }
        return false;
    }
    
    //borrar cliente
    public boolean eliminarEnvio(String id){
        String query = "{CALL EliminarPedidoEnvio(?)}";
        try {
            Connection conn = Conexion.getConexion();
            CallableStatement cstmt = conn.prepareCall(query);
            cstmt.setString(1, id);
            ResultSet res = cstmt.executeQuery();
            System.out.println("Res de eliminar env: "+res);
            conn.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error> "+ex);
        } 
        
        return false;
    }
    
    public boolean agregarCiAEnvio(String ci,int idEnvio){
    String query = "UPDATE ENVIO SET CICHOFER = ? WHERE ID_PEDIDO = ?;";
        try {
            Connection conn = Conexion.getConexion();
            CallableStatement cstmt = conn.prepareCall(query);
            cstmt.setString(1, ci);
            cstmt.setInt(2, idEnvio);
            cstmt.executeUpdate();
            //System.out.println("Res de eliminar env: "+res);
            conn.close();
            return true;
        } catch (SQLException ex) {
            System.out.println("Error en agregarCiAEnvio> "+ex);
        } 
        
        return false;
    }
}
