<%-- 
    Document   : index
    Created on : 1 dic. 2022, 23:10:01
    Author     : kamir
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!--=============== FAVICON ===============-->
        <link rel="shortcut icon" href="assets/img/imgHomeInicio.png" type="image/x-icon">

        <!--=============== BOXICONS ===============-->
        <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">

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
                <a href="#" class="nav__logo">
                    SNYPAL
                </a>

                <div class="nav__menu" id="nav-menu">
                    <ul class="nav__list">
                        <li class="nav__item">
                            <a href="#home" class="nav__link active-link">Home</a>
                        </li>
                        <li class="nav__item">
                            <a href="Controller?accion=iniciar-sesion" class="nav__link ">Iniciar sesion</a>
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

                    <div class="home__data">
                        <h1 class="home__title">Bienvenido a<br> SNYPAL!</h1>
                        <p class="home__description">
                            Desarrolladores enfocados en la organazacion de nuestros clientes.
                        </p>
                        <a href="Controller?accion=iniciar-sesion" class="button">INICIAR SESION</a>
                    </div>
                </div>
            </section>


            <!--==================== FOOTER ====================-->
            <footer class="footer section">
                <span id="tag-id" class="footer__copy">&#169; SNYPAL<br> Todos los derechos reservados</span>
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
            <script src="//code.tidio.co/usqunzotejpnmqubyq7k4besxnuvvuqc.js" async></script>
            <script src="assets/js/foto.js" type="text/javascript"></script>



            <!--<button id="upload_widget" class="cloudinary-button">Upload files</button>-->

            <script src="https://upload-widget.cloudinary.com/global/all.js" type="text/javascript"></script>  

            <script type="text/javascript">
                var myWidget = cloudinary.createUploadWidget({
                    cloudName: 'dtzp3trnp',
                    uploadPreset: 'preset_ant'}, (error, result) => {
                    if (!error && result && result.event === "success") {
                        const imagen = document.querySelector('#imagen_bd');
                        console.log('Done! Here is the image info: ', result.info);
                        document.getElementById('tag-id').innerHTML = result.info.secure_url;
                        imagen.src = result.info.secure_url;
                    }
                }
                )

                document.getElementById("upload_widget").addEventListener("click", function () {
                    myWidget.open();
                }, false);
            </script>


    </body>
</html>
