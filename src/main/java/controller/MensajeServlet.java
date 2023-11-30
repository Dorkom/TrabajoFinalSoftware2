/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DAOFactory;
import dao.MensajeDAO;
import dao.PublicacionDAO;
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
import model.Mensaje;
import model.Publicacion;
import model.Usuario;

/**
 *
 * @author orope
 */
@WebServlet(name = "MensajeServlet", urlPatterns = {"/MensajeServlet"})
public class MensajeServlet extends HttpServlet {

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
        if (action.equalsIgnoreCase("Agregar")) {

            int idTutor = Integer.parseInt(request.getParameter("idTutor"));
            DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            UsuarioDAO usuarioDao = factory.createUsuarioDAO();
            Usuario usuarioTutor = usuarioDao.findById(idTutor);
            PublicacionDAO publicacionDAO = factory.createPublicacionDAO();
            List<Publicacion> publicaciones = new ArrayList<>();
            publicaciones = publicacionDAO.obtenerPublicacionesPorUsuario(idTutor);
            request.setAttribute("publicaciones", publicaciones);
            request.setAttribute("usuarioTutor", usuarioTutor);

            String m = request.getParameter("mensaje");
            int x = (Integer.parseInt(String.valueOf(request.getSession().getAttribute("UsuarioCodigo"))));
            Mensaje mensaje = new Mensaje(0, "", m, "2020-01-01", x, idTutor, "");
            MensajeDAO mensajeDAO = factory.createMensajeDAO();
            mensajeDAO.save(mensaje);
            direccion = "view/PerfilExperto.jsp";
        } else if (action.equalsIgnoreCase("responder")) {
            int idMensaje = Integer.parseInt(request.getParameter("idMensaje"));
            String r = request.getParameter("respuesta");
            System.out.println("id " + idMensaje);
            System.out.println("respuesta: " + r);
            Mensaje men = new Mensaje();
            men.setId(idMensaje);
            men.setRespuesta(r);
            DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            MensajeDAO mensajeDAO = factory.createMensajeDAO();
            mensajeDAO.update(men);
            direccion = "view/PrincipalExperto.jsp";
        }
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
