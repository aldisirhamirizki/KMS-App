<%-- 
    Document   : nameTag
    Created on : Jul 18, 2019, 4:39:41 PM
    Author     : Aldis-PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <style>
        #nameTag {
            
        }
        #gambar {
            position: absolute;
            z-index: 22;
            left: 70%;
            animation-name: floating;
            animation-duration: 3s;
            animation-iteration-count: infinite;
            animation-timing-function: ease-in-out;
        }

        #profil {
            text-align: center;
            position: absolute;
            z-index: 222;
            left: 72%;
            margin-top: 65px;
            margin-left: 55px;
            font-size: 20px;
            animation-name: floating;
            animation-duration: 3s;
            animation-iteration-count: infinite;
            animation-timing-function: ease-in-out;
        }

        #profil2 {
            text-align: center;
            position: absolute;
            z-index: 222;
            left: 72%;
            margin-top: 88px;
            margin-left: 55px;
            animation-name: floating;
            animation-duration: 3s;
            animation-iteration-count: infinite;
            animation-timing-function: ease-in-out;
        }

        @keyframes floating {
            from { transform: translate(0, 0px); }
            65%  { transform: translate(0, 50px); }
            to   { transform: translate(0, 0px); }
        }
        
        #nameTag a h3 {
            color: darkslategray !important;
        }
        
        #nameTag a p {
            color: saddlebrown !important;
        }
    </style>
</head>
<c:choose>
    <c:when test="${sessionModel.idDaftar != null}">
        <div class="container" id="nameTag">
            <a class="" href="${pageContext.request.contextPath}/siswa/profil">
                <img id="gambar" width="300" src="<c:url value="/static/img/nametag.png" />"/>
                <h3 id="profil">Hai, ${sessionModel.namaDaftar}</h3>
                <p id="profil2">Silahkan ke menu profil <br>untuk melengkapi <br>data pendaftaran</p>
            </a>
        </div>
    </c:when>
</c:choose>
