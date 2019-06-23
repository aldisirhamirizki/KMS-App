<%-- 
    Document   : form_kursus
    Created on : Jun 23, 2019, 6:56:19 PM
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
        <h1>FORM KURSUS</h1>
        <div class="container">
            <form:form action="${pageContext.request.contextPath}/kursus/saveKursus" method="POST" modelAttribute="kursus">
                <div Class="form-group">
                    <form:hidden path="idKursus"></form:hidden>
                        <label for="namaKursus">Nama Program</label>
                    <form:input cssClass="form-control" placeholder="masukan nama kursus" path="namaKursus" />
                </div>

                <button Class="btn btn-primary">Submit</button>
            </form:form>
        </div>
    </body>
</html>
