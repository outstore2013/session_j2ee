package com.cc.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Restriction extends HttpServlet {
    public static final String PUBLIC_ACCESS     = "/accesPublic.jsp";
    public static final String RESTRICTED_ACCESS  = "/restricted/restrictedAccess.jsp";
    public static final String SESSION_USER_ATT = "userSession";

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Récupération de la session depuis la requête */
        HttpSession session = request.getSession();

        /*
         * Si l'objet utilisateur n'existe pas dans la session en cours, alors
         * l'utilisateur n'est pas connecté.
         */
        if ( session.getAttribute( SESSION_USER_ATT ) == null ) {
            /* Redirection vers la page publique */
            response.sendRedirect( request.getContextPath() + PUBLIC_ACCESS );
        } else {
            /* Affichage de la page restreinte */
            this.getServletContext().getRequestDispatcher( RESTRICTED_ACCESS ).forward( request, response );
        }
    }
}