<%-- 
    Document   : sign_form
    Created on : 6 avr. 2014, 12:33:51
    Author     : Louis
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="form-group">
    <label for="customerLastname">Nom <span class="requis">*</span></label>
    <input type="text" id="customerLastname" name="customerLastname" value="<c:out value="${custormer.lastname}"/>" size="30" maxlength="30" />
    <span class="erreur">${form.errors['customerLastname']}</span>
</div>


<div class="form-group">
    <label for="customerFirstname">Prénom </label>
    <input type="text" id="customerFirstname" name="customerFirstname" value="<c:out value="${custormer.firstname}"/>" size="30" maxlength="30" />
    <span class="erreur">${form.errors['customerFirstname']}</span>
</div>

<div class="form-group">
    <label for="customerAddress">Adresse de livraison <span class="requis">*</span></label>
    <input type="text" id="customerAddress" name="customerAddress" value="<c:out value="${custormer.adresse}"/>" size="30" maxlength="60" />
    <span class="erreur">${form.errors['customerAddress']}</span>
</div>

<div class="form-group">
    <label for="customerPhone">Numéro de téléphone <span class="requis">*</span></label>
    <input type="text" id="customerPhone" name="customerPhone" value="<c:out value="${custormer.telephone}"/>" size="30" maxlength="30" />
    <span class="erreur">${form.errors['customerPhone']}</span>
</div>

<div class="form-group">
    <label for="customerEmail">Adresse email</label>
    <input type="email" id="customerEmail" name="customerEmail" value="<c:out value="${custormer.email}"/>" size="30" maxlength="60" />
    <span class="erreur">${form.errors['customerEmail']}</span>
</div>