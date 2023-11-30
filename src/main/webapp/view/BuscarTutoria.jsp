<%-- 
    Document   : BuscarTutoria
    Created on : 25 nov. 2023, 10:12:56
    Author     : brayan
--%>

<%@page import="dao.UsuarioDAO"%>
<%@page import="model.Usuario"%>
<%@page import="model.Tutoria"%>
<%@page import="dao.TutoriaDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="dao.CursoDAO"%>
<%@page import="dao.DAOFactory"%>
<%@page import="model.Curso"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="../Recursos/CSSPropio/newcss.css"/>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

        <!-- Opcional: Enlazar al archivo JavaScript de Bootstrap (si necesitas componentes interactivos) -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <meta charset="UTF-8">

        <!--<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">-->
        <title>Buscar tutoria</title>

        <style> body {
                text-align: center;
            } </style>
    </head>
    <body>
        <div class="container mt-5">

            <div class="row justify-content-center">
                <%
                    List<Curso> cursos = new ArrayList<>();
                    DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
                    CursoDAO cursoDAO = factory.createCursoDAO();
                    cursos = cursoDAO.findAll();
                %>
                <div class="col-md-6">
                    <div class="form-group">
                        <form action="../ServletTutoria">
                            <label for="cursos">Seleccionar curso</label>
                            <select class="form-control" name="idCurso" id="idCursoSelect">
                                <option value="-1">Seleccione Curso</option>
                                <%for (Curso c : cursos) {%>
                                <option value="<%= c.getIdCurso()%>"><%= c.getDescripcion()%></option>
                                <%}%>
                            </select>
                            <button type="submit" class="btn btn-primary" name="accion" value="buscarxcurso">Buscar por curso</button>
                        </form>
                    </div>
                    <div class="form-group">
                        <form action="../ServletTutoria">
                            <label for="titulo">Buscar por tema</label>
                            <input type="text" class="form-control" id="titulo" name="tema">
                            <button type="submit" class="btn btn-primary" name="accion" value="buscarxtema">Buscar por tema</button>
                        </form>
                    </div>
                </div>
            </div>

            <h1>Tutores</h1>


            <table class="table">
                <thead>
                    <tr>
                        <th>idUsuario</th>
                        <th>nombre</th>
                        <th>apellidos</th>
                        <th>correo</th>
                        <th>accion</th>
                    </tr>
                </thead>
                <tbody>
                    <% List<Usuario> listaUsuarios = (List<Usuario>) request.getAttribute("listaUsuarios"); %>
                    <% if (listaUsuarios != null) {  %>
                    <% for (Usuario usuario : listaUsuarios) {%>
                    <tr>
                        <td><%= usuario.getId()%></td>
                        <td><%= usuario.getNombres()%></td>
                        <td><%= usuario.getApellidos()%></td>
                        <td><%= usuario.getEmail()%></td>
                        <td>
                            
                            <a class="btn btn btn-secondary btn_add_tutoria" href="usuarioServlet?accion=verPerfil&id=<%= usuario.getId()%>" role="button">Ver Perfil</a>
                        </td>
                    </tr>
                    <% } %>
                    <% }%>
                </tbody>
            </table>
        </div>

    </div>
</body>
</html>
