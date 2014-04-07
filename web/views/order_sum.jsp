<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="corps">
            <p class="info">${ message }</p>
            <c:if test="${ !error }">
                <p>Client</p>
                <p>Nom : <c:out value="${ order.customer.lastname }"/></p>
                <p>Prélastname : <c:out value="${ order.customer.firstname }"/></p>
                <p>Adresse : <c:out value="${ order.customer.address }"/></p>
                <p>Numéro de téléphone : <c:out value="${ order.customer.phone }"/></p>
                <p>Email : <c:out value="${ order.customer.email }"/></p>
                <p>Commande</p>
                <p>Date  : <c:out value="${ order.date }"/></p> 
                <p>Montant  : <c:out value="${ order.amount }"/></p> 
                <p>Mode de paiement  : <c:out value="${ order.paymentMode }"/></p> 
                <p>Statut du paiement  : <c:out value="${ order.paymentState }"/></p> 
                <p>Mode de livraison  : <c:out value="${ order.deliveryMode }"/></p> 
                <p>Statut de la livraison  : <c:out value="${ order.deliveryState }"/></p> 
            </c:if>
        </div>
