package Controlador;

import Modelo.DAO.ChoferDAO;
import Modelo.DTO.Chofer;
import Vista.Chofer.ChoferForm;
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
public class ChoferController {
    ChoferForm clt;

    public ChoferController(ChoferForm cform) {
        this.clt = cform;
    }

    public ChoferForm getCform() {
        return clt;
    }

    public void setCform(ChoferForm clt) {
        this.clt = clt;
    }
    
    public ChoferController() {
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
        
        clt.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {                             
                Chofer obj = getAllValueRow();
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
        ChoferDAO choDAO = new ChoferDAO();
        //traer cliente de form
        Chofer cho = new Chofer();
        cho.setCi(clt.txtCi.getText());
        cho.setNombre(clt.txtNombre.getText());
        cho.setApellido(clt.txtApellido.getText());
        cho.setCelular(clt.txtCelu.getText());        
        cho.setFecha(clt.txtEdad.getText());
        cho.setCorreo(clt.txtCorreo.getText());
        cho.setDireccion(clt.txtDir.getText());
        cho.setDisponibilidad(clt.cbDisp.getSelectedItem().toString());
        cho.setContrasenia(clt.txtContra.getText());        
        
        boolean res = choDAO.crearChofer(cho);
        if(res){
            JOptionPane.showMessageDialog(null, "Vechiculo guardado!!");
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo guardar!!");
        }
        
    }
    
    //limpiar inputs
    private void limpiarTodo(){
        clt.txtCi.setText("");
        clt.txtNombre.setText("");
        clt.txtApellido.setText("");
        clt.txtCelu.setText("");
        clt.txtEdad.setText("");
        clt.txtCorreo.setText("");
        clt.txtDir.setText("");
        clt.cbDisp.setSelectedIndex(0);
        clt.txtContra.setText("");
    }
    
    //llenar todo
    private void llenarCampos(Chofer cho){
        clt.txtCi.setText(cho.getCi());
        clt.txtNombre.setText(cho.getNombre());
        clt.txtApellido.setText(cho.getApellido());
        clt.txtCelu.setText(cho.getCelular());
        clt.txtEdad.setText(cho.getFecha());
        clt.txtCorreo.setText(cho.getCorreo());
        clt.txtDir.setText(cho.getDireccion());
        clt.cbDisp.setSelectedItem(cho.getDisponibilidad());
        clt.txtContra.setText(cho.getContrasenia());
    }
    
    //devuelve row seleccionado
    private int getRowSelected(){
        clt.txtCi.setEditable(false);
        int selectedRow = clt.table.getSelectedRow();
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
            Object value = clt.table.getValueAt(rowselected, 0);

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
    private Chofer getAllValueRow(){
        int rowSelected = getRowSelected();
        Chofer cho = new Chofer();
        
        if(rowSelected > -1){
            Object ci = clt.table.getValueAt(rowSelected, 0);
            Object nombre = clt.table.getValueAt(rowSelected, 1);
            Object apell = clt.table.getValueAt(rowSelected, 2);
            Object cel = clt.table.getValueAt(rowSelected, 3);
            Object edad = clt.table.getValueAt(rowSelected, 4);
            Object corr = clt.table.getValueAt(rowSelected, 5);
            Object dir = clt.table.getValueAt(rowSelected, 6);
            Object dispon = clt.table.getValueAt(rowSelected, 7);
            Object contra = clt.table.getValueAt(rowSelected, 8);
            
            cho.setCi(ci.toString());
            cho.setNombre(nombre.toString());
            cho.setApellido(apell.toString());
            cho.setCelular(cel.toString());
            cho.setFecha(edad.toString());
            cho.setCorreo(corr.toString());
            cho.setDireccion(dir.toString());
            cho.setDisponibilidad(dispon.toString());
            cho.setContrasenia(contra.toString());           
            
            return cho;
        }
        return null;
    }
    
    //eliminar empleado
    private void eliminar(String ci) throws SQLException{
        
        boolean elim = new ChoferDAO().eliminarChofer(ci);
        if(elim){
            cargar();
            JOptionPane.showMessageDialog(null, "Cliente eliminado Correctamente...");
        }else{
            JOptionPane.showMessageDialog(null, "Error al eliminar");
        }
    }
    
    //modificar empleado
    private void editar() throws SQLException{
        Chofer cho = new Chofer();
        cho.setCi(clt.txtCi.getText());
        cho.setNombre(clt.txtNombre.getText());
        cho.setApellido(clt.txtApellido.getText());
        cho.setCelular(clt.txtCelu.getText());        
        cho.setFecha(clt.txtEdad.getText());
        cho.setCorreo(clt.txtCorreo.getText());
        cho.setDireccion(clt.txtDir.getText());
        cho.setDisponibilidad(clt.cbDisp.getSelectedItem().toString());
        cho.setContrasenia(clt.txtContra.getText());        
        
        ChoferDAO chodao = new ChoferDAO();
        boolean res = chodao.editarChofer(cho);
        if(res){
            JOptionPane.showMessageDialog(null, "Vehiculo editado!!");
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo guardar!!");
        }
    }
    
    //cargar empleado(os)
    private void cargar() throws SQLException{
        List<Chofer> data = new ChoferDAO().getChofer();
        String[] cols = {"CEDULA","NOMBRE","APELLIDO","CELULAR","FECHA","CORREO","DIRECCION","DISPONIBILIDAD"};
        
        DefaultTableModel model = new DefaultTableModel(cols,0);
        if(data!=null){
            for (Chofer cola : data) {
            Object[] dt = {cola.getCi(),cola.getNombre(),cola.getApellido(),cola.getCelular(),
                cola.getFecha(),cola.getCorreo(),cola.getDireccion(),cola.getDisponibilidad()};
            
            model.addRow(dt);
            }        
        }else{
            System.out.println("No hay nada en chofer...");
        }
        clt.table.setModel(model);
    }
}
