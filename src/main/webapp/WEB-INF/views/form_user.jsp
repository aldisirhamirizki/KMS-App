<%-- 
    Document   : form_admin
    Created on : Jun 21, 2019, 10:06:03 AM
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
        <link href="<c:url value="/static/bootstrap4/css/bootstrap.css"/>" rel="stylesheet">
        <title>KMS - App</title>
    </head>
    <body>
        <h1>FORM USER</h1>
        <div class="container">
            <form:form action="${pageContext.request.contextPath}/user/saveUser" method="POST" modelAttribute="user">
                <div Class="form-group">
                    <form:hidden path="idUser"></form:hidden>
                    <label for="namaUser">Nama User</label>
                    <form:input cssClass="form-control" placeholder="nama admin" path="namaUser" />
                </div>
                <div class="form-group">
                    <label for="emailUser">Email User</label>
                    <form:input cssClass="form-control" type="text" placeholder="email" path="emailUser"/>
                </div>
                <div class="form-group">
                    <label for="passwordUser">Password User</label>
                    <form:input cssClass="form-control" type="password" placeholder="password" path="passwordUser"/>
                </div>

                    <button Class="btn btn-primary">Daftar</button>
                </form:form>
        </div>

        <script src="<c:url value="/static/bootstrap4/jquery-3.3.1.min.js"/>"></script>
        <script src="<c:url value="/static/bootstrap4/js/bootstrap.js"/>"></script>
        <script src="<c:url value="/static/bootstrap4/popper.js"/>"></script>


    </body>
</html>
