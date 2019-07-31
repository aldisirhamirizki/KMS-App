<%-- 
    Document   : list_program
    Created on : Jun 26, 2019, 5:52:19 AM
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
        <div class="panel-heading text-right">
            <input type="button" value="Tambah Program"
                   onclick="window.location.href = 'form_program'; return false;"
                   class="btn btn-primary" />
        </div>
        <div class="panel-title">
           Daftar Program
        </div>
    <div class="panel-body">
        <table class="table table-striped table-bordered">
            <tr>
                <th>Id program</th>
                <th>Nama program</th>
                <th>Biaya</th>
                <th>Action</th>
            </tr>

            <c:forEach var="tempProg" items="${program}">

                <c:url var="updateLink" value="/program/updateProgram">  
                    <c:param name="idProgram" value="${tempProg.idProgram}"/>
                </c:url>

                <c:url var="deleteLink" value="delete">
                    <c:param name="idProgram" value="${tempProg.idProgram}" />
                </c:url>

                <tr>
                    <td>${tempProg.idProgram}</td>
                    <td>${tempProg.namaProgram}</td>
                    <td>${tempProg.biaya}</td>

                    <td class="text-center">
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


    <script src="<c:url value="/static/bootstrap4/jquery-3.3.1.min.js"/>"></script>
    <script src="<c:url value="/static/bootstrap4/js/bootstrap.js"/>"></script>
    <script src="<c:url value="/static/bootstrap4/popper.js"/>"></script>


</body>
</html>