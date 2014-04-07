<%-- 
    Document   : form_order
    Created on : 6 avr. 2014, 22:01:38
    Author     : Louis
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="form-group">
    <label for="orderDate">Date <span class="requis">*</span></label>
    <input type="text" id="v" name="orderDate" value="<c:out value="${order.date}"/>" size="30" maxlength="30" disabled />
    <span class="erreur">${form.errors['orderDate']}</span>
</div>

<div class="form-group">
    <label for="orderAmount">Montant <span class="requis">*</span></label>
    <input type="text" id="orderAmount" name="orderAmount" value="<c:out value="${order.amount}"/>" size="30" maxlength="30" />
    <span class="erreur">${form.errors['orderAmount']}</span>
</div>

<div class="form-group">
    <label for="orderPaymentMode">Mode de paiement <span class="requis">*</span></label>
    <input type="text" id="orderPaymentMode" name="orderPaymentMode" value="<c:out value="${order.paymentMode}"/>" size="30" maxlength="30" />
    <span class="erreur">${form.errors['orderPaymentMode']}</span>
</div>

<div class="form-group">
    <label for="orderPaymentState">Statut du paiement</label>
<input type="text" id="orderPaymentState" name="orderPaymentState" value="<c:out value="${order.paymentState}"/>" size="30" maxlength="30" />
<span class="erreur">${form.errors['orderPaymentState']}</span>
</div>


<div class="form-group">
    <label for="orderDeliveryMode">Mode de livraison <span class="requis">*</span></label>
    <input type="text" id="orderDeliveryMode" name="orderDeliveryMode" value="<c:out value="${order.deliveryMode}"/>" size="30" maxlength="30" />
    <span class="erreur">${form.errors['orderDeliveryMode']}</span>
</div>

<div class="form-group">
    <label for="orderDeliveryState">Statut de la livraison</label>
    <input type="text" id="orderDeliveryState" name="orderDeliveryState" value="<c:out value="${order.deliveryState}"/>" size="30" maxlength="30" />
    <span class="erreur">${form.errors['orderDeliveryState']}</span>
</div>
