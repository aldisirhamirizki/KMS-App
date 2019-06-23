<%-- 
    Document   : form_pendaftaran
    Created on : Jun 23, 2019, 9:06:07 PM
    Author     : Aldis-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="<c:url value="/static/bootstrap4/css/bootstrap.css"/>" rel="stylesheet"/>
        <title>KMS - App</title>
    </head>
    <body>

        <h1>FORM PENDAFTARAN</h1>
        <div class="container">
            <form:form action="${pageContext.request.contextPath}/pendaftaran/savePendaftaran" method="POST" modelAttribute="pendaftaran">
                <div Class="form-group">
                    <form:hidden path="idSiswa"></form:hidden>
                        <label for="namaSiswa">Nama Siswa</label>
                    <form:input cssClass="form-control" placeholder="masukan nama siswa" path="namaSiswa" />
                </div>
                <div class="form-group">
                    <label for="emailSiswa">Email Siswa</label>
                    <form:input cssClass="form-control" type="text" placeholder="masukan email" path="emailSiswa"/>
                </div>
                <div class="form-group">
                    <label for="passwordSiswa">Password</label>
                    <form:input cssClass="form-control" type="password" placeholder="password" path="passwordSiswa"/>
                </div>
                <div class="form-group">
                    <label for="teleponSiswa">Telepon</label>
                    <form:input cssClass="form-control" type="number" placeholder="masukan telepon" path="teleponSiswa"/>
                </div>
                <div class="form-group">
                    <label for="program">Program</label>
                    <form:input cssClass="form-control" type="" placeholder="---" path="program"/>
                </div>
                <div class="form-group">
                    <label for="program">Kursus</label>
                    <form:input cssClass="form-control" type="" placeholder="---" path="kursus"/>
                </div>

                <button Class="btn btn-primary">Submit</button>
            </form:form>
        </div>

        <script src="<c:url value="/static/bootstrap4/jquery-3.3.1.min.js"/>"></script>
        <script src="<c:url value="/static/bootstrap4/js/bootstrap.js"/>"></script>
        <script src="<c:url value="/static/bootstrap4/popper.js"/>"></script>
    </body>
</html>
