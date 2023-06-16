<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-expand-lg bg-ficticia-secondary ficticia ">
    <div class="container-fluid">
        <a class="navbar-brand text-light" href="/">Ficticia</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav text-center text-light text-white">
                <li class="nav-item ">
                    <a class="nav-link active" aria-current="page" href="/">Inicio</a>
                </li>

                <c:if test="${empty sessionScope.usuario}">
                    <li class="nav-item">
                        <a class="nav-link" href="#quienes-somos">¿Quienes somos?</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#recruiting">Recruiting</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#perfiles">Perfiles</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/login">Login</a>
                    </li>
                </c:if>

                <c:if test="${not empty sessionScope.usuario}">

                    <li class="nav-item">
                        <a class="nav-link" href="/admin">Admin</a>
                    </li>
                   
                    <li class="nav-item">
                        <a class="nav-link" >${sessionScope.usuario}</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/logout">Logout</a>
                    </li>


                </c:if>
            </ul>
            
        </div>
    </div>
</nav>
