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

        <title>Trabajadores</title>
    </head>

    <body>

        <header>
            <%@ include file="/WEB-INF/includes/navbar.jsp" %>
        </header>
        <!-- Hero -->

        <div class="container-fluid">
            <form class="container-fluid card mt-4 p-4 col-12 col-lg-8 mb-4" action="/admin/trabajadores" method="POST">
                <input type="hidden" class="form-control" name="opcion" value="${modoEditar ? "actualizar" : 'agregar'}" id="exampleInputEmail1" required>

                <h2 class="text-center">${modoEditar ? 'Editar trabajador' : 'Añadir trabajador'}</h2>

                <div class="mb-3 row">
                    <label for="exampleInputEmail1" class="col-12 form-label">RUT 
                        <c:if test="modoEditar"><span class="fw-lighter text-muted">(No puedes editar el rut)</span></c:if></label>
                        <div class="col-10  pe-1"> 
                            <input type="text" class="form-control" ${modoEditar ? "readonly" : ''}  name="rut" id="exampleInputEmail1" required aria-describedby="emailHelp"
                               value="${modoEditar ? usuario.getRut() : ''}">
                    </div>
                    <div class="col-2 ps-1 d-flex"> 
                        <span class="pe-2">-</span>
                        <input type="text" class="form-control" name="dv" id="exampleInputEmail1" required
                               aria-describedby="emailHelp" ${modoEditar ? "readonly" : ''}  value="${modoEditar ? usuario.getDv() : ''}"></div> 
                </div>
                <div class="mb-3 row">
                    <div class="col-6"><label for="exampleInputEmail1" class="form-label">Nombres:</label>
                        <input type="text" class="form-control" name="nombres" id="exampleInputEmail1" required
                               aria-describedby="emailHelp" value="${modoEditar ? usuario.getNombres() : ''}"></div>
                    <div class="col">
                        <label for="exampleInputEmail1" class="form-label">Apellidos</label>
                        <input type="text" class="form-control" name="apellidos" id="exampleInputEmail1" required
                               aria-describedby="emailHelp" value="${modoEditar ? usuario.getApellidos() : ''}">
                    </div>

                </div>


                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Correo</label>
                    <input type="email" class="form-control" name="correo" id="exampleInputEmail1" required
                           aria-describedby="emailHelp" value="${modoEditar ? usuario.getCorreo() : ''}">
                </div>

                <div class="mb-3 row">
                    <div class="col-6"><label for="fechaNacimiento" class="form-label">Fecha nacimiento:</label>
                        <input type="date" class="form-control" name="fechaNacimiento" id="fechaNacimiento" required
                               aria-describedby="emailHelp" value="${modoEditar? usuario.getFechaNacimiento() : ''}"></div>
                    <div class="col-6">
                        <label for="genero" class="form-label">Género:</label>
                        <select class="form-select" name="genero" id="genero" required>
                            <option value="">Seleccionar género</option>
                            <option value="Femenino" ${modoEditar && usuario.getGenero().equals("Femenino") ? 'selected' : ''}>Femenino</option>
                            <option value="Masculino" ${modoEditar && usuario.getGenero().equals("Masculino") ? 'selected' : ''}>Masculino</option>
                            <option value="Otro" ${modoEditar && usuario.getGenero().equals("Otro") ? 'selected' : ''}>Otro</option>
                        </select>
                    </div>
                </div>



                <div class="mb-3 row">
                    <div class="col-6"><label for="exampleInputEmail1" class="form-label">Fecha contratación:</label>
                        <input type="date" class="form-control" name="fechaContratacion" id="exampleInputEmail1"
                               required aria-describedby="emailHelp" value="${modoEditar ? usuario.getFechaContratacion() : ''}"></div>
                    <div class="col-6">
                        <label for="idCargo" class="form-label">Cargo</label>
                        <select class="form-select" name="idCargo" id="idCargo" required>
                            <option value="">Seleccione un cargo</option>
                            <option value="1" ${modoEditar && usuario.getIdCargo() == 1 ? 'selected' : ''}>Frontend</option>
                            <option value="2" ${modoEditar && usuario.getIdCargo() == 2 ? 'selected' : ''}>Backend</option>

                            <option value="3" ${modoEditar && usuario.getIdCargo() == 3 ? 'selected' : ''}>FullStack</option>

                            <option value="4" ${modoEditar && usuario.getIdCargo() == 4 ? 'selected' : ''}>Cloud Engineer</option>
                        </select>
                    </div>
                </div>

                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Telefono</label>
                    <input type="text" class="form-control" name="telefonoUsuario" id="exampleInputEmail1" required
                           aria-describedby="emailHelp" value="${modoEditar? usuario.getTelefonoUsuario() : ''}">
                </div>

                <input type="submit" value="${modoEditar? "Actualizar": "Crear"}" class="btn btn-primary">
            </form>
        </div>

        <!-- Hero -->
        <%@ include file="/WEB-INF/includes/footer.jsp" %>
    </body>

</html>