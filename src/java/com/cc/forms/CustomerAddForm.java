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
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.cc.beans.Customer;

public final class CustomerAddForm {
    private static final String LASTNAME_FIELD       = "customerFirstname";
    private static final String FIRSTNAME_FIELD    = "customerFirstname";
    private static final String ADDRESS_FIELD   = "customerEmail";
    private static final String PHONE_FIELD = "customerPhone";
    private static final String EMAIL_FIELD     = "customerEmail";

    private String              result;
    private Map<String, String> errors         = new HashMap<String, String>();

    public Map<String, String> getErrors() {
        return errors;
    }

    public String getResult() {
        return result;
    }

    public Customer createCustomer( HttpServletRequest request ) {
        String lastname = getFieldValue( request, LASTNAME_FIELD );
        String firstname = getFieldValue( request, FIRSTNAME_FIELD );
        String address = getFieldValue( request, ADDRESS_FIELD );
        String phone = getFieldValue( request, PHONE_FIELD );
        String email = getFieldValue( request, EMAIL_FIELD );

        Customer customer = new Customer();

        try {
            lastnameValidation( lastname );
        } catch ( Exception e ) {
            setError( LASTNAME_FIELD, e.getMessage() );
        }
        customer.setLastname( lastname );

        try {
            firstnameValidation( firstname );
        } catch ( Exception e ) {
            setError( FIRSTNAME_FIELD, e.getMessage() );
        }
        customer.setFirstname( firstname );

        try {
            addressValidation( address );
        } catch ( Exception e ) {
            setError( ADDRESS_FIELD, e.getMessage() );
        }
        customer.setAddress( address );

        try {
            phoneValidation( phone );
        } catch ( Exception e ) {
            setError( PHONE_FIELD, e.getMessage() );
        }
        customer.setPhone( phone );

        try {
            emailValidation( email );
        } catch ( Exception e ) {
            setError( EMAIL_FIELD, e.getMessage() );
        }
        customer.setEmail( email );

        if ( errors.isEmpty() ) {
            result = "Succès de la création du customer.";
        } else {
            result = "Échec de la création du customer.";
        }

        return customer;
    }

    private void lastnameValidation( String lastname ) throws Exception {
        if ( lastname != null ) {
            if ( lastname.length() < 2 ) {
                throw new Exception( "Le lastname d'utilisateur doit contenir au moins 2 caractères." );
            }
        } else {
            throw new Exception( "Merci d'entrer un lastname d'utilisateur." );
        }
    }

    private void firstnameValidation( String firstname ) throws Exception {
        if ( firstname != null && firstname.length() < 2 ) {
            throw new Exception( "Le prélastname d'utilisateur doit contenir au moins 2 caractères." );
        }
    }

    private void addressValidation( String address ) throws Exception {
        if ( address != null ) {
            if ( address.length() < 10 ) {
                throw new Exception( "L'address de livraison doit contenir au moins 10 caractères." );
            }
        } else {
            throw new Exception( "Merci d'entrer une address de livraison." );
        }
    }

    private void phoneValidation( String phone ) throws Exception {
        if ( phone != null ) {
            if ( !phone.matches( "^\\d+$" ) ) {
                throw new Exception( "Le numéro de téléphone doit uniquement contenir des chiffres." );
            } else if ( phone.length() < 4 ) {
                throw new Exception( "Le numéro de téléphone doit contenir au moins 4 chiffres." );
            }
        } else {
            throw new Exception( "Merci d'entrer un numéro de téléphone." );
        }
    }

    private void emailValidation( String email ) throws Exception {
        if ( email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
            throw new Exception( "Merci de saisir une address mail valide." );
        }
    }

    /*
     * Ajoute un message correspondant au field spécifié à la map des errors.
     */
    private void setError( String field, String message ) {
        errors.put( field, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un field est vide, et son contenu
     * sinon.
     */
    private static String getFieldValue( HttpServletRequest request, String lastnameChamp ) {
        String value = request.getParameter( lastnameChamp );
        if ( value == null || value.trim().length() == 0 ) {
            return null;
        } else {
            return value;
        }
    }
}