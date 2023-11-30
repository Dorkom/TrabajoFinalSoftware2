/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.DAOFactory;
import dao.PublicacionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Publicacion;

/**
 *
 * @author orope
 */
@WebServlet(name = "ServletPublicacion", urlPatterns = {"/ServletPublicacion"})
public class ServletPublicacion extends HttpServlet {

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
        System.out.println("hola esto es action" + action);
        int x = (Integer.parseInt(String.valueOf(request.getSession().getAttribute("UsuarioCodigo"))));
        if (action.equalsIgnoreCase("Guardar")) {
            String titulo = request.getParameter("titulo");
            String cuerpo = request.getParameter("cuerpo");
            String fecha = request.getParameter("fecha");
            int idCurso = Integer.parseInt(request.getParameter("idCurso"));
            Publicacion p = new Publicacion(1, titulo, cuerpo, fecha, 1, idCurso, x);
            DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            PublicacionDAO publicacionDAO = factory.createPublicacionDAO();
            publicacionDAO.save(p);
            direccion = "view/PrincipalExperto.jsp";
        } else if (action.equalsIgnoreCase("eliminar")) {
            int eliminar = Integer.parseInt(request.getParameter("id"));
            DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            PublicacionDAO publicacionDAO = factory.createPublicacionDAO();
            publicacionDAO.delete(eliminar);
            direccion = "view/PrincipalExperto.jsp";
        } else if (action.equalsIgnoreCase("crear")) {
            direccion = "view/CrearPublicacion.jsp";
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
