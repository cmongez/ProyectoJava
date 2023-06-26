<%-- Document : index Created on : 26-may-2023, 18:44:14 Author : cmongez --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ES">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
              crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="../css/styles.css">
        <title>Trabajadores</title>
    </head>

    <body>

        <header>
            <%@ include file="/WEB-INF/includes/navbar.jsp" %>
        </header>
        <!-- Hero -->
        <h2 class="text-center">TRABAJADORES</h2>

        <div class="px-4 container">
            <div class=" row">
                <div class=" table-responsive border p-0">
                    <a class="btn btn-success" href="/admin/trabajadores?opcion=crear">Crear</a>
                    <table class="col-12 table table-hover table-striped table-bordered ">
                        <thead>
                            <tr>
                                <th>Nombres</th>
                                <th>Apellidos</th>
                                <th>RUT</th>
                                <th>Correo</th>
                                <th>Fecha Nacimiento</th>
                                <th>Genero</th>
                                <th>Fecha contratación</th>
                                <th>Telefono</th>
                                <th>Acción</th>


                            </tr>

                        </thead>
                        <tbody>

                            <c:forEach var="usuario" items="${usuarios}">
                                <tr>
                                    
                                    <td>${usuario.getNombres()}</td>
                                    <td>${usuario.getApellidos()}</td>
                                    <td>
                                        <div class="d-flex">${usuario.getRut()}-${usuario.getDv()}</div>
                                    </td>

                                    <td>${usuario.getCorreo()}</td>

                                    <td>${usuario.getFechaNacimiento()}</td>
                                    <td>${usuario.getGenero()}</td>
                                    <td>${usuario.getFechaContratacion()}</td>
                                    <td>${usuario.getTelefonoUsuario()}</td>
                                    <td><a class="btn btn-primary"
                                           href="/admin/trabajadores?opcion=editar&rutUsuario=${usuario.getRut()}"><i class="fa-solid fa-pencil"></i></a><a
                                           class="btn btn-danger"
                                           href="/admin/trabajadores?opcion=eliminar&rutUsuario=${usuario.getRut()}"><i class="fa-regular fa-trash-can"></i> </a>
                                    </td>
                                </tr>

                            </c:forEach>

                        </tbody>
                    </table>

                </div>
            </div>
        </div>

        <!-- Hero -->
        <%@ include file="/WEB-INF/includes/footer.jsp" %>
    </body>

</html>