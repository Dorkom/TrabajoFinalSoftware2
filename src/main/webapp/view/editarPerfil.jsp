<%-- 
    Document   : editarPerfil
    Created on : 15 oct. 2023, 23:15:13
    Author     : orope
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta charset="UTF-8">
        <title>Editar perfil</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="Recursos/CSSPropio/editar.css"/>
        <link rel="stylesheet" href="Recursos/CSSPropio/newcss.css"/>

    </head>
    <body>
        <div class="header">
            <strong>Seguridad del Sistema</strong>
        </div>
        <div class="center-container">
            <div class="container">
                <div class="row">
                    <div class="col-md-4 offset-md-4">
                        <div>
                            <center><img src="https://cdn-icons-png.flaticon.com/512/1/1663.png" alt="imagen" style="width: 300px; height: 220px;"></center>
                        </div>
                        &nbsp;
                        <form action="../usuarioServlet">
                            <div class="form-group">
                                <label for="nombre">Nombres:</label>
                                <input type="text" placeholder="Nombres" name="nombre" id="nombre" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="apellido">Apellidos</label>
                                <input type="text" placeholder="Apellidos" name="apellido" id="apellido" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="correo">Correo:</label>
                                <input type="text" placeholder="Correo" name="correo" id="correo" class="form-control">
                            </div>
                            <div class="campo">
                                <label for="tipo-estudiante">Tipo de estudiante:</label>
                                <select name="tipo-estudiante" id="tipo-estudiante">
                                    <option value="1">Normal</option>
                                    <option value="2">Experto</option>
                                </select>
                            </div>
                            <button class="btn btn-primary w-100" type="submit" name="accion" value="Guardar">Guardar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="footer">
            <strong>Universidad de Lima - Grupo 2</strong>
        </div>
    </body>
</html>