<%-- 
    Document   : publicAccess
    Created on : 6 avr. 2014, 23:17:04
    Author     : Louis
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <c:choose>
        <c:when test="${empty sessionScope.userSession}">
            <p>Vous n'avez pas accès à l'espace restreint : vous devez vous <a href="?p=user_signin">connecter</a> d'abord. </p>
        </c:when>
        <c:otherwise>
            <c:redirect url="/restricted/restrictedAccess.jsp"/>
        </c:otherwise>
    </c:choose>



