/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Guilherme
 */
public interface IActualizableEscuela extends Remote{
    public void actualizable() throws RemoteException;
}
