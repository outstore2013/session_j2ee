<%-- 
    Document   : order_form
    Created on : 6 avr. 2014, 12:39:47
    Author     : Louis
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <div>
            <form method="post" action="<c:url value="OrderAdd"/>" role="form">
                <fieldset>
                    <legend>Informations client</legend>
                    <c:import url="/inc/form_customer.jsp" />
                </fieldset>
                <fieldset>
                    <legend>Informations commande</legend>
                    <c:import url="/inc/form_order.jsp" />
                    
                </fieldset>
                <input type="submit" value="Valider"  class="btn btn-default"/>
            </form>
        </div>