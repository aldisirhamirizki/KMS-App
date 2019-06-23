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

        <h1>FORM BANK</h1>
        <div class="container">
            <form:form action="${pageContext.request.contextPath}/bank/saveBank" method="POST" modelAttribute="bank">
                <div Class="form-group">
                    <form:hidden path="idBank"></form:hidden>
                        <label for="namaBank">Nama Bank</label>
                    <form:input cssClass="form-control" placeholder="masukan nama bank" path="namaBank" />
                </div>
                <div class="form-group">
                    <label for="rekening">Rekening</label>
                    <form:input cssClass="form-control" type="text" placeholder="rekening" path="rekening"/>
                </div>

                <button Class="btn btn-primary">Submit</button>
            </form:form>
        </div>

        <script src="<c:url value="/static/bootstrap4/jquery-3.3.1.min.js"/>"></script>
        <script src="<c:url value="/static/bootstrap4/js/bootstrap.js"/>"></script>
        <script src="<c:url value="/static/bootstrap4/popper.js"/>"></script>
    </body>
</html>
