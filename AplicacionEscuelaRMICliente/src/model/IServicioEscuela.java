/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import escuela.Escuela;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import vistas.IActualizableEscuela;

/**
 *
 * @author Guilherme
 */
public interface IServicioEscuela extends Remote{
    public Escuela getEscuela() throws RemoteException;
    public void addVista(IActualizableEscuela gui) throws RemoteException;
    public void setEscuela(Escuela escuela) throws RemoteException;
    public void insertar(Escuela e) throws RemoteException;
    public void eliminar(Escuela e) throws RemoteException;
    public void editar(Escuela e, String n, String p, String es) throws RemoteException;
    public void auxActualizable() throws RemoteException;
    public ArrayList<Escuela> getArrayEsc() throws RemoteException;
    public Escuela buscar(String id) throws RemoteException;
}
