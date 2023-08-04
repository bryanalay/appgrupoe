
package Controlador;

import Vista.Chofer.ChoferForm;
import Vista.Cliente.ClienteForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vista.Secretaria.SecretariaForm;
import Vista.Vehiculo.VehiculoForm;
import java.sql.SQLException;
import javax.swing.JPanel;

/**
 *
 * @author Almi-
 */
public class SecretariaController {
    public void menuController(SecretariaForm sec) throws SQLException{
        ChoferForm chofer = new ChoferForm();
        ClienteForm clt = new ClienteForm();
        VehiculoForm veh = new VehiculoForm();
        sec.btnChofer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel pan = sec.panelContent;
                pan.removeAll();
                pan.add(chofer.getContentPane());
                pan.revalidate();
                pan.repaint();
            }
        });
        
        sec.btnCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel pan = sec.panelContent;
                pan.removeAll();
                pan.add(clt.getContentPane());
                pan.revalidate();
                pan.repaint();
            }
        });
        
        sec.btnVehiculo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel pan = sec.panelContent;
                pan.removeAll();
                pan.add(veh.getContentPane());
                pan.revalidate();
                pan.repaint();
            }
        });
    }
}
