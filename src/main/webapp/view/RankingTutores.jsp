<%-- 
    Document   : RankingTutores
    Created on : 23 nov. 2023, 12:00:28
    Author     : brayan
--%>

<%@page import="dao.mysql.DTO.RankingTutoresDTO"%>
<%@page import="dao.CursoDAO"%>
<%@page import="dao.DAOFactory"%>
<%@page import="model.Curso"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Ranking de Tutores</title>
        <!-- Agrega el enlace a la hoja de estilos de Bootstrap -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    </head>
    <body>
        <%
            List<Curso> cursos = (List<Curso>) request.getAttribute("listaCursos");
            List<RankingTutoresDTO> listaRanking = (List<RankingTutoresDTO>) request.getAttribute("listaRanking");
        %>
        <div class="container mt-4">
            <h1>Ranking de Tutores</h1>

            <!-- Filtro por Curso -->
            <form action="ServletTutoria">
                <div class="form-group">
                    <label for="curso">Curso:</label>
                    <select class="form-control" name="idCurso" id="idCursoSelect">
                        <option value="-1">Seleccione Curso</option>
                        <%for (Curso c : cursos) {%>
                        <option value="<%= c.getIdCurso()%>"><%= c.getDescripcion()%></option>
                        <%}%>
                    </select>
                </div>
                <button type="submit" class="btn btn-primary" name="accion" value="vizualizarFiltro">Filtrar</button>
            </form>
            <!-- Botón para aplicar filtro -->

            <!-- Tabla de Ranking -->
            <table class="table mt-4">
                <thead>
                    <tr>
                        <th>ID Tutor</th>
                        <th>Nombre</th>
                        <th>Cantidad de Tutorías</th>
                        <th>Puntuación</th>
                        <th>Accion</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (RankingTutoresDTO r : listaRanking) {%>
                    <tr>
                        <td><%= r.getIdTutor()%></td>
                        <td><%= r.getNombre() + " " + r.getApellidos()%></td>
                        <td><%= r.getCantTutorias()%></td>
                        <td><%= r.getPromPuntuacion()%></td>
                        <td>
                            <a class="btn btn btn-secondary btn_add_tutoria" href="usuarioServlet?accion=verPerfil&id=<%= r.getIdTutor()%>" role="button">Ver Perfil</a>
                        </td>
                    </tr>
                    <% }%>
                </tbody>
            </table>

            <!-- Botón para visualizar todo el ranking sin filtro -->
            <a class="btn btn-primary" href="ServletTutoria?accion=vizualizar" role="button">Mostrar Ranking Completo</a>
        </div>

        <!-- Agrega el enlace a los scripts de Bootstrap y jQuery -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

        <!-- Agrega tus propios scripts aquí -->


    </body>
</html>

