/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DAO.ClienteDAO;
import Modelo.DAO.EnvioDAO;
import Modelo.DTO.Cliente;
import Modelo.DTO.Envio;
import Vista.Cliente.ClienteForm;
import Vista.Envio.EnvioForm;
import Vista.Envio.PedidoForm;
import Vista.Secretaria.SecretariaForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LEKIAM
 */
public class EnvioController {
    EnvioForm clt;
    //regresar al home
    
    public void EnvioController(EnvioForm cform) throws SQLException{
        this.clt = cform;
        
        clt.btnRegresarAlMenu.addActionListener(new ActionListener() {
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

    public EnvioForm getCform() {
        return clt;
    }

    public void setCform(EnvioForm clt) {
        this.clt = clt;
    }
    
    public EnvioController() {
    }    
    
    private String state;

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
        
        clt.tbEnvio.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {                             
                Envio obj = getAllValueRow();
                llenarCampos(obj);
                System.out.println("Clickeqdoadasd");             
            }
        });
        
        clt.btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    crearEnvio();
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
                    clt.txtId.setEditable(true);
                } catch (SQLException ex) {
                    System.out.println("No se pudo editar..");
                }
            }
        });
        
        /*clt.txtBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    buscarCliente(clt.txtBuscar.getText());
                } catch (SQLException ex) {
                    System.out.println("Error al buscar cliente");
                }
            }
        });*/

        clt.btnAbrirPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Envio cosoEnv = getAllValueRow();
                    System.out.println(cosoEnv.getId());                     
                    PedidoForm pedidoForm = new PedidoForm(cosoEnv);                    
                    pedidoForm.setVisible(true);
                    
                    clt.setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(EnvioController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }); 
        
        clt.txtBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    buscarEnvio(clt.txtBuscar.getText());
                } catch (SQLException ex) {
                    System.out.println("Error al buscar el envio");
                }
            }
        });
        
        cargar();
        limpiarTodo();
    }
    
    //guardae cliente
    private void crearEnvio() throws SQLException{
        //usar crear de DAO
        EnvioDAO envdao = new EnvioDAO();
        //traer cliente de form
        Envio env = new Envio();
        env.setFecha(LocalDate.now().toString());
        env.setRucCliente(clt.txtRuc.getText());        
        env.setDetalles(clt.txtDetalles.getText());
        env.setPeso(clt.txtPeso.getText());
        env.setEnvioInterprov(clt.checkInter.isSelected()?"Si":"No");
        env.setDireccion(clt.txtDir.getText());
        env.setCiDestinatario(clt.txtCIdest.getText());        
        env.setTelefono(clt.txtTel.getText());    
        
        boolean res = envdao.crearEnvio(env);
        if(res){
            JOptionPane.showMessageDialog(null, "Cliente guardado!!");
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo guardar!!");
        }
        
    }
    
    
    //limpiar inputs
    private void limpiarTodo(){
        clt.txtId.setText("");
        clt.txtRuc.setText("");
        clt.txtTel.setText("");
        clt.txtPeso.setText("");
        clt.txtDetalles.setText("");
        clt.txtDir.setText("");
    }
    
    //llenar todo
    private void llenarCampos(Envio ro){
        clt.txtId.setText(ro.getId());
        clt.txtRuc.setText(ro.getRucCliente());
        clt.txtTel.setText(ro.getTelefono());
        clt.txtDir.setText(ro.getDireccion());
        clt.txtDetalles.setText(ro.getDetalles());
        clt.txtPeso.setText(ro.getPeso());
        clt.txtCIdest.setText(ro.getCiDestinatario());
        String interprov = ro.getEnvioInterprov();

        if ("Si".equals(interprov)) {
            clt.checkInter.setSelected(true);
        } else if ("No".equals(interprov)) {
            clt.checkInter.setSelected(false);
        }
    }
    
    //devuelve row seleccionado
    private int getRowSelected(){
        //la tabla se llama
        //clt.tablaCliente
        clt.txtId.setEditable(false);
        int selectedRow = clt.tbEnvio.getSelectedRow();
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
            Object value = clt.tbEnvio.getValueAt(rowselected, 0);

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
    private Envio getAllValueRow(){
        int rowSelected = getRowSelected();
        Envio cli = new Envio();
        
        if(rowSelected > -1){
            Object id = clt.tbEnvio.getValueAt(rowSelected,0);
            Object fecha = clt.tbEnvio.getValueAt(rowSelected, 1);
            Object ruc = clt.tbEnvio.getValueAt(rowSelected, 2);
            Object detalles = clt.tbEnvio.getValueAt(rowSelected, 3);
            Object peso = clt.tbEnvio.getValueAt(rowSelected, 4);
            Object costo = clt.tbEnvio.getValueAt(rowSelected, 6);
            Object dir = clt.tbEnvio.getValueAt(rowSelected, 7);
            Object cidest = clt.tbEnvio.getValueAt(rowSelected, 8);
            Object telf = clt.tbEnvio.getValueAt(rowSelected, 9);
            Object stst = clt.tbEnvio.getValueAt(rowSelected, 10);
            Object inter = clt.tbEnvio.getValueAt(rowSelected, 5);
            Object cichofer = clt.tbEnvio.getValueAt(rowSelected, 12);
            
            cli.setId(id.toString());
            cli.setFecha(fecha.toString());
            cli.setRucCliente(ruc.toString());
            cli.setPeso(peso.toString());
            cli.setDetalles(detalles.toString());
            cli.setCosto(costo.toString());
            state = stst.toString();
            cli.setEstado(state);
            cli.setCiDestinatario(cidest.toString());
            cli.setTelefono(telf.toString());
            if(cichofer != null){
                cli.setCiChofer(cichofer.toString());
            }
            //cli.setCorreo(corr.toString());
            cli.setDireccion(dir.toString());
            cli.setEnvioInterprov(inter.toString());
            System.out.println("Inter string: "+inter.toString());
            
            return cli;
        }
        return null;
    }
    
    //eliminar empleado
    private void eliminar(String ruc) throws SQLException{
        
        boolean elim = new EnvioDAO().eliminarEnvio(ruc);
        if(elim){
            cargar();
            JOptionPane.showMessageDialog(null, "Cliente eliminado Correctamente...");
        }else{
            JOptionPane.showMessageDialog(null, "Error al eliminar");
        }
    }
    
    //modificar empleado
    private void editar() throws SQLException{
        
//        cstmt.setString(1, env.getId());
//            cstmt.setString(2, env.getDetalles());
//            cstmt.setString(3, env.getPeso());
//            cstmt.setString(4, env.getEnvioInterprov());
//            cstmt.setString(5, env.getDireccion());
//            cstmt.setString(6, env.getTelefono());
//            cstmt.setString(7, env.getEstado());
        
        Envio env = new Envio();
        env.setId(clt.txtId.getText());
        env.setDetalles(clt.txtDetalles.getText());
        env.setPeso(clt.txtPeso.getText());
        env.setEnvioInterprov(clt.checkInter.isSelected()?"Si":"No");        
        env.setDireccion(clt.txtDir.getText());
        env.setTelefono(clt.txtTel.getText());
        env.setEstado(state);
        EnvioDAO cltdao = new EnvioDAO();
        boolean res = cltdao.editarEnvio(env);
        if(res){
            JOptionPane.showMessageDialog(null, "Cliente editado!!");
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo guardar!!");
        }
    }
    
    //cargar empleado(os)
    private void cargar() throws SQLException{
        List<Envio> data = new EnvioDAO().getEnvios();
        String[] cols = {"ID","FECHA","RUC CLIENTE","DETALLES","PESO","ENVIO INTERPROVINCIAL",
        "COSTO","DIRECCION DESTINATARIO","CI DESTINATARIO", "TELEFONO DESTINATARIO","ESTADO","FECHA FINALIZACION","CI CHOFER"};
        
        DefaultTableModel model = new DefaultTableModel(cols,0);
        for (Envio cola : data) {
            Object[] dt = {cola.getId(),cola.getFecha(),cola.getRucCliente(),cola.getDetalles(),
                cola.getPeso(),cola.getEnvioInterprov(),cola.getCosto(),cola.getDireccion(),
                cola.getCiDestinatario(),cola.getTelefono(),cola.getEstado(),cola.getFechaEntrega(),cola.getCiChofer()};
            
            model.addRow(dt);
        }
        clt.tbEnvio.setModel(model);
    }
    /*
    // Método para buscar un cliente por su nombre o RUC
    private void buscarCliente(String searchTerm) throws SQLException {
        List<Cliente> resultados = new ArrayList<>();
        List<Cliente> data = new ClienteDAO().getClientes();

        for (Cliente cliente : data) {
            if (cliente.getNombre().toLowerCase().contains(searchTerm.toLowerCase())
                    || cliente.getRuc().toLowerCase().contains(searchTerm.toLowerCase())) {
                resultados.add(cliente);
            }
        }
        if (resultados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encontraron clientes con la búsqueda proporcionada.");
        } else {
            mostrarResultados(resultados);
            JOptionPane.showMessageDialog(null, "Clientes encontrados:"+ resultados.size());
        }

        mostrarResultados(resultados);
    }

    // Método para mostrar los resultados de la búsqueda en la tabla
    private void mostrarResultados(List<Cliente> resultados) {
        String[] cols = {"RUC", "NOMBRE", "TELEFONO", "CORREO", "DIRECCION"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);

        for (Cliente cliente : resultados) {
            Object[] dt = {cliente.getRuc(), cliente.getNombre(), cliente.getTelefono(),
                    cliente.getCorreo(), cliente.getDireccion()};
            model.addRow(dt);
            //JOptionPane.showMessageDialog(null, "Clientes encontrados: " + resultados.size());
        }

        clt.tbEnvio.setModel(model);
    }*/
    private void buscarEnvio(String searchTerm) throws SQLException {
        List<Envio> resultados = new ArrayList<>();
        List<Envio> data = new EnvioDAO().getEnvios();

        for (Envio envio : data) {
            if (envio.getEstado().toLowerCase().contains(searchTerm.toLowerCase())
                    ) {
                resultados.add(envio);
            }
        }
        if (resultados.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encontraron envios con la búsqueda proporcionada.");
        } else {
            mostrarResultados(resultados);
            JOptionPane.showMessageDialog(null, "envios encontrados:"+ resultados.size());
        }

        //mostrarResultados(resultados);
    }

    // Método para mostrar los resultados de la búsqueda en la tabla
    private void mostrarResultados(List<Envio> resultados) {
        String[] cols = {"ID","FECHA","RUC CLIENTE","DETALLES","PESO","ENVIO INTERPROVINCIAL",
        "COSTO","DIRECCION DESTINATARIO","CI DESTINATARIO", "TELEFONO DESTINATARIO","ESTADO","FECHA FINALIZACION","CI CHOFER"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);
        for (Envio envio : resultados) {
            Object[] dt = {envio.getId(), envio.getFecha(), envio.getRucCliente(),
                    envio.getDetalles(), envio.getPeso(), envio.getEnvioInterprov(), envio.getCosto(),envio.getDireccion(),
            envio.getCiDestinatario(),envio.getTelefono(),envio.getEstado(),envio.getFechaEntrega(),envio.getCiChofer()};
            model.addRow(dt);
            //JOptionPane.showMessageDialog(null, "Clientes encontrados: " + resultados.size());
        }

        clt.tbEnvio.setModel(model);
    }
}
