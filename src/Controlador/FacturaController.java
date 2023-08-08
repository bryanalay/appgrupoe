/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DAO.FacturaDAO;
import Modelo.DTO.Factura;
import Vista.Factura.FacturaForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 *
 * @author LEKIAM
 */
public class FacturaController {
    FacturaForm factura;
    public void FacturaController(FacturaForm cform) throws SQLException{
        this.factura = cform;
                
    }
    
    public void Load() throws SQLException {
    factura.btnEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Factura guardada...");
                creaFactura();
            }
        });
    }
    
    private void creaFactura(){
        FacturaDAO fdao= new FacturaDAO();
        Factura fct=new Factura();
        fct.setIdEnvio(Integer.parseInt(factura.env.getId()));
        fct.setRuc(factura.env.getRucCliente());
        fct.setCiDestino(factura.env.getCiDestinatario());
        fct.setDireccion(factura.env.getDireccion());
        fct.setDetalles(factura.env.getDetalles());
        fct.setTotal(factura.env.getCosto());
        boolean res = fdao.crearFactura(fct);
        if(res){
            System.out.println("FACTURA CREADA");
        }else{
        System.out.println("NO SE PUDO CREAR FACTURA");
        }
    }

}
