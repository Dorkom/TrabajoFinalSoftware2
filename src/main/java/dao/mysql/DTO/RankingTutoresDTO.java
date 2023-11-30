/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.mysql.DTO;

/**
 *
 * @author brayan
 */
public class RankingTutoresDTO {
    private String nombreCurso;
    private int idTutor;
    private String nombre;
    private String apellidos;
    private int cantTutorias;
    private double promPuntuacion;

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public int getIdTutor() {
        return idTutor;
    }

    public void setIdTutor(int idTutor) {
        this.idTutor = idTutor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getCantTutorias() {
        return cantTutorias;
    }

    public void setCantTutorias(int cantTutorias) {
        this.cantTutorias = cantTutorias;
    }

    public double getPromPuntuacion() {
        return promPuntuacion;
    }

    public void setPromPuntuacion(double promPuntuacion) {
        this.promPuntuacion = promPuntuacion;
    }
    
    
    
}
