<%-- 
    Document   : about
    Created on : May 6, 2019, 8:11:57 AM
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
        <style>
            #nav-contact {
                margin-left: 35%;
                margin-top: 30px;
            }
            #nav-profile {
                margin-left: 30%;
                margin-top: 30px;
            }
        </style>
    </head>
    <body>

        <!--navbar-->
        <jsp:include page="navbar2.jsp"/>
        <!--akhir navbar-->

        <!--about-->
        <div class="container about-con">
            <nav>
                <div class="nav nav-tabs justify-content-center" id="about" role="tablist">
                    <a class="nav-item nav-link active" id="tab" data-toggle="tab" href="#nav- cara" role="tab" aria-selected="false">Cara Pendaftaran</a>
                    <a class="nav-item nav-link" id="tab" data-toggle="tab" href="#nav-contact" role="tab" aria-selected="false">Contact</a>
                    <a class="nav-item nav-link" id="tab" data-toggle="tab" href="#nav-profile" role="tab" aria-selected="false">Visi & Misi</a>
                </div>
            </nav>

            <div class="tab-content" id="nav-tabContent">
                <div class="tab-pane fade" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab">
                    <p>Alamat<br>Ciledug Raya, Kab.Tangerang, Banten 15151</p>
                    <p>Email<br>KMS@gmail.com</p>
                    <p>Telepon<br>+6281283746554</p>
                </div>
                <div class="tab-pane fade  show active" id="nav-cara" role="tabpanel" aria-labelledby="nav-contact-tab">
                    <p>1. Tekan tombol <b>LOGIN/DAFTAR</b> lalu pilih tab <b>REGISTER</b><br>
                        2. isi <b>NAMA, EMAIL</b> dan <b>PASSWORD</b> lalu <b>SIGN UP</b>, 
                        website akan mengeluarkan notifikasi dan akan kembali ke halaman utama<br>
                        3. Tekan tombol <b>LOGIN/DAFTAR</b> lalu pilih tab <b>LOGIN</b><br>
                        4. Masukan <b>EMAIL</b> dan <b>PASSWORD</b> dan pilih <b>LOGIN</b><br>
                        5. Pilih tombol <b>PROFIL</b> lalu isi <b>TANGGAL LAHIR, 
                            JENIS KELAMIN, TEMPAT TINGGAL, TELEPON, PROGRAM, KURSUS, LEVEL, BANK</b> lalu pilih <b>SUBMIT</b><br>
                        6. Anda akan menerima <b>EMAIL</b> dan segeralah melakukan pembayaran ke rekening yang diberikan di email<br>
                        7. <b>UPLOAD</b> bukti transfer dengan cara tekan tombol <b>KONFIRMASI PEMBAYARAN ANDA DISINI</b>
                        dan <b>UPLOAD</b> bukti transfer anda lalu <b>SUBMIT</b><br>
                        8. website akan kembali ke halaman profil dan <b>SELAMAT ANDA TELAH TERDAFTAR SEBAGAI SISWA KURSUS MUSIK</b>
                    </p>
                </div>
                <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
                    <p>VISI<br>Menciptakan regenerasi musisi yang handal dalam bermusik,<br>dan bisa menciptakan suatu karya musik yang berkualitas</p>
                    <p>MISI<br>&sstarf; Mendidik musisi untuk bermain musik dengan benar<br>
                        &sstarf; Meningkatkan dan mengasah bakat kemampuan dalam bermusik<br>
                        &sstarf; Mengajari cara berkarya beserta komposisi yang benar dalam bermusik<br>
                        &sstarf; Cepat dan berkualitas</p>
                </div>
            </div>
        </div>
        <!--about-->

        <%@include file="footer.jsp" %>
        <jsp:include page="daftar.jsp" />

        <script src="<c:url value="/static/bootstrap4/jquery-3.3.1.min.js"/>"></script>
        <script src="<c:url value="/static/bootstrap4/js/bootstrap.js"/>"></script>
        <script src="<c:url value="/static/bootstrap4/popper.js"/>"></script>
        <script src="<c:url value="/static/bootstrap4/js/parallax.js"/>"></script>
    </body>
</html>
