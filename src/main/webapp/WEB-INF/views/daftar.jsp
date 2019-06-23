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
    <title>KMS - App</title>
        <style>

 
            #tmbl {
                background-color: #232320;
            }
            #pencetan {
                position: relative;
                left: 80%;
            }
            .wrap {
                margin: auto;
                max-width: 600px;
            }
            .kartudaftar {
                position: relative;
                overflow: hidden;
                background: #232320;
                margin-top: 150px;
                width: 100%;
                display: table;
                border: 0;
                -webkit-border-radius: 8px;
            }

            .kartudaftar .card-heading {
                background: url(../..//static/img/misa.jpg)top left/cover no-repeat;
                display: table-cell;
                width: 50%;
            }
            .kartudaftar .card-body {
                padding: 25px 25px 50px;
                display: table-cell;
                -webkit-border-radius: 2px;
            }

            .title {
                color:#cdcbcb;
                text-align: center;
                margin-bottom: 30px;
            }
            .input-group {
                margin: 5px;
                border-bottom: 1px solid rgba(225, 225, 225, 0.2);
            }
            .kartudaftar .input-form {
                background: #232320;
                padding: 5px;
                border: 0;
                width: 250px;
            }
            input:valid {
                color: #cdcbcb;
            }

            #pilihan {
                background-color: #232320;
                border: 0;
            }

            #pilihan:valid {
                color: #cdcbcb;
            }
            ::placeholder {
                color: #cdcbcb;
            }
            

        </style>
    </head>
    <body>
        <nav class="navbar navbar-light fixed-bottom" id="tmbl">
            <button class="btn btn-outline-info" data-toggle="modal" id="pencetan" data-target="#formDaftar">Daftar sekarang</button>
        </nav>

        <!--modal-->
        <div class="modal" id="formDaftar" tabindex="-1" role="dialog">
            <div class="wrap">
                <div class="card kartudaftar">
                    <div class="card-heading">
                    </div>
                    <div class="card-body">
                        <h3 class="title">form pendaftaran</h3>
                        <form method="POST">
                            <div class="input-group">
                                <input class="input-form" type="text" placeholder="nama" name="Nama">
                            </div>
                            <div class="input-group">
                                <input class="input-form" type="text" placeholder="alamat" name="alamat">
                            </div>
                            <div class="input-group">
                                <input class="input-form" type="text" placeholder="email" name="email">
                            </div>
                            <div class="input-group">
                                <input class="input-form" type="tel" placeholder="telepon" name="telepon">
                            </div>
                            <div class="input-group">
                                <select class="custom-select" id="pilihan" name="program">
                                    <option selected>pilih program</option>
                                    <option value="1">Profesional</option>
                                    <option value="2">Hobi</option>
                                </select>
                            </div>
                            <div class="input-group">
                                <select class="custom-select" id="pilihan" name="kursus">
                                    <option selected>pilih kursus</option>
                                    <option value="1">vokal</option>
                                    <option value="2">gitar</option>
                                    <option value="2">bass</option>
                                    <option value="2">drum</option>
                                </select>
                            </div>
                        </form>
                        <button class="btn btn-primary">Daftar</button>
                    </div>
                </div>
            </div>
        </div>
        <!--modal-->

    </body>
</html>
