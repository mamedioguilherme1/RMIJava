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
 * @author Guilherme
 */
public class ViewActualizarEscuela extends UnicastRemoteObject implements IActualizableEscuela, Serializable{
    private IServicioEscuela model;
    private transient GUIActualizarEscuela gui;
    ViewActualizarEscuela(IServicioEscuela ser) throws RemoteException
    {
        model = ser;
        model.addVista(this);
        gui = new GUIActualizarEscuela(model);
        gui.setVisible(true);
    }
    
    public void actualizable() throws RemoteException
    {
        gui.actualizable();
    }
}
