/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escuela;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Guilherme
 */
public class Escuela implements Serializable{
    private String nombre;
    private String profesor;
    private String estudiante;
    private int incrementa = 1;
    private String idE;

    private ArrayList<Integer> d =  new ArrayList<>();
    public Escuela(String id,String nombre, String profesor, String estudiante) {
        //this.id = incrementa++;
        this.idE = id;
        this.nombre = nombre;
        this.profesor = profesor;
        this.estudiante = estudiante;
    }
    public Escuela(){}
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }
    
    public int getIncrementa() {
        return incrementa;
    }

    public void setIncrementa(int incrementa) {
        this.incrementa = incrementa;
    }
    
    public String getIdE() {
        return idE;
    }

    public void setIdE(String idE) {
        this.idE = idE;
    }
    
}
