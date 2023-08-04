/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista.Vehiculo;

import Controlador.VehiculoController;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Almi-
 */
public class VehiculoForm extends javax.swing.JFrame {

    /**
     * Creates new form VehiculoForm
     */
    public VehiculoForm() throws SQLException {
        initComponents();
        VehiculoController vfrm = new VehiculoController();
        vfrm.VehiculoController(this);
        vfrm.setCform(this);
        vfrm.Load();
        //icono app
        setIconImage(new ImageIcon (getClass().getResource("/Vista/Login/Camion.png")).getImage());
        //Tamaño de las imagenes
        ImageIcon img=new ImageIcon(getClass().getResource("/Vista/Vehiculo/vehiculo.png"));
        ImageIcon img2=new ImageIcon(getClass().getResource("/Images/buscar.png"));
        Icon tmn=new ImageIcon(img.getImage().getScaledInstance(lblVehiculo.getWidth(), lblVehiculo.getHeight(), Image.SCALE_DEFAULT));
        Icon tmn2=new ImageIcon(img2.getImage().getScaledInstance(lblBuscar.getWidth(), lblBuscar.getHeight(), Image.SCALE_DEFAULT));
        lblBuscar.setIcon(tmn2);
        lblVehiculo.setIcon(tmn);
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

        panelContent = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVeh = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        txtMat = new javax.swing.JTextField();
        txtMarca = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtAnio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbDisp = new javax.swing.JComboBox<>();
        cbTipo = new javax.swing.JComboBox<>();
        lblVehiculo = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        lblBuscar = new javax.swing.JLabel();
        btnRegresarAlMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));
        setForeground(new java.awt.Color(153, 153, 255));

        panelContent.setBackground(new java.awt.Color(223, 223, 236));
        panelContent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clickPanel(evt);
            }
        });
        panelContent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 180, 85));
        jLabel1.setText("Vehiculo");
        panelContent.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, -1));

        tableVeh.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableVeh);

        panelContent.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 796, 206));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel2.setText("Matricula");
        panelContent.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, -1, -1));

        btnGuardar.setBackground(new java.awt.Color(192, 255, 255));
        btnGuardar.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        btnGuardar.setText("Guardar");
        panelContent.add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, -1, -1));

        btnEliminar.setBackground(new java.awt.Color(192, 255, 255));
        btnEliminar.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        btnEliminar.setText("Eliminar");
        panelContent.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 200, -1, -1));

        btnEditar.setBackground(new java.awt.Color(192, 255, 255));
        btnEditar.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        btnEditar.setText("Editar");
        panelContent.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 150, 100, -1));

        btnLimpiar.setBackground(new java.awt.Color(192, 255, 255));
        btnLimpiar.setFont(new java.awt.Font("Century", 1, 18)); // NOI18N
        btnLimpiar.setText("Limpiar");
        panelContent.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 200, -1, -1));

        txtMat.setText("jTextField1");
        panelContent.add(txtMat, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 162, -1));

        txtMarca.setText("jTextField2");
        panelContent.add(txtMarca, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 162, -1));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel3.setText("Marca");
        panelContent.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel4.setText("Año");
        panelContent.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, -1, -1));

        txtAnio.setText("jTextField3");
        panelContent.add(txtAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 162, -1));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel5.setText("Tipo");
        panelContent.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, -1, -1));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel6.setText("Disponibilidad");
        panelContent.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, -1, -1));

        cbDisp.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cbDisp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disponible", "No disponible" }));
        panelContent.add(cbDisp, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 100, -1));

        cbTipo.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Camioneta", "Camion" }));
        panelContent.add(cbTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, -1, -1));

        lblVehiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Vehiculo/vehiculo.png"))); // NOI18N
        panelContent.add(lblVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 60, 100, 80));

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel8.setText("Buscar");
        panelContent.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 290, -1, -1));
        panelContent.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 290, 189, -1));

        lblBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/buscar.png"))); // NOI18N
        panelContent.add(lblBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 270, 48, 42));

        btnRegresarAlMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/RegresoMenú.png"))); // NOI18N
        panelContent.add(btnRegresarAlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContent, javax.swing.GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContent, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void clickPanel(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clickPanel
        this.txtMat.setEditable(true);
    }//GEN-LAST:event_clickPanel
    
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
            java.util.logging.Logger.getLogger(VehiculoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VehiculoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VehiculoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VehiculoForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new VehiculoForm().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(VehiculoForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnEditar;
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnGuardar;
    public javax.swing.JButton btnLimpiar;
    public javax.swing.JButton btnRegresarAlMenu;
    public javax.swing.JComboBox<String> cbDisp;
    public javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblVehiculo;
    public javax.swing.JPanel panelContent;
    public javax.swing.JTable tableVeh;
    public javax.swing.JTextField txtAnio;
    public javax.swing.JTextField txtBuscar;
    public javax.swing.JTextField txtMarca;
    public javax.swing.JTextField txtMat;
    // End of variables declaration//GEN-END:variables
}
