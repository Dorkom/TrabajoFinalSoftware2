<%-- 
    Document   : PrincipalExperto
    Created on : 25 set. 2023, 20:16:48
    Author     : orope
--%>

<%@page import="dao.UsuarioDAO"%>
<%@page import="dao.MensajeDAO"%>
<%@page import="model.Mensaje"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Usuario"%>
<%@page import="dao.CursoDAO"%>
<%@page import="dao.PublicacionDAO"%>
<%@page import="model.Publicacion"%>
<%@page import="java.util.List"%>
<%@page import="dao.DAOFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>:::Bienvenido al Sistema:::</title>

        <link rel="stylesheet" href="Recursos/Bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="Recursos/CSSPropio/newcss.css"/>
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
            int x = Integer.parseInt(String.valueOf(session.getAttribute("UsuarioCodigo")));
            
            
            
            List<Mensaje> mensajes = new ArrayList<>();
            DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            UsuarioDAO usuarioDAO=factory.createUsuarioDAO();
            MensajeDAO mensajeDAO = factory.createMensajeDAO();
            mensajes = mensajeDAO.getMensajesXExperto(x);
        %>
        <div class="container-fluid">
            <div class="row" style="margin-top: 100px;">
                <div class="col-2" style="align-content: center;">
                    <div style="border: 1px solid black; padding: 10px;">
                        <center><strong><p class="text-dark">Datos del Profesor:</p></strong></center>
                        <center><b>Nombre: <%= session.getAttribute("UsuarioNombre")%> </b></center>
                        <center><b>Apellido: <%= session.getAttribute("UsuarioApellido")%></b></center>
                    </div>
                    &nbsp;
                    <center>
                        <div class="col-12">
                            <a class="btn btn-primary" href="ServletPublicacion?accion=crear" role="button">Crear Publicacion</a>
                        </div>
                        <div class="col-12">
                            <a class="btn btn-primary" href="usuarioServlet?accion=editarPerfil" role="button">Editar Perfil</a>
                        </div>
                        <div class="col-12">
                            <a class="btn btn-primary" href="ServletTutoria?accion=vistaCrearTutoria" role="button">Crear Tutorias</a>
                        </div>
                        <div class="col-12">
                            <a class="btn btn-primary" href="usuarioServlet?accion=vistaUpdatePass" role="button">Actualizar Contraseña</a>
                        </div>
                    </center>
                    <div class="fixed-form">
                        <h2>Mensajes</h2>
                        <form action="MensajeServlet">
                            <div class="border border-5 border-primary mt-2">
                                <% for (Mensaje mensaje : mensajes) {%>
                                <div class="media-body">
                                    <div class="media-body">
                                        <input type="text" name="idMensaje" class="form-control" style="display: none;" value="<%= mensaje.getId() %>">
                                        <h5 class="mt-0"><%= usuarioDAO.obtenerNombrePorUsuarioId(mensaje.getIdEmisor())%></h5>
                                        <%= mensaje.getContenido()%>
                                        <input type="text" placeholder="Ingrese Respuesta" name="respuesta" id="respuesta" class="form-control" value="<%= mensaje.getRespuesta() %>">
                                        <button class="btn btn-primary" type="submit" name="accion" value="responder">Responder</button>
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

                        List<Publicacion> publicaciones = publicacionDAO.obtenerPublicacionesPorUsuario(x);
                        request.setAttribute("publicaciones", publicaciones);

                        DAOFactory factory2 = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
                        CursoDAO cursoDAO = factory2.createCursoDAO();
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
                                    <th>Accion</th>
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
                                    <td>
                                        <a class="btn btn btn-secondary btn_add_tutoria" href="ServletPublicacion?accion=eliminar&id=<%= publicacion.getIdPublicacion()%>" role="button">Eliminar</a>
                                    </td>
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
