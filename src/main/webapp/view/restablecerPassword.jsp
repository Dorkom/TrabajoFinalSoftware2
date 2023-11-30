<%-- 
    Document   : restablecerPassword
    Created on : 17 oct. 2023, 14:17:14
    Author     : orope
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>:::Registro del Sistema:::</title>
        <link rel="stylesheet" href="Recursos/Bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="Recursos/CSSPropio/newcss.css"/>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


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
        <div class="header">
            <strong>Seguridad del Sistema</strong>
        </div>


        <div class="container">
            <div class="row centrado-vertical">
                <div class="col-md-6 text-center">
                    <!-- Columna de la imagen -->
                    <img src="Recursos/img/reset_pass.png" alt="Imagen de la persona" class="img-fluid">
                </div>
                <div class="col-md-6">
                    <!-- Columna del formulario de creación de cuenta -->
                    <h2>Actualizar Contraseña</h2>

                    <form name="formulario" method="post" id="formulario" action="../usuarioServlet">
                        <div class="form-group">
                            <label for="contrasena-actual">Contraseña Actual:</label>
                            <input type="password" class="form-control" id="contrasena-actual" name="passActual" placeholder="Ingresa tu contraseña actual">
                        </div>
                        <div class="form-group">
                            <label for="contrasena-nueva">Contraseña Nueva:</label>
                            <input type="password" class="form-control" id="contrasena-nueva" name="passNueva" placeholder="Ingresa tu contraseña nueva">
                        </div>
                        <div class="form-group">
                            <label for="confirmar-contrasena-nueva">Confirmar Contraseña Nueva:</label>
                            <input type="password" class="form-control" id="confirmar-contrasena-nueva" name="passNueva" placeholder="Confirma tu contraseña nueva">
                        </div>
                        <button class="btn btn-primary w-100" type="submit" name="accion" value="UpdatePass">Actualizar</button>
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
