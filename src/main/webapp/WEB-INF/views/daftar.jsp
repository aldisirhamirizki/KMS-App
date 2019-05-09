<%-- 
    Document   : daftar
    Created on : May 6, 2019, 11:32:36 AM
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
        <link href="<c:url value="/static/bootstrap4/css/owl.carousel.css"/>" rel="stylesheet"/>
        <link href="<c:url value="/static/bootstrap4/css/animate.css"/>" rel="stylesheet"/>
        <link href="<c:url value="/static/bootstrap4/css/style.css"/>" rel="stylesheet"/>
        <title>KMS - App</title>
        <style>

            #tmbl {
                background-color: #232320;
            }
            #pencetan {
                position: relative;
                left: 80%;
            }
            .kartudaftar {
                max-width: 600px;
                position: relative;
                margin: auto;
                margin-top: 180px;
                width: 100%;
                display: table;
                -webkit-border-radius: 2px;
            }

            .kartudaftar .card-heading {
                background: url(../..//static/img/misa.jpg)top left/cover no-repeat;
                display: table-cell;
                width: 50%;
            }
            .kartudaftar .card-body {
                background-color: #232320;
                padding: 50px 25px;
                display: table-cell;
            }
            .input-group {
                margin: 5px;
                border-bottom: 1px solid rgba(225, 225, 225, 0.2);
            }
            .input-form {
                background: 0;
                border: 0;
            }

        </style>
    </head>
    <body>
        <nav class="navbar navbar-light fixed-bottom" id="tmbl">
            <button class="btn btn-outline-info" data-toggle="modal" id="pencetan" data-target="#formDaftar">Daftar sekarang</button>
        </nav>

        <!--modal-->
        <div class="modal" id="formDaftar" tabindex="-1" role="dialog">
            <div class="card kartudaftar">
                <div class="card-heading">
                </div>
                <div class="card-body">
                    <form method="POST">
                        <div class="input-group">
                            <input class="input-form" type="text" placeholder="nama" name="Nama">
                        </div>
                        <div class="input-group">
                            <input class="input-form" type="text" placeholder="email" name="Nama">
                        </div>
                        <div class="input-group">
                            <input class="input-form" type="text" placeholder="alamat" name="Nama">
                        </div>
                        <div class="input-group">
                            <input class="input-form" type="date" placeholder="tanggal lahir" name="Nama">
                        </div>
                        <div class="input-group">
                            <input class="input-form" type="text" placeholder="kursus" name="Nama">
                        </div>
                    </form>
                    <button class="btn btn-primary">Daftar</button>
                </div>
            </div>
        </div>
        <!--modal-->

    </body>
</html>
