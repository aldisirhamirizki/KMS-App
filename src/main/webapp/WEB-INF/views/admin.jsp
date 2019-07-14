<%-- 
    Document   : admin
    Created on : Jun 26, 2019, 11:59:25 AM
    Author     : Aldis-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html xmlns:th="http://www.thymeleaf.org">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="<c:url value="/static/bootstrap4/css/bootstrap.css"/>" rel="stylesheet"/>
        <title>KMS - App</title>
    </head>
    <body>
        <div class="container row">
            <div class="col-md-4">
                <a href="admin?hal=kursus">Kursus</a>
            </div>
            <div class="col-md-8">
                <c:choose>
                    <c:when test="${param.hal=='kursus'}">
                        <jsp:include page="${request.contextPath}/kursus/list_kursus"></jsp:include>
                    </c:when>
                </c:choose>
            </div>
        </div>

        <script src="<c:url value="/static/bootstrap4/jquery-3.3.1.min.js"/>"></script>
        <script src="<c:url value="/static/bootstrap4/js/bootstrap.js"/>"></script>
        <script src="<c:url value="/static/bootstrap4/popper.js"/>"></script>
    </body>
</html>
