/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.Secretaria.SecretariaForm;
import Vista.Usuario.UsuarioForm;
//import Vista.Usuario.UsuarioForm;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LEKIAM
 */
public class UsuarioController {
    UsuarioForm usuario;
    
    public void UsuarioController(UsuarioForm cform) throws SQLException{
        this.usuario = cform;
            
            cform.btnRegresarMenu.addActionListener(new ActionListener() {
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

}