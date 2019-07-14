<%-- 
    Document   : profil
    Created on : Jul 1, 2019, 4:15:04 PM
    Author     : Aldis-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

<head>
    <link href="<c:url value="/static/bootstrap4/css/bootstrap.css"/>" rel="stylesheet" />
    <link href="<c:url value="/static/bootstrap4/css/style.css"/>" rel="stylesheet" />
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
            padding-top: 50px;
        }

        #fileProfil {
            max-width: 150px;
        }

        #fileBukti {
            max-width: 200px;
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
    </style>
</head>

<body>

    <jsp:include page="navbar2.jsp" />
    <div class="text-center" id="textTop">
        <h3>Silahkan Lengkapi Data Anda</h3>
    </div>
    <div class="container" id="formProfil">
        <div class="row">
            <!-- edit form column -->
            <div class="col-lg-4 text-lg-center">
                <form:form action="${pageContext.request.contextPath}/siswa/saveSiswa" method="post"
                    modelAttribute="siswa" enctype="multipart/form-data">
                    <h2>Edit Profile</h2>
                    <img id="fileProfil" src="${pageContext.request.contextPath}/siswa/imageDisplay?id=${siswa.idSiswa}"
                        class="m-x-auto img-fluid img-circle" />
                    <h6 class="m-t-2">Upload a different photo</h6>
                    <label class="custom-file">
                        <input type="file" name="imageUpload" onchange="readURL(this, '#fileProfil');" />
                    </label>
            </div>

            <div class="col-lg-8">
                <div Class="form-group">
                    <form:hidden path="idSiswa" />
                    <form:hidden path="idDaftar" />
                    <form:hidden path="idKonfirmasi" />

                    <label data-error="wrong" data-success="right" for="namaDaftar">Nama</label>
                    <form:input type="text" class="form-control form-control-sm" path="namaDaftar" />
                    <form:errors path="namaDaftar"></form:errors>
                </div>
                <div class="form-group">
                    <label data-error="wrong" data-success="right" for="emailDaftar">Email</label>
                    <form:input type="email" class="form-control form-control-sm" path="emailDaftar" />
                    <form:errors path="emailDaftar"></form:errors>
                </div>
                <div Class="form-group">
                    <label data-error="wrong" data-success="right" for="tanggalLahir">Tanggal Lahir</label>
                    <form:input type="date" class="form-control form-control-sm" path="tanggalLahir" />
                    <form:errors path="tanggalLahir"></form:errors>
                </div>
                <div class="form-group">
                    <label data-error="wrong" data-success="right" for="jenisKelamin">Jenis Kelamin</label>
                    <form:select cssClass="form-control" path="jenisKelamin">
                        <form:option value="none" label="--pilih jenis kelamin--" />
                        <form:options items="${jenisKelamin}" />
                    </form:select>
                    <form:errors path="jenisKelamin"></form:errors>
                </div>
                <div Class="form-group">
                    <label data-error="wrong" data-success="right" for="tempatTinggal">Tempat Tinggal</label>
                    <form:input type="text" class="form-control form-control-sm" path="tempatTinggal" />
                    <form:errors path="tempatTinggal"></form:errors>
                </div>
                <div Class="form-group">
                    <label data-error="wrong" data-success="right" for="telepon">Telepon</label>
                    <form:input type="text" class="form-control form-control-sm" path="telepon" />
                    <form:errors path="telepon"></form:errors>
                </div>

                <div class="row">
                    <div Class="form-group">
                        <label for="programSelect">Program</label>
                        <form:select path="idProgram" class="form-control" id="programSelect" onchange="getBiayaProgram()">
                            <form:option value="none">--pilih program--</form:option>
                            <c:forEach items="${program}" var="program">
                                <form:option value="${program.idProgram}">${program.namaProgram}
                                </form:option>
                            </c:forEach>
                        </form:select>
                        <form:errors path="idProgram"></form:errors>
                    </div>
                    <div class="form-group">
                        <input type="text" id="biayaProgram" class="form-control" readonly />
                    </div>
                </div>


                <div class="row">
                    <label for="kursusSelect">Kursus</label>
                    <div Class="form-group">
                        <form:select path="idKursus" class="form-control" id="kursusSelect" onchange="getBiayaKursus()">
                            <form:option value="none">--pilih kursus--</form:option>
                            <c:forEach items="${kursus}" var="kursus">
                                <form:option value="${kursus.idKursus}">${kursus.namaKursus}
                                </form:option>
                            </c:forEach>
                        </form:select>
                        <form:errors path="idKursus"></form:errors>
                    </div>
                    <div class="form-group">
                        <input type="text" id="biayaKursus" class="form-control" readonly />
                    </div>
                </div>

                <div class="row">
                    <div Class="form-group">
                        <label for="levelSelect">Level</label>
                        <form:select path="idLevel" class="form-control" id="levelSelect" onchange="getBiayaLevel()">
                            <form:option value="none">--pilih level--</form:option>
                            <c:forEach items="${level}" var="level">
                                <form:option value="${level.idLevel}">${level.namaLevel}</form:option>
                            </c:forEach>
                        </form:select>
                        <form:errors path="idLevel"></form:errors>
                    </div>
                    <div class="form-group">
                        <input type="text" id="biayaLevel" class="form-control" readonly />
                    </div>
                </div>
                <div Class="form-group">
                    <label for="bankSelect">Bank</label>
                    <form:select path="idBank" class="form-control" id="bankSelect">
                        <form:option value="none">--pilih bank--</form:option>
                        <c:forEach items="${bank}" var="bank">
                            <form:option value="${bank.idBank}">${bank.namaBank}</form:option>
                        </c:forEach>
                    </form:select>
                    <form:errors path="idBank"></form:errors>
                </div>
                <div class="form-group">
                    <label for="totalBiaya">Total Biaya</label>
                <form:input type="text" id="totalBiaya" class="form-control" path="totalBiaya" readonly="true" />
                </div>
                
                <!--
                <div class="text-center">
                                <h5>Upload Bukti Transfer</h5>
                                <img id="fileBukti" src="http://placehold.it/200" class="img-thumbnail" alt="avatar" />
                                <label class="custom-file">
                                    <input type="file" onchange="readURL(this, '#fileBukti');" class="form-control">
                                </label>
                            </div>-->
                <button type="submit" Class="btn btn-primary">Submit</button>
            </div>
            </form:form>

        </div>
    </div>
    <hr />
    <script src="<c:url value="/static/bootstrap4/jquery-3.3.1.min.js"/>"> </script> <script>
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
            let idLevel = $('#kursusSelect option:selected').val();
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
        
        function getTotal(){
            let biayaProgram = isNaN(parseFloat($('#biayaProgram').val())) ? 0 : parseFloat($('#biayaProgram').val());
            let biayaKursus = isNaN(parseFloat($('#biayaKursus').val())) ? 0 : parseFloat($('#biayaKursus').val());
            let biayaLevel = isNaN(parseFloat($('#biayaLevel').val())) ? 0 : parseFloat($('#biayaLevel').val());
            
            let totalBiaya = biayaProgram + biayaKursus + biayaLevel;
            $('#totalBiaya').val(parseFloat(totalBiaya));
        }








        function readURL(input, imageId) {
            debugger;
            if (input.files && input.files[0]) {
                var reader = new FileReader();

                reader.onload = function (e) {
                    $(imageId).attr('src', e.target.result);
                };

                reader.readAsDataURL(input.files[0]);
                console.log(input);
                console.log(reader);
                console.log(input.files[0]);
            }
        }

        document.getElementById("tanggalLahir").addEventListener("change", function () {
            var input = this.value;
            var dateEntered = new Date(input);
            console.log(input); //e.g. 2015-11-13
            console.log(dateEntered); //e.g. Fri Nov 13 2015 00:00:00 GMT+0000 (GMT Standard Time)
        });
    </script>

</body>

</html>