<%-- 
    Document   : defaultLayouts
    Created on : Jun 26, 2019, 9:05:03 PM
    Author     : Aldis-PC
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/static/bootstrap4/css/styleAdmin.css"/>" rel="stylesheet"/>
        <link href="<c:url value="/static/bootstrap4/css/bootstrap.css"/>" rel="stylesheet"/>
        <style>
            
            
            #site-content {
                margin-top: 20px;
                width: 900px;
            }
            .panel-heading {
                margin: 15px 15px 0 0;
                text-align: right;
            }
            .panel-title {
                text-align: center;
                font-size: 20pt;
                margin: 20px 0 20px 0;
            }
            .row {
                color: white;
                background-image: url("<c:url value="${pageContext.request.contextPath}/static/img/monyet.jpg" />");
                background-size: cover;
                padding-bottom: 75px;
            }
            .table {
                color: white !important;
            }
        </style>
        <title>KMS-App Dashboard Admin</title>
    </head>
    <body>
        <div id="header">
            <tiles:insertAttribute name="header"/>
        </div>


        <div class="row">
            <div class="col-md-3" id="sidemenu">
                <tiles:insertAttribute name="menu"/>
            </div>

            <div id="site-content">
                <tiles:insertAttribute name="body"/>
            </div>
        </div>
            <div id="footer">
                <tiles:insertAttribute name="footer"/>
            </div>


        <script src="<c:url value="/static/bootstrap4/jquery-3.3.1.min.js"/>"></script>
        <script src="<c:url value="/static/bootstrap4/js/bootstrap.js"/>"></script>
        <script src="<c:url value="/static/bootstrap4/popper.js"/>"></script>
    </body>
</html>
