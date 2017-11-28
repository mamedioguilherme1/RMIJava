/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import escuela.Escuela;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.rmi.server.*; 
import java.rmi.*;
import vistas.IActualizableEscuela;
/**
 *
 * @author Guilherme
 */
public class ServicioEscuela extends UnicastRemoteObject implements IServicioEscuela{
    private ArrayList <IActualizableEscuela> v =  new ArrayList<>();
    private static ArrayList <Escuela> arrayEsc = new ArrayList<>();
    private Escuela escuela = new Escuela();
    
    public ServicioEscuela() throws RemoteException 
    {
        v = new ArrayList<>();
        arrayEsc = new ArrayList<>();
    }
    
    public Escuela getEscuela() throws RemoteException {return escuela;}
    
    public void addVista(IActualizableEscuela gui) throws RemoteException{v.add(gui);}

    public void setEscuela(Escuela escuela) throws RemoteException {
        this.escuela = escuela;
    }

    
    private void actualizable()
    {
        for(IActualizableEscuela gui : v){
            try {
                gui.actualizable();
            } catch (RemoteException ex) {
                Logger.getLogger(ServicioEscuela.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void insertar(Escuela e) throws RemoteException
    {   
        arrayEsc.add(e);
        System.out.println("\n------------------- \nDADO INSERTADO");
        actualizable();
        
        //insertarBD();
    }
    
    public void eliminar(Escuela e) throws RemoteException
    {   
        //arrayEsc.remove(e);
        Escuela tem = null;
        for(Escuela es : arrayEsc){
            if(es.getIdE().equals(e.getIdE())){
                tem = es;
            }
        }
        if (tem != null){
            arrayEsc.remove(tem);
            System.out.println("\n------------------- \nDADO ELIMINADO");
        }
        
        
        actualizable();
        //insertarBD();
    }
    
    public void editar(Escuela e, String n, String p, String es) throws RemoteException
    {
        Escuela tem = null;
        for(Escuela esc : arrayEsc){
            if(esc.getIdE().equals(e.getIdE())){
                tem = esc;
            }
        }
        if (tem != null)
        {
            for(Escuela esc : arrayEsc)
            {
                if(esc.getIdE().equals(e.getIdE()))
                {
                    esc.setNombre(n);
                    esc.setProfesor(p);
                    esc.setEstudiante(es);
                }
            }
            System.out.println("\n------------------- \nDADO EDITADO");
        }
        actualizable();
    }
    public void auxActualizable() throws RemoteException{actualizable();}
//    public void insertarBD()
//    {
//        String insert = "";
//        insert = "INSERT INTO esc VALUES (" + "'"
//            +arrayEsc.get(arrayEsc.size() - 1).getIdE()+"','"
//            +arrayEsc.get(arrayEsc.size() - 1).getNombre()+"','"
//            +arrayEsc.get(arrayEsc.size() - 1).getProfesor()+"','" 
//            +arrayEsc.get(arrayEsc.size() - 1).getEstudiante() + "')";
//        con.executeUpdateStatement(insert);
//        
//    }
    public ArrayList<Escuela> getArrayEsc() throws RemoteException
    {
        return arrayEsc; 
    }
//    public void cargaDatosDB()
//    {
//        ResultSet res = null;
//        
//        String busca = "SELECT * FROM esc";
//        res = con.executeQueryStatement(busca);
//        if(arrayEsc.size()>=1){
//          arrayEsc.clear();
//        }
//        
//        try {
//            while(res.next())
//            {
//               String id = res.getString("IDESCUELA");
//               String nEscuela = res.getString("nombreEscuela");
//               String profesor = res.getString("profesor");
//               String estudiante = res.getString("estudiante");
//               escuela = new Escuela(id, nEscuela, profesor, estudiante);
//               arrayEsc.add(escuela);
//               
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ServicioEscuela.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    public void editarDB(String id, String nome, String profesor, String estudiante)
//    {
//        String busca = "UPDATE esc set NOMBREESCUELA='"+ nome
//                +"', PROFESOR='" + profesor
//                +"', ESTUDIANTE='" + estudiante
//                +"' where IDESCUELA='" + id +"'";
//        con.executeQueryStatement(busca);
//    }
//    public void eliminarDB(String id)
//    {
//        String busca = "DELETE from esc where IDESCUELA='"+ id +"'";
//        con.executeQueryStatement(busca);
//    }
//    public int contador() 
//    {
//        int id = 0;
//        ResultSet res = null;
//        String busca = "SELECT * FROM esc";
//        res = con.executeQueryStatement(busca);
//        try {
//            while(res.next())
//            {
//               id = res.getInt("idEscuela");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(ServicioEscuela.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            res.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(ServicioEscuela.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return (id+1);
//    }
    public Escuela buscar(String id) throws RemoteException
    {
        escuela = new Escuela ("","","","");
        int cont = 0;
        for(int i = 0; i < arrayEsc.size(); i++)
        {
            if(id.equals(arrayEsc.get(i).getIdE()))
            {
                escuela =  arrayEsc.get(i);
            }else{
                cont++;
            }
        }
        if(cont == arrayEsc.size())
        {
            //cargaDatosDB();
        }
        
        return escuela;
    }
}
