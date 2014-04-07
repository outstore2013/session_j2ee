package com.cc.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.cc.beans.Customer;
import com.cc.beans.Order;

    public final class OrderAddForm {
    private static final String DATE_FIELD             = "orderDate";
    private static final String AMOUNT_FIELD          = "orderAmount";
    private static final String PAYMENT_MODE_FIELD    = "orderPaymentMode";
    private static final String PAYMENT_STATE_FIELD  = "orderPaymentState";
    private static final String DELIVERY_MODE_FIELD   = "orderDeliveryMode";
    private static final String DELIVERY_STATE_FIELD = "orderDeliveryState";

    private static final String DATE_FORMAT            = "dd/MM/yyyy HH:mm:ss";

    private String              result;
    private Map<String, String> errors                = new HashMap<String, String>();

    public Map<String, String> getErrors() {
        return errors;
    }

    public String getResult() {
        return result;
    }

    public Order createOrder( HttpServletRequest request ) {
        /*
         * L'objet métier pour valider la création d'un customer existe déjà, il
         * est donc déconseillé de dupliquer ici son contenu ! À la place, il
         * suffit de passer la requête courante à l'objet métier existant et de
         * récupérer l'objet CustomerAddForm créé.
         */
        CustomerAddForm customerForm = new CustomerAddForm();
        Customer customer = customerForm.createCustomer(request);

        /*
         * Et très important, il ne faut pas oublier de récupérer le contenu de
         * la map d'errors créée par l'objet métier OrderAddForm dans la
         * map d'errors courante, actuellement vide.
         */
        errors = customerForm.getErrors();

        /*
         * Ensuite, il suffit de procéder normalement avec le reste des champs
         * spécifiques à une order.
         */

        /*
         * Récupération et conversion de la date en String selon le format
         * choisi.
         */
        DateTime dt = new DateTime();
        DateTimeFormatter formatter = DateTimeFormat.forPattern( DATE_FORMAT );
        String date = dt.toString( formatter );

        String amount = getFieldValue( request, AMOUNT_FIELD );
        String paymentMode = getFieldValue( request, PAYMENT_MODE_FIELD );
        String paymentState = getFieldValue( request, PAYMENT_STATE_FIELD );
        String deliveryMode = getFieldValue( request, DELIVERY_MODE_FIELD );
        String deliveryState = getFieldValue( request, DELIVERY_STATE_FIELD );

        Order order = new Order();

        order.setCustomer( customer );

        order.setDate( date );

        double amountValue = -1;
        try {
            amountValue = validationAmount( amount );
        } catch ( Exception e ) {
            setError( AMOUNT_FIELD, e.getMessage() );
        }
        order.setAmount( amountValue );

        try {
            paymentModeValidation( paymentMode );
        } catch ( Exception e ) {
            setError( PAYMENT_MODE_FIELD, e.getMessage() );
        }
        order.setPaymentMode( paymentMode );

        try {
            paymentStateValidation( paymentState );
        } catch ( Exception e ) {
            setError( PAYMENT_STATE_FIELD, e.getMessage() );
        }
        order.setPaymentState( paymentState );

        try {
            deliveryModeValidation( deliveryMode );
        } catch ( Exception e ) {
            setError( DELIVERY_MODE_FIELD, e.getMessage() );
        }
        order.setDeliveryMode( deliveryMode );

        try {
            deliveryStateValidation( deliveryState );
        } catch ( Exception e ) {
            setError( DELIVERY_STATE_FIELD, e.getMessage() );
        }
        order.setDeliveryState( deliveryState );

        if ( errors.isEmpty() ) {
            result = "Succès de la création de la order.";
        } else {
            result = "Échec de la création de la order.";
        }
        return order;
    }

    private double validationAmount( String amount ) throws Exception {
        double temp;
        if ( amount != null ) {
            try {
                temp = Double.parseDouble( amount );
                if ( temp < 0 ) {
                    throw new Exception( "Le amount doit être un nombre positif." );
                }
            } catch ( NumberFormatException e ) {
                temp = -1;
                throw new Exception( "Le amount doit être un nombre." );
            }
        } else {
            temp = -1;
            throw new Exception( "Merci d'entrer un amount." );
        }
        return temp;
    }

    private void paymentModeValidation( String paymentMode ) throws Exception {
        if ( paymentMode != null ) {
            if ( paymentMode.length() < 2 ) {
                throw new Exception( "Le mode de paiement doit contenir au moins 2 caractères." );
            }
        } else {
            throw new Exception( "Merci d'entrer un mode de paiement." );
        }
    }

    private void paymentStateValidation( String paymentState ) throws Exception {
        if ( paymentState != null && paymentState.length() < 2 ) {
            throw new Exception( "Le statut de paiement doit contenir au moins 2 caractères." );
        }
    }

    private void deliveryModeValidation( String deliveryMode ) throws Exception {
        if ( deliveryMode != null ) {
            if ( deliveryMode.length() < 2 ) {
                throw new Exception( "Le mode de livraison doit contenir au moins 2 caractères." );
            }
        } else {
            throw new Exception( "Merci d'entrer un mode de livraison." );
        }
    }

    private void deliveryStateValidation( String deliveryState ) throws Exception {
        if ( deliveryState != null && deliveryState.length() < 2 ) {
            throw new Exception( "Le statut de livraison doit contenir au moins 2 caractères." );
        }
    }

    /*
     * Ajoute un message correspondant au champ spécifié à la map des errors.
     */
    private void setError( String champ, String message ) {
        errors.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getFieldValue( HttpServletRequest request, String nomChamp ) {
        String value = request.getParameter( nomChamp );
        if ( value == null || value.trim().length() == 0 ) {
            return null;
        } else {
            return value;
        }
    }
}