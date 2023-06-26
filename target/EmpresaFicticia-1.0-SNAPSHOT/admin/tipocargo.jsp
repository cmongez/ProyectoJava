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
            <title>Tipos de cargo</title>
        </head>

        <body>

            <header>
                <%@ include file="/WEB-INF/includes/navbar.jsp" %>
            </header>
            <!-- Hero -->
            <h2 class="text-center">TIPOS DE CARGO</h2>

            <div class="px-2 container ">
                <div class=" d-flex justify-content-center row">

                    <div class="col-12 col-md-6 table-responsive border p-0 ">
                        <a class="btn btn-success" href="/admin/tipocargo?opcion=crear">Crear</a>

                        <table class="table table-hover table-striped table-bordered ">
                            <thead>
                                <tr>
                                    <th>id</th>
                                    <th>Nombre</th>
                                    <th>Descripción</th>
                                    <th>Acción</th>

                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="tipoCargo" items="${tipoCargos}">
                                    <tr>
                                        

                                        <td>${tipoCargo.getIdTipoCargo()}</td>
                                        <td>${tipoCargo.getNombreTipoCargo()}</td>
                                        <td>${tipoCargo.getDescripcionTipoCargo()}</td>
                                        <td><a class="btn btn-success"
                                               href="/admin/tipocargo?opcion=editar&idTipoCargo=${tipoCargo.getIdTipoCargo()}"><i class="fa-solid fa-pencil"></i></a><a
                                                class="btn btn-danger"
                                                href="/admin/tipocargo?opcion=eliminar&idTipoCargo=${tipoCargo.getIdTipoCargo()}"><i class="fa-regular fa-trash-can"></i>
                                                </a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div >
                        <table class="table table-hover table-striped table-bordered ">
                            <thead>
                                <tr>
                                    <th>Nombre Tipo Cargo</th>
                                    <th>Cantidad</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="tipoCargoCantidad" items="${tipoCargosCantidad}">
                                    <tr>
                                        <td>${tipoCargoCantidad.getNombreTipoCargo()}</td>
                                        <td>${tipoCargoCantidad.getCantidadCargos()}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <div>
                        
                    </div>
                </div>
            </div>

            <!-- Hero -->
            <%@ include file="/WEB-INF/includes/footer.jsp" %>
        </body>

        </html>