<%-- 
    Document   : navbar2
    Created on : Jul 1, 2019, 11:30:37 AM
    Author     : Aldis-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<nav class="navbar navbar-expand-md navbar-light navkursus">
    <div class="container">    
        <a class="navbar-brand" href="${pageContext.request.contextPath}/keong/index/">
            <img src="<c:url value="/static/img/logo.png" />" alt="kms"/>
        </a>
    </div>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse " id="navbarNavAltMarkup">
        <div class="navbar-nav ml-auto">
            <c:if test="${sessionModel.idDaftar != null}">
                <a class="nav-item nav-link" href="${pageContext.request.contextPath}/siswa/profil">Profil</a>
            </c:if>
            <a class="nav-item nav-link active" href="${pageContext.request.contextPath}/keong/index/">Home</a>
            <a class="nav-item nav-link" href="${pageContext.request.contextPath}/keong/kursus/">Kursus</a>
            <div class="dropdown">
                <a class="nav-link dropdown" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" >
                    Program
                </a>
                <div class="dropdown-menu" id="drp">
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/keong/profesional/">Profesional</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/keong/hobi/">Hobi</a>
                </div>
            </div>
            <a class="nav-item nav-link" href="${pageContext.request.contextPath}/keong/about">About Us</a>
            <c:choose>
                <c:when test="${sessionModel.idDaftar == null}">
                    <a class="nav-item btn btn-info" href="" data-toggle="modal" data-target="#modalLRForm">Daftar/Login</a>
                </c:when>
                <c:otherwise>
                    <a class="nav-item btn btn-danger" href="${pageContext.request.contextPath}/login/logout">Logout</a>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</nav>
