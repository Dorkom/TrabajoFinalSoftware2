/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DAOFactory;
import dao.PublicacionDAO;
import dao.TutoriaDAO;
import dao.UsuarioDAO;
import dao.mysql.DTO.PerfilEstudianteDTO;
import dao.mysql.DTO.perfilExpertoDTO;
import dao.mysql.UsuarioDAOImplMysql;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Publicacion;
import model.Tutoria;
import model.Usuario;

/**
 *
 * @author orope
 */
@WebServlet(name = "ServletInicioSesion", urlPatterns = {"/ServletInicioSesion"})
public class ServletInicioSesion extends HttpServlet {

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
        // Variables
        String correo = request.getParameter("correo");
        String clave = request.getParameter("clave");
        String direccion = "errorLogUsuario.html";

        // Activamos la sesión
        HttpSession sesion = request.getSession();
        if (sesion.isNew()) {
            sesion = request.getSession(true);
        }

        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        UsuarioDAO usuarioDao = factory.createUsuarioDAO();

        System.out.println(correo);
        System.out.println(clave);

        Usuario usuario = usuarioDao.autentificar(correo, clave);

        if (usuario != null) {
            // Guardamos los datos del cliente en variables de sesión

            sesion.setAttribute("UsuarioCodigo", usuario.getId());
            sesion.setAttribute("UsuarioNombre", usuario.getNombres());
            sesion.setAttribute("UsuarioApellido", usuario.getApellidos());
            sesion.setAttribute("idCursoAux", -1);
            sesion.setAttribute("idExpertoAux", -1);

            // Obtener el rol del usuario
            if (usuario.getIdTipo() == 2) {
                PublicacionDAO publicacionDAO=factory.createPublicacionDAO();
                List<Publicacion> publicaciones=new ArrayList<>();
                publicaciones=publicacionDAO.obtenerPublicacionesPorUsuario(usuario.getId());
                perfilExpertoDTO perfilExpertoDTO=new perfilExpertoDTO();
                perfilExpertoDTO.setUsuario(usuario);
                perfilExpertoDTO.setPublicaciones(publicaciones);
                perfilExpertoDTO.setUsuario(usuario);
                request.setAttribute("perfilExperto", perfilExpertoDTO);
                direccion = "view/PrincipalExperto.jsp";
            } else if (usuario.getIdTipo() == 1) {
                TutoriaDAO tutoriaDAO = factory.createTutoriaDAO();
                List<Tutoria> tutorias=new ArrayList<>();
                tutorias=tutoriaDAO.obtenerListaTutoriasXEstudiante(usuario.getId());
                PerfilEstudianteDTO perfilEstudiante=new PerfilEstudianteDTO();
                perfilEstudiante.setUsuario(usuario);
                perfilEstudiante.setTurorias(tutorias);
                request.setAttribute("perfilEstudiante", perfilEstudiante);
                direccion = "view/PrincipalUsuario.jsp";
            }
        }

        // Redirigir a la dirección correspondiente
        RequestDispatcher dispatcher = request.getRequestDispatcher(direccion);
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
