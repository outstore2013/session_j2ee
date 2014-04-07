<%-- 
    Document   : restrictedAccess
    Created on : 6 avr. 2014, 23:15:17
    Author     : Louis
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Accès restreint</title>
    </head>
    <body>
    <c:choose>
        <c:when test="${empty sessionScope.userSession}">
            <c:redirect url="?p=publicAccess"/>
        </c:when>
        <c:otherwise>
            <p>Vous êtes connecté(e) avec l'adresse ${sessionScope.userSession.email}, vous avez bien accès à l'espace restreint.</p>
        </c:otherwise>
    </c:choose>
        
    </body>
</html>
