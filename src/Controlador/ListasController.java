/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Listas.ListasForm;
import Vista.ListadoFacturas.ListadoForm;
import Vista.Secretaria.SecretariaForm;
import Vista.Usuario.UsuarioForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ERICK
 */
public class ListasController {
    ListadoForm listas;
    public void ListasController(ListadoForm cform) throws SQLException{
        this.listas = cform;
            
            cform.btnRegresarAlMenu.addActionListener(new ActionListener() {
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
