<%-- 
    Document   : CrearTutoria
    Created on : 25 nov. 2023, 09:46:21
    Author     : brayan
--%>

<%@page import="model.Tutoria"%>
<%@page import="dao.TutoriaDAO"%>
<%@page import="dao.DAOFactory"%>
<%@page import="dao.CursoDAO"%>
<%@page import="model.Curso"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <title>Registro de Tutorías</title>
    </head>
    <body>
        <%
            List<Curso> cursos = new ArrayList<>();
            DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            CursoDAO cursoDAO = factory.createCursoDAO();
            cursos = cursoDAO.findAll();
            List<Tutoria> tutorias = new ArrayList<>();
            TutoriaDAO tutoriaDAO = factory.createTutoriaDAO();
            int x = (Integer.parseInt(String.valueOf(request.getSession().getAttribute("UsuarioCodigo"))));
            tutorias = tutoriaDAO.obtenerTutoriasPorIdTutor(x);
        %>
        <div class="container mt-4">
            <h2>Registro de Tutorías</h2>

            <!-- Formulario de registro -->
            <form action="ServletTutoria">
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="tema">Tema:</label>
                        <input type="text" class="form-control" id="tema" name="tema">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="fecha">Fecha:</label>
                        <input type="date" class="form-control" id="fecha" name="fecha">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="horaInicio">Hora de Inicio:</label>
                        <input type="time" class="form-control" id="horaInicio" name="horaInicio">
                    </div>
                </div>
                <div class="form-row">
                    <div class="form-group col-md-4">
                        <label for="horaFin">Hora de Fin:</label>
                        <input type="time" class="form-control" id="horaFin" name="horaFin">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="curso">Curso:</label>
                        <select class="form-control" name="idCurso" id="">
                            <option value="-1">Seleccione Curso</option>
                            <%for (Curso c : cursos) {%>
                            <option value="<%= c.getIdCurso()%>"><%= c.getDescripcion()%></option>
                            <%}%>
                        </select>
                    </div>
                    <div class="form-group col-md-4">
                        <button type="submit" class="btn btn-primary" name="accion" value="Guardar">Crear Tutoria</button>
                    </div>
                </div>
            </form>

            <!-- Tabla de registros -->
            <table class="table mt-4">
                <thead>
                    <tr>
                        <th>Tema</th>
                        <th>Fecha</th>
                        <th>Hora de Inicio</th>
                        <th>Hora de Fin</th>
                        <th>Curso</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <% for (Tutoria t : tutorias) {%>
                    <tr>
                        <td><%= t.getTema()%></td>
                        <td><%= t.getFecha()%></td>
                        <td><%= t.getHoraIni()%></td>
                        <td><%= t.getHoraFin()%></td>
                        <td><%= cursoDAO.NombreCurso(t.getIdCur())%></td>
                        <td></td>
                        <td>
                            <a class="btn btn btn-secondary btn_add_tutoria" href="ServletTutoria?accion=eliminar&id=<%= t.getId()%>" role="button">Eliminar</a>
                        </td>
                    </tr>
                    <% }%>
                </tbody>
            </table>
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script>

    </body>
</html>
