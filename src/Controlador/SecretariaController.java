package Controlador;

import Modelo.DAO.LoginDAO;
import Modelo.DTO.Empleado;
import Vista.Chofer.ChoferForm;
import Vista.Cliente.ClienteForm;
import Vista.Envio.EnvioForm;
import Vista.Factura.FacturaForm;
import Vista.ListadoFacturas.ListadoForm;
import Vista.Listas.ListasForm;
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
    //private Empleado empleadoActual;
    
    public void menuController(SecretariaForm sec) throws SQLException{
        ChoferForm chofer = new ChoferForm();
        ClienteForm clt = new ClienteForm();
        VehiculoForm veh = new VehiculoForm();
        UsuarioForm user= new UsuarioForm();
        FacturaForm fac=new FacturaForm();
        LoginForm loginForm = new LoginForm(); 
        EnvioForm env = new EnvioForm();
        ListadoForm lst = new ListadoForm();
        
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
                // Obtener los datos del empleado desde la base de datos
                try {
            // Proporciona el CI y contraseña correctos
            
            Empleado empleado = sec.emp;

            if (empleado != null) {
                UsuarioForm usuarioForm = new UsuarioForm();
                usuarioForm.mostrarDatosEmpleado(empleado);
                usuarioForm.setVisible(true);
                sec.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Credenciales incorrectas. Por favor, intente nuevamente.");
            }
            } catch (SQLException ex) {
                ex.printStackTrace();
               }
            }
        });
            sec.btnEnvio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                env.setVisible(true);
                sec.setVisible(false);
            }
            
            
        });
            sec.btnListas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lst.setVisible(true);
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

}
