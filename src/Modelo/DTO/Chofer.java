/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DTO;

/**
 *
 * @author Almi-
 */
public class Chofer extends Empleado{
    
    String disponibilidad;

    public Chofer(String disponibilidad, String ci, String nombre, String apellido, String celular, String fecha, String correo, String direccion, String contrasenia) {
        super(ci, nombre, apellido, celular, fecha, correo, direccion, contrasenia);
        this.disponibilidad = disponibilidad;
    }

    public Chofer(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Chofer() {
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    
    
}
