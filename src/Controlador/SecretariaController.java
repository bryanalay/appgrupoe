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
                // Obtener los datos del empleado desde la base de datos
                try {
            // Proporciona el CI y contraseña correctos
            String ciEmpleado = "1719963470"; // Reemplaza con el CI correcto
            String contrasenia = "123"; // Reemplaza con la contraseña correcta
            
            Empleado empleado = obtenerEmpleadoDesdeBD(ciEmpleado, contrasenia);

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
        
        private Empleado obtenerEmpleadoDesdeBD(String ci, String password) throws SQLException {
    // Aquí debes implementar la lógica para obtener los datos del empleado desde la base de datos
    // y retornar una instancia de Empleado con esos datos
    LoginDAO loginDAO = new LoginDAO(); // Suponiendo que tienes un DAO para acceder a la base de datos
    Empleado emp= loginDAO.login(ci, password); // Suponiendo que tienes un método en el DAO para obtener el empleado por su ID
    return emp;
    }
}
