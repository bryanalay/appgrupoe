/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista.Secretaria;

import Controlador.SecretariaController;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Almi-
 */
public class SecretariaForm extends javax.swing.JFrame {

    /**
     * Creates new form SecretariaForm
     */
    public SecretariaForm() throws SQLException {
        initComponents();
        SecretariaController sec = new SecretariaController();
        sec.menuController(this);
        //icono app
        setIconImage(new ImageIcon (getClass().getResource("/Vista/Login/Camion.png")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelContent = new javax.swing.JPanel();
        btnVehiculo = new javax.swing.JButton();
        btnChofer = new javax.swing.JButton();
        btnListas = new javax.swing.JButton();
        btnCliente = new javax.swing.JButton();
        btnUsuario = new javax.swing.JButton();
        btnEnvio = new javax.swing.JButton();
        lblSesion = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelContent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnVehiculo.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnVehiculo.setText("Vehiculo");
        btnVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVehiculoActionPerformed(evt);
            }
        });
        panelContent.add(btnVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 130, 150, 41));

        btnChofer.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnChofer.setText("Chofer");
        btnChofer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChoferActionPerformed(evt);
            }
        });
        panelContent.add(btnChofer, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 170, 41));

        btnListas.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnListas.setText("Listas");
        btnListas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListasActionPerformed(evt);
            }
        });
        panelContent.add(btnListas, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 280, 150, 41));

        btnCliente.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnCliente.setText("Cliente");
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });
        panelContent.add(btnCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 168, 41));

        btnUsuario.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnUsuario.setText("Usuario");
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
            }
        });
        panelContent.add(btnUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 130, 170, 41));

        btnEnvio.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnEnvio.setText("Envio");
        btnEnvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnvioActionPerformed(evt);
            }
        });
        panelContent.add(btnEnvio, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, 170, 41));

        lblSesion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSesion.setText("Cerrar Sesion");
        panelContent.add(lblSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 40, 90, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/FondoLoginY.jpg"))); // NOI18N
        panelContent.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-9, 0, 1000, 450));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContent, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 993, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnListasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnListasActionPerformed

    private void btnChoferActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChoferActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChoferActionPerformed

    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClienteActionPerformed

    private void btnVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVehiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVehiculoActionPerformed

    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnUsuarioActionPerformed

    private void btnEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnvioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnvioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SecretariaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SecretariaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SecretariaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SecretariaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SecretariaForm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(SecretariaForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnChofer;
    public javax.swing.JButton btnCliente;
    public javax.swing.JButton btnEnvio;
    public javax.swing.JButton btnListas;
    public javax.swing.JButton btnUsuario;
    public javax.swing.JButton btnVehiculo;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel lblSesion;
    public javax.swing.JPanel panelContent;
    // End of variables declaration//GEN-END:variables
}
