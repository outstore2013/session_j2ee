/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cc.servlets;

/**
 *
 * @author Louis
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cc.beans.User;
import com.cc.forms.UserSignupForm;
public class UserSignup extends HttpServlet {
    public static final String ATT_USER = "user";
    public static final String ATT_FORM = "form";
    public static final String VIEW = "?p=user_signup";
		
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Affichage de la page d'inscription */
        this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
    }
	
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Préparation de l'objet formulaire */
        UserSignupForm form = new UserSignupForm();
		
        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
        User user = form.registerUser( request );
		
        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_USER, user );
		
        //this.getServletContext().getRequestDispatcher( VIEW ).forward( request, response );
        response.sendRedirect(request.getContextPath()+VIEW);
    }
}
