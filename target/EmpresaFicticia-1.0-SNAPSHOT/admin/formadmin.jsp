<%-- Document : index Created on : 26-may-2023, 18:44:14 Author : cmongez --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
              crossorigin="anonymous">
                   <link rel="stylesheet" type="text/css" href="../css/styles.css">

        <title>JSP Page</title>
    </head>

    <body>

        <header>
            <%@ include file="/WEB-INF/includes/navbar.jsp" %>
        </header>
        <!-- Hero -->

        <div class="container">
            <form class="container card p-4 mt-4 col-6" action="/admin" method="POST">
                <input type="hidden" class="form-control" name="opcion" value="${modoEditar ? "actualizar" : 'agregar'}" id="exampleInputEmail1" required>

                <h2 class="text-center">${modoEditar ? 'Editar admin' : 'Añadir admin'}</h2>

                <div class="mb-3 row">
                    <label for="exampleInputEmail1" class="col-12 form-label">${modoEditar ? 'Nueva contraseña' : 'Contraseña'} 
                        <c:if test="modoEditar"><span class="fw-lighter text-muted">(No puedes editar el rut)</span></c:if></label>
                        <div class="col-10  pe-1"> 
                            <input type="password" class="form-control" name="contrasenia" id="exampleInputEmail1" required aria-describedby="emailHelp">
                        </div>
                        
                </div>


                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Correo</label>
                    <input type="email" class="form-control" name="correo" id="exampleInputEmail1" required
                           aria-describedby="emailHelp" value="${modoEditar ? usuario.getCorreo() : ''}">
                </div>



                <input type="submit" value="${modoEditar? "Actualizar": "Crear"}" class="btn btn-primary">
            </form>
        </div>

        <!-- Hero -->
        <%@ include file="/WEB-INF/includes/footer.jsp" %>
    </body>

</html>