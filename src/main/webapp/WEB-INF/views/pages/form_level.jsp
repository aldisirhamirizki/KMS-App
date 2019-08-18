<%-- 
    Document   : form_level
    Created on : Jun 26, 2019, 4:28:27 PM
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
        <h1>FORM LEVEL</h1>
        <div class="container">
            <form:form action="${pageContext.request.contextPath}/level/saveLevel" method="POST" modelAttribute="level">
                <div Class="form-group">
                    <form:hidden path="idLevel"></form:hidden>
                        <label for="namaLevel">Nama Level</label>
                    <form:input cssClass="form-control" path="namaLevel" />
                </div>
                <div class="form-group">
                    <label for="keterangan">Keterangan</label>
                    <form:input cssClass="form-control" type="text"  path="keterangan"/>
                </div>
                <div class="form-group">
                    <label for="biaya">biaya</label>
                    <form:input cssClass="form-control" type="text"  path="biaya"/>
                </div>

                <button Class="btn btn-primary">Submit</button>
            </form:form>
        </div>
    </body>
</html>
