<%-- 
    Document   : customer
    Created on : 6 avr. 2014, 12:30:07
    Author     : Louis
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="corps">
            <p class="info">${ message }</p>
            <c:if test="${ !error }">
                <p>Nom : <c:out value="${ customer.lastname }"/></p>
                <p>Pr�nom : <c:out value="${ customer.firstname }"/></p>
                <p>Adresse : <c:out value="${ customer.address }"/></p>
                <p>Num�ro de t�l�phone : <c:out value="${ customer.phone }"/></p>
                <p>Email : <c:out value="${ customer.email }"/></p>
            </c:if>
        </div>
