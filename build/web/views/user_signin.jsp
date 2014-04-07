<%-- 
    Document   : auth_user
    Created on : 6 avr. 2014, 17:31:42
    Author     : Louis
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${empty sessionScope.userSession}">
    <form method="post" action="UserSignin" role="form">
        <fieldset>
            <legend>Connexion</legend>
            <p>Vous pouvez vous connecter via ce formulaire.</p>
            <c:import url="/inc/form_user.jsp" />
            <input type="submit" value="Connexion"  class="btn btn-default"/>
            <br />
            <p class="${empty form.errors ? 'succes' : 'error'}">${form.result}</p>
            
        </fieldset>
    </form>
</c:if>

<c:if test="${!empty sessionScope.userSession}">
    <%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
    <p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.userSession.email}</p>
</c:if>