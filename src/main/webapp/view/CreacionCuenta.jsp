<%-- 
    Document   : CreacionCuenta
    Created on : 17 oct. 2023, 08:50:12
    Author     : orope
--%>

<%@page import="dao.DAOFactory"%>
<%@page import="dao.TipoUsuarioDAO"%>
<%@page import="model.TipoUsuario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>:::Registro del Sistema:::</title>
        <link rel="stylesheet" href="../Recursos/Bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="../Recursos/CSSPropio/newcss.css"/>
        <script src="../Recursos/Bootstrap/js/bootstrap.min.js"></script>
        <script src="../Recursos/JsPropio/ValidaJS.js"></script>


        <style>
            .center-container {
                margin-top: 90px; /* Mueve el div 20 píxeles hacia abajo */

            }
            .centrado-vertical {
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }
        </style>
    </head>
    <body>
        <%
            List<TipoUsuario> tiposUsuario = new ArrayList<>();

            DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            TipoUsuarioDAO tipoUsuarioDAO = factory.createTipoUsuarioDAO();
            tiposUsuario = tipoUsuarioDAO.findAll();
        %>
        <div class="header">
            <strong>Seguridad del Sistema</strong>
        </div>


        <div class="container">
            <div class="row centrado-vertical">
                <div class="col-md-6 text-center">
                    <!-- Columna de la imagen -->
                    <img src="../Recursos/img/usuario_nuevo.png" alt="Imagen de la persona" class="img-fluid">
                </div>
                <div class="col-md-6">
                    <!-- Columna del formulario de creación de cuenta -->
                    <h2>Registro de Cuenta</h2>
                    <form name="formulario" method="post" id="formulario" action="../usuarioServlet">
                        <div class="form-group">
                            <label for="nombres">Nombres:</label>
                            <input type="text" placeholder="Nombres" name="nombre" id="nombres" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="apellidos">Apellidos</label>
                            <input type="text" placeholder="Apellidos" name="apellido" id="apellidos" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="correo">Correo:</label>
                            <input type="text" placeholder="Correo" name="correo" id="correo" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="clave">Contraseña:</label>
                            <input type="password" placeholder="Contraseña" name="clave" id="clave" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="rol">Rol:</label><br>
                            <select class="form-control" name="idTipoUsuario" id="">
                                <option value="-1">Seleccione Tipo</option>
                                <%                                        for (TipoUsuario c : tiposUsuario) {
                                %>
                                <option value="<%= c.getIdTipoUsuario()%>"><%= c.getDescripcion()%></option>
                                <%
                                    }
                                %>
                            </select>
                        </div>
                        <div class="form-group">
                            <button class="btn btn-primary w-100" type="submit" name="accion" value="Agregar">Agregar</button>
                        </div>
                        <div class="form-group">
                            <button class="btn btn-primary w-100" type="submit" name="accion" value="Volver">Volver</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

        <div class="footer">
            <strong>Universidad de Lima - Grupo 2</strong>
        </div> 
    </body>
</html>
