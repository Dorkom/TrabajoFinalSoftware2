/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author orope
 */
public class Tutoria {

    private int id;
    private String tema;
    private String estado;
    private String fecha;
    private String horaIni;
    private String horaFin;
    private String puntuacion;
    private String comentario;
    private String estadoPago;
    private int idTut;
    private int idEst;
    private int idCur;

    public Tutoria(int id, String tema, String estado, String fecha, String horaIni, String horaFin, String puntuacion, String comentario, String estadoPago, int idTut, int idEst, int idCur) {
        this.id = id;
        this.tema = tema;
        this.estado = estado;
        this.fecha = fecha;
        this.horaIni = horaIni;
        this.horaFin = horaFin;
        this.puntuacion = puntuacion;
        this.comentario = comentario;
        this.estadoPago = estadoPago;
        this.idTut = idTut;
        this.idEst = idEst;
        this.idCur = idCur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHoraIni() {
        return horaIni;
    }

    public void setHoraIni(String horaIni) {
        this.horaIni = horaIni;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(String puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(String estadoPago) {
        this.estadoPago = estadoPago;
    }

    public int getIdTut() {
        return idTut;
    }

    public void setIdTut(int idTut) {
        this.idTut = idTut;
    }

    public int getIdEst() {
        return idEst;
    }

    public void setIdEst(int idEst) {
        this.idEst = idEst;
    }

    public int getIdCur() {
        return idCur;
    }

    public void setIdCur(int idCur) {
        this.idCur = idCur;
    }

}
