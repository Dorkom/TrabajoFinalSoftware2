/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.CursoDAO;
import dao.DAOFactory;
import dao.TutoriaDAO;
import dao.UsuarioDAO;
import dao.mysql.DTO.RankingTutoresDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Curso;
import model.Tutoria;
import model.Usuario;

/**
 *
 * @author brayan
 */
@WebServlet(name = "ServletTutoria", urlPatterns = {"/ServletTutoria"})
public class ServletTutoria extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("accion");
        String direccion = "";
        int x = (Integer.parseInt(String.valueOf(request.getSession().getAttribute("UsuarioCodigo"))));
        if (action.equalsIgnoreCase("Guardar")) {
            System.out.println("accion guardar");
            String tema = request.getParameter("tema");
            String fecha = request.getParameter("fecha");
            String horaInicio = request.getParameter("horaInicio");
            String horaFin = request.getParameter("horaFin");
            int idCurso = Integer.parseInt(request.getParameter("idCurso"));
            Tutoria p = new Tutoria(1, tema, "pendiente", fecha, horaInicio, horaFin, "vacio", "vacio", "vacio", x, -1, idCurso);
            //public Tutoria(int id, String tema, String estado, String fecha, String horaIni, String horaFin, String puntuacion, String comentario, String estadoPago, int idTut, int idEst, int idCur)
            DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            TutoriaDAO tutoriaDAO = factory.createTutoriaDAO();
            tutoriaDAO.save(p);
            direccion = "view/CrearTutoria.jsp";
        } else if (action.equalsIgnoreCase("eliminar")) {
            int eliminar = Integer.parseInt(request.getParameter("id"));
            DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            TutoriaDAO tutoriaDAO = factory.createTutoriaDAO();
            tutoriaDAO.delete(eliminar);
            direccion = "view/CrearTutoria.jsp";
        } else if (action.equalsIgnoreCase("buscarxtema")) {
            System.out.println("entro a la accion buscar por tema");
            String tema = request.getParameter("tema");
            System.out.println(tema);
            List<Usuario> usuarios = new ArrayList<>();
            DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            UsuarioDAO usuarioDAO = factory.createUsuarioDAO();
            usuarios = usuarioDAO.obtenerTutoresXTema(tema);
            System.out.println(usuarios.size());
            request.setAttribute("listaUsuarios", usuarios);
            direccion = "view/BuscarTutoria.jsp";

        } else if (action.equalsIgnoreCase("buscarxcurso")) {
            int curso = Integer.parseInt(request.getParameter("idCurso"));
            System.out.println("filtrar por curso");
            System.out.println(curso);

            List<Usuario> usuarios = new ArrayList<>();
            DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            UsuarioDAO usuarioDAO = factory.createUsuarioDAO();
            usuarios = usuarioDAO.obtenerTutoresXCurso(curso);
            System.out.println(usuarios.size());
            request.setAttribute("listaUsuarios", usuarios);
            direccion = "view/BuscarTutoria.jsp";
            System.out.println("prueba de servlet tutoria curso");
        } else if (action.equalsIgnoreCase("vizualizar")) {
            System.out.println("entro a ver ranking");
            List<Curso> cursos = new ArrayList<>();
            List<RankingTutoresDTO> ranking = new ArrayList<>();
            DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            CursoDAO cursoDAO = factory.createCursoDAO();
            cursos = cursoDAO.findAll();
            TutoriaDAO tutoriadao = factory.createTutoriaDAO();
            ranking = tutoriadao.listarRankingTUtores();
            request.setAttribute("listaCursos", cursos);
            request.setAttribute("listaRanking", ranking);
            direccion = "view/RankingTutores.jsp";
        } else if (action.equalsIgnoreCase("vizualizarFiltro")) {
            int curso = Integer.parseInt(request.getParameter("idCurso"));
            List<Curso> cursos = new ArrayList<>();
            List<RankingTutoresDTO> ranking = new ArrayList<>();
            DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            CursoDAO cursoDAO = factory.createCursoDAO();
            cursos = cursoDAO.findAll();
            TutoriaDAO tutoriadao = factory.createTutoriaDAO();
            ranking = tutoriadao.listarRankingTUtoresxCurso(curso);
            request.setAttribute("listaCursos", cursos);
            request.setAttribute("listaRanking", ranking);
            direccion = "view/RankingTutores.jsp";
        } else if (action.equalsIgnoreCase("consultarTutoria")) {
            int tutor = Integer.parseInt(request.getParameter("id"));
            List<Tutoria> tutorias = new ArrayList<>();
            DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            TutoriaDAO tutoriaDAO = factory.createTutoriaDAO();
            tutorias = tutoriaDAO.obtenerTutoriasPorIdTutor(tutor);
            request.setAttribute("tutorias", tutorias);
            direccion = "view/ConsultarTutoria.jsp";
        } else if (action.equalsIgnoreCase("registrarseTutoria")) {
            int idTutoria = Integer.parseInt(request.getParameter("id"));
            int idTutor = Integer.parseInt(request.getParameter("IdTutor"));
            int idEstudiante = (Integer.parseInt(String.valueOf(request.getSession().getAttribute("UsuarioCodigo"))));
            DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            TutoriaDAO tutoriaDAO = factory.createTutoriaDAO();
            tutoriaDAO.registrarseUnaTutoria(idTutoria, idEstudiante);
            List<Tutoria> tutorias = new ArrayList<>();
            tutorias = tutoriaDAO.obtenerTutoriasPorIdTutor(idTutor);
            request.setAttribute("tutorias", tutorias);
            direccion = "view/ConsultarTutoria.jsp";
        }else if (action.equalsIgnoreCase("vistaCrearTutoria")) {
            direccion = "view/CrearTutoria.jsp";
        }
//        response.sendRedirect(direccion);

        // Obtener el objeto RequestDispatcher
        RequestDispatcher dispatcher = request.getRequestDispatcher(direccion);

        // Redirigir la solicitud al JSP
        dispatcher.forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
