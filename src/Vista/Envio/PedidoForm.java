/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista.Envio;

import Controlador.PedidoController;
import Modelo.DTO.Envio;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Almi-
 */
public class PedidoForm extends javax.swing.JFrame {
    public Envio env;
    

    public PedidoForm(Envio env) throws SQLException {
        this.env = env;
        //icono app
        setIconImage(new ImageIcon (getClass().getResource("/Vista/Login/Camion.png")).getImage());
        System.out.println("CIchofer desde pedido form: "+env.getCiChofer());
        initComponents();        
        PedidoController pedidoController = new PedidoController();
        pedidoController.PedidoController(this);
        
    }
    
    public PedidoForm(){}
    
    public void cargar() throws SQLException{
        lblId.setText(env.getId());
        lblRuc.setText(env.getRucCliente());
        lblFecha.setText(env.getFecha());
        lblDetalles.setText(env.getDetalles());
        lblPeso.setText(env.getPeso());
        lblInter.setText(env.getEnvioInterprov());
        lblCosto.setText(env.getCosto());
        lblDir.setText(env.getDireccion());
        lblDiDest.setText(env.getCiDestinatario());
        lblTel.setText(env.getTelefono());
        lblEstado.setText(env.getEstado());
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
        btnAsignar = new javax.swing.JButton();
        btnFinal = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnRegresarAlMenu = new javax.swing.JButton();
        btnFactura = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblRuc = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblDetalles = new javax.swing.JLabel();
        lblPeso = new javax.swing.JLabel();
        lblInter = new javax.swing.JLabel();
        lblCosto = new javax.swing.JLabel();
        lblDiDest = new javax.swing.JLabel();
        lblDir = new javax.swing.JLabel();
        lblTel = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(223, 223, 236));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAsignar.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        btnAsignar.setText("Asignar Chofer");
        jPanel1.add(btnAsignar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, -1, -1));

        btnFinal.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        btnFinal.setText("Finalizar Pedido");
        jPanel1.add(btnFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 280, -1, -1));

        jLabel1.setText("ID");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 65, -1, -1));

        jLabel2.setText("IDRUC");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 99, -1, -1));

        btnRegresarAlMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/RegresoMenú.png"))); // NOI18N
        jPanel1.add(btnRegresarAlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        btnFactura.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        btnFactura.setText("Ver Factura");
        jPanel1.add(btnFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, -1, -1));

        jLabel3.setText("FECHA");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 133, -1, -1));

        jLabel4.setText("DETALLES");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 167, -1, -1));

        jLabel5.setText("PESO");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 201, -1, -1));

        jLabel6.setText("INTERPROVINCIAL");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 65, -1, -1));

        jLabel7.setText("COSTO");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 99, -1, -1));

        jLabel8.setText("DIRECCION");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 133, -1, -1));

        jLabel9.setText("CI DESTINO");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 167, -1, -1));

        jLabel10.setText("TELEFONO");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(411, 201, -1, -1));

        jLabel11.setText("ESTADO");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(231, 235, -1, -1));

        lblId.setText("asdasd");
        jPanel1.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 65, 43, -1));

        lblRuc.setText("jLabel12");
        jPanel1.add(lblRuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 99, -1, -1));

        lblFecha.setText("jLabel12");
        jPanel1.add(lblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 133, 149, -1));

        lblDetalles.setText("jLabel12");
        jPanel1.add(lblDetalles, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 167, 149, -1));

        lblPeso.setText("jLabel12");
        jPanel1.add(lblPeso, new org.netbeans.lib.awtextra.AbsoluteConstraints(186, 201, 149, -1));

        lblInter.setText("jLabel12");
        jPanel1.add(lblInter, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 65, -1, -1));

        lblCosto.setText("jLabel12");
        jPanel1.add(lblCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 99, -1, -1));

        lblDiDest.setText("jLabel12");
        jPanel1.add(lblDiDest, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 167, -1, -1));

        lblDir.setText("jLabel12");
        jPanel1.add(lblDir, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 133, -1, -1));

        lblTel.setText("jLabel12");
        jPanel1.add(lblTel, new org.netbeans.lib.awtextra.AbsoluteConstraints(535, 201, -1, -1));

        lblEstado.setText("jLabel12");
        jPanel1.add(lblEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 235, -1, -1));

        jLabel12.setFont(new java.awt.Font("Century", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 180, 85));
        jLabel12.setText("PEDIDO");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(PedidoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PedidoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PedidoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PedidoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                PedidoForm pf = new PedidoForm();
                pf.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAsignar;
    public javax.swing.JButton btnFactura;
    public javax.swing.JButton btnFinal;
    public javax.swing.JButton btnRegresarAlMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel lblCosto;
    public javax.swing.JLabel lblDetalles;
    public javax.swing.JLabel lblDiDest;
    public javax.swing.JLabel lblDir;
    public javax.swing.JLabel lblEstado;
    public javax.swing.JLabel lblFecha;
    public javax.swing.JLabel lblId;
    public javax.swing.JLabel lblInter;
    public javax.swing.JLabel lblPeso;
    public javax.swing.JLabel lblRuc;
    public javax.swing.JLabel lblTel;
    // End of variables declaration//GEN-END:variables
}
