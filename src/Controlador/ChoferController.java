package Controlador;

import Modelo.DAO.ChoferDAO;
import Modelo.DTO.Chofer;
import Vista.Chofer.ChoferForm;
import Vista.Secretaria.SecretariaForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Almi-
 */
public class ChoferController {
    ChoferForm chofer;

        public void ChoferController(ChoferForm cform) throws SQLException{
        this.chofer = cform;
            
            cform.btnRegresarMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SecretariaForm sec = null;
                try {
                    sec = new SecretariaForm();
                } catch (SQLException ex) {
                    Logger.getLogger(ChoferController.class.getName()).log(Level.SEVERE, null, ex);
                }
                sec.setVisible(true);
                cform.setVisible(false);
                

            }
        });
            cform.txtBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    buscarChofer(chofer.txtBuscar.getText());
                } catch (SQLException ex) {
                    System.out.println("Error al buscar chofer");
                }
            }
        });
    }

    public ChoferForm getCform() {
        return chofer;
    }

    public void setCform(ChoferForm clt) {
        this.chofer = clt;
    }
    
    public ChoferController() {
    }    

    public void Load() throws SQLException {
         
        //agregara eventos
        chofer.btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarTodo();
            }
        });
        
        chofer.btnEliminar.addActionListener(new ActionListener() {
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
        
        chofer.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {                             
                Chofer obj = getAllValueRow();
                llenarCampos(obj);
                System.out.println("Clickeqdoadasd");             
            }
        });
        
        chofer.btnGuardar.addActionListener(new ActionListener() {
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
        
        chofer.btnEditar.addActionListener(new ActionListener() {
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
        cho.setCi(chofer.txtCi.getText());
        cho.setNombre(chofer.txtNombre.getText());
        cho.setApellido(chofer.txtApellido.getText());
        cho.setCelular(chofer.txtCelu.getText());        
        cho.setFecha(chofer.txtEdad.getText());
        cho.setCorreo(chofer.txtCorreo.getText());
        cho.setDireccion(chofer.txtDir.getText());
        cho.setDisponibilidad(chofer.cbDisp.getSelectedItem().toString());
        cho.setContrasenia(chofer.txtContra.getText());        
        
        boolean res = choDAO.crearChofer(cho);
        if(res){
            JOptionPane.showMessageDialog(null, "Chofer guardado!!");
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo guardar!!");
        }
        
    }
    
    //limpiar inputs
    private void limpiarTodo(){
        chofer.txtCi.setText("");
        chofer.txtNombre.setText("");
        chofer.txtApellido.setText("");
        chofer.txtCelu.setText("");
        chofer.txtEdad.setText("");
        chofer.txtCorreo.setText("");
        chofer.txtDir.setText("");
        chofer.cbDisp.setSelectedIndex(0);
        chofer.txtContra.setText("");
    }
    
    //llenar todo
    private void llenarCampos(Chofer cho){
        chofer.txtCi.setText(cho.getCi());
        chofer.txtNombre.setText(cho.getNombre());
        chofer.txtApellido.setText(cho.getApellido());
        chofer.txtCelu.setText(cho.getCelular());
        chofer.txtEdad.setText(cho.getFecha());
        chofer.txtCorreo.setText(cho.getCorreo());
        chofer.txtDir.setText(cho.getDireccion());
        chofer.cbDisp.setSelectedItem(cho.getDisponibilidad());
        chofer.txtContra.setText(cho.getContrasenia());
    }
    
    //devuelve row seleccionado
    private int getRowSelected(){
        chofer.txtCi.setEditable(false);
        int selectedRow = chofer.table.getSelectedRow();
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
            Object value = chofer.table.getValueAt(rowselected, 0);

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
            Object ci = chofer.table.getValueAt(rowSelected, 0);
            Object nombre = chofer.table.getValueAt(rowSelected, 1);
            Object apell = chofer.table.getValueAt(rowSelected, 2);
            Object cel = chofer.table.getValueAt(rowSelected, 3);
            Object edad = chofer.table.getValueAt(rowSelected, 4);
            Object corr = chofer.table.getValueAt(rowSelected, 5);
            Object dir = chofer.table.getValueAt(rowSelected, 6);
            Object dispon = chofer.table.getValueAt(rowSelected, 7);
            
            
            cho.setCi(ci.toString());
            cho.setNombre(nombre.toString());
            cho.setApellido(apell.toString());
            cho.setCelular(cel.toString());
            cho.setFecha(edad.toString());
            cho.setCorreo(corr.toString());
            cho.setDireccion(dir.toString());
            cho.setDisponibilidad(dispon.toString());
                     
            
            return cho;
        }
        return null;
    }
    
    //eliminar empleado
    private void eliminar(String ci) throws SQLException{
        
        boolean elim = new ChoferDAO().eliminarChofer(ci);
        if(elim){
            cargar();
            JOptionPane.showMessageDialog(null, "Chofer eliminado Correctamente...");
        }else{
            JOptionPane.showMessageDialog(null, "Error al eliminar");
        }
    }
    
    //modificar empleado
    private void editar() throws SQLException{
        Chofer cho = new Chofer();
        cho.setCi(chofer.txtCi.getText());
        cho.setNombre(chofer.txtNombre.getText());
        cho.setApellido(chofer.txtApellido.getText());
        cho.setCelular(chofer.txtCelu.getText());        
        cho.setFecha(chofer.txtEdad.getText());
        cho.setCorreo(chofer.txtCorreo.getText());
        cho.setDireccion(chofer.txtDir.getText());
        cho.setDisponibilidad(chofer.cbDisp.getSelectedItem().toString());
        cho.setContrasenia(chofer.txtContra.getText());        
        
        ChoferDAO chodao = new ChoferDAO();
        boolean res = chodao.editarChofer(cho);
        if(res){
            JOptionPane.showMessageDialog(null, "Chofer Agregado!!");
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
            System.out.println("Correcto...");
        }
        chofer.table.setModel(model);
    }
    
    private void buscarChofer(String searchTerm) throws SQLException {
        List<Chofer> resultados = new ArrayList<>();
        List<Chofer> data = new ChoferDAO().getChofer();

        for (Chofer chofer : data) {
            if (chofer.getNombre().toLowerCase().contains(searchTerm.toLowerCase())
                    || chofer.getCi().toLowerCase().contains(searchTerm.toLowerCase())||
                chofer.getDisponibilidad().toLowerCase().contains(searchTerm.toLowerCase())) {
                resultados.add(chofer);
            }
        }

        if (resultados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encontraron choferes con la búsqueda proporcionada.");
        } else {
            mostrarResultados(resultados);
            JOptionPane.showMessageDialog(null, "Choferes encontrados:"+ resultados.size());
        }
    }
    private void mostrarResultados(List<Chofer> resultados) {
        String[] cols = {"CEDULA", "NOMBRE", "APELLIDO", "CELULAR", "FECHA", "CORREO", "DIRECCION", "DISPONIBILIDAD"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);

        for (Chofer chofer : resultados) {
            Object[] dt = {chofer.getCi(), chofer.getNombre(), chofer.getApellido(), chofer.getCelular(),
                    chofer.getFecha(), chofer.getCorreo(), chofer.getDireccion(), chofer.getDisponibilidad()};
            model.addRow(dt);
        }

        chofer.table.setModel(model);
    }
}
