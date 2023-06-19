<%-- 
    Document   : login
    Created on : 25-may-2023, 21:19:53
    Author     : cmongez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Iniciar sesión</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="../css/styles.css">

    </head>
    <body  >
        <header>
                        <%@ include file="/WEB-INF/includes/navbar.jsp" %>

        </header>
        <div class="container min-vh-100 h-100 d-flex justify-content-center align-items-center">
            <div class="p-4 col-10 card shadow-lg col-md-6"><h1 class="">Iniciar sesión</h1>
                <form action="login" method="POST" >
                    <div class="form-group">
                        <label for="correo">Correo electrónico</label>
                        <input type="email" class="form-control" id="correo" name="correo" placeholder="Ingrese su correo electrónico" required>
                    </div>
                    <div class="form-group">
                        <label for="contrasenia">Contraseña</label>
                        <input type="password" class="form-control" id="contrasenia" name="contrasenia" placeholder="Ingrese su contraseña" required>
                    </div>
                    <button type="submit" class="btn btn-primary mt-2">Iniciar sesión</button>
                </form>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    </body>
</html>
