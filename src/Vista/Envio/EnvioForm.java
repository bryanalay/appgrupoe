/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista.Envio;

import Vista.Cliente.*;
import Controlador.ClienteController;
import Controlador.EnvioController;
import Controlador.UsuarioController;
import Vista.Factura.FacturaForm;
import java.awt.Image;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;


/**
 *
 * @author Almi-
 */
public class EnvioForm extends javax.swing.JFrame {
    
    /**
     * Creates new form ClienteForm
     */
    public EnvioForm() throws SQLException {
        initComponents();
        EnvioController env = new EnvioController();
        env.EnvioController(this);
        env.Load();
        //ClienteController envio = new ClienteController();
//        envio.ClienteController(this);
//        envio.setCform(this);
//        envio.Load();
        //icono app
        setIconImage(new ImageIcon (getClass().getResource("/Vista/Login/Camion.png")).getImage());
        //Tamaño de las imagenes
        ImageIcon img=new ImageIcon(getClass().getResource("/Vista/Envio/envio.png"));
        ImageIcon img2=new ImageIcon(getClass().getResource("/Images/buscar.png"));
        Icon tmn=new ImageIcon(img.getImage().getScaledInstance(lblCliente.getWidth(), lblCliente.getHeight(), Image.SCALE_DEFAULT));
        Icon tmn2=new ImageIcon(img2.getImage().getScaledInstance(lblBuscar.getWidth(), lblBuscar.getHeight(), Image.SCALE_DEFAULT));
        lblCliente.setIcon(tmn);
        lblBuscar.setIcon(tmn2);
        this.repaint();
        btnGenerarFactura.setVisible(false);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCont = new javax.swing.JPanel();
        txtRuc = new javax.swing.JTextField();
        txtTel = new javax.swing.JTextField();
        txtDir = new javax.swing.JTextField();
        txtDetalles = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        btnGenerarFactura = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEnvio = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        lblCliente = new javax.swing.JLabel();
        lblBuscar = new javax.swing.JLabel();
        btnRegresarAlMenu = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtPeso = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        checkInter = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        txtCIdest = new javax.swing.JTextField();
        btnAbrirPedido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));
        setUndecorated(true);

        panelCont.setBackground(new java.awt.Color(223, 223, 236));
        panelCont.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clicPanel(evt);
            }
        });
        panelCont.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panelCont.add(txtRuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, 150, -1));
        panelCont.add(txtTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 150, -1));
        panelCont.add(txtDir, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 150, -1));
        panelCont.add(txtDetalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 150, -1));

        btnGuardar.setBackground(new java.awt.Color(192, 255, 255));
        btnGuardar.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        btnGuardar.setText("Guardar");
        panelCont.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, 115, -1));

        btnEdit.setBackground(new java.awt.Color(192, 255, 255));
        btnEdit.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        btnEdit.setText("Editar");
        panelCont.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 150, 109, -1));

        btnLimpiar.setBackground(new java.awt.Color(192, 255, 255));
        btnLimpiar.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        btnLimpiar.setText("Limpiar");
        panelCont.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 210, 115, -1));

        btnGenerarFactura.setBackground(new java.awt.Color(192, 255, 255));
        btnGenerarFactura.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        btnGenerarFactura.setText("...");
        btnGenerarFactura.setEnabled(false);
        btnGenerarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarFacturaActionPerformed(evt);
            }
        });
        panelCont.add(btnGenerarFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 480, 30, -1));

        jLabel1.setFont(new java.awt.Font("Century", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 180, 85));
        jLabel1.setText("ENVIO");
        panelCont.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel2.setText("ID");
        panelCont.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel3.setText("RUC");
        panelCont.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, -1, -1));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel4.setText("TELEFONO");
        panelCont.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, -1, -1));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel5.setText("DETALLES");
        panelCont.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, -1, -1));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel6.setText("PESO");
        panelCont.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, -1, -1));

        txtId.setEnabled(false);
        panelCont.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 150, -1));

        tbEnvio.setModel(new javax.swing.table.DefaultTableModel(
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
        tbEnvio.setEditingRow(0);
        jScrollPane1.setViewportView(tbEnvio);

        panelCont.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 764, 184));

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel8.setText("Buscar");
        panelCont.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, -1, -1));
        panelCont.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, 189, -1));

        lblCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Cliente/cliente.png"))); // NOI18N
        panelCont.add(lblCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, 81, 79));

        lblBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/buscar.png"))); // NOI18N
        panelCont.add(lblBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 310, 48, 42));

        btnRegresarAlMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/RegresoMenú.png"))); // NOI18N
        panelCont.add(btnRegresarAlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        btnEliminar.setBackground(new java.awt.Color(192, 255, 255));
        btnEliminar.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        btnEliminar.setText("Eliminar");
        panelCont.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 210, -1, -1));

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel7.setText("DIRECCION");
        panelCont.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, -1, -1));
        panelCont.add(txtPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 150, -1));

        jLabel9.setText("INTERPROV:");
        panelCont.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, -1, -1));
        panelCont.add(checkInter, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 20, -1));

        jLabel10.setText("CI DESTITANTARIO:");
        panelCont.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, -1, -1));
        panelCont.add(txtCIdest, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, 110, -1));

        btnAbrirPedido.setBackground(new java.awt.Color(192, 255, 255));
        btnAbrirPedido.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        btnAbrirPedido.setText("Abrir Pedido");
        panelCont.add(btnAbrirPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 260, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelCont, javax.swing.GroupLayout.PREFERRED_SIZE, 985, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelCont, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void clicPanel(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clicPanel
        this.txtId.setEditable(true);
    }//GEN-LAST:event_clicPanel

    private void btnGenerarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarFacturaActionPerformed
        // TODO add your handling code here:
            this.dispose();
            FacturaForm facturaForm = new FacturaForm();
            facturaForm.setVisible(true);
    }//GEN-LAST:event_btnGenerarFacturaActionPerformed

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
            java.util.logging.Logger.getLogger(ClienteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClienteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClienteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClienteForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ClienteForm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAbrirPedido;
    public javax.swing.JButton btnEdit;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnGenerarFactura;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JButton btnRegresarAlMenu;
    public javax.swing.JCheckBox checkInter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblCliente;
    public javax.swing.JPanel panelCont;
    public javax.swing.JTable tbEnvio;
    public javax.swing.JTextField txtBuscar;
    public javax.swing.JTextField txtCIdest;
    public javax.swing.JTextField txtDetalles;
    public javax.swing.JTextField txtDir;
    public javax.swing.JTextField txtId;
    public javax.swing.JTextField txtPeso;
    public javax.swing.JTextField txtRuc;
    public javax.swing.JTextField txtTel;
    // End of variables declaration//GEN-END:variables
}
