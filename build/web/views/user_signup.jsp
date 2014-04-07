<%-- 
    Document   : add_user
    Created on : 6 avr. 2014, 16:12:46
    Author     : Louis
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<form method="post" action="UserSignup" role="form">
            <fieldset>
                <legend>Inscription</legend>
                <c:import url="/inc/form_customer.jsp" />
                <br />
                <input type="submit" value="Inscription" class="sansLabel" />                
            </fieldset>
</form>
