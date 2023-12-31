/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.DAO.ChoferDAO;
import Modelo.DAO.EnvioDAO;
import Modelo.DTO.Chofer;
import Modelo.DTO.Envio;
import Vista.Envio.EnvioForm;
import Vista.Envio.PedidoForm;
import Vista.Factura.FacturaForm;
import Vista.Secretaria.SecretariaForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Almi-
 */
public class PedidoController {
    //private Envio envioObj = new Envio();
    
    //PedidoForm cform;
    //regresar al home
    
    public void PedidoController(PedidoForm cform) throws SQLException{
        //Envio env = cform.getEnv();
        //System.out.println("Esto es de cforn.env: "+env.getDetalles());
        //String ciGlobal;
        cform.btnRegresarAlMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EnvioForm envF = null;
                try {
                    envF = new EnvioForm();
                } catch (SQLException ex) {
                    Logger.getLogger(SecretariaController.class.getName()).log(Level.SEVERE, null, ex);
                }
                envF.setVisible(true);
                
                cform.setVisible(false);
                

            }
        });
        
        cform.btnAsignar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ci = "";
                ChoferDAO chdao = new ChoferDAO();
                EnvioDAO envdao = new EnvioDAO();
                try {
                    Chofer chf = chdao.getChoferDisp();
                    ci = chf.getCi();
                    //cform.env.setCiChofer(ci);
                    String status = "Ocupado";
                    boolean res = chdao.cambiarDisponChofer(ci, status);
                    boolean setCi = envdao.agregarCiAEnvio(ci, Integer.parseInt(cform.env.getId()));
                    if(res){
                        JOptionPane.showMessageDialog(null, "Se cambio a ocupado");
                    }else{
                        JOptionPane.showMessageDialog(null, "No se cambio a ocupado");
                    }
                    System.out.println("este es el CI del chofer asignado: "+ci);
                } catch (SQLException ex) {
                    System.out.println("No hay choferes disponibles");
                }
                
                boolean res = chdao.asignarChofer(ci, Integer.parseInt(cform.lblId.getText()));
                if(res){
                    //EnvioDAO envdao = new EnvioDAO();
                    //cform.env.setEstado("Finalizado");
                    //envdao.editarEnvio(cform.env);
//                    try {
//                        cform.cargar();
//                    } catch (SQLException ex) {
//                        Logger.getLogger(PedidoController.class.getName()).log(Level.SEVERE, null, ex);
//                    }
                    JOptionPane.showMessageDialog(null, "Chofer Asignado Correctamente!");                    
                }else{
                    JOptionPane.showMessageDialog(null, "No se pudo asignar chofer!"); 
                }
            }
        });
        
        cform.btnFinal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EnvioDAO endai = new EnvioDAO();
                cform.env.setEstado("Finalizado");
                ChoferDAO chdao  = new ChoferDAO();                 
                boolean res = endai.editarEnvio(cform.env);
                chdao.cambiarDisponChofer(cform.env.getCiChofer(), "Disponible");
                System.out.println("Este es el CI del chofer, si abro un pedido con chofer ya asignado: "
                        +cform.env.getCiChofer());
                if(res){
                    JOptionPane.showMessageDialog(null, "Envio finalizado!!");
                    try {
                    cform.cargar();
                } catch (SQLException ex) {
                    Logger.getLogger(PedidoController.class.getName()).log(Level.SEVERE, null, ex);
                }
                }
                
            }
        });

        
        Load(cform);
        cform.cargar();
//        if(env.getId()!=null){
//            System.out.println("este es el id del pedido: "+env.getId());
//            //cargar(cform,env);
//        }else{
//            System.out.println("No cargo el envio");
//        }
    }
    
    
    
    public PedidoController() {
    }    

    //private String state;

    public void Load(PedidoForm cform) throws SQLException {

            cform.btnFactura.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    FacturaForm factura= new FacturaForm(cform.env);
                    System.out.print(cform.env.getDetalles());
                    System.out.print("hola");
                    factura.cargar();
                    factura.setVisible (true) ;
                    cform.setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(PedidoController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
               
            }
        }); 

        //limpiarTodo();
    }
}