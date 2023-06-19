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
                <form class="container card p-4 mt-4 col-12 col-lg-8" action="cargo" method="POST">
                    <h2 class="text-center">${modoEditar ?"Editar cargo" : 'Crear cargo'}</h2>
                     <input type="hidden" class="form-control" name="opcion" value="${modoEditar ? "actualizar" : 'agregar'}" id="exampleInputEmail1" required>
                     
                     <input type="hidden" class="form-control" name="idCargo" value="${modoEditar ? cargo.getIdCargo() : ''}" id="exampleInputEmail1" required>



                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Nombre del cargo:</label>
                        <input type="text" value="${modoEditar ? cargo.getNombreCargo() : ''}" class="form-control" name="nombreCargo" id="exampleInputEmail1" required
                            aria-describedby="emailHelp">
                    </div>
                    <div class="mb-3">
                        <label for="idTipoCargo" class="form-label">Tipo cargo</label>
                        <select class="form-select" name="idTipoCargo" id="idTipoCargo" required>
                            <option value="">Seleccione un tipo de cargo</option>
                            <option value="1" ${modoEditar && cargo.getIdTipoCargo() == 1 ? 'selected' : ''}>Developer</option>
                            <option value="2" ${modoEditar && cargo.getIdTipoCargo() == 2 ? 'selected' : ''}>SRE / DevOps</option>
                        </select>
                    </div>


                    <input type="submit" vañue="${modoEditar ?"Editar cargo" : 'Crear cargo'}" class="btn btn-primary"/>
                </form>
            </div>

            <!-- Hero -->
            <%@ include file="/WEB-INF/includes/footer.jsp" %>
        </body>

        </html>