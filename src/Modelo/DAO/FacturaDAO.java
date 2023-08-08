/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;
import Modelo.DTO.Factura;
import utils.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FacturaDAO {

    public List<Factura> getFacturas() throws SQLException {
        String query = "Select * from factura;";
        List<Factura> facturas = new ArrayList<>();

        try {
            Connection conn = Conexion.getConexion();
            CallableStatement cstmt = conn.prepareCall(query);
            ResultSet result = cstmt.executeQuery();

            while (result.next()) {
                Factura factura = new Factura();
                factura.setId(result.getInt("ID"));
                factura.setIdEnvio(result.getInt("IDEnvio"));
                factura.setRuc(result.getString("RUC"));
                factura.setCiDestino(result.getString("CIDestino"));
                factura.setDireccion(result.getString("Direccion"));
                factura.setDetalles(result.getString("Detalles"));
                factura.setTotal(result.getString("Total"));
                // Otros campos

                facturas.add(factura);
            }

            System.out.println("Estas son las facturas: " + facturas);
            return facturas;
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            // Manejar excepciones apropiadamente
        }

        return null;
    }

    public Factura getFacturaPorId(int id) {
        String query = "{CALL LeerFactura(?)}";

        try {
            Connection conn = Conexion.getConexion();
            CallableStatement cstmt = conn.prepareCall(query);
            cstmt.setInt(1, id);
            ResultSet result = cstmt.executeQuery();

            if (result.next()) {
                Factura factura = new Factura();
                factura.setId(result.getInt("ID"));
                factura.setIdEnvio(result.getInt("IDEnvio"));
                factura.setRuc(result.getString("RUC"));
                factura.setCiDestino(result.getString("CIDestino"));
                factura.setDireccion(result.getString("Direccion"));
                factura.setDetalles(result.getString("Detalles"));
                factura.setTotal(result.getString("Total"));
                // Otros campos

                System.out.println("Esta es la factura por id: " + factura);
                return factura;
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            // Manejar excepciones apropiadamente
        }

        return null;
    }

    public boolean crearFactura(Factura factura) {
        String query = "{CALL CrearFactura(?,?,?,?,?,?)}";

        try {
            Connection conn = Conexion.getConexion();
            CallableStatement cstmt = conn.prepareCall(query);
            cstmt.setInt(1, factura.getIdEnvio());
            cstmt.setString(2, factura.getRuc());
            cstmt.setString(3, factura.getCiDestino());
            cstmt.setString(4, factura.getDireccion());
            cstmt.setString(5, factura.getDetalles());
            cstmt.setString(6, factura.getTotal());

            cstmt.executeUpdate();
            System.out.println("Factura creada");

            return true;
        } catch (SQLException ex) {
            System.out.println("Error en crear factura: " + ex.getMessage());
            // Manejar excepciones apropiadamente
        }

        return false;
    }

    public boolean actualizarFactura(Factura factura) {
        String query = "{CALL ActualizarFactura(?,?,?,?,?,?,?)}";

        try {
            Connection conn = Conexion.getConexion();
            CallableStatement cstmt = conn.prepareCall(query);
            cstmt.setInt(1, factura.getId());
            cstmt.setInt(2, factura.getIdEnvio());
            cstmt.setString(3, factura.getRuc());
            cstmt.setString(4, factura.getCiDestino());
            cstmt.setString(5, factura.getDireccion());
            cstmt.setString(6, factura.getDetalles());
            cstmt.setString(7, factura.getTotal());

            ResultSet res = cstmt.executeQuery();
            System.out.println("Factura actualizada: " + res);

            return true;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            // Manejar excepciones apropiadamente
        }

        return false;
    }

    public boolean eliminarFactura(int id) {
        String query = "{CALL EliminarFactura(?)}";

        try {
            Connection conn = Conexion.getConexion();
            CallableStatement cstmt = conn.prepareCall(query);
            cstmt.setInt(1, id);
            ResultSet res = cstmt.executeQuery();
            System.out.println("Factura eliminada: " + res);

            return true;
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
            // Manejar excepciones apropiadamente
        }

        return false;
    }
}
