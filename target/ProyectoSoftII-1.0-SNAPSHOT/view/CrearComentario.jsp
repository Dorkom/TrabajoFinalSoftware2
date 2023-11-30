<%-- 
    Document   : CrearComentario
    Created on : 26 nov. 2023, 03:45:04
    Author     : brayan
--%>

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
                <div class="col-md-6">
                    <div class="form-group">
                        <form action="/ProyectoSoftII/usuarioServlet">
                            <label for="clave">COMENTARIO</label>
                            <input type="text" class="form-control" name="comentarioname" id="comentarioid">
                            <button class="btn btn-primary btn-sm float-right mt-2" type="submit" name="accion" value="CrearComentario">Subir comentario</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
