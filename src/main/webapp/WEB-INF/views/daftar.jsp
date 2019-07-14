<%-- 
    Document   : daftar
    Created on : May 6, 2019, 11:32:36 AM
    Author     : Aldis-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <style>
        #tab {
            color: #17a2b8 !important;
        }
        #tab:hover {
            color: white !important;
            background-color: #17a2b8;
        }
        #tab.active {
            color: white !important;
            background-color: #17a2b8;
        }
    </style>
    <link href="<c:url value="/static/bootstrap4/css/bootstrap.css"/>" rel="stylesheet"/>
</head>
<!--Modal: Login / Register Form-->
<div class="modal fade" id="modalLRForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog cascading-modal" role="document">
        <!--Content-->
        <div class="modal-content">

            <!--Modal cascading tabs-->
            <div class="modal-c-tabs">

                <!-- Nav tabs -->
                <ul class="nav nav-tabs justify-content-center" role="tablist">
                    <li class="nav-item">
                        <a class="nav-link active" id="tab" data-toggle="tab" href="#panel7" role="tab"><i class="fas fa-user mr-1"></i>
                            Login</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" id="tab" data-toggle="tab" href="#panel8" role="tab"><i class="fas fa-user-plus mr-1"></i>
                            Register</a>
                    </li>
                </ul>

                <!-- Tab panels -->
                <div class="tab-content">
                    <!--Panel 7-->
                    
                    <div class="tab-pane fade in show active" id="panel7" role="tabpanel">
                        <div class="modal-body">
                            <!--Body-->
                            <form:form action="${pageContext.request.contextPath}/login/doLogin" method="POST" modelAttribute="login" name="loginForm">
                                <form:hidden path="idDaftar"></form:hidden>
                                <form:hidden path="namaDaftar"></form:hidden>
                                
                                <div class="md-form form-sm">
                                        <label data-error="wrong" data-success="right" for="emailLogin">Email</label>
                                    <form:input type="email" id="emailLogin" class="form-control form-control-sm validate" path="emailDaftar" />
                                </div>
                                <div class="md-form form-sm">
                                    <label data-error="wrong" data-success="right" for="passwordLogin">Password</label>
                                    <form:input type="password" id="passwordLogin" class="form-control form-control-sm validate" path="passwordDaftar" />
                                </div>
                                <div class="text-center form-sm mt-2">
                                    <button class="btn btn-info">Login</button>
                                </div>
                            </form:form>
                        </div>

                        <div class="modal-footer">
                            <div class="options text-center text-md-right mt-1">
                                <p>Not a member? <a href="#" class="blue-text">Sign Up</a></p>
                                <p>Forgot <a href="#" class="blue-text">Password?</a></p>
                            </div>
                            <button type="button" class="btn btn-outline-info waves-effect ml-auto" data-dismiss="modal">Close</button>
                        </div>

                    </div>
                    <!--/.Panel 7-->

                    <!--Panel 8-->
                    <div class="tab-pane fade" id="panel8" role="tabpanel">

                        <!--Body-->
                        <div class="modal-body">
                            <form:form action="${pageContext.request.contextPath}/pendaftaran/savePendaftaran" method="POST" modelAttribute="pendaftaran">
                                <form:hidden path="idDaftar" style="0"></form:hidden>

                                    <div class="md-form form-sm">
                                        <label data-error="wrong" data-success="right" for="namaDaftar">Nama</label>
                                    <form:input type="text" id="namaDaftar" cssClass="form-control form-control-sm validate" path="namaDaftar" />

                                    <%--<form:errors path="namaDaftar"/>--%>
                                </div>

                                <div class="md-form form-sm">
                                    <label data-error="wrong" data-success="right" for="emailDaftar">Email</label>
                                    <form:input type="email" id="emailDaftar" class="form-control form-control-sm validate" path="emailDaftar" />
                                </div>

                                <div class="md-form form-sm">
                                    <label data-error="wrong" data-success="right" for="passwordDaftar">Password</label>
                                    <form:input type="password" id="passwordDaftar" class="form-control form-control-sm validate" path="passwordDaftar" />
                                </div>

                                <div class="text-center form-sm mt-2">
                                    <button id="signUp" class="btn btn-info">Sign up</button>
                                </div>
                            </form:form>

                        </div>
                        <!--Footer-->
                        <div class="modal-footer">
                            <button type="button" class="btn btn-outline-info waves-effect ml-auto" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                    <!--/.Panel 8-->
                </div>

            </div>
        </div>
        <!--/.Content-->
    </div>
    <!--Modal: Login / Register Form-->


    <script src="<c:url value="/static/bootstrap4/js/sweetalert2.all.js"/>"></script>
    <script src="<c:url value="/static/bootstrap4/jquery-3.3.1.min.js"/>"></script>
    <script>

        // daftar function
        $('#pendaftaran').submit(function (e) {
            
            e.preventDefault();
            let form = $(this);
            let url = form.attr('action');
//            form.find('input:hidden[id="idDaftar"]').val("INIT_VALUE");

            $.ajax({
                type: "POST",
                url: url,
                data: form.serialize(),
                success: function (data)
                {
                    let responseData = JSON.parse(data);
                    console.log("RESPONSE: " + JSON.stringify(responseData));
                    if (responseData.status === "SUCCESS") {
                        $('#modalLRForm').modal('hide');
                        Swal.fire({
                            title: 'Success',
                            text: 'Anda Berhasil Daftar',
                            type: 'success'
                        }).then(function (result) {
                            if (result.value) {
                                window.location.href = responseData.redirectUrl;
                            }
                        });

                    } else if (responseData.status === "FAIL") {
                        clearErrorElement();
                        showFormDaftarError(responseData.listErrorMessages);
                    }
                }
            });
        });

        let namaField = $('#namaDaftar');
        let emailField = $('#emailDaftar');
        let passwordField = $('#passwordDaftar');

        function clearFormDaftar(){
            namaField.next('div').remove();
            emailField.next('div').remove();
            passwordField.next('div').remove();
        }

        function showFormDaftarError(errorVal) {
            for (var i = 0; i < errorVal.length; i++) {
                if (errorVal[i].fieldName === 'namaDaftar') {
                    createElementError(namaField, errorVal[i].message);
                } else if (errorVal[i].fieldName === 'emailDaftar') {
                    createElementError(emailField, errorVal[i].message);
                } else if (errorVal[i].fieldName === 'passwordDaftar') {
                    createElementError(passwordField, errorVal[i].message);
                }
            }
        }
        // end daftar

        // login function
        $('#login').submit(function (e) {
            e.preventDefault();
            let form = $(this);
            let url = form.attr('action');
            
            // inisialisasi idDaftar & namaDaftar
            form.find('input:hidden[id="idDaftar"]').val("INIT_VALUE");
            form.find('input:hidden[id="namaDaftar"]').val("INIT_VALUE");
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
                        $('#modalLRForm').modal('hide');
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
                if (errorVal[i].fieldName === 'emailDaftar') {
                    createElementError(emailLoginField, errorVal[i].message);
                } else if (errorVal[i].fieldName === 'passwordDaftar') {
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
