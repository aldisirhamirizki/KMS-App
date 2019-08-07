<%-- 
    Document   : profil
    Created on : Jul 1, 2019, 4:15:04 PM
    Author     : Aldis-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

    <head>
        <link href="<c:url value="/static/bootstrap4/css/bootstrap.css"/>" rel="stylesheet" />
        <link href="<c:url value="/static/bootstrap4/css/style.css"/>" rel="stylesheet" />
        <title>KMS-App</title>
        <style>
            body {
                background: linear-gradient(-25deg, #ffffff, #ffffff, #fffa6f, #f9cc66);
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

            #textTop {
                padding-top: 50px;
            }

            #formProfil {
                background-color: #ffffff4a;
                padding-top: 100px;
            }

            #fileProfil {
                max-width: 150px;
            }

            #optionRow {
                margin-left: 20px;
            }

            #option {
                margin-right: 25px;
            }

            #fileProfil {
                background-image: url("<c:url value="../static/img/150.png" />");
                width: 150px;
                height: 150px;
            }

            #formBiaya {
                margin-left: 50px;
            }

            .form-inline {
                margin-bottom: 10px;
            }

            .formSlc2 {
                padding-right: 28px;
            }

            .formSlc3 {
                padding-right: 41px;
            }

            #konfirm {
                position: absolute;
                left: 65%;
            }

            #konfirm .btn-danger  {
                text-align: center;
            }

        </style>
    </head>

    <body>
        <jsp:include page="navbar2.jsp" />
        <div class="text-center" id="textTop">
            <h3>Silahkan Lengkapi Data Anda</h3>
        </div>


        <!--tombol konfirmasi-->
        <c:if test="${siswa.idKonfirmasi != null}">
            <div class="container" id="konfirm">
                <a href="${pageContext.request.contextPath}/konfirmasi/form_konfirmasi/${siswa.idSiswa}" class="btn btn-danger">Konfirmasi Pembayaran Anda<br>disini!!!</a>
            </div>
        </c:if>

        <div class="container" id="formProfil">
            <div class="row">
                <!-- edit form column -->
                <div class="col-lg-4 text-lg-center">
                    <form:form action="${pageContext.request.contextPath}/siswa/saveSiswa" method="post"
                               modelAttribute="siswa" enctype="multipart/form-data">
                    <h2>Edit Profile</h2>
                    <img id="fileProfil" src="${imageDisplay}"
                         class="m-x-auto img-fluid img-circle"/>
                    <p class="small">Max 500kb</p>
                    <label class="custom-file">
                        <input type="file" name="imageUpload" onchange="readURL(this, '#fileProfil');"/>
                    </label>
                    <input type="hidden" name="hiddenImage" id="hiddenImage" />
                </div>

                <div class="col-lg-8">
                    <div Class="form-group">
                        <form:hidden path="idSiswa"/>
                        <form:hidden path="idDaftar"/>
                        <form:hidden path="idKonfirmasi"/>

                        <label data-error="wrong" data-success="right" for="namaDaftar">Nama</label>
                        <form:input type="text" class="form-control form-control-sm" path="namaDaftar"/>
                        <form:errors path="namaDaftar" cssClass="text-danger small"></form:errors>
                    </div>
                    <div class="form-group">
                        <label data-error="wrong" data-success="right" for="emailDaftar">Email</label>
                        <form:input type="email" class="form-control form-control-sm" path="emailDaftar"/>
                        <form:errors path="emailDaftar" cssClass="text-danger small"></form:errors>
                    </div>
                    <div Class="form-group">
                        <label data-error="wrong" data-success="right" for="tanggalLahir">Tanggal Lahir</label>
                        <form:input type="date" class="form-control form-control-sm" path="tanggalLahir"/>
                        <form:errors path="tanggalLahir" cssClass="text-danger small"></form:errors>
                    </div>
                    <div class="form-group">
                        <label data-error="wrong" data-success="right" for="jenisKelamin">Jenis Kelamin</label>
                        <form:select cssClass="form-control" path="jenisKelamin">
                            <form:option value="" label="--pilih jenis kelamin--"/>
                            <form:options items="${jenisKelamin}"/>
                        </form:select>
                        <form:errors path="jenisKelamin" cssClass="text-danger small"></form:errors>
                    </div>
                    <div Class="form-group">
                        <label data-error="wrong" data-success="right" for="tempatTinggal">Tempat Tinggal</label>
                        <form:input type="text" class="form-control form-control-sm" path="tempatTinggal"/>
                        <form:errors path="tempatTinggal" cssClass="text-danger small"></form:errors>
                    </div>
                    <div Class="form-group">
                        <label data-error="wrong" data-success="right" for="telepon">Telepon</label>
                        <form:input type="text" class="form-control form-control-sm" path="telepon"/>
                        <form:errors path="telepon" cssClass="text-danger small"></form:errors>
                    </div>

                    <div class="form-inline">
                        <label for="kursusSelect" class="col-md-2">Kursus</label>
                        <div Class="form-group">
                            <form:select path="idKursus" class="form-control formSlc2" id="kursusSelect"
                                         onchange="getBiayaKursus()">
                                <form:option value="">--pilih kursus--</form:option>
                                <c:forEach items="${kursus}" var="kursus">
                                    <form:option value="${kursus.idKursus}">${kursus.namaKursus}
                                    </form:option>
                                </c:forEach>
                            </form:select>
                        </div>
                        <div class="form-group" id="formBiaya">
                            <input type="text" id="biayaKursus" class="form-control" readonly/>
                        </div>
                    <form:errors path="idKursus" cssClass="text-danger small"></form:errors>
                    </div>


                    <div class="form-inline">
                        <label for="levelSelect" class="col-md-2">Level</label>
                        <div Class="form-group">
                            <form:select path="idLevel" class="form-control formSlc3" id="levelSelect"
                                         onchange="getBiayaLevel()">
                                <form:option value="">--pilih level--</form:option>
                                <c:forEach items="${level}" var="level">
                                    <form:option value="${level.idLevel}">${level.namaLevel}</form:option>
                                </c:forEach>
                            </form:select>
                        </div>
                        <div class="form-group" id="formBiaya">
                            <input type="text" id="biayaLevel" class="form-control" readonly/>
                        </div>
                    <form:errors path="idLevel" cssClass="text-danger small"></form:errors>
                    </div>

                    <div class="form-inline">
                        <label for="programSelect" class="col-md-2">Program</label>
                        <div Class="form-group">
                            <form:select path="idProgram" class="form-control formSlc1" id="programSelect"
                                         onchange="getBiayaProgram()">
                                <form:option value="">--pilih program--</form:option>
                                <c:forEach items="${program}" var="program">
                                    <form:option value="${program.idProgram}">${program.namaProgram}
                                    </form:option>
                                </c:forEach>
                            </form:select>
                        </div>
                        <div class="form-group" id="formBiaya">
                            <input type="text" id="biayaProgram" class="form-control" readonly/>
                        </div>
                    <form:errors path="idProgram" cssClass="text-danger small"></form:errors>
                    </div>

                    <div Class="form-group">
                        <label for="bankSelect">Bank</label>
                        <form:select path="idBank" class="form-control" id="bankSelect">
                            <form:option value="">--pilih bank--</form:option>
                            <c:forEach items="${bank}" var="bank">
                                <form:option value="${bank.idBank}">${bank.namaBank}</form:option>
                            </c:forEach>
                        </form:select>
                        <form:errors path="idBank" cssClass="text-danger small"></form:errors>
                    </div>


                    <div class="form-group">
                        <label for="totalBiaya">Total Biaya</label>
                        <form:input type="text" id="totalBiaya" class="form-control" path="totalBiaya" readonly="true"/>
                    </div>
                    <button type="submit" Class="btn btn-primary">Submit</button>
                </div>
                </form:form>

            </div>
        </div>
        <hr />
        <script src="<c:url value="/static/bootstrap4/jquery-3.3.1.min.js" />" ></script>
        <script src="<c:url value="/static/bootstrap4/js/sweetalert2.all.js" />" ></script>

        <script>
            function setHiddenImageValue(){
                let imageFile = $('#fileProfil').attr('src');
                $('#hiddenImage').val(imageFile);

                /*$('input[name=imageUpload]').change(function(){
                    var fotoKu = document.getElementById('fileProfil').src;
                    let myImage = $('#hiddenImage').attr('src',fotoKu);
                    let shit = $('input[name=imageUpload]');
                    console.log("HIDDEN", myImage);
                    console.log("SHIT: ", shit);
                });*/
            }

            // initial object Program
            function Program(idProgram, namaProgram, biaya) {
                this.idProgram = idProgram;
                this.namaProgram = namaProgram;
                this.biaya = biaya;
            }

            var listProgram = [];
            <c:forEach var="list" items="${program}">
            var program = new Program("${list.idProgram}", "${list.namaProgram}", "${list.biaya}");
            listProgram.push(program);
            </c:forEach >

            // initial object Kursus
            function Kursus(idKursus, namaKursus, biaya) {
                this.idKursus = idKursus;
                this.namaKursus = namaKursus;
                this.biaya = biaya;
            }

            var listKursus = [];
            <c:forEach var="list" items="${kursus}">
            var kursus = new Kursus("${list.idKursus}", "${list.namaKursus}", "${list.biaya}");
            listKursus.push(kursus);
            </c:forEach >

            // initial object level
            function Level(idLevel, namaLevel, biaya) {
                this.idLevel = idLevel;
                this.namaLevel = namaLevel;
                this.biaya = biaya;
            }

            var listLevel = [];
            <c:forEach var="list" items="${level}">
            var level = new Level("${list.idLevel}", "${list.namaLevel}", "${list.biaya}");
            listLevel.push(level);
            </c:forEach >

            function getBiayaProgram() {
                let idProgram = $('#programSelect option:selected').val();
                for (let i = 0; i < listProgram.length; i++) {
                    if (listProgram[i].idProgram === idProgram) {
                        $('#biayaProgram').val(listProgram[i].biaya);
                        break;
                    } else {
                        $('#biayaProgram').val(0);
                    }
                }
                getTotal();
            }

            function getBiayaKursus() {
                let idKursus = $('#kursusSelect option:selected').val();
                for (let i = 0; i < listKursus.length; i++) {
                    if (listKursus[i].idKursus === idKursus) {
                        $('#biayaKursus').val(listKursus[i].biaya);
                        break;
                    } else {
                        $('#biayaKursus').val(0);
                    }
                }
                getTotal();
            }

            function getBiayaLevel() {
                let idLevel = $('#levelSelect option:selected').val();
                for (let i = 0; i < listLevel.length; i++) {
                    if (listLevel[i].idLevel === idLevel) {
                        $('#biayaLevel').val(listLevel[i].biaya);
                        break;
                    } else {
                        $('#biayaLevel').val(0);
                    }
                }
                getTotal();
            }

            // Initialize value
            getBiayaKursus();
            getBiayaLevel();
            getBiayaProgram();
            setHiddenImageValue();

            function getTotal() {
                let biayaProgram = isNaN(parseFloat($('#biayaProgram').val())) ? 0 : parseFloat($('#biayaProgram').val());
                let biayaKursus = isNaN(parseFloat($('#biayaKursus').val())) ? 0 : parseFloat($('#biayaKursus').val());
                let biayaLevel = isNaN(parseFloat($('#biayaLevel').val())) ? 0 : parseFloat($('#biayaLevel').val());

                let totalBiaya = biayaProgram + biayaKursus + biayaLevel;
                $('#totalBiaya').val(parseFloat(totalBiaya));
            }

            function readURL(input, imageId) {
                if (input.files && input.files[0]) {
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        $(imageId).attr('src', e.target.result);
                    };
                    reader.readAsDataURL(input.files[0]);
                    setHiddenImageValue();
                    // console.log(input);
                    // console.log(reader);
                    // console.log(input.files[0]);
                }
            }



            document.getElementById("tanggalLahir").addEventListener("change", function () {
                var input = this.value;
                var dateEntered = new Date(input);
                // console.log(input); //e.g. 2015-11-13
                // console.log(dateEntered); //e.g. Fri Nov 13 2015 00:00:00 GMT+0000 (GMT Standard Time)
            });


            $('#siswa').submit(function () {
                Swal.fire({
                    title: 'Success',
                    text: 'Anda Berhasil Daftar',
                    type: 'success'
                });
            });
        </script>

    </body>

</html>