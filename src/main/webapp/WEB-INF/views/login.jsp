<%-- 
    Document   : login
    Created on : May 12, 2019, 10:54:47 AM
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
            .wrapp  {
                margin: auto;
                max-width: 600px;
            }
            .kartuLogin {
                background-color: #232320;
                position: relative;
                overflow: hidden;
                margin-top: 75px;
                height: 500px;
            }
            .kartuLogin .card-heading{
                text-align: center;
            }
            .kartuLogin .card-heading .loginLogo{
                width: 50%;
                margin: 20px 0 0 0;
            }
            .kartuLogin h3 {
                margin: 0;
                margin-top: 20px;
            }
            .kartuLogin .card-body {
                margin: 20px 40px;
            }
            .kartuLogin .input-group {
                margin-bottom: 15px;
            }
            .kartuLogin .input-form {
                background: #232320;
                border: 0;
                width: 100%;
            }
            
        </style>
    </head>
    <body>

        <!--modal-->
        <div class="modal" id="formLogin" tabindex="-1" role="dialog">
            <div class="wrapp">
                <div class="card kartuLogin">
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
                    </div>
                </div>
            </div>
        </div>
        <!--modal-->



    </body>
</html>
