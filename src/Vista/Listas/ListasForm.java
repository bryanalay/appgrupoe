/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Listas;

import Controlador.ListasController;
import Controlador.UsuarioController;
import java.awt.Image;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author ERICK
 */
public class ListasForm extends javax.swing.JFrame {

    /**
     * Creates new form ListasForm
     */
    public ListasForm() throws SQLException {
        initComponents();
//        ListasController lista = new ListasController();
//        lista.ListasController(this);
//        //icono app
//        setIconImage(new ImageIcon (getClass().getResource("/Vista/Login/Camion.png")).getImage());
//        //Tamaño de las imagenes
//        ImageIcon img=new ImageIcon(getClass().getResource("/Vista/Listas/lista.png"));
//        ImageIcon img2=new ImageIcon(getClass().getResource("/Images/buscar.png"));
//        Icon tmn=new ImageIcon(img.getImage().getScaledInstance(lblLista.getWidth(), lblLista.getHeight(), Image.SCALE_DEFAULT));
//        Icon tmn2=new ImageIcon(img2.getImage().getScaledInstance(lblBuscar.getWidth(), lblBuscar.getHeight(), Image.SCALE_DEFAULT));
//        lblLista.setIcon(tmn);
//        lblBuscar.setIcon(tmn2);
//        this.repaint();
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
        cmbEstado = new javax.swing.JComboBox<>();
        lblLista = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnLimpiar = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        lblBuscar = new javax.swing.JLabel();
        btnRegresarAlMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(223, 223, 236));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbEstado.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "En espera", "Viajando", "Entregado" }));
        jPanel1.add(cmbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 90, 30));
        jPanel1.add(lblLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 90, 70));

        btnGuardar.setBackground(new java.awt.Color(192, 255, 255));
        btnGuardar.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        btnGuardar.setText("Guardar");
        jPanel1.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 115, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 610, 170));

        btnLimpiar.setBackground(new java.awt.Color(192, 255, 255));
        btnLimpiar.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        btnLimpiar.setText("Limpiar");
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 160, 115, -1));

        btnEdit.setBackground(new java.awt.Color(192, 255, 255));
        btnEdit.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        btnEdit.setText("Editar");
        jPanel1.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 109, -1));

        btnEliminar.setBackground(new java.awt.Color(192, 255, 255));
        btnEliminar.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        btnEliminar.setText("Eliminar");
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Estado");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 70, 30));

        jLabel2.setFont(new java.awt.Font("Century", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 180, 85));
        jLabel2.setText("LISTAS");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, -1, -1));

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel8.setText("Buscar");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 260, -1, -1));
        jPanel1.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, 189, -1));

        lblBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/buscar.png"))); // NOI18N
        jPanel1.add(lblBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 48, 42));

        btnRegresarAlMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/RegresoMenú.png"))); // NOI18N
        jPanel1.add(btnRegresarAlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            java.util.logging.Logger.getLogger(ListasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListasForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ListasForm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ListasForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnEdit;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JButton btnRegresarAlMenu;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblBuscar;
    public javax.swing.JLabel lblLista;
    public javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
