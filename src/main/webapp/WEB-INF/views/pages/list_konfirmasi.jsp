<%-- 
    Document   : list_konfirmasi
    Created on : Jul 22, 2019, 6:55:24 PM
    Author     : Aldis-PC
--%>

<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/static/bootstrap4/css/bootstrap.css"/>" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="panel-title">
            Daftar Konfirmasi
        </div>

        <div class="panel-body">

            <form action="${pageContext.request.contextPath}/konfirmasi/getPdf" target="${pageContext.request.contextPath}/konfirmasi/getPdf">
                <div class="form-group" id="cetak">
                    <label>Cetak Daftar Konfirmasi</label><br>
                    <input type="text" class="form-control-sm" id="cariReport" name="cariReport"/>
                    <button type="submit" class="btn btn-info">Cetak</button>
                </div>
            </form>

            <table class="table table-striped table-bordered table-sm">
                <tr>
                    <th>Id Siswa</th>
                    <th>Id Konfirmasi</th>
                    <th>Nama Siswa</th>
                    <th>Bank</th>
                    <th>Tanggal Konfirmasi</th>
                    <th>Total Biaya</th>
                </tr>

                <c:forEach var="temp" items="${konfirm}">
                    <tr>
                        <td>${temp.idSiswa}</td>
                        <td>${temp.idKonfirmasi}</td>
                        <td>${temp.namaDaftar}</td>
                        <td>${temp.bank}</td>
                        <fmt:setLocale value="id_ID" scope="session"/>
                        <td><fmt:formatDate value="${temp.tglKonfirmasi}" pattern="EEEE, dd-MM-yyyy"/></td>
                        <td>${temp.totalBiaya}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
