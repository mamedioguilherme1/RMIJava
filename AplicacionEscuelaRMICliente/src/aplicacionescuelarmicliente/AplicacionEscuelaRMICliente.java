/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionescuelarmicliente;

import java.rmi.Naming;
import model.IServicioEscuela;
import vistas.GUIPrincipal;

/**
 *
 * @author Guilherme
 */
public class AplicacionEscuelaRMICliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String rmiRegistryHost = "192.168.16.8";
        try {
            if (args.length > 0) {
                rmiRegistryHost = args[0];
            }

            IServicioEscuela model = (IServicioEscuela) Naming.lookup("//"
                    + rmiRegistryHost + "/AplicacionEscuela");
            if (model == null) {
                System.out.println("Error... Cliente ");
                return;
            }
            System.out.println("objecto servidor");
            GUIPrincipal gui = new GUIPrincipal(model);
            gui.setVisible(true);
        } catch (Exception e) {
            System.out.println("Error... " + e);
        }
    }
    
}
