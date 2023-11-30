/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Curso;

/**
 *
 * @author orope
 */
public abstract class CursoDAO implements CRUD<Curso>{
    public abstract String NombreCurso (int idCurso);
}
