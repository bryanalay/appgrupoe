package Controlador;

import Modelo.DAO.LoginDAO;
import Modelo.DTO.Empleado;
import Vista.Secretaria.SecretariaForm;
import Vista.Login.LoginForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Almi-
 */
public class LoginController {
    //LoginForm vista = new LoginForm();
    
    public void Login(LoginForm vista){
        
        vista.btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String ci = vista.txtCedula.getText();
                    String contra = vista.txtContra.getText();
                    btnClick(ci,contra,vista);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        
    }
    
    private void btnClick(String ci,String contra,LoginForm vista) throws SQLException{
        LoginDAO ld = new LoginDAO();
        Empleado emp = ld.login(ci, contra);
        
        if(emp==null){            
            JOptionPane.showMessageDialog(null, "CI o Contraseña incorrecta");            
        } else {
            //llamo secretaria form y le paso el empleado
            vista.setVisible(false);
            System.out.println("Logueado..!!");
            abirMenuSecretaria(emp.getCi(),emp.getNombre());
        }
    }
    
    private void abirMenuSecretaria(String ci,String nombre) throws SQLException{
        SecretariaForm secre = new SecretariaForm();
        secre.lblNombre.setText(nombre);
        secre.lblCi.setText(ci);
        
        secre.setVisible(true);
    }
}
