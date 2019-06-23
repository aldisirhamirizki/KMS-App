<%-- 
    Document   : kursus
    Created on : May 1, 2019, 10:27:55 AM
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
        <nav class="navbar navbar-expand-md navbar-light navkursus">
            <div class="container">    
                <a class="navbar-brand" href="/KMS-App/keong/index/">
                    <img src="<c:url value="/static/img/logo.png" />" alt="kms"/>
                </a>
            </div>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse " id="navbarNavAltMarkup">
                <div class="navbar-nav ml-auto">
                    <a class="nav-item nav-link active" href="/KMS-App/keong/index/">Home</a>
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

        <!--vokal-->
        <div class="row vokal">
            <div class="col-md-5 offset-md-1">
                <img src="<c:url value="/static/img/saiki.jpg"/>" class="img-fluid gambar">
            </div>
            <div class="col-md-5">
                <h2>Vokal</h2>
                <p>
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                </p>
            </div>
        </div>
        <!--akhir vokal-->

        <!--gitar-->
        <div class="row gitar">
            <div class="col-md-5 offset-md-1">
                <h2>Gitar</h2>
                <p>
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                </p>
            </div>
            <div class="col-md-5">
                <img src="<c:url value="/static/img/jacky.jpg"/>" class="img-fluid gambar">
            </div>
        </div>
        <!--akhir gitar-->

        <!--bass-->
        <div class="row bass">
            <div class="col-md-5 offset-md-1">
                <img src="<c:url value="/static/img/misa.jpg"/>" class="img-fluid gambar">
            </div>
            <div class="col-md-5">
                <h2>Bass</h2>
                <p>
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                </p>
            </div>
        </div>
        <!--akhir bass-->

        <!--drum-->
        <div class="row drum">
            <div class="col-md-5 offset-md-1">
                <h2>Drum</h2>
                <p>
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                </p>
            </div>
            <div class="col-md-5">
                <img src="<c:url value="/static/img/lee.jpg"/>" class="img-fluid gambar">
            </div>
        </div>
        <!--akhir drum-->

        <%@include file="footer.jsp" %>

        <script src="<c:url value="/static/bootstrap4/jquery-3.3.1.min.js"/>"></script>
        <script src="<c:url value="/static/bootstrap4/js/bootstrap.js"/>"></script>
        <script src="<c:url value="/static/bootstrap4/popper.js"/>"></script>
    </body>
</html>
