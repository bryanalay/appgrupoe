/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Usuario;

import Controlador.UsuarioController;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author ERICK
 */
public class UsuarioForm extends javax.swing.JFrame {

    /**
     * Creates new form UsuarioForm
     */
    public UsuarioForm() {
        initComponents();
        UsuarioController usuario = new UsuarioController();
        //usuario.UsuarioController(this);
        //usuario.setUform(this);

        //Icono de la aplicacion
        setIconImage(new ImageIcon (getClass().getResource("/Vista/Login/Camion.png")).getImage());
        //Tamaño de las imagenes
        ImageIcon img=new ImageIcon(getClass().getResource("/Vista/Usuario/usuario.png"));
        Icon tmn=new ImageIcon(img.getImage().getScaledInstance(lblUsuario.getWidth(), lblUsuario.getHeight(), Image.SCALE_DEFAULT));        
        lblUsuario.setIcon(tmn);
        this.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        lblCi = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblCelular = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        btnRegresarMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(223, 223, 236));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(249, 154, 49));
        jLabel1.setText("Cedula:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 70, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(249, 154, 49));
        jLabel2.setText("Nombre:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(249, 154, 49));
        jLabel3.setText("Apellido:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(249, 154, 49));
        jLabel4.setText("Celular:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(249, 154, 49));
        jLabel5.setText("F. Nacimiento:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, -1, -1));

        jLabel6.setFont(new java.awt.Font("Century", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(252, 13, 13));
        jLabel6.setText("Datos Personales");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(249, 154, 49));
        jLabel7.setText("Correo:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, -1, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(249, 154, 49));
        jLabel8.setText("Direccion:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, -1, -1));

        lblUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Usuario/usuario.png"))); // NOI18N
        jPanel1.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 120, 120));
        jPanel1.add(lblCi, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 80, 70, 40));
        jPanel1.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 70, 30));
        jPanel1.add(lblApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 80, 40));
        jPanel1.add(lblCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 100, 40));
        jPanel1.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, 80, 40));
        jPanel1.add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 160, 90, 30));
        jPanel1.add(lblDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 100, 40));

        btnRegresarMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/RegresoMenú.png"))); // NOI18N
        jPanel1.add(btnRegresarMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 270, 50, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(UsuarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsuarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsuarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsuarioForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsuarioForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnRegresarMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lblApellido;
    public javax.swing.JLabel lblCelular;
    public javax.swing.JLabel lblCi;
    public javax.swing.JLabel lblCorreo;
    public javax.swing.JLabel lblDireccion;
    public javax.swing.JLabel lblFecha;
    public javax.swing.JLabel lblNombre;
    public javax.swing.JLabel lblUsuario;
    // End of variables declaration//GEN-END:variables
}
