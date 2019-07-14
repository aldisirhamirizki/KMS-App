<%-- 
    Document   : list_siswa
    Created on : Jul 12, 2019, 2:58:39 PM
    Author     : Aldis-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="panel-title">
                Kursus List
            </div>
            <div class="panel-body">
                <table class="table table-striped table-bordered">
                    <tr>
                        <th>Id Siswa</th>
                        <th>Id Daftar</th>
                        <th>Jenis Kelamin</th>
                        <th>Tanggal Lahir</th>
                        <th>Tempat Tinggal</th>
                        <th>Telepon</th>
                        <th>Id Program</th>
                        <th>Id Kursus</th>
                        <th>Id Level</th>
                        <th>Id Bank</th>
                        <th>Foto</th>
                        <th>Action</th>
                    </tr>

                    <c:forEach var="temp" items="${siswa}">

                        <c:url var="updateLink" value="">  
                            <c:param name="idSiswa" value="${temp.idSiswa}"/>
                        </c:url>

                        <c:url var="deleteLink" value="delete">
                            <c:param name="idSiswa" value="${temp.idSiswa}" />
                        </c:url>

                        <tr>
                            <td>${temp.idSiswa}</td>
                            <td>${temp.idDaftar}</td>
                            <td>${temp.jenisKelamin}</td>
                            <td>${temp.tanggalLahir}</td>
                            <td>${temp.tempatTinggal}</td>
                            <td>${temp.telepon}</td>
                            <td>${temp.idProgram}</td>
                            <td>${temp.idKursus}</td>
                            <td>${temp.idLevel}</td>
                            <td>${temp.idBank}</td>
                            <td>${temp.image}</td>

                            <td>
                                <a class="btn btn-primary" href="${updateLink}">Update</a>
                                <a class="btn btn-danger" href="${deleteLink}" 
                                   onclick="if (!(confirm('apa anda yakin ingin menghapus user ini?')))
                                               return false">
                                    Delete
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

    </body>
</html>
