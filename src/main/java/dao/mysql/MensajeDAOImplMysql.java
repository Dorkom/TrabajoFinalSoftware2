/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.mysql;

import conexion.Conexion;
import dao.MensajeDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Mensaje;

/**
 *
 * @author orope
 */
public class MensajeDAOImplMysql extends MensajeDAO {

    Conexion conexionMysql = ConexionMysql.obtenerInstancia();

    @Override
    public Mensaje findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Mensaje> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void save(Mensaje entity) {
        Connection conn = conexionMysql.getConexion();
        PreparedStatement stmt;
        String query = "INSERT INTO `tutobox`.`mensaje` (`asunto`, `cuerpo`, `fechaEnvio`, `idUsuarioEmisor`, `idUsuarioReceptor`) VALUES (?, ?, ?, ?, ?);";
        try {
            stmt = conn.prepareStatement(query);
            stmt.setString(1, entity.getAsunto());
            stmt.setString(2, entity.getContenido());
            stmt.setString(3, entity.getFecha());
            stmt.setInt(4, entity.getIdEmisor());
            stmt.setInt(5, entity.getIdReceptor());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: No se pudo guardar mensaje\n" + e.getMessage());
        }
    }

    @Override
    public void update(Mensaje entity) {
        Connection conn = conexionMysql.getConexion();
        PreparedStatement ps;
        String query = "UPDATE `tutobox`.`mensaje` SET `respuesta` = ? WHERE (`idMensaje` = ?);";

        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, entity.getRespuesta());
            ps.setInt(2, entity.getId());

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: No se pudo actualizar el usuario\n" + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Mensaje> getMensajesXExperto(int idExperto) {
        Connection conn = conexionMysql.getConexion();
        PreparedStatement stmt;
        String query = "SELECT * FROM tutobox.mensaje where idUsuarioReceptor=? order by idMensaje desc;";
        List<Mensaje> mensajes = new ArrayList();
        try {
            stmt = conn.prepareStatement(query);
            stmt.setInt(1, idExperto);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String asunto = rs.getNString(2);
                String contenido = rs.getString(3);
                String fecha = rs.getString(4);
                int idEmisor = rs.getInt(5);
                int idRecpetor = rs.getInt(6);
                String respuesta=rs.getString(7);
                Mensaje mensaje= new Mensaje(id, asunto, contenido, fecha, idEmisor, idRecpetor,respuesta);
                mensajes.add(mensaje);
            }

        } catch (SQLException e) {
            System.out.println("Error: No se pudo traer los mensajes\n" + e.getMessage());
        }
        return mensajes;
    }

    @Override
    public String getNombreEmisor(int idEmisor) {
        return "";
    }

}
