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
            <form class="container card p-4 mt-4 col-6" action="tipocargo" method="POST">
                <h2 class="text-center">${modoEditar ?"Editar tipo de cargo" : 'Crear tipo de cargo'}</h2>
                <input type="hidden" class="form-control" name="opcion" value="${modoEditar ? "actualizar" : 'agregar'}" id="exampleInputEmail1" required>

                <input type="hidden" class="form-control" name="idTipoCargo" value="${modoEditar ? tipoCargo.getIdTipoCargo() : ''}" id="exampleInputEmail1" required>



                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Nombre del cargo:</label>
                    <input type="text" value="${modoEditar ? tipoCargo.getNombreTipoCargo() : ''}" class="form-control" name="nombreTipoCargo" id="exampleInputEmail1" required
                           aria-describedby="emailHelp">
                </div>
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Descripción del cargo:</label>
                    <input type="text" value="${modoEditar ? tipoCargo.getDescripcionTipoCargo() : ''}" class="form-control" name="descripcionTipoCargo" id="exampleInputEmail1"
                           required aria-describedby="emailHelp">
                </div>


                <input type="submit" vañue="${modoEditar ?"Editar tipo de cargo" : 'Crear tipo de cargo'}" class="btn btn-primary"/>
            </form>
        </div>

        <!-- Hero -->
        <%@ include file="/WEB-INF/includes/footer.jsp" %>
    </body>

</html>