<%-- 
    Document   : form_konfirmasi
    Created on : Jul 17, 2019, 3:15:52 PM
    Author     : Aldis-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/static/bootstrap4/css/bootstrap.css"/>" rel="stylesheet" />
        <link href="<c:url value="/static/bootstrap4/css/style.css"/>" rel="stylesheet" />
        <style>
            .background {
                background-image: url("<c:url value="/static/img/guitarbackground.jpg" />");    
                padding-top: 50px;
                padding-bottom: 200px;
            }

            #fileBukti {
                width: 300px;
                height: 300px;
            }
            #formBukti {
                border-radius: 15px;
                background-image: url("<c:url value="/static/img/guitarbackground 1.jpg" />");
                padding-top:50px;
                padding-bottom: 50px;
            }
        </style>
    </head>
    <body>

        <jsp:include page="navbar2.jsp" />
        <div class="background">
            <div class="text-center">
                <h1>Silahkan Upload Bukti Pembayaran</h1>
            </div>
            <div class="container" >


                <form:form action="${pageContext.request.contextPath}/konfirmasi/saveKonfirmasi" 
                           modelAttribute="konfirmasiPembayaran" enctype="multipart/form-data" >
                    <div class="row" id="formBukti">
                        <form:hidden path="idKonfirmasi"></form:hidden>
                        <form:hidden path="idBank"></form:hidden>
                            <div class="col-md-4 text-md-right">
<!--                                <img class="img-fluid" id="fileBukti" src="${pageContext.request.contextPath}/konfirmasi/imageDisplay" />-->
                            <img class="img-fluid" id="fileBukti" src="${imageDisplay}" />
                            <p class="small">Max 500kb</p>
                            <form:input type="file" class="form-control" onchange="readURL(this, '#fileBukti');" path="imageBukti" />
                        </div>
                        <div class="col-md-7">
                            <div class="form-group">
                                <label>Id Siswa</label>
                                <form:input type="text" cssClass="form-control" path="idSiswa" readonly="true" />
                            </div>
                            <div class="form-group">
                                <label>Nama Siswa</label>
                                <form:input type="text" cssClass="form-control" path="namaDaftar" readonly="true" />
                            </div>
                            <div class="form-group">
                                <label>Bank</label>
                                <form:input type="text" cssClass="form-control" path="bank" readonly="true" />
                            </div>
                            <button type="submit" Class="btn btn-primary">Submit</button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
        <jsp:include page="footer.jsp" />
        <script src="<c:url value="/static/bootstrap4/jquery-3.3.1.min.js" />" ></script> 
        <script src="<c:url value="/static/bootstrap4/js/sweetalert2.all.js" />" ></script>
        <script>
            function readURL(input, imageId) {
                if (input.files && input.files[0]) {
                    var reader = new FileReader();

                    reader.onload = function (e) {
                        $(imageId).attr('src', e.target.result);
                    };

                    reader.readAsDataURL(input.files[0]);
                    console.log(input);
                    console.log(reader);
                    console.log(input.files[0]);
                }
            }

            function cekStatus() {
                let status = "${konfirmasiPembayaran.status}";

                if (status === "SUDAH BAYAR") {
                    Swal.fire({
                        title: 'Success',
                        text: 'Anda Sudah Terdaftar Sebagai Murid Kursus KMS',
                        type: 'success',
                        allowOutsideClick: false
                    }).then(function (result) {
                        if (result.value) {
                            window.location.href = "${pageContext.request.contextPath}/siswa/profil";
                        }
                    });
                }
            }

            cekStatus();


        </script>
    </body>
</html>
