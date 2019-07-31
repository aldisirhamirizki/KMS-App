<%-- 
    Document   : defaultMenu
    Created on : Jun 26, 2019, 9:12:29 PM
    Author     : Aldis-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<style>
    .nav-link {
        margin: 25px;
        text-align: center;
        -moz-box-shadow: 0px 10px 14px -7px #00abc2;
        -webkit-box-shadow: 0px 10px 14px -7px #00abc2;
        box-shadow: 0px 10px 14px -7px #00abc2;
        background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #61bde8), color-stop(1, #0096ad));
        background:-moz-linear-gradient(top, #61bde8 5%, #0096ad 100%);
        background:-webkit-linear-gradient(top, #61bde8 5%, #0096ad 100%);
        background:-o-linear-gradient(top, #61bde8 5%, #0096ad 100%);
        background:-ms-linear-gradient(top, #61bde8 5%, #0096ad 100%);
        background:linear-gradient(to bottom, #61bde8 5%, #0096ad 100%);
        filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#61bde8', endColorstr='#0096ad',GradientType=0);
        background-color:#61bde8;
        -moz-border-radius:8px;
        -webkit-border-radius:8px;
        border-radius:8px;
        display:inline-block;
        cursor:pointer;
        color:#ffffff;
        font-family:Arial;
        font-size:15px;
        font-weight:bold;
        padding:13px 32px;
        text-decoration:none;
        text-shadow:0px 1px 0px #116d8c;
    }
    .nav-link:hover {
        background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #0096ad), color-stop(1, #61bde8));
        background:-moz-linear-gradient(top, #0096ad 5%, #61bde8 100%);
        background:-webkit-linear-gradient(top, #0096ad 5%, #61bde8 100%);
        background:-o-linear-gradient(top, #0096ad 5%, #61bde8 100%);
        background:-ms-linear-gradient(top, #0096ad 5%, #61bde8 100%);
        background:linear-gradient(to bottom, #0096ad 5%, #61bde8 100%);
        filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#0096ad', endColorstr='#61bde8',GradientType=0);
        background-color:#0096ad;
    }
    .nav-link:active {
        position:relative;
        top:1px;
    }
    a:hover {
        color: white !important;
    }

</style>

<div class="nav-item">
    <a class="nav-link active" href="${pageContext.request.contextPath}/keong/admin">Home</a>
</div>
<div class="nav-item">
    <a class="nav-link" href="${pageContext.request.contextPath}/program/list_program">Program</a>
</div>
<div class="nav-item">
    <a class="nav-link" href="${pageContext.request.contextPath}/kursus/list_kursus">Kursus</a>
</div>
<div class="nav-item">
    <a class="nav-link" href="${pageContext.request.contextPath}/level/list_level">Level</a>
</div>
<div class="nav-item">
    <a class="nav-link" href="${pageContext.request.contextPath}/bank/list_bank">Bank</a>
</div>
<div class="nav-item">
    <a class="nav-link" href="${pageContext.request.contextPath}/siswa/list_siswa">Daftar Siswa</a>
</div>
<div class="nav-item">
    <a class="nav-link" href="${pageContext.request.contextPath}/konfirmasi/list_konfirmasi">Daftar Konfirmasi</a>
</div>
<div class="nav-item">
    <a class="nav-link" href="${pageContext.request.contextPath}/user/list_user">User</a>
</div>

<c:if test="${sessionModel.idUser != null}">
    <div class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/login/logoutAdmin">Logout</a>
    </div>
</c:if>

