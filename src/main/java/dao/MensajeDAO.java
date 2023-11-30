/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import model.Mensaje;

/**
 *
 * @author orope
 */
public abstract class MensajeDAO implements CRUD<Mensaje>{
    
    public abstract List<Mensaje> getMensajesXExperto(int idExperto);
    
    public abstract String getNombreEmisor(int idEmisor);
}
