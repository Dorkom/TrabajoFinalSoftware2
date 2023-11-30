/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author orope
 */
public interface Conexion {

    Connection getConexion();

//    void cerrarConexion();
//
//    void cerrarRecursos(Connection conn, PreparedStatement stmt, ResultSet rs);
//    
}
