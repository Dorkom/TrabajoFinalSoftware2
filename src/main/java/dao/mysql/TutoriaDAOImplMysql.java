/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.mysql;

import conexion.Conexion;
import dao.TutoriaDAO;
import dao.mysql.DTO.PerfilEstudianteDTO;
import dao.mysql.DTO.RankingTutoresDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Tutoria;

/**
 *
 * @author orope
 */
public class TutoriaDAOImplMysql extends TutoriaDAO {

    Conexion conexionMysql = ConexionMysql.obtenerInstancia();

    @Override
    public Tutoria findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Tutoria> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void save(Tutoria entity) {
        Connection conn = conexionMysql.getConexion();
        try {
            // Consulta SQL para insertar una nueva tutoría
            String query = "INSERT INTO `tutobox`.`tutoria` (`tema`, `estado`, `fecha`, `horaIni`, `horaFin`, `idTutor`, `idCurso`) VALUES (?,?,?,?,?,?,?);";

            // Crear un objeto PreparedStatement para ejecutar la consulta
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                // Establecer los valores de los parámetros
                preparedStatement.setString(1, entity.getTema());
                preparedStatement.setString(2, entity.getEstado());
                preparedStatement.setString(3, entity.getFecha());
                preparedStatement.setString(4, entity.getHoraIni());
                preparedStatement.setString(5, entity.getHoraFin());
                preparedStatement.setInt(6, entity.getIdTut());
                preparedStatement.setInt(7, entity.getIdCur());

                // Ejecutar la consulta
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error\n" + e.getMessage());
        }
    }

    @Override
    public void update(Tutoria entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) {
        Connection conn = conexionMysql.getConexion();

        try {
            String query = "DELETE FROM `tutobox`.`tutoria` WHERE (`idTutoria` = ?);";
            try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("Error\n" + e.getMessage());
        }
    }

    @Override
    public List<Tutoria> obtenerListaTutoriasXEstudiante(int idEstudiante) {
        Connection conn = conexionMysql.getConexion();
        PreparedStatement ps;
        String query = "SELECT * FROM tutobox.tutoria WHERE idEstudiante = ?";

        List<Tutoria> tutorias = new ArrayList<>();

        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, idEstudiante);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String tema = rs.getString(2);
                String estado = rs.getString(3);
                String fecha = rs.getString(4);
                String horaIni = rs.getString(5);
                String horaFin = rs.getString(6);
                String puntuacion = rs.getString(7);
                String comentario = rs.getString(8);
                String estadoPago = rs.getString(9);
                int idTut = rs.getInt(10);
                int idEst = rs.getInt(11);
                int idCur = rs.getInt(12);
                Tutoria p = new Tutoria(id, tema, estado, fecha, horaIni, horaFin, puntuacion, comentario, estadoPago, idTut, idEst, idCur);

                tutorias.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Error: No se pudieron obtener las tutorias del estudiante\n" + e.getMessage());
        }

        return tutorias;
    }

    @Override
    public List<Tutoria> obtenerTutoriasPorIdTutor(int idTutor) {
        Connection conn = conexionMysql.getConexion();
        PreparedStatement ps;
        String query = "SELECT * FROM tutobox.tutoria WHERE idTutor = ? and idEstudiante IS null";

        List<Tutoria> tutorias = new ArrayList<>();
        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, idTutor);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String tema = rs.getString(2);
                String estado = rs.getString(3);
                String fecha = rs.getString(4);
                String horaIni = rs.getString(5);
                String horaFin = rs.getString(6);
                String puntuacion = rs.getString(7);
                String comentario = rs.getString(8);
                String estadoPago = rs.getString(9);
                int idTut = rs.getInt(10);
                int idEst = rs.getInt(11);
                int idCur = rs.getInt(12);
                Tutoria p = new Tutoria(id, tema, estado, fecha, horaIni, horaFin, puntuacion, comentario, estadoPago, idTut, idEst, idCur);

                tutorias.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Error: No se pudieron obtener las tutorias del estudiante\n" + e.getMessage());
        }

        return tutorias;
    }

    @Override
    public void updatecomentario(String comentario, int idTutoria) {
        Connection conn = conexionMysql.getConexion();
        PreparedStatement ps;
        String query = "UPDATE `tutobox`.`tutoria` SET `comentario` = ? WHERE (`idTutoria` = ?)";

        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, comentario);
            ps.setInt(2, idTutoria);

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: No se pudo actualizar el usuario\n" + e.getMessage());
        }
    }

    @Override
    public void updatepuntuacion(int puntuacion, int idTutoria) {
        Connection conn = conexionMysql.getConexion();
        PreparedStatement ps;
        String query = "UPDATE `tutobox`.`tutoria` SET `puntuacion` = ? WHERE (`idTutoria` = ?)";

        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, puntuacion);
            ps.setInt(2, idTutoria);

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: No se pudo actualizar el usuario\n" + e.getMessage());
        }
    }

    @Override
    public void eliminartutoria(int idEstudiante, int idTutoria) {
        Connection conn = conexionMysql.getConexion();
        PreparedStatement ps;
        String query = "UPDATE tutobox.tutoria SET idEstudiante = null WHERE idTutoria = ?";

        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, idTutoria);

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: No se pudo actualizar el usuario\n" + e.getMessage());
        }
    }

    @Override
    public List<RankingTutoresDTO> listarRankingTUtores() {
        Connection conn = conexionMysql.getConexion();
        PreparedStatement ps;
        String query = "SELECT\n"
                + "    u.idusuario AS idprofesor,\n"
                + "    u.nombre AS nombre_profesor,\n"
                + "    u.apellidos AS nombre_profesor,\n"
                + "    COUNT(t.idtutoria) AS cantidad_tutorias_calificadas,\n"
                + "    AVG(t.puntuacion) AS puntuacion_promedio\n"
                + "FROM\n"
                + "    usuario u\n"
                + "    JOIN tutoria t ON u.idusuario = t.idTutor\n"
                + "WHERE\n"
                + "    u.idTipo = (SELECT idTipousuario FROM tipousuario WHERE descripcion = 'Tutor')\n"
                + "    AND t.puntuacion IS NOT NULL\n"
                + "GROUP BY\n"
                + "    u.idusuario, u.nombre\n"
                + "ORDER BY\n"
                + "	AVG(t.puntuacion) DESC;";

        List<RankingTutoresDTO> lista_ranking = new ArrayList<>();

        try {
            ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idTutor = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellidos = rs.getString(3);
                int cantTutorias = rs.getInt(4);
                float prom = rs.getFloat(5);
                RankingTutoresDTO ranking = new RankingTutoresDTO();
                ranking.setIdTutor(idTutor);
                ranking.setNombre(nombre);
                ranking.setApellidos(apellidos);
                ranking.setCantTutorias(cantTutorias);
                ranking.setPromPuntuacion(prom);
                lista_ranking.add(ranking);
            }

        } catch (SQLException e) {
            System.out.println("Error: No se pudieron obtener las tutorias del estudiante\n" + e.getMessage());
        }
        return lista_ranking;
    }

    @Override
    public List<RankingTutoresDTO> listarRankingTUtoresxCurso(int idCurso) {
        Connection conn = conexionMysql.getConexion();
        PreparedStatement ps;
        String query = "SELECT c.descripcion AS nombre_curso, u.idUsuario, u.nombre AS nombre_usuario, u.apellidos AS apellidos_usuario,\n"
                + "COUNT(t.idTutoria) AS total_tutorias, AVG(t.puntuacion) AS promedio_puntuacion\n"
                + "FROM curso c\n"
                + "JOIN tutoria t ON c.idCurso = t.idCurso\n"
                + "JOIN usuario u ON u.idUsuario = t.idTutor\n"
                + "WHERE t.idCurso = ? AND t.puntuacion IS NOT NULL\n"
                + "GROUP BY c.descripcion, u.idUsuario, u.nombre\n"
                + "ORDER BY AVG(t.puntuacion) DESC;";

        List<RankingTutoresDTO> lista_ranking = new ArrayList<>();

        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, idCurso);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String nombreCurso = rs.getString(1);
                int idTutor = rs.getInt(2);
                String nombre = rs.getString(3);
                String apellidos = rs.getString(4);
                int cantTutorias = rs.getInt(5);
                float prom = rs.getFloat(6);
                RankingTutoresDTO ranking = new RankingTutoresDTO();
                ranking.setNombreCurso(nombreCurso);
                ranking.setIdTutor(idTutor);
                ranking.setNombre(nombre);
                ranking.setApellidos(apellidos);
                ranking.setCantTutorias(cantTutorias);
                ranking.setPromPuntuacion(prom);
                lista_ranking.add(ranking);
            }

        } catch (SQLException e) {
            System.out.println("Error: No se pudieron obtener las tutorias del estudiante\n" + e.getMessage());
        }
        return lista_ranking;
    }

    @Override
    public void registrarseUnaTutoria(int idTutoria, int idEstudiante) {
        Connection conn = conexionMysql.getConexion();
        PreparedStatement ps;
        String query = "UPDATE `tutobox`.`tutoria` SET `idEstudiante` = ? WHERE (`idTutoria` = ?);";

        try {
            ps = conn.prepareStatement(query);
            ps.setInt(1, idEstudiante);
            ps.setInt(2, idTutoria);

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: No se pudo actualizar el usuario\n" + e.getMessage());
        }
    }
}
