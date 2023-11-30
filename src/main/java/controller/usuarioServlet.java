/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DAOFactory;
import dao.PublicacionDAO;
import dao.TutoriaDAO;
import dao.UsuarioDAO;
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
import javax.servlet.http.HttpSession;
import model.Publicacion;
import model.Usuario;

/**
 *
 * @author orope
 */
@WebServlet(name = "usuarioServlet", urlPatterns = {"/usuarioServlet"})
public class usuarioServlet extends HttpServlet {

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

        if (action.equalsIgnoreCase("Guardar")) {
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String correo = request.getParameter("correo");
            int tipo_estudiante = Integer.parseInt(request.getParameter("tipo-estudiante"));
            Usuario u = new Usuario(nombre, apellido, correo, "", tipo_estudiante);

            int x = (Integer.parseInt(String.valueOf(request.getSession().getAttribute("UsuarioCodigo"))));
            u.setId(x);
            DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            UsuarioDAO usuarioDao = factory.createUsuarioDAO();
            usuarioDao.update(u);
            direccion = "view/login.jsp";
        } else if (action.equalsIgnoreCase("Agregar")) {
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String correo = request.getParameter("correo");
            String clave = request.getParameter("clave");
            int tipo_estudiante = Integer.parseInt(request.getParameter("idTipoUsuario"));
            Usuario u = new Usuario(nombre, apellido, correo, clave, tipo_estudiante);

            DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            UsuarioDAO usuarioDao = factory.createUsuarioDAO();
            usuarioDao.save(u);
            direccion = "view/login.jsp";
        } else if (action.equalsIgnoreCase("UpdatePass")) {
            String clave = request.getParameter("passNueva");
            DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            UsuarioDAO usuarioDao = factory.createUsuarioDAO();
            int x = (Integer.parseInt(String.valueOf(request.getSession().getAttribute("UsuarioCodigo"))));
            usuarioDao.updatePassword(clave, x);
            direccion = "view/login.jsp";
        } else if (action.equalsIgnoreCase("verPerfil")) {
            int idTutor = Integer.parseInt(request.getParameter("id"));
            DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            UsuarioDAO usuarioDao = factory.createUsuarioDAO();
            Usuario usuarioTutor = usuarioDao.findById(idTutor);
            PublicacionDAO publicacionDAO = factory.createPublicacionDAO();
            List<Publicacion> publicaciones = new ArrayList<>();
            publicaciones = publicacionDAO.obtenerPublicacionesPorUsuario(idTutor);
            request.setAttribute("publicaciones", publicaciones);
            request.setAttribute("usuarioTutor", usuarioTutor);
            direccion = "view/PerfilExperto.jsp";
//            int x= (Integer.parseInt(String.valueOf(request.getSession().getAttribute("UsuarioCodigo"))));
//            usuarioDao.updatePassword(clave, x);
//            direccion = "view/login.jsp";
        } else if (action.equalsIgnoreCase("UpdatePuntuacion")) {
            int puntuacion = Integer.parseInt(request.getParameter("rankingname"));
            System.out.println("esta es la puntuacion");
            System.out.println(puntuacion);
            DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            TutoriaDAO tutoriaDAO = factory.createTutoriaDAO();
            int idTutoria = Integer.parseInt(request.getParameter("info"));
//            int x = (Integer.parseInt(String.valueOf(request.getSession().getAttribute("UsuarioCodigo"))));
            System.out.println("id de tutoria?");
            System.out.println(idTutoria);
            tutoriaDAO.updatepuntuacion(puntuacion, idTutoria);
            direccion = "view/PrincipalUsuario.jsp";
        } else if (action.equalsIgnoreCase("UpdateFeedback")) {
            int idTutoria = Integer.parseInt(request.getParameter("info"));
            HttpSession session = request.getSession();
            session.setAttribute("idTutoria", idTutoria);

            System.out.println("prueba update feedback id tutoria");
            System.out.println(idTutoria);

            direccion = "view/CrearComentario.jsp";
        } else if (action.equalsIgnoreCase("CrearComentario")) {

            HttpSession session = request.getSession();
            int idTutoria = (int) session.getAttribute("idTutoria");
            System.out.println("prueba crear comentario id tutoria");
            System.out.println(idTutoria);

            String comentario = request.getParameter("comentarioname");
            System.out.println("esta es el comentario");
            System.out.println(comentario);
            DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            TutoriaDAO tutoriaDAO = factory.createTutoriaDAO();
            tutoriaDAO.updatecomentario(comentario, idTutoria);
            direccion = "view/PrincipalUsuario.jsp";
        } else if (action.equalsIgnoreCase("CancelarTutoria")) {
            DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            TutoriaDAO tutoriaDAO = factory.createTutoriaDAO();
            int idTutoria = Integer.parseInt(request.getParameter("infoid"));
            int idEstudiante = Integer.parseInt(request.getParameter("infoest"));
            System.out.println("id de tutoria?");
            System.out.println(idTutoria);
            System.out.println("id de estudiante??");
            System.out.println(idEstudiante);
            tutoriaDAO.eliminartutoria(idEstudiante, idTutoria);
            direccion = "view/PrincipalUsuario.jsp";
        } else if (action.equalsIgnoreCase("editarPerfil")) {
            direccion = "view/editarPerfil.jsp";
        } else if (action.equalsIgnoreCase("vistaUpdatePass")) {
            direccion = "view/restablecerPassword.jsp";
        }

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
