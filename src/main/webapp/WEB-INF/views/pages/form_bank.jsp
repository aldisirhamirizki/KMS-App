<%-- 
    Document   : form_bank
    Created on : Jun 23, 2019, 8:19:47 PM
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
            <form:form action="${pageContext.request.contextPath}/bank/saveBank" method="POST" modelAttribute="bank">
                <div Class="form-group">
                    <form:hidden path="idBank"></form:hidden>
                        <label for="namaBank">Nama Bank</label>
                    <form:input cssClass="form-control" path="namaBank" />
                </div>
                <div class="form-group">
                    <label for="ket">Rekening</label>
                    <form:input cssClass="form-control" type="text"  path="rekening"/>
                </div>

                <button Class="btn btn-primary">Submit</button>
            </form:form>
        </div>
    </body>
</html>
