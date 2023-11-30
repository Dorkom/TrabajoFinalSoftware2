<%-- 
    Document   : CrearPublicacion
    Created on : 17 oct. 2023, 10:19:23
    Author     : orope
--%>

<%@page import="dao.CursoDAO"%>
<%@page import="dao.DAOFactory"%>
<%@page import="model.Curso"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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

        <title>Publicación Nueva</title>
        <style> body {
                text-align: center;
            } </style>
    </head>
    <body>
        <%
            List<Curso> cursos = new ArrayList<>();
            DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            CursoDAO cursoDAO = factory.createCursoDAO();
            cursos = cursoDAO.findAll();
        %>
        <div class="header">
            <strong>Seguridad del Sistema</strong>
        </div>
        <h1>Publicación Nueva</h1>

        <div class="container mt-5">
            <div class="row justify-content-center">
                <div class="col-md-6">
                    <form action="ServletPublicacion">
                        <div class="form-group">
                            <label for="titulo">Título</label>
                            <input type="text" class="form-control" id="titulo" name="titulo">
                        </div>
                        <div class="form-group">
                            <label for="cuerpo">Cuerpo</label>
                            <textarea class="form-control" id="cuerpo" name="cuerpo" rows="4"></textarea>
                        </div>
                        <div class="form-group">
                            <label for="cursos">Seleccionar curso</label>
                            <select class="form-control" name="idCurso" id="">
                                <option value="-1">Seleccione Curso</option>
                                <%for (Curso c : cursos) {%>
                                <option value="<%= c.getIdCurso()%>"><%= c.getDescripcion()%></option>
                                <%}%>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="fecha_publicacion">Fecha de Publicación:</label>
                            <input type="text" class="form-control" name="fecha" required>
                        </div>
                        <button type="submit" class="btn btn-primary" name="accion" value="Guardar">Guardar</button>
                    </form>
                </div>
            </div>

            <div class="footer">
                <strong>Universidad de Lima - Grupo 2</strong>
            </div>
    </body>
</html>
