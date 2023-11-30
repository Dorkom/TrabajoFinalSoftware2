/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import model.Publicacion;

/**
 *
 * @author orope
 */
public abstract class PublicacionDAO implements CRUD<Publicacion>{
    
    public abstract List<Publicacion> obtenerPublicacionesPorUsuario(int idUsuario);
    
}
