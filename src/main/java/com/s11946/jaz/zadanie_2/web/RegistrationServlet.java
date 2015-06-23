/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s11946.jaz.zadanie_2.web;

import com.s11946.jaz.zadanie_2.domain.Person;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bartek
 */
@WebServlet(name = "RegistrationServlet", urlPatterns = {"/RegistrationServlet"})
public class RegistrationServlet extends DefaultServlet {
    private static final long serialVersionUID = 1L;
    
    public RegistrationServlet() {
        super();
        
    }
    

    @Override
    public void init() throws ServletException {
        super.init(); 
        
        System.out.println("RegistrationServlet init completed");
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        RequestDispatcher rd = request.getRequestDispatcher("/registrationForm.jsp");
       rd.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/html");
        
                String firstName = (String) request.getParameter("firstName");
		String lastName = (String) request.getParameter("lastName");
		String email = (String) request.getParameter("email");
		String password = (String) request.getParameter("password");
		String company = (String) request.getParameter("company");
		String job = (String) request.getParameter("job");
		String premium = (String) request.getParameter("premium");
                
        System.out.println("Premium: " + premium);
        
        if (lastName != null && !lastName.equals("") && email != null && !email.equals("")) {
            
            System.out.println("RegistrationServlet - Registration with email: " +email);
            
            Person person = new Person(firstName, lastName);
            person.setEmail(email);
            person.setPassword(password);
            person.setCompany(company);
            person.setJob(job);
            
            if(premium != null) {
                person.setUserType(DefaultServlet.PREMIUM);
            } else {
                person.setUserType(DefaultServlet.NORMAL);
            }
            
            savePerson(person);
        }
        
        response.getWriter().println("<a href=''>Go back</a><br />");
        }
    }