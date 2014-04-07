<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>TP CADDIE -- <c:out value="${param.p}" /></title>
        <meta name="viewport" content="width=device-width">
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/custom.css" rel="stylesheet">
        
        <script src="js/jquery-1.11.0.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
    </head>
    <body>
        <jsp:include page="/inc/header.jsp" />
        <div class="container" role="main" id="main">
        
        <%--Main--%>
        <%--Mécanisme d'inclusion dynamique des pages avec JSTL, ça roxx du poney :) --%>
        
        <%-- Test tout les autre cas , par exemple la page demandée n'existe pas --%>
        <c:catch var="e">
            <c:choose>
                <%--Test si valeur du parametre passer dans l'url est nule--%>
                <c:when test="${empty param.p }">
                    <%--Test si valeur est nule,alors on inclus la page d'accueil--%>
                    <c:import url="/views/home.jsp" />
                </c:when>
               <%--Sinon--%>
                <c:otherwise>
                        <%--On inclus la page demandée--%>
                        <c:import url="/views/${param.p}.jsp"></c:import>                    
                </c:otherwise>
            </c:choose>
        </c:catch>
        <%-- Test de l'existence d'une erreur , ex: page inexistante--%>
        <c:if test="${!empty e}">
            <%-- On inclus lapage d'erreur 404 personnalisée--%>
            <c:import url="/views/404.jsp"></c:import>
        </c:if>
        </div>
        <%--Main End--%>
    </body>
</html>