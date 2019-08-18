<%-- 
    Document   : form_siswa
    Created on : Aug 5, 2019, 12:44:58 PM
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
        <title>KMS-App</title>
        <style>
            #formProfil {
                background: 0;
                background-color: #17171791;
            }
            #formProfil .row {
                padding-top: 30px;
                background: 0;
            }
        </style>
    </head>
    <body>
        <div class="container" id="formProfil">
            <h3 class="text-center">Informasi Siswa</h3>
            <div class="text-right">
                <button class="btn btn-warning" onclick="history.back()">Kembali</button>
            </div>
            <div class="row">
                <!-- edit form column -->
                <div class="col-lg-4 text-lg-center">
                    <form:form action="${pageContext.request.contextPath}/siswa/saveSiswa" method="post"
                               modelAttribute="siswa">
                        <label class="custom-file">Foto Profil Siswa</label>
                        <img id="fileProfil"  src="${imageDisplay}"
                             class="m-x-auto img-fluid img-circle" />
                    </div>

                    <div class="col-lg-8">
                        <div Class="form-group">
                            <form:hidden path="idSiswa"/>
                            <form:hidden path="idDaftar" />
                            <form:hidden path="idKonfirmasi" />

                            <label data-error="wrong" data-success="right" for="namaDaftar">Nama</label>
                            <form:input type="text" class="form-control form-control-sm" path="namaDaftar" readonly="true" />
                            <form:errors path="namaDaftar"></form:errors>
                            </div>
                            <div class="form-group">
                                <label data-error="wrong" data-success="right" for="emailDaftar">Email</label>
                            <form:input type="email" class="form-control form-control-sm" path="emailDaftar" readonly="true"/>
                            <form:errors path="emailDaftar"></form:errors>
                            </div>
                            <div Class="form-group">
                                <label data-error="wrong" data-success="right" for="tanggalLahir">Tanggal Lahir</label>
                            <form:input type="date" class="form-control form-control-sm" path="tanggalLahir" readonly="true"/>
                            <form:errors path="tanggalLahir"></form:errors>
                            </div>
                            <div class="form-group">
                                <label data-error="wrong" data-success="right" for="jenisKelamin">Jenis Kelamin</label>
                            <form:input type="text" class="form-control form-control-sm" path="jenisKelamin" readonly="true"/>
                            <form:errors path="jenisKelamin"></form:errors>
                            </div>
                            <div Class="form-group">
                                <label data-error="wrong" data-success="right" for="tempatTinggal">Tempat Tinggal</label>
                            <form:input type="text" class="form-control form-control-sm" path="tempatTinggal" readonly="true"/>
                            <form:errors path="tempatTinggal"></form:errors>
                            </div>
                            <div Class="form-group">
                                <label data-error="wrong" data-success="right" for="telepon">Telepon</label>
                            <form:input type="text" class="form-control form-control-sm" path="telepon" readonly="true"/>
                            <form:errors path="telepon"></form:errors>
                            </div>
                            <div class="form-group">
                                <label for="program" >Program</label>
                            <form:input type="text" class="form-control form-control-sm" path="namaProgram" readonly="true"/>
                        </div>
                        <div class="form-group">
                            <label for="kursus" >Kursus</label>
                            <form:input type="text" class="form-control form-control-sm" path="namaKursus" readonly="true"/>
                        </div>

                        <div class="form-group">
                            <label for="levelSelect" class="col-md-2">Level</label>
                            <form:input type="text" class="form-control form-control-sm" path="namaLevel" readonly="true"/>
                        </div>
                        <div Class="form-group">
                            <label for="bank">Bank</label>
                            <form:input type="text" class="form-control form-control-sm" path="namaBank" readonly="true"/>
                        </div>
                    </div>
                </form:form>

            </div>
        </div>
    </body>
</html>
