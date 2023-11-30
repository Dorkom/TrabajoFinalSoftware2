/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author orope
 */
public class Mensaje {

    private int id;
    private String asunto;
    private String contenido;
    private String fecha;
    private int idEmisor;
    private int idReceptor;
    private String respuesta;

    public Mensaje() {
    }
    
    

    public Mensaje(int id, String asunto, String contenido, String fecha, int idEmisor, int idReceptor, String respuesta ) {
        this.id = id;
        this.asunto = asunto;
        this.contenido = contenido;
        this.fecha = fecha;
        this.idEmisor = idEmisor;
        this.idReceptor = idReceptor;
        this.respuesta=respuesta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getIdEmisor() {
        return idEmisor;
    }

    public void setIdEmisor(int idEmisor) {
        this.idEmisor = idEmisor;
    }

    public int getIdReceptor() {
        return idReceptor;
    }

    public void setIdReceptor(int idReceptor) {
        this.idReceptor = idReceptor;
    }
    
    

}
