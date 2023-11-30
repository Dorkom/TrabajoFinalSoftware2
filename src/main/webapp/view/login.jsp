<%-- 
    Document   : login
    Created on : 25 set. 2023, 14:10:43
    Author     : orope
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>:::Bienvenido al Sistema::: Ingrese su Correo y Clave</title>
    <link rel="stylesheet" href="../Recursos/Bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../Recursos/CSSPropio/newcss.css"/>
    <script src="../Recursos/Bootstrap/js/bootstrap.min.js"></script>
    <script src="../Recursos/JsPropio/ValidaJS.js"></script>

    
    
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
                        <center><img src="../Recursos/img/logo2.jpg" alt="imagen" style="width: 300px; height: 220px;"></center>
                    </div>
                    
                    &nbsp;
    
                    <form name="formulario" method="post" id="formulario" action="../ServletInicioSesion">
                        <div class="form-group">
                            <label for="correo">Correo</label>
                            <input type="text" placeholder="Correo" name="correo" id="correo" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="clave">Contraseña</label>
                            <input type="password" placeholder="Contraseña" name="clave" id="clave" class="form-control">
                        </div>
                        
                        <div class="form-group">
                            <a href="CreacionCuenta.jsp">Registrarse.....</a>
                        </div>
    
                        <div class="form-group">
                            <a href="restablecerPassword.jsp">Restablecer Contraseña.....</a>
                        </div>
                        
                        <div class="form-group">
                            <button class="btn btn-primary w-100" type="button" onclick="ValidaLogin()">Ingresar</button>
                        </div>
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
