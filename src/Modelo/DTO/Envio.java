/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DTO;

/**
 *
 * @author Almi-
 */
public class Envio {
String id;
String fecha;
String rucCliente;
String detalles;
String peso;
String envioInterprov;
String costo;
String direccion;
String ciDestinatario;
String telefono;
String estado;
String fechaEntrega;
String ciChofer;

public Envio(){}

public Envio(String id, String fecha, String rucCliente, String detalles, String peso, String envioInterprov, String costo, String direccion, String ciDestinatario, String telefono, String estado, String fechaEntrega,String ciChofer) {
        this.id = id;
        this.fecha = fecha;
        this.rucCliente = rucCliente;
        this.detalles = detalles;
        this.peso = peso;
        this.envioInterprov = envioInterprov;
        this.costo = costo;
        this.direccion = direccion;
        this.ciDestinatario = ciDestinatario;
        this.telefono = telefono;
        this.estado = estado;
        this.fechaEntrega = fechaEntrega;
        this.ciChofer = ciChofer;
    }

    public String getCiChofer() {
        return ciChofer;
    }

    public void setCiChofer(String ciChofer) {
        this.ciChofer = ciChofer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getRucCliente() {
        return rucCliente;
    }

    public void setRucCliente(String rucCliente) {
        this.rucCliente = rucCliente;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getEnvioInterprov() {
        return envioInterprov;
    }

    public void setEnvioInterprov(String envioInterprov) {
        this.envioInterprov = envioInterprov;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiDestinatario() {
        return ciDestinatario;
    }

    public void setCiDestinatario(String ciDestinatario) {
        this.ciDestinatario = ciDestinatario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }   
}