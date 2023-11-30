/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.mysql;

import conexion.Conexion;
import dao.CursoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Curso;

/**
 *
 * @author orope
 */
public class CursoDAOImplMysql extends CursoDAO {

    Conexion conexionMysql = ConexionMysql.obtenerInstancia();

    @Override
    public String NombreCurso(int idCurso) {
        Connection conn = conexionMysql.getConexion();
        String courseName = null;
        String sql = "SELECT descripcion FROM tutobox.curso WHERE idCurso = ?;";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idCurso);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    courseName = rs.getString("descripcion");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courseName;
    }

    @Override
    public Curso findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Curso> findAll() {
        Connection conn = conexionMysql.getConexion();
        PreparedStatement stmt;
        String query = "SELECT * FROM tutobox.curso;";
        List<Curso> cursos = new ArrayList();
        try {
            stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String descripcion = rs.getString(2);
                Curso curso = new Curso(id, descripcion);
                cursos.add(curso);
            }

        } catch (SQLException e) {
            System.out.println("Error: No se pudo actualizar el usuario\n" + e.getMessage());
        }
        return cursos;
    }

    @Override
    public void save(Curso entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Curso entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
