<%-- 
    Document   : client_create
    Created on : 6 avr. 2014, 15:34:26
    Author     : Louis
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>
    <form method="post" action="<c:url value="CustomerAdd"/>" role="form">
        <fieldset>
            <legend>Informations client</legend>
            <c:import url="/inc/form_customer.jsp" />
            <input type="submit" value="Valider"  />
            <input type="reset" value="Remettre à zéro" /> <br />
        </fieldset>            
    </form>
</div>
<p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.userSession.email}</p>