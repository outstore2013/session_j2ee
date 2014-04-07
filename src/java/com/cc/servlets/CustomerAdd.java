package com.cc.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cc.beans.Customer;
import com.cc.forms.CustomerAddForm;

public class CustomerAdd extends HttpServlet {
    public static final String CUSTOMER_ATT = "customer";
    public static final String FORM_ATT   = "form";

    public static final String SUCCESS_VIEW = "?p=customer_sum";
    public static final String FORM_VIEW   = "?p=customer_add";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* À la réception d'une requête GET, simple affichage du formulaire */
        //this.getServletContext().getRequestDispatcher( FORM_VIEW ).forward( request, response );
        response.sendRedirect(request.getContextPath()+FORM_VIEW);
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
        CustomerAddForm form = new CustomerAddForm();

        /* Traitement de la requête et récupération du bean en résultant */
        Customer customer = form.createCustomer( request );

        /* Ajout du bean et de l'objet métier à l'objet requête */
        request.setAttribute( CUSTOMER_ATT, customer );
        request.setAttribute( FORM_ATT, form );

        if ( form.getErrors().isEmpty() ) {
            /* Si aucune error, alors affichage de la fiche récapitulative */
            //this.getServletContext().getRequestDispatcher( SUCCESS_VIEW ).forward( request, response );
            response.sendRedirect(request.getContextPath()+SUCCESS_VIEW);
        } else {
            /* Sinon, ré-affichage du formulaire de création avec les errors */
            //this.getServletContext().getRequestDispatcher( FORM_VIEW ).forward( request, response );
            response.sendRedirect(request.getContextPath()+FORM_VIEW);
        }
    }
}