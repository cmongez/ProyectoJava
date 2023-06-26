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
        <title>Cargo</title>
    </head>

    <body>

        <header>
            <%@ include file="/WEB-INF/includes/navbar.jsp" %>
        </header>
        <!-- Hero -->
        <div class="h-100"><h2 class="text-center">CARGOS</h2>

            <div class="px-2 container ">
                <div class="d-flex justify-content-center  row">

                    <div class="col-12 col-md-6 table-responsive border p-0 ">
                        <a class="btn btn-success" href="/admin/cargo?opcion=crear">Crear</a>

                        <table class="table table-hover table-striped table-bordered ">
                            <thead>
                                <tr>
                                    <th>idCargo</th>
                                    <th>idTipoCargo</th>
                                    <th>Nombre Cargo</th>
                                    <th>Nombre Tipo Cargo</th>
                                    <th>op</th>

                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="cargo" items="${cargos}">
                                    <tr>


                                        <td>${cargo.getIdCargo()}</td>
                                        <td>${cargo.getIdTipoCargo()}</td>
                                        <td>${cargo.getNombreCargo()}</td>
                                        <td>${cargo.getNombreTipoCargo()}</td>
                                        <td><a class="btn btn-primary"
                                               href="/admin/cargo?opcion=editar&idCargo=${cargo.getIdCargo()}"><i class="fa-solid fa-pencil"></i></a><a
                                               class="btn btn-danger"
                                               href="/admin/cargo?opcion=eliminar&idCargo=${cargo.getIdCargo()}"> <i class="fa-regular fa-trash-can"></i> </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    
                </div>
            </div>
        </div>

        <!-- Hero -->
        <%@ include file="/WEB-INF/includes/footer.jsp" %>
    </body>

</html>