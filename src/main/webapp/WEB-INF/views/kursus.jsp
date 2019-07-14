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
         <jsp:include page="navbar2.jsp"/>
        <!--akhir navbar-->

        <!--vokal-->
        <div class="row vokal">
            <div class="col-md-5 offset-md-1">
                <img src="<c:url value="/static/img/saiki.jpg"/>" class="img-fluid gambar">
            </div>
            <div class="col-md-5">
                <h2>Vokal</h2>
                <p>
                    Sebagai seorang penyanyi yang menjadi nahkoda dari sebuah performa musik band,
                    harus memiliki jiwa leadership di atas panggung. Dan penyanyi harus memiliki basic
                    vocal yang baik, memiliki suara yang jelas dan jernih serta tidak fals, dan dapat 
                    mengharmonikan diri dengan paduan suara alat musik yang lain
                </p>
            </div>
        </div>
        <!--akhir vokal-->

        <!--gitar-->
        <div class="row gitar">
            <div class="col-md-5 offset-md-1">
                <h2>Gitar</h2>
                <p>
                Gitaris adalah pemusik yang memainkan alat musik gitar atau yang berprofesi sebagai pemain gitar.
                Seorang gitaris dapat bermain solo atau gitar tunggal, duet, maupun bergabung dalam sebuah grup musik atau grup band.
                Perkembangan dunia gitar rock di Indonesia diawali oleh munculnya gitaris-gitaris seperti Ian Antono dalam band God Bless. 
                Eet Sjahranie , John Paul Ivan, Andra Ramadhan, andry Muhammad, Beng beng , Aria Baron, Puguh Kribo Dan masih banyak lagi
                legenda dari luar negeri seperti Jimi Hendrix, Wes Montgomery, Stevie Ray Vaughan, Eddie Van Halen, Ritchie blackmore, 
                Ritchie sambora, Steve vai, Joe Satriani, Yngwie J Malmsteen, Paul Gilbert, Eric Johnson, Gary Moore, B.B king, Eric Clapton   
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
                secara teknis bass adalah instrumen yang paling mampu memperlihatkan teknik dari sebuah lagu y
                ang sesungguhnya. Bassist juga memiliki peran penting dalam membangun arah harmonik dan melodi musik. 
                Penelitian lain yang dilakukan Universitas Northwestern, telah menemukan bahwa suara bass lebih 
                efektif untuk memberikan efek menginspirasi dan memainkan perasaan penonton.   
                </p>
            </div>
        </div>
        <!--akhir bass-->

        <!--drum-->
        <div class="row drum">
            <div class="col-md-5 offset-md-1">
                <h2>Drum</h2>
                <p>
                Drum adalah jenis alat musik perkusi yang digunakan sebagai penuntuk ketukan bagi alat musik lainnya, 
                sehingga dalam suatu kelompok musik (group band) akan tercipta suatu harmonisasi suara yang kompak.
                Untuk menjadi seorang pemain drum yang ahli dibutuhkan proses belajar yang tepat, dengan kurikulum yang 
                dirancang secara tepat, dan yang terutama dibimbing oleh guru yang kompeten, profesional, serta ramah.
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
