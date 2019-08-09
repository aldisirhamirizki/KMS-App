<%-- 
    Document   : list_level
    Created on : Jun 26, 2019, 4:21:59 PM
    Author     : Aldis-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link href="<c:url value="/static/bootstrap4/css/bootstrap.css"/>" rel="stylesheet">
        <title>KMS - App</title>
    </head>
    <body>
        <div class="container">
            <div class="panel-heading">
                <input type="button" value="Tambah Level"
                       onclick="window.location.href = 'form_level'; return false;"
                       class="btn btn-primary" />
            </div>
            <div class="panel-title">
                Daftar Level
            </div>
            <div class="panel-body">
                <table class="table table-dark table-striped table-bordered">
                    <tr>
                        <th>Id level</th>
                        <th>Nama level</th>
                        <th>Keterangan</th>
                        <th>Biaya</th>
                        <th>Action</th>
                    </tr>

                    <c:forEach var="temp" items="${level}">

                        <c:url var="updateLink" value="/level/updateLevel">  
                            <c:param name="idLevel" value="${temp.idLevel}"/>
                        </c:url>

                        <c:url var="deleteLink" value="delete">
                            <c:param name="idLevel" value="${temp.idLevel}" />
                        </c:url>

                        <tr>
                            <td>${temp.idLevel}</td>
                            <td>${temp.namaLevel}</td>
                            <td>${temp.keterangan}</td>
                            <td>${temp.biaya}</td>

                            <td>
                                <a class="btn btn-primary btn-sm" href="${updateLink}">Update</a>
                                <a class="btn btn-danger btn-sm" href="${deleteLink}" 
                                   onclick="if (!(confirm('apa anda yakin ingin menghapus user ini?')))
                                               return false">
                                    Delete
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

        </div>

        <script src="<c:url value="/static/bootstrap4/jquery-3.3.1.min.js"/>"></script>
        <script src="<c:url value="/static/bootstrap4/js/bootstrap.js"/>"></script>
        <script src="<c:url value="/static/bootstrap4/popper.js"/>"></script>


    </body>
</html>
