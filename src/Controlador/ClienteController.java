/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DAO.ClienteDAO;
import Modelo.DTO.Cliente;
import Vista.Cliente.ClienteForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Almi-
 */
public class ClienteController {
    
    ClienteForm clt;

    public ClienteController(ClienteForm cform) {
        this.clt = cform;
    }

    public ClienteForm getCform() {
        return clt;
    }

    public void setCform(ClienteForm clt) {
        this.clt = clt;
    }
    
    public ClienteController() {
    }    

    public void Load() throws SQLException {
         
        //agregara eventos
        clt.btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarTodo();
            }
        });
        
        clt.btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    eliminar(getValueRow());
                    limpiarTodo();
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        clt.tablaCliente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {                             
                Cliente obj = getAllValueRow();
                llenarCampos(obj);
                System.out.println("Clickeqdoadasd");             
            }
        });
        
        clt.btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    crearCliente();
                    cargar();
                    limpiarTodo();
                    System.out.println("Guardando cliente...");
                } catch (SQLException ex) {
                    System.out.println("Ocurrio algo pa!!");
                }
                
            }
        });
        
        clt.btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    editar();
                    cargar();
                    limpiarTodo();
                    clt.txtRuc.setEditable(true);
                } catch (SQLException ex) {
                    System.out.println("No se pudo editar..");
                }
            }
        });
        
        cargar();
        limpiarTodo();
    }
    
    //guardae cliente
    private void crearCliente() throws SQLException{
        //usar crear de DAO
        ClienteDAO cltdao = new ClienteDAO();
        //traer cliente de form
        Cliente cliente = new Cliente();
        cliente.setRuc(clt.txtRuc.getText());
        cliente.setNombre(clt.txtNombre.getText());
        cliente.setTelefono(clt.txtTel.getText());
        cliente.setCorreo(clt.txtCorreo.getText());
        cliente.setDireccion(clt.txtDir.getText());
        
        boolean res = cltdao.crearCliente(cliente);
        if(res){
            JOptionPane.showMessageDialog(null, "Cliente guardado!!");
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo guardar!!");
        }
        
    }
    
    
    //limpiar inputs
    private void limpiarTodo(){
        clt.txtRuc.setText("");
        clt.txtNombre.setText("");
        clt.txtTel.setText("");
        clt.txtCorreo.setText("");
        clt.txtDir.setText("");
    }
    
    //llenar todo
    private void llenarCampos(Cliente ro){
        clt.txtRuc.setText(ro.getRuc());
        clt.txtNombre.setText(ro.getNombre());
        clt.txtTel.setText(ro.getTelefono());
        clt.txtCorreo.setText(ro.getCorreo());
        clt.txtDir.setText(ro.getDireccion());
    }
    
    //devuelve row seleccionado
    private int getRowSelected(){
        //la tabla se llama
        //clt.tablaCliente
        clt.txtRuc.setEditable(false);
        int selectedRow = clt.tablaCliente.getSelectedRow();
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
            Object value = clt.tablaCliente.getValueAt(rowselected, 0);

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
    private Cliente getAllValueRow(){
        int rowSelected = getRowSelected();
        Cliente cli = new Cliente();
        
        if(rowSelected > -1){
            Object ruc = clt.tablaCliente.getValueAt(rowSelected, 0);
            Object nombre = clt.tablaCliente.getValueAt(rowSelected, 1);
            Object tel = clt.tablaCliente.getValueAt(rowSelected, 2);
            Object corr = clt.tablaCliente.getValueAt(rowSelected, 3);
            Object dir = clt.tablaCliente.getValueAt(rowSelected, 4);
            
            cli.setRuc(ruc.toString());
            cli.setNombre(nombre.toString());
            cli.setTelefono(tel.toString());
            cli.setCorreo(corr.toString());
            cli.setDireccion(dir.toString());
            
            return cli;
        }
        return null;
    }
    
    //eliminar empleado
    private void eliminar(String ruc) throws SQLException{
        
        boolean elim = new ClienteDAO().eliminarCliente(ruc);
        if(elim){
            cargar();
            JOptionPane.showMessageDialog(null, "Cliente eliminado Correctamente...");
        }else{
            JOptionPane.showMessageDialog(null, "Error al eliminar");
        }
    }
    
    //modificar empleado
    private void editar() throws SQLException{
        Cliente cliente = new Cliente();
        cliente.setRuc(clt.txtRuc.getText());
        cliente.setNombre(clt.txtNombre.getText());
        cliente.setTelefono(clt.txtTel.getText());
        cliente.setCorreo(clt.txtCorreo.getText());
        cliente.setDireccion(clt.txtDir.getText());
        ClienteDAO cltdao = new ClienteDAO();
        boolean res = cltdao.editarCliente(cliente);
        if(res){
            JOptionPane.showMessageDialog(null, "Cliente editado!!");
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo guardar!!");
        }
    }
    
    //cargar empleado(os)
    private void cargar() throws SQLException{
        List<Cliente> data = new ClienteDAO().getClientes();
        String[] cols = {"RUC","NOMBRE","TELEFONO","CORREO","DIRECCION"};
        
        DefaultTableModel model = new DefaultTableModel(cols,0);
        for (Cliente cola : data) {
            Object[] dt = {cola.getRuc(),cola.getNombre(),cola.getTelefono(),cola.getCorreo(),cola.getDireccion()};
            
            model.addRow(dt);
        }
        clt.tablaCliente.setModel(model);
    }
}
