<%-- 
    Document   : login_admin
    Created on : Jun 21, 2019, 9:36:40 AM
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
        <style>
            body {
                background: linear-gradient(-45deg, #EE7752, #E73C7E, #23A6D5, #23D5AB);
                background-size: 400% 400%;
                -webkit-animation: Gradient 15s ease infinite;
                -moz-animation: Gradient 15s ease infinite;
                animation: Gradient 15s ease infinite;
            }

            @-webkit-keyframes Gradient {
                0% {
                    background-position: 0% 50%
                }
                50% {
                    background-position: 100% 50%
                }
                100% {
                    background-position: 0% 50%
                }
            }

            @-moz-keyframes Gradient {
                0% {
                    background-position: 0% 50%
                }
                50% {
                    background-position: 100% 50%
                }
                100% {
                    background-position: 0% 50%
                }
            }

            @keyframes Gradient {
                0% {
                    background-position: 0% 50%
                }
                50% {
                    background-position: 100% 50%
                }
                100% {
                    background-position: 0% 50%
                }
            }

            .card {
                background-color: #ffc1c159;
            }
        </style>
    </head>
    <body>
        <div class="container py-5">
            <div class="row">
                <div class="col-md-12">
                    <h2 class="text-center mb-4">Silahkan Login</h2>
                    <div class="row">
                        <div class="col-md-5 mx-auto">

                            <!-- form card login -->
                            <div class="card rounded-0">
                                <div class="card-header bg-dark">
                                    <a class="navbar-brand">
                                        <img class="img-fluid" width="75" src="<c:url value="/static/img/logo.png" />"/>
                                    </a>
                                </div>
                                <div class="card-body">
                                    <form:form action="${pageContext.request.contextPath}/login/adminLogin" modelAttribute="login2" method="POST">
                                        <form:hidden path="idUser"></form:hidden>
                                        <form:hidden path="namaUser"></form:hidden>
                                            <div class="form-group">
                                                <label>Email</label>
                                            <form:input type="email" id="emailLogin" cssClass="form-control form-control-lg rounded-0" path="emailUser"/>
                                        </div>
                                        <div class="form-group">
                                            <label>Password</label>
                                            <form:input type="password" id="passwordLogin" cssClass="form-control form-control-lg rounded-0" path="passwordUser"/>
                                        </div>
                                        <button class="btn btn-success btn-lg float-right">Login</button>
                                    </form:form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="<c:url value="/static/bootstrap4/js/sweetalert2.all.js"/>"></script>
        <script src="<c:url value="/static/bootstrap4/jquery-3.3.1.min.js"/>"></script>


        <script>

            $('#login2').submit(function (e) {
                e.preventDefault();
                let form = $(this);
                let url = form.attr('action');

                // inisialisasi idUser & namaUser
                form.find('input:hidden[id="idUser"]').val("INIT_VALUE");
                form.find('input:hidden[id="namaUser"]').val("INIT_VALUE");
                console.log("Serialize: " + form.serialize());
                $.ajax({
                    type: "POST",
                    url: url,
                    data: form.serialize(),
                    success: function (data)
                    {
                        console.log("Login Response: " + data);
                        let responseData = JSON.parse(data);

                        console.log("Login Response Object: " + JSON.stringify(responseData));
                        if (responseData.status === "SUCCESS") {
                            Swal.fire({
                                title: 'Success',
                                text: 'Login Sukses',
                                type: 'success'
                            }).then(function (result) {
                                if (result.value) {
                                    window.location.href = responseData.redirectUrl;
                                }
                            });

                        } else if (responseData.status === "FAIL") {
                            clearErrorElement();
                            showFormLoginError(responseData.listErrorMessages);
                        }
                    }
                });
            });

            let emailLoginField = $('#emailLogin');
            let passwordLoginField = $('#passwordLogin');

            function showFormLoginError(errorVal) {
                for (var i = 0; i < errorVal.length; i++) {
                    if (errorVal[i].fieldName === 'emailUser') {
                        createElementError(emailLoginField, errorVal[i].message);
                    } else if (errorVal[i].fieldName === 'passwordUser') {
                        createElementError(passwordLoginField, errorVal[i].message);
                    }
                    // tampilkan error email dan password tidak valid
                    else if (errorVal[i].fieldName === 'loginNotif') {
                        createElementError(passwordLoginField, errorVal[i].message);
                    }
                }
            }
            //end login function

            function createElementError(field, textMessage) {
                let newElement = document.createElement("div");
                let textNode = document.createTextNode(textMessage);
                let errorClass = "error-field";
                newElement.appendChild(textNode);
                newElement.setAttribute("class", "text-danger small " + errorClass);

                field.after(newElement);
            }
            function clearErrorElement() {
                $(".error-field").remove();
            }
        </script>

    </body>
</html>
