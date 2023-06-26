<%-- 
    Document   : index
    Created on : 26-may-2023, 18:44:14
    Author     : cmongez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="./css/styles.css">
        <title>Admin</title>
    </head>
    <body>

        <header>
            <%@ include file="/WEB-INF/includes/navbar.jsp" %>
        </header>
        <!-- Hero -->
        <main class="h-100 d-flex w-100 justify-content-center align-items-center flex-grow-1 container-fluid p-0 flex-column ">




            <section id="quienes-somos" class=" container-fluid w-100 d-flex justify-content-center">
                <div class="row gap-2 h-100">
                    <a href="/admin/trabajadores" class=" btn col-2 tiles bg-success p-2"><div class="   text-white ">Trabajadores</div></a>
                    <a href="/admin/cargo" class=" btn col-2  tiles bg-success p-2"><div class="   text-white  ">Cargos</div></a>
                    <a href="/admin/tipocargo" class=" btn col-2  tiles bg-success p-2"><div class="   text-white ">Tipos de cargo</div></a>
                    <%-- 
<a href="/admin/admin" class=" btn col-2  tiles bg-success p-2"><div class="   text-white  ">Admin</div></a>
--%>
                </div>
            </section>

        </main>

        <!-- Hero -->
        <%@ include file="/WEB-INF/includes/footer.jsp" %>
    </body>
</html>
