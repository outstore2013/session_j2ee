package com.cc.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cc.beans.User;
import com.cc.forms.UserSigninForm;

public class UserSignin extends HttpServlet {
    public static final String USER_ATT         = "user";
    public static final String FORM_ATT         = "form";
    public static final String SESSION_USER_ATT = "userSession";
    public static final String VIEW              = "/views/user_signin.jsp";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Affichage de la page de connexion */
        this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
        UserSigninForm form = new UserSigninForm();

        /* Traitement de la requête et récupération du bean en résultant */
        User user = form.userConnect( request );

        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();

        /**
         * Si aucune error de validation n'a eu lieu, alors ajout du bean
         * User à la session, sinon suppression du bean de la session.
         */
        if ( form.getErrors().isEmpty() ) {
            session.setAttribute( SESSION_USER_ATT, user );
        } else {
            session.setAttribute( SESSION_USER_ATT, null );
        }

        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( FORM_ATT, form );
        request.setAttribute( USER_ATT, user );

        //this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
        response.sendRedirect(request.getContextPath()+"?p=user_signin");
     
    }
}