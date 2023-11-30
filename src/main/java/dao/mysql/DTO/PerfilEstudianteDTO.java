/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.mysql.DTO;

import java.util.List;
import model.Tutoria;
import model.Usuario;


public class PerfilEstudianteDTO {
    
    Usuario usuario;
    List<Tutoria> turorias;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Tutoria> getTurorias() {
        return turorias;
    }

    public void setTurorias(List<Tutoria> turorias) {
        this.turorias = turorias;
    }
    
}
