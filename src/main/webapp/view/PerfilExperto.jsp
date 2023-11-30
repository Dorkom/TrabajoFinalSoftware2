<%-- 
    Document   : PerfilExperto
    Created on : 18 oct. 2023, 10:43:16
    Author     : orope
--%>

<%@page import="dao.PublicacionDAO"%>
<%@page import="model.Publicacion"%>
<%@page import="dao.CursoDAO"%>
<%@page import="model.Usuario"%>
<%@page import="dao.UsuarioDAO"%>
<%@page import="dao.MensajeDAO"%>
<%@page import="dao.DAOFactory"%>
<%@page import="model.Mensaje"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>:::Bienvenido al Sistema:::</title>

        <link rel="stylesheet" href="Recursos/Bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="Recursos/CSSPropio/newcss.css"/>
        <script src="Recursos/Bootstrap/js/bootstrap.min.js"></script>
        <script src="Recursos/JsPropio/ValidaJS.js"></script>
        <style>
            .card {
                margin-bottom: 20px;
            }
            .btn.btn-primary {
                margin-bottom: 20px;
                width: 100%;
            }
            .fixed-form {
                position: fixed;
                bottom: 0;
                left: 0;
                width: 25%;
                height: 50%;
                background-color: #f0f0f0;
                padding: 20px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
                overflow-y: scroll; /* Agrega un scroll vertical */
            }

            .form-field {
                margin-bottom: 10px;
            }
        </style>
    </head>
    <body>  
        <div class="header">
            <center><b>Bienvenido</b></center>
        </div>
        <%
            DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            int x = Integer.parseInt(String.valueOf(session.getAttribute("UsuarioCodigo")));
            CursoDAO cursoDAO = factory.createCursoDAO();
            Usuario usuario = (Usuario) request.getAttribute("usuarioTutor");
            List<Publicacion> publicaciones = (List<Publicacion>) request.getAttribute("publicaciones"); 
            List<Mensaje> mensajes = new ArrayList<>();           
            UsuarioDAO usuarioDAO=factory.createUsuarioDAO();
            MensajeDAO mensajeDAO = factory.createMensajeDAO();
            mensajes = mensajeDAO.getMensajesXExperto(usuario.getId());
        %>
        <div class="container-fluid">
            <div class="row" style="margin-top: 100px;">
                <div class="col-2" style="align-content: center;">
                    <div class = "datosperfil" style="border: 1px solid black; padding: 10px;">
                        <center><strong><p class="text-dark">Datos del Profesor:</p></strong></center>
                        <center><b>Nombre: <%= usuario.getNombres()%> </b></center>
                        <center><b>Apellido: <%= usuario.getApellidos()%></b></center>
                    </div>
                    &nbsp;
                    <center>
                        <div class="col-12">
                            <a class="btn btn btn-secondary btn_add_tutoria" href="ServletTutoria?accion=consultarTutoria&id=<%= usuario.getId()%>" role="button">Consultar Tutoria</a>
                        </div>
                    </center>
                    <div class="fixed-form">
                        <h2>Mensajes</h2>
                        <form action="MensajeServlet">
                            <div class="form-group">
                                <input type="text" class="form-control" id="mensaje" placeholder="Escribe tu mensaje" name="mensaje">
                            </div>
                            <input type="text" name="idTutor" class="form-control" style="display: none;" value="<%= usuario.getId() %>">
                            <button class="btn btn-primary" type="submit" name="accion" value="Agregar">Enviar</button>
                            <div class="border border-5 border-primary mt-2">
                                <% for (Mensaje mensaje : mensajes) {%>
                                <div class="media-body">
                                    <div class="media-body">
                                        <h5 class="mt-0"><%= usuarioDAO.obtenerNombrePorUsuarioId(mensaje.getIdEmisor())%></h5>
                                        <%= mensaje.getContenido()%>
                                    </div>
                                </div>
                                <hr>
                                <% }%>

                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-10">
                    <h1>Publicaciones</h1>
                    <%
                        System.out.println("idUsuario0" + x);
                        PublicacionDAO publicacionDAO = factory.createPublicacionDAO();
                        request.setAttribute("publicaciones", publicaciones);
                        DAOFactory factory2 = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
                    %>

                    <div class="container">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Titulo</th>
                                    <th>Cuerpo</th>
                                    <th>Nombre Curso</th>
                                    <th>Fecha de Publicacion</th>
                                    <th>Documento</th>
                                </tr>
                            </thead>
                            <tbody>
                                <% for (Publicacion publicacion : publicaciones) {%>
                                <tr>
                                    <td><%= publicacion.getTitulo()%></td>
                                    <td><%= publicacion.getCuerpo()%></td>
                                    <td><%= cursoDAO.NombreCurso(publicacion.getIdCurso())%></td>
                                    <td><%= publicacion.getFecha()%></td>
                                    <td></td>
                                </tr>
                                <% }%>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

        <div class="footer">
            <strong>Universidad de Lima - Grupo 2</strong>
        </div>
    </body>
</html>
