/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vistas;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import model.IServicioEscuela;

/**
 *
 * @author Estudiante
 */
public class ViewEliminarEscuela  extends UnicastRemoteObject implements IActualizableEscuela, Serializable{
    private IServicioEscuela model;
    private transient GUIEliminarEscuela gui;
    ViewEliminarEscuela(IServicioEscuela ser) throws RemoteException 
    {
        model = ser;
        model.addVista(this);
        gui = new GUIEliminarEscuela(model);
        gui.setVisible(true);
    }

    @Override
    public void actualizable() throws RemoteException {
       
    }
}
