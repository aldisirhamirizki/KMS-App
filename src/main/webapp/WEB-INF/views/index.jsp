<%-- 
    Document   : index
    Created on : Mar 31, 2019, 6:22:14 PM
    Author     : Aldis-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="<c:url value="/static/bootstrap4/css/bootstrap.css"/>" rel="stylesheet"/>
        <link href="<c:url value="/static/bootstrap4/css/owl.carousel.css"/>" rel="stylesheet"/>
        <link href="<c:url value="/static/bootstrap4/css/animate.css"/>" rel="stylesheet"/>
        <link href="<c:url value="/static/bootstrap4/css/style.css"/>" rel="stylesheet"/>
        <title>KMS - App</title>
    </head>
    <body>

        <!--navbar-->
        <nav class="navbar navbar-expand-md navbar-light navhome">
            <div class="container">    
                <a class="navbar-brand" href="#/">
                    <img src="<c:url value="/static/img/logo.png" />" alt="kms"/>
                </a>
            </div>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse " id="navbarNavAltMarkup">
                <div class="navbar-nav ml-auto">
                    <a class="nav-item nav-link active" href="#">Home <span class="sr-only">(current)</span></a>
                    <a class="nav-item nav-link" href="/KMS-App/keong/kursus/">Kursus</a>
                    <div class="dropdown">
                        <a class="nav-link dropdown" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" >
                            Program
                        </a>
                        <div class="dropdown-menu" id="drp">
                            <a class="dropdown-item" href="/KMS-App/keong/profesional/">Profesional</a>
                            <a class="dropdown-item" href="/KMS-App/keong/hobi/">Hobi</a>
                        </div>
                    </div>
                    <a class="nav-item nav-link" href="/KMS-App/keong/about/">About Us</a>
                    <a class="nav-item nav-link" href="/KMS-App/keong/">Login</a>
                </div>
            </div>
        </nav>
        <!--akhir navbar-->

        <!--Carousel-->
        <section class="hero-section">
            <div class="hero-slider owl-carousel">
                <div class="hs-item set-bg sp-pad" data-setbg="<c:url value="/static/img/chris.jpg"/>">
                    <div class="hs-text">
                        <h2 class="hs-title">Drummer</h2>
                        <p class="hs-des">Yang Handal <br>Profesional</p>
                    </div>
                </div>
                <div class="hs-item set-bg sp-pad" data-setbg="<c:url value="/static/img/kanami.png"/>">
                    <div class="hs-text">
                        <h2 class="hs-title">Gitaris</h2>
                        <p class="hs-des">Mainkan Ngebut Jarimu <br> Tanpa menggunakan helm</p>
                    </div>
                </div>
                <div class="hs-item set-bg sp-pad" data-setbg="<c:url value="/static/img/anthony.jpg"/>">
                    <div class="hs-text">
                        <h2 class="hs-title">Vokalis</h2>
                        <p class="hs-des">Multi Talenta <br> Menciptakan Lagu</p>
                    </div>
                </div>
                <div class="hs-item set-bg sp-pad" data-setbg="<c:url value="/static/img/boh.jpg"/>">
                    <div class="hs-text">
                        <h2 class="hs-title">Bassist</h2>
                        <p class="hs-des">Picking Popping <br>Slopping</p>
                    </div>
                </div>
            </div>
        </section>
        <!-- AkhirCarousel-->

        <!--deskripsi-->
        <section class="deskripsi">
            <div class="container">
                <h1>Selamat Datang Di KMS</h1>
                <p>kami tidak hanya melatih musik
                    kami melatih otak agar bisa berfikir, bagaimana cara mengatasi masalah, 
                    bagaimana berkolaborasi dengan musik, kami memberi harapan yang nyata,berlatih musik dengan suasana yang santai, 
                    dengan materi yang simpel dan juga efektif,
                    mendahulukan kreativitas. dengan pelatih yang ramah dan berpengalaman
                    untuk hobi maupun profesional</p>
            </div>
        </section>
        <!--akhir deskripsi-->

        <!--program hobi-->
        <section class="hobi" data-parallax="scroll" data-image-src="<c:url value="/static/img/hobi.jpg"/>">
            <div class="container">
                <h1>Hobi</h1>
                <p>memainkan alunan musik untuk menenangkan hati,<br> mainkan musik sesuai dengan suasana hati anda</p>
            </div>
        </section>
        <!--akhir program hobi-->

        <!--Level skill-->
        <section class="level">
            <div class="container">
                <h2>level</h2>
                <div class="row justify-content-center">
                    <div class="col-lg" id="skillmenu">
                        <h5>Beginner</h5>
                        <p>1 X Pertemuan seminggu<br>60 menit</p>
                    </div>
                    <div class="col-lg" id="skillmenu">
                        <h5>Competent</h5>
                        <p>2 X Pertemuan seminggu<br>60 menit</p>
                    </div>
                    <div class="col-lg" id="skillmenu">
                        <h5>Expert</h5>
                        <p>3 X Pertemuan seminggu<br>60 menit</p>
                    </div>
                </div>
            </div>
        </section>
        <!--Akhir Level skill-->

        <!--program profesional-->
        <section class="profesional" data-parallax="scroll" data-image-src="">
            <div class="container">
                <h1></h1>
                <p></p>
            </div>
        </section>
        <!--akhir program profesional-->

        <%@include file="footer.jsp" %>


        <script src="<c:url value="/static/bootstrap4/jquery-3.3.1.min.js"/>"></script>
        <script src="<c:url value="/static/bootstrap4/js/bootstrap.js"/>"></script>
        <script src="<c:url value="/static/bootstrap4/popper.js"/>"></script>
        <script src="<c:url value="/static/bootstrap4/js/script.js"/>"></script>
        <script src="<c:url value="/static/bootstrap4/js/owl.carousel.min.js"/>"></script>
        <script src="<c:url value="/static/bootstrap4/js/main.js"/>"></script>
        <script src="<c:url value="/static/bootstrap4/js/parallax.js"/>"></script>
    </body>
</html>
