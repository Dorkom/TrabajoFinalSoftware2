/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.mysql;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author orope
 */
public class ConexionMysql implements Conexion {

    private static ConexionMysql instancia;
    private Connection cn;

    private ConexionMysql() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tutobox", "root", "admin");
            System.out.println("Conexion Satisfactoria :)");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de Conexión\n" + e);
        }
    }
    
    public static synchronized ConexionMysql obtenerInstancia(){
        if (instancia==null) {
            instancia = new ConexionMysql();
        }
        return instancia;
    }
    
    @Override
    public Connection getConexion() {
        return cn;
    }

//    @Override
//    public void cerrarConexion() {
//        try {
//            if (cn!=null) {
//                cn.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

//    @Override
//    public void cerrarRecursos(Connection conn, PreparedStatement stmt, ResultSet rs) {
//        try {
//            if (rs != null) {
//                rs.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            if (stmt != null) {
//                stmt.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            if (conn != null) {
//                conn.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

}
