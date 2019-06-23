<%-- 
    Document   : login_admin
    Created on : Jun 21, 2019, 9:36:40 AM
    Author     : Aldis-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <div class="card loginAdmin">
            <div class="card-heading">
                <img src="<c:url value="/static/img/logo.png/"/>" class="img-fluid loginLogo"/>
            </div>
            <h3 class="title">Silahkan Login Jika Sudah Mendaftar</h3>
            <div class="card-body">
                <form method="POST">
                    <div class="input-group">
                        <input class="input-form" type="text" placeholder="email" name="Nama">
                    </div>
                    <div class="input-group">
                        <input class="input-form" type="text" placeholder="password" name="alamat">
                    </div>
                </form>
                <button class="btn btn-primary">Login</button>
                <a href="form_admin.jsp">Daftar Admin</a>
            </div>
        </div>


        <script src="<c:url value="/static/bootstrap4/jquery-3.3.1.min.js"/>"></script>
        <script src="<c:url value="/static/bootstrap4/js/bootstrap.js"/>"></script>
        <script src="<c:url value="/static/bootstrap4/popper.js"/>"></script>
    </body>
</html>
