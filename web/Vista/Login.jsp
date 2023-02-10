<%-- 
    Document   : index
    Created on : 1 dic. 2022, 23:10:01
    Author     : kamir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

        <!--=============== FAVICON ===============-->
        <link rel="shortcut icon" href="assets/img/imgHomeInicio.png" type="image/x-icon">
        <!--=============== BOXICONS ===============-->
        <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
        <!--<script src="assets/js/sweetalert2.all.min.js" type="text/javascript"></script>-->
        <!--=============== SWIPER CSS ===============--> 
        <link rel="stylesheet" href="assets/css/swiper-bundle.min.css">

        <!--=============== CSS ===============-->
        <link rel="stylesheet" href="assets/css/styles.css">
        <title>SNYPAL</title>
    </head>
    <body>
        <!--==================== HEADER ====================-->
        <header class="header" id="header">
            <nav class="nav container">
                <a href="Controller?accion=main" class="nav__logo">
                    SNYPAL
                </a>

                <div class="nav__menu" id="nav-menu">
                    <ul class="nav__list">
                        <li class="nav__item">
                            <a href="Controller?accion=main" class="nav__link">Home</a>
                        </li>
                        <li class="nav__item">
                            <a href="#" class="nav__link active-link">Iniciar sesion</a>
                        </li>
                        <li class="nav__item">
                            <a href="Controller?accion=unirme" class="nav__link">Registrarme</a>
                        </li>
                    </ul>

                    <div class="nav__close" id="nav-close">
                        <i class='bx bx-x' ></i>
                    </div>
                </div>
                <div class="nav__btns">
                    <!-- Theme change button -->
                    <i class='bx bx-moon change-theme' id="theme-button"></i>

                    <!-- Toggle button -->
                    <div class="nav__toggle" id="nav-toggle">
                        <i class='bx bx-grid-alt' ></i>
                    </div>
                </div>

            </nav>
        </header>

        <!--==================== MAIN ====================-->
        <main class="main">
            <!--==================== HOME ====================-->
            <section class="home" id="home">
                <div class="home__container container grid">
                    <img src="img/tab/K41.png" alt="" class="home__img">

                    <div class="home__data" id="flogin">
                        <form action="#">
                            <h1 class="home__title">INICIAR SESION</h1>
                            <br>
                            <input type="text" placeholder="Usuario" class="message__input" name="user_input" id="user_input" required="true">
                            <input type="password" placeholder="Contraseña" class="message__input" name="password_input" id="password_input" required="true">
                            <!--<a class="link" href="#">¿Olvidaste tu contraseña?</a>-->
                            <br>
                            <br>
                            <button id="btn-ingresar" class="button" onclick="return false;">INGRESAR</button>
                        </form>
                    </div>
                </div>
            </section>            
        </main>


        <!--==================== FOOTER ====================-->
        <footer class="footer section">
            <span class="footer__copy">&#169; SNYPAL.<br> Todos los derechos reservados</span>
        </footer>


        <!--=============== SCROLL UP ===============-->
        <a href="#" class="scrollup" id="scroll-up"> 
            <i class='bx bx-up-arrow-alt scrollup__icon' ></i>
        </a>

        <!--=============== SCROLL REVEAL ===============-->
        <script src="assets/js/scrollreveal.min.js"></script>

        <!--=============== SWIPER JS ===============-->
        <script src="assets/js/swiper-bundle.min.js"></script>

        <!--=============== MAIN JS ===============-->
        <script src="assets/js/main.js"></script>
        
        
        <!--=============== LIBRERIA DE mensaje ===============-->
        <script src="//code.tidio.co/usqunzotejpnmqubyq7k4besxnuvvuqc.js" async></script>
        
        
        <!--=============== LIBRERIA DE ALERTAS ===============-->
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script src="Controller/Login.js" type="text/javascript"></script>
    </body>
</html>
