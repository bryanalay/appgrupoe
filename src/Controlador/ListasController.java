/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.DAO.FacturaDAO;
import Modelo.DTO.Factura;
import Vista.Listas.ListasForm;
import Vista.ListadoFacturas.ListadoForm;
import Vista.Secretaria.SecretariaForm;
import Vista.Usuario.UsuarioForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ERICK
 */
public class ListasController {
    ListadoForm listas;
    public void ListasController(ListadoForm cform) throws SQLException{
        this.listas = cform;
            
            cform.btnRegresarAlMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SecretariaForm sec = null;
                try {
                    sec = new SecretariaForm();
                } catch (SQLException ex) {
                    Logger.getLogger(SecretariaController.class.getName()).log(Level.SEVERE, null, ex);
                }
                sec.setVisible(true);
                cform.setVisible(false);
               
            }
        });
    }
     public void Load() throws SQLException{
        listas.btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    eliminar(Integer.parseInt(getValueRow()));
                    cargar();
                } catch (SQLException ex) {
                    Logger.getLogger(ListasController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
         
        cargar();
         
    }
    
    private void eliminar(int id) throws SQLException{
        
        boolean elim = new FacturaDAO().eliminarFactura(id);
        if(elim){
            cargar();
            JOptionPane.showMessageDialog(null, "Factura eliminada correctamente...");
        }else{
            JOptionPane.showMessageDialog(null, "Error al eliminar factura");
        }
    }
     
    public void cargar() throws SQLException{
        List<Factura> data = new FacturaDAO().getFacturas();
        String[] cols = {"ID","ID ENVIO","RUC CLIENTE","CI DESTINO","DIRECCION","DETALLES",
        "TOTAL"};
        
        DefaultTableModel model = new DefaultTableModel(cols,0);
        for (Factura cola : data) {
            Object[] dt = {cola.getId(),cola.getIdEnvio(),cola.getRuc(),cola.getCiDestino(),
                cola.getDireccion(),cola.getDetalles(),cola.getTotal()};
            
            model.addRow(dt);
        }
        listas.tbLista.setModel(model);
    }
    
    //devuelve row seleccionado
    private int getRowSelected(){
        //la tabla se llama
        //clt.tablaCliente
        //listas.txtId.setEditable(false);
        int selectedRow = listas.tbLista.getSelectedRow();
        if (selectedRow >-1) {
            //si hay fila seleccionada
            return selectedRow;
        }
        return -1;
    }
    
    //get value of row
    private String getValueRow(){
        int rowselected = getRowSelected();
        if(rowselected == -1){
            JOptionPane.showMessageDialog(null, "No ha seleeccioonado nada..");
        }else{
            Object value = listas.tbLista.getValueAt(rowselected, 0);

            if (value == null) {
                return null;
            } else {
                System.out.println(value.toString());
                return value.toString();
            } 
        }
        return null;
    }
    
    //get All values de row
    private Factura getAllValueRow(){
        int rowSelected = getRowSelected();
        Factura fac = new Factura();
        
        if(rowSelected > -1){
            Object id = listas.tbLista.getValueAt(rowSelected,0);
            Object idEnvio = listas.tbLista.getValueAt(rowSelected, 1);
            Object ruc = listas.tbLista.getValueAt(rowSelected, 2);
            Object ciDestino = listas.tbLista.getValueAt(rowSelected, 3);
            Object direccion = listas.tbLista.getValueAt(rowSelected, 4);
            Object detalles = listas.tbLista.getValueAt(rowSelected, 5);
            Object total = listas.tbLista.getValueAt(rowSelected, 6);
            
            
            fac.setId(Integer.parseInt(id.toString()));
            fac.setIdEnvio(Integer.parseInt(idEnvio.toString()));
            fac.setRuc(ruc.toString());
            fac.setCiDestino(ciDestino.toString());
            fac.setDireccion(direccion.toString());
            fac.setDetalles(detalles.toString());
            fac.setTotal(total.toString());
            
            return fac;
        }
        return null;
    }
}
