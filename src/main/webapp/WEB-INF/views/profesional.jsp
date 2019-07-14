<%-- 
    Document   : profesional
    Created on : May 4, 2019, 9:51:43 PM
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
        <jsp:include page="navbar.jsp"/>
        <!--akhir navbar-->

        <!--parallax-->
        <section class="hobiprlx" data-parallax="scroll" data-image-src="<c:url value="/static/img/hyde.jpg"/>">
            <h1>program profesional</h1>
        </section>
        <!--parallax-->

        <!--deskripsi-->
        <section class="desk">
            <div class="container justify-content-center">
                <p>
                    Lorem ipsum dolor sit amet, consectetur adipisicing elit, 
                    sed do eiusmod tempor incididunt ut labore et dolore magna 
                    aliqua. Ut enim ad minim veniam, quis nostrud exercitation 
                    ullamco laboris nisi ut aliquip ex ea commodo consequat. 
                    Duis aute irure dolor in reprehenderit in voluptate velit 
                    esse cillum dolore eu fugiat nulla pariatur. Excepteur sint
                    occaecat cupidatat non proident, sunt in culpa qui officia 
                    deserunt mollit anim id est laborum.
                </p>
            </div>
        </section>
        <!--deskripsi-->

        <!--jadwal-->
        <section class="jadwal">
            <div class="container">
                <h2>Jadwal</h2>
                <div class="row">
                    <div class="col-lg" id="daftar">
                        <h5>Beginner</h5>
                        <p>1 X Pertemuan seminggu<br>60 menit</p>
                    </div>
                    <div class="col-lg" id="daftar">
                        <h5>Competent</h5>
                        <p>2 X Pertemuan seminggu<br>60 menit</p>
                    </div>
                    <div class="col-lg" id="daftar">
                        <h5>Expert</h5>
                        <p>3 X Pertemuan seminggu<br>60 menit</p>
                    </div>
                </div>
                <button class="btn btn-outline-primary" id="tombol">Daftar</button>
            </div>
        </section>
        <!--jadwal-->

        <%@include file="footer.jsp" %>

        <script src="<c:url value="/static/bootstrap4/jquery-3.3.1.min.js"/>"></script>
        <script src="<c:url value="/static/bootstrap4/js/bootstrap.js"/>"></script>
        <script src="<c:url value="/static/bootstrap4/popper.js"/>"></script>
        <script src="<c:url value="/static/bootstrap4/js/parallax.js"/>"></script>
    </body>
</html>
