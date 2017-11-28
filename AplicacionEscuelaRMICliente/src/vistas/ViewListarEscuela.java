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
public class ViewListarEscuela extends UnicastRemoteObject implements IActualizableEscuela, Serializable
{
    private IServicioEscuela model;
    private transient GUIListarEscuela gui;
    ViewListarEscuela(IServicioEscuela ser) throws RemoteException
    {
        model = ser;
        model.addVista(this);
        gui = new GUIListarEscuela(model);
        gui.setVisible(true);
    }
    
    public void actualizable() throws RemoteException
    {
        gui.actualizable();
    }
}
