<%-- 
    Document   : home
    Created on : Jun 27, 2019, 3:21:24 PM
    Author     : Aldis-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <link href="<c:url value="/static/bootstrap4/css/bootstrap.css"/>" rel="stylesheet"/>
    <style>
        #t1 {
            font-size: 70px;
            color: khaki;
        }
    </style>
</head>
<div class="text-center">
    <h1><span id="t1">S</span>elamat <span id="t1">D</span>atang</h1>
</div>
<div >
    <h3>Hy 
        <c:if test="${sessionModel.idUser != null}">
            ${sessionModel.namaUser}
        </c:if>, selamat datang Di Halaman Admin Kursus Musik<br>
        silahkan memilih menu untuk mengelola data
    </h3>

</div>