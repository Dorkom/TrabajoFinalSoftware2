/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.mysql;

import conexion.Conexion;
import dao.TipoUsuarioDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.TipoUsuario;

/**
 *
 * @author orope
 */
public class TipoUsuarioDAOImplMysql extends TipoUsuarioDAO {

    Conexion conexionMysql = ConexionMysql.obtenerInstancia();



    @Override
    public List<TipoUsuario> findAll() {

        Connection conn = conexionMysql.getConexion();
        PreparedStatement ps;
        String query = "SELECT * FROM tutobox.tipousuario;";
        List<TipoUsuario> tiposUsuarios = new ArrayList<>();

        try {
            ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id=(rs.getInt("idTipousuario"));
                String tipo=(rs.getString("descripcion"));
                TipoUsuario tipoU=new TipoUsuario(id, tipo);
                tiposUsuarios.add(tipoU);
            }
            //Conexion.cerrarConexion(cn);
        } catch (SQLException e) {
            System.out.println("Error: No se pudo traer la lista de los tipos de usuario\n" + e.getMessage());

        } 
        return tiposUsuarios;
    }



    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public TipoUsuario findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void save(TipoUsuario entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(TipoUsuario entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
