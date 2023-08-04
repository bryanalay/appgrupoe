/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DAO.VehiculoDAO;
import Modelo.DTO.Vehiculo;
import Vista.Vehiculo.VehiculoForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Almi-
 */
public class VehiculoController {
    VehiculoForm clt;

    public VehiculoController(VehiculoForm cform) {
        this.clt = cform;
    }

    public VehiculoForm getCform() {
        return clt;
    }

    public void setCform(VehiculoForm clt) {
        this.clt = clt;
    }
    
    public VehiculoController() {
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
                    System.out.println("No se realizo el delete por..."+ex);
                }
            }
        });
        
        clt.tableVeh.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {                             
                Vehiculo obj = getAllValueRow();
                llenarCampos(obj);
                System.out.println("Clickeqdoadasd");             
            }
        });
        
        clt.btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    crearVehiculo();
                    cargar();
                    limpiarTodo();
                    System.out.println("Guardando Vehiculo...");
                } catch (SQLException ex) {
                    System.out.println("Ocurrio algo pa!!");
                }
                
            }
        });
        
        clt.btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    editar();
                    cargar();
                    limpiarTodo();
                    //clt.txtRuc.setEditable(true);
                } catch (SQLException ex) {
                    System.out.println("No se pudo editar..");
                }
            }
        });
        
        cargar();
        limpiarTodo();
    }
    
    //guardae cliente
    private void crearVehiculo() throws SQLException{
        //usar crear de DAO
        VehiculoDAO vehDao = new VehiculoDAO();
        //traer cliente de form
        Vehiculo veh = new Vehiculo();
        veh.setMatricula(clt.txtMat.getText());
        veh.setMarca(clt.txtMarca.getText());
        veh.setAnio(clt.txtAnio.getText());
        veh.setTipo(clt.cbTipo.getSelectedItem().toString());
        veh.setDispon(clt.cbDisp.getSelectedItem().toString());
        
        boolean res = vehDao.crearVehiculo(veh);
        if(res){
            JOptionPane.showMessageDialog(null, "Vechiculo guardado!!");
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo guardar!!");
        }
        
    }
    
    //limpiar inputs
    private void limpiarTodo(){
        clt.txtMat.setText("");
        clt.txtMarca.setText("");
        clt.txtAnio.setText("");
        clt.cbTipo.setSelectedIndex(0);
        clt.cbDisp.setSelectedIndex(0);
    }
    
    //llenar todo
    private void llenarCampos(Vehiculo veh){
        clt.txtMat.setText(veh.getMatricula());
        clt.txtMarca.setText(veh.getMarca());
        clt.txtAnio.setText(veh.getAnio());
        clt.cbTipo.setSelectedItem(veh.getTipo());
        clt.cbDisp.setSelectedItem(veh.getDispon());
    }
    
    //devuelve row seleccionado
    private int getRowSelected(){
        clt.txtMat.setEditable(false);
        int selectedRow = clt.tableVeh.getSelectedRow();
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
            Object value = clt.tableVeh.getValueAt(rowselected, 0);

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
    private Vehiculo getAllValueRow(){
        int rowSelected = getRowSelected();
        Vehiculo veh = new Vehiculo();
        
        if(rowSelected > -1){
            Object ruc = clt.tableVeh.getValueAt(rowSelected, 0);
            Object nombre = clt.tableVeh.getValueAt(rowSelected, 1);
            Object tel = clt.tableVeh.getValueAt(rowSelected, 2);
            Object corr = clt.tableVeh.getValueAt(rowSelected, 3);
            Object dir = clt.tableVeh.getValueAt(rowSelected, 4);
            
            veh.setMatricula(ruc.toString());
            veh.setMarca(nombre.toString());
            veh.setAnio(tel.toString());
            veh.setTipo(corr.toString());
            veh.setDispon(dir.toString());
            
            return veh;
        }
        return null;
    }
    
    //eliminar empleado
    private void eliminar(String matric) throws SQLException{
        
        boolean elim = new VehiculoDAO().eliminarVehiculo(matric);
        if(elim){
            cargar();
            JOptionPane.showMessageDialog(null, "Cliente eliminado Correctamente...");
        }else{
            JOptionPane.showMessageDialog(null, "Error al eliminar");
        }
    }
    
    //modificar empleado
    private void editar() throws SQLException{
        Vehiculo veh = new Vehiculo();
        veh.setMatricula(clt.txtMat.getText());
        veh.setMarca(clt.txtMarca.getText());
        veh.setAnio(clt.txtAnio.getText());
        veh.setTipo(clt.cbTipo.getSelectedItem().toString());
        veh.setDispon(clt.cbDisp.getSelectedItem().toString());
        VehiculoDAO cltdao = new VehiculoDAO();
        boolean res = cltdao.editarCliente(veh);
        if(res){
            JOptionPane.showMessageDialog(null, "Vehiculo editado!!");
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo guardar!!");
        }
    }
    
    //cargar empleado(os)
    private void cargar() throws SQLException{
        List<Vehiculo> data = new VehiculoDAO().getVehiculoByRuc("");
        String[] cols = {"MATRICULA","MARCA","AÑO","TIPO","DISPONIBILIDAD"};
        
        DefaultTableModel model = new DefaultTableModel(cols,0);
        for (Vehiculo cola : data) {
            Object[] dt = {cola.getMatricula(),cola.getMarca(),cola.getAnio(),cola.getTipo(),cola.getDispon()};
            
            model.addRow(dt);
        }
        clt.tableVeh.setModel(model);
    }
}
