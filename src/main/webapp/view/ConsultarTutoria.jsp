<%-- 
    Document   : ConsultarTutoria
    Created on : 27 nov. 2023, 14:08:01
    Author     : brayan
--%>

<%@page import="model.Tutoria"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Tutorías</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <style>
            body {
                background-color: #f8f9fa;
            }

            .card {
                border: 2px solid #000;
                border-radius: 20px;
                margin-bottom: 20px;
            }

            .card-header {
                background-color: #000;
                color: #fff;
                border-top-left-radius: 20px;
                border-top-right-radius: 20px;
            }
        </style>
    </head>
    <body>
        <%
            List<Tutoria> listaTutorias = (List<Tutoria>) request.getAttribute("tutorias");
        %>
        <div class="container mt-4">
            <h1 class="text-center mb-4">Tutorías</h1>

            <% for (Tutoria t : listaTutorias) {%>
            <div class="card">
                <div class="card-header">
                    <h5 class="mb-0"><%= t.getTema()%></h5>
                </div>
                <div class="card-body">
                    <p>Fecha: <%= t.getFecha()%></p>
                    <p>Hora de Inicio: <%= t.getHoraIni()%></p>
                    <p>Hora de Fin: <%= t.getHoraFin()%></p>
                    <a class="btn btn btn-secondary btn_add_tutoria" href="ServletTutoria?accion=registrarseTutoria&id=<%= t.getId()%>&IdTutor=<%= t.getIdTut()%>" role="button">Registrarse</a>
                </div>
            </div>
            <% }%>
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    </body>
</html>
