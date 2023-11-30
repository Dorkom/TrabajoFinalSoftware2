/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import model.Usuario;

/**
 *
 * @author orope
 */
public abstract class UsuarioDAO implements CRUD<Usuario> {

    public abstract List<String> obtenerNombreRolesUsuario(int usuarioId);

    public abstract Usuario autentificar(String correo, String password);

    public abstract String obtenerNombrePorUsuarioId(int idUsuario);

    public abstract void updatePassword(String passwordActual, int id);

    public abstract List<Usuario> obtenerTutoresXTema(String tema);

    public abstract List<Usuario> obtenerTutoresXCurso(int idCurso);
    

}
