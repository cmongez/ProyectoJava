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
        <title>JSP Page</title>
    </head>
    <body>

        <header>
            <%@ include file="/WEB-INF/includes/navbar.jsp" %>
        </header>
        <!-- Hero -->
        <main class="h-100 d-flex w-100 flex-grow-1 container-fluid p-0 flex-column">



            <section class="position-relative overflow-hidden w-100">
                <div class="d-flex min-vh-100 justify-content-center" lc-helper="video-bg">
                    <video style="z-index:1;object-fit: cover; object-position: 50% 50%;" class="position-absolute w-100 min-vh-100" autoplay="" preload="" muted="" loop="" playsinline="">
                        <!-- adjust object-position to tweak cropping on mobile -->
                        <source src="https://cdn.livecanvas.com/media/nature/video.mp4" type="video/mp4">
                    </video>
                    <div style="z-index:2" class="align-self-center text-center text-light ">
                        <div class="lc-block mb-4">
                            <div editable="rich">
                                <h1 class="display-1 fw-bolder">Empresa Ficticia</h1>
                            </div>
                        </div>

                        <div class="lc-block">
                            <div editable="rich">
                                <p class="lead">Somos una empresa Ficticia</p>

                                <p class="lead">Sim in vestibulum metus pulvinar sit amet.

                                </p>

                            </div>
                        </div>

                        <div class="lc-block">
                            <svg onclick="this.closest('section').nextElementSibling.scrollIntoView({behavior: 'smooth'});" width="4em" height="4em" viewBox="0 0 16 16" lc-helper="svg-icon" fill="currentColor" xmlns="http://www.w3.org/2000/svg" style="">
                            <path fill-rule="evenodd" d="M8 15A7 7 0 1 0 8 1a7 7 0 0 0 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"></path>
                            <path fill-rule="evenodd" d="M8 4a.5.5 0 0 1 .5.5v5.793l2.146-2.147a.5.5 0 0 1 .708.708l-3 3a.5.5 0 0 1-.708 0l-3-3a.5.5 0 1 1 .708-.708L7.5 10.293V4.5A.5.5 0 0 1 8 4z"></path>
                            </svg>

                            <!-- for Safari support only, remove if you want  -->
                            <script async="" src="https://unpkg.com/smoothscroll-polyfill/dist/smoothscroll.min.js"></script>

                        </div>
                    </div>
                </div>
            </section>
            <section id="quienes-somos" class="bg-warning bg-opacity-10">
                <div class="container">
                    <div class="row p-4 my-4">
                        <div class="col-lg-6 shadow-lg rounded rounded-3">
                            <h2 class="text-center">Quiénes somos</h2>
                            <p>Somos una empresa de desarrollo comprometida en proporcionar soluciones tecnológicas innovadoras y de alta calidad a nuestros clientes. Nuestro equipo está formado por profesionales altamente capacitados y apasionados por la tecnología.</p>
                            <p>En nuestra empresa, nos especializamos en el desarrollo de aplicaciones web y móviles personalizadas, el diseño de interfaces intuitivas y atractivas, y la implementación de soluciones de comercio electrónico efectivas.</p>
                            <p>Nos enorgullece ofrecer un enfoque personalizado a cada proyecto, trabajando estrechamente con nuestros clientes para comprender sus necesidades y brindarles soluciones a medida que impulsen su éxito en el mercado.</p>
                        </div>
                        <div class="col-lg-6 shadow-lg rounded rounded-3 p-0 m-0 d-flex justify-content-center align-items-center">
                            <img class="img-fluid " src="img/developers.png" alt="Equipo de trabajo">
                        </div>
                    </div>
                </div>
            </section>
            <section id="recruiting" class="bg-primary p-2 text-dark bg-opacity-10" >
                <div class="container">
                    <div class="row p-4 my-4">
                        <div class="col-lg-6 shadow-lg rounded rounded-3 p-0 m-0 d-flex justify-content-center align-items-center">
                            <img class="img-fluid " src="img/recruiting.jpg" alt="Equipo de trabajo">
                        </div>
                        <div class="col-lg-6 shadow-lg rounded rounded-3">
                            <h2 class="text-center">Reclutamiento de Profesionales y Equipos TI</h2>
                            <p>Te apoyamos en la incorporación de Profesionales IT a tu equipo. Colocamos toda nuestra experiencia al servicio de nuestros clientes simplificando el proceso de contratación y reduciendo la incertidumbre en la toma de decisiones.</p>

                        </div>

                    </div>
                </div>
            </section>

            <section id="perfiles" class="bg-warning bg-opacity-10">
                <div class="container">
                    <div class="row p-4 my-4">
                        <h2 class="text-center mb-4">Nuestros Perfiles</h2>

                        <div class="col-6 ">
                            <h3>Developers</h3>
                            <ul class="">
                                <li >Frontend</li>
                                <li >Backend</li>
                                <li >FullStack</li>
                                <li >Mobile Developers</li>
                            </ul>
                        </div>
                        <div class="col-6">
                            <h3>SRE / DevOps</h3>
                            <ul class="">
                                <li >DevOps Engineers</li>
                                <li >Cloud Engineers</li>
                                <li >Cloud Architects</li>
                            </ul>
                        </div>
                    </div>
                </div>
            </section>







        </main>








        <!-- Hero -->
        <%@ include file="/WEB-INF/includes/footer.jsp" %>
    </body>
</html>
