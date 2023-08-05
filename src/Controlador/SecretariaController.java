package Controlador;

import Modelo.DAO.LoginDAO;
import Modelo.DTO.Empleado;
import Vista.Chofer.ChoferForm;
import Vista.Cliente.ClienteForm;
import Vista.Factura.FacturaForm;
import Vista.Login.LoginForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.Secretaria.SecretariaForm;
import Vista.Usuario.UsuarioForm;
import Vista.Vehiculo.VehiculoForm;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Almi-
 */
public class SecretariaController {
    public void menuController(SecretariaForm sec) throws SQLException{
        ChoferForm chofer = new ChoferForm();
        ClienteForm clt = new ClienteForm();
        VehiculoForm veh = new VehiculoForm();
        UsuarioForm user= new UsuarioForm();
        FacturaForm fac=new FacturaForm();
//        UsuarioForm UsuarioF = new UsuarioForm();
        sec.btnChofer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chofer.setVisible(true);
                sec.setVisible(false);
            }
        });
        
        sec.btnCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clt.setVisible(true);
                sec.setVisible(false);
            }
        });
        
        sec.btnVehiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                veh.setVisible(true);
                sec.setVisible(false);
            }
            
            
        });
            sec.btnUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                user.setVisible(true);
                sec.setVisible(false);
            }
            
            
        });
            sec.btnEnvio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                veh.setVisible(true);
                sec.setVisible(false);
            }
            
            
        });
            sec.btnListas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                veh.setVisible(true);
                sec.setVisible(false);
            }
            
            
        });
        
            sec.btnVehiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                veh.setVisible(true);
                sec.setVisible(false);
            }
            
       
        });
            
            sec.lblSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarSesion(sec);
            }
        });
    }
        private void cerrarSesion(SecretariaForm sec) {
            // Código para cerrar la sesión y mostrar el formulario de inicio de sesión (LoginForm)
            LoginForm loginForm = new LoginForm();
            loginForm.setVisible(true);
            sec.dispose(); // Cierra la ventana actual de SecretariaForm
        }
        
            private void btnUsuario(String ci,String contra,LoginForm vista) throws SQLException{
        LoginDAO ld = new LoginDAO();
        Empleado emp = ld.login(ci, contra);
        
        if(emp==null){            
            //JOptionPane.showMessageDialog(null, "CI o Contraseña incorrecta");            
        } else {
            //llamo secretaria form y le paso el empleado
            vista.setVisible(false);
            //System.out.println("Logueado..!!");
            abrirUsuario(emp.getCi(),emp.getNombre(), emp.getApellido(), emp.getCelular(), emp.getFecha(), emp.getCorreo(), emp.getDireccion());
        }
    }
    
    private void abrirUsuario(String ci,String nombre, String apellido, String celular, String fecha, String correo, String direccion) throws SQLException{
        UsuarioForm user = new UsuarioForm();
        user.lblNombre.setText(nombre);
        user.lblCi.setText(ci);
        user.lblCelular.setText(celular);
        user.lblApellido.setText(apellido);
        user.lblCorreo.setText(correo);
        user.lblFecha.setText(fecha);
        user.lblDireccion.setText(direccion);
        
        user.setVisible(true);
    }
}
