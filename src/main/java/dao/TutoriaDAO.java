/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dao.mysql.DTO.PerfilEstudianteDTO;
import dao.mysql.DTO.RankingTutoresDTO;
import java.util.List;
import model.Tutoria;

/**
 *
 * @author orope
 */
public abstract class TutoriaDAO implements CRUD<Tutoria> {

    public abstract List<Tutoria> obtenerListaTutoriasXEstudiante(int idEstudiante);

    public abstract List<Tutoria> obtenerTutoriasPorIdTutor(int idTutor);

    public abstract void updatecomentario(String comentario, int idTutoria);

    public abstract void updatepuntuacion(int puntuacion, int idTutoria);

    public abstract void eliminartutoria(int idEstudiante, int idTutoria);
    
    public abstract List<RankingTutoresDTO> listarRankingTUtores();
    
    public abstract List<RankingTutoresDTO> listarRankingTUtoresxCurso(int idCurso);
    
    public abstract void registrarseUnaTutoria(int idTutoria, int idEstudiante);

}
