/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionescuelarmiservidor;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import model.IServicioEscuela;
import model.ServicioEscuela;

/**
 *
 * @author Guilherme
 */
public class AplicacionEscuelaRMIServidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Direccion IP del equipo doonde se ejecute esta aplicacion Servidor
        String dbHost = "127.0.0.1";
        try {
            if (args.length > 0) {
                dbHost = args[0];
            }
            //puerto donde recide el servidor (model)
            LocateRegistry.createRegistry(1099);
            IServicioEscuela model = new ServicioEscuela();
            Naming.rebind("//" + dbHost + "/AplicacionEscuela", model);
            System.out.println("Objeto Model en el servidor...");
        } catch (Exception e) {
            System.out.println("Eror: " + e.getMessage());
        }
    }
    
}
