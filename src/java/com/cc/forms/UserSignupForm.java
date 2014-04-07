/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cc.forms;

/**
 *
 * @author Louis
 */
import com.cc.beans.User;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public final class UserSignupForm {
    private static final String EMAIL_FIELD  = "email";
    private static final String PASSWORD_FIELD   = "password";
    private static final String CONFIRMATION_FIELD   = "confirmation";
    private static final String NAME_FIELD    = "username";

    private String  result;
    private Map<String, String> Errors = new HashMap<String, String>();

    public String getResult() {
        return result;
    }

    public Map<String, String> getErrors() {
        return Errors;
    }
    
    /*Validation*/
    public User registerUser( HttpServletRequest request ) {
        String email = getFieldValue( request, EMAIL_FIELD );
        String password = getFieldValue( request, PASSWORD_FIELD );
        String confirmation = getFieldValue( request, CONFIRMATION_FIELD );
        String username = getFieldValue( request, NAME_FIELD );

        User user = new User();

        try {
            emailValidation( email );
        } catch ( Exception e ) {
            setError( EMAIL_FIELD, e.getMessage() );
        }
        user.setEmail( email );

        try {
            passwordValidation( password, confirmation );
        } catch ( Exception e ) {
            setError( PASSWORD_FIELD, e.getMessage() );
            setError( CONFIRMATION_FIELD, null );
        }
        user.setPassword( password );

        try {
            usernameValidation( username );
        } catch ( Exception e ) {
            setError( NAME_FIELD, e.getMessage() );
        }
        user.setUsername( username );

        if ( Errors.isEmpty() ) {
            result = "Succès de l'inscription.";
        } else {
            result = "Échec de l'inscription.";
        }

        return user;
    }
    
    
    private void emailValidation( String email ) throws Exception {
        if ( email != null ) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new Exception( "Merci de saisir une adresse mail valide." );
            }
        } else {
            throw new Exception( "Merci de saisir une adresse mail." );
        }
    }

    private void passwordValidation( String password, String confirmation ) throws Exception {
        if ( password != null && confirmation != null ) {
            if ( !password.equals( confirmation ) ) {
                throw new Exception( "Les mots de passe entrés sont différents, merci de les saisir à nouveau." );
            } else if ( password.length() < 3 ) {
                throw new Exception( "Les mots de passe doivent contenir au moins 3 caractères." );
            }
        } else {
            throw new Exception( "Merci de saisir et confirmer votre mot de passe." );
        }
    }

    private void usernameValidation( String username ) throws Exception {
        if ( username != null && username.length() < 3 ) {
            throw new Exception( "Le username d'user doit contenir au moins 3 caractères." );
        }
    }

    /*
     * Ajoute un message correspondant au field spécifié à la map des Errors.
     */
    private void setError( String field, String message ) {
        Errors.put( field, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un field est vide, et son contenu
     * sinon.
     */
    private static String getFieldValue( HttpServletRequest request, String usernameField ) {
        String value = request.getParameter( usernameField );
        if ( value == null || value.trim().length() == 0 ) {
            return null;
        } else {
            return value.trim();
        }
    }
}
