<%-- 
    Document   : form_user
    Created on : 6 avr. 2014, 16:13:36
    Author     : Louis
--%>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="form-group">
    <label for="nom">Adresse email <span class="requis">*</span></label>
    <input type="email" id="email" name="email" value="<c:out value="${user.email}"/>" size="20" maxlength="60" />
    <span class="erreur">${form.errors['email']}</span>
</div>

<div class="form-group">
    <label for="password">Mot de passe <span class="requis">*</span></label>
    <input type="password" id="password" name="password" value="" size="20" maxlength="20" />
    <span class="erreur">${form.errors['password']}</span>
</div>
