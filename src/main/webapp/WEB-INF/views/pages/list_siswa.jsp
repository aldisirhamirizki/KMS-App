<%-- 
    Document   : list_siswa
    Created on : Jul 12, 2019, 2:58:39 PM
    Author     : Aldis-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/static/bootstrap4/css/bootstrap.css"/>" rel="stylesheet">
        <title>JSP Page</title>
        <style>
            .panel-body .table {
                width: 110%;
                font-size: 12px;
            }

            #action {
                display: flex;
            }

            .btn {
                padding: 5px;
                font-size: 10px;
                margin: 5px;
            }

            .row #search {
                background: none;
                margin: auto;
                padding-bottom: 20px;
            }

            #cari {

            }

            #cetak {
                position: absolute;
                left: 75%;
            }
        </style>
    </head>
    <body>
        <div class="panel-title">
            Daftar Siswa
        </div>
        <div class="panel-body">
            <div class="row" id="search">
                <form action="${pageContext.request.contextPath}/siswa/list_siswa" >
                    <div class="form-group" id="cari">
                        <label>Pencarian</label><br>
                        <c:choose>
                            <c:when test="${not empty cari}">
                                <input type="text" class="form-control-sm" id="cariSiswa" name="cariSiswa" value="${cari}"/>
                            </c:when>
                            <c:otherwise>
                                <input type="text" class="form-control-sm" id="cariSiswa" name="cariSiswa"/>
                            </c:otherwise>
                        </c:choose>

                        <button type="submit" class="btn btn-info">Cari</button>
                    </div>
                </form>

                <form action="${pageContext.request.contextPath}/siswa/getPdf" target="${pageContext.request.contextPath}/siswa/search">
                    <div class="form-group" id="cetak">
                        <label>Cetak Daftar Siswa</label><br>
                        <input type="text" class="form-control-sm" id="cariReport" name="cariReport"/>
                        <button type="submit" class="btn btn-info">Cetak</button>
                    </div>
                </form>
            </div>

            <table class="table table-dark table-striped table-bordered table-sm">
                <tr>
                    <th>Id Siswa</th>
                    <th>Nama Siswa</th>
                    <th>Jenis Kelamin</th>
                    <th>Tanggal Lahir</th>
                    <th>Tempat Tinggal</th>
                    <th>Telepon</th>
                    <th>Program</th>
                    <th>Kursus</th>
                    <th>Level</th>
                    <th>Bank</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>

                <c:forEach var="temp" items="${siswa}">

                    <c:url var="updateLink" value="/siswa/updateSiswa">
                        <c:param name="idSiswa" value="${temp.idSiswa}"/>
                    </c:url>

                    <c:url var="deleteLink" value="delete">
                        <c:param name="idSiswa" value="${temp.idSiswa}" />
                    </c:url>

                    <tr>
                        <td>${temp.idSiswa}</td>
                        <td>${temp.namaDaftar}</td>
                        <td>${temp.jenisKelamin}</td>

                        <td><fmt:formatDate value="${temp.tanggalLahir}" pattern="dd-MM-yyyy"/></td>

                        <td>${temp.tempatTinggal}</td>
                        <td>${temp.telepon}</td>
                        <td>${temp.idProgram}</td>
                        <td>${temp.idKursus}</td>
                        <td>${temp.idLevel}</td>
                        <td>${temp.idBank}</td>
                        <td>${temp.status}</td>

                        <td class="text-center" id="action">
                            <a class="btn btn-primary" href="${updateLink}">Lihat</a>
                            <a class="btn btn-danger" href="${deleteLink}"
                               onclick="if (!(confirm('apa anda yakin ingin menghapus user ini?')))
                                           return false">
                                Delete
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <nav aria-label="...">
                <ul class="pagination pagination-sm">
                    <c:url var="previousURL" value="/siswa/list_siswa">
                        <c:param name="page" value="${page.getNumber() - 1}"></c:param>
                    </c:url>
                    <c:url var="nextURL" value="/siswa/list_siswa">
                        <c:param name="page" value="${page.getNumber() + 1}"></c:param>
                    </c:url>
                    <c:choose>
                        <c:when test="${page.hasPrevious()}">
                            <li class="page-item">
                                <a class="page-link" href="${previousURL}" tabindex="-1" onclick="getCariValue(this)">Previous</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item disabled">
                                <a class="page-link" href="#" tabindex="-1">Previous</a>
                            </li>
                        </c:otherwise>
                    </c:choose>

                    <c:forEach var="i" begin="1" end="${page.getTotalPages()}" varStatus="loop">
                        <c:url var="pageURL" value="/siswa/list_siswa">
                            <c:param name="page" value="${i - 1}"></c:param>
                        </c:url>
                        <c:choose>
                            <c:when test="${(page.getNumber() + 1) == i}" >
                                <li class="page-item active">
                                    <a class="page-link" href="${pageURL}" onclick="getCariValue(this)">${i}</a>
                                </li>
                            </c:when>
                            <c:otherwise>
                                <li class="page-item"><a class="page-link" href="${pageURL}" onclick="getCariValue(this)">${i}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>

                    <c:choose>
                        <c:when test="${page.hasNext()}">
                            <li class="page-item">
                                <a class="page-link" href="${nextURL}" onclick="getCariValue(this)">Next</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item disabled">
                                <a class="page-link" href="#">Next</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </nav>


        </div>
        <script src="<c:url value="/static/bootstrap4/jquery-3.3.1.min.js" />" ></script>
        <script>
            function getCariValue(e) {
                let href = $(e).attr('href');
                let hitLink = href + "&cariSiswa=" + $('#cariSiswa').val();
                $(e).attr("href", hitLink);
                return false;
            }
        </script>
    </body>
</html>
