/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s11946.jaz.zadanie_2.web;

import com.s11946.jaz.zadanie_2.domain.Person;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bartek
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends DefaultServlet {
    private static final long serialVersionUID = 1L;
    
    public LoginServlet() {
        super();
     
    }

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        
        System.out.println("LoginServlet init completed");
    }
    
 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false);
        
        System.out.println("LoginServlet - request attribute email: " + request.getParameter("email"));
        
        session.setAttribute("email", request.getParameter("email"));
        
        Person person = getPersonByEmail(request.getParameter("email"));
        session.setAttribute("userType", person.getUserType());
        
        RequestDispatcher rd = request.getRequestDispatcher("/ProfileServlet");
        rd.forward(request, response);
    }


}
