/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s11946.jaz.zadanie_2.web;

import com.s11946.jaz.zadanie_2.domain.Address;
import com.s11946.jaz.zadanie_2.domain.Person;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "ProfileServlet", urlPatterns = {"/ProfileServlet"})
public class ProfileServlet extends DefaultServlet {

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String email = (String) session.getAttribute("email");
        
        List<Person> persons = personRepository.getAll();
        
        System.out.println("Persons: " + persons.size());
        System.out.println("Email: " + email);
   
        for (Person person : persons) {
            System.out.println("Person in loop: " + person.toString());
            if(person.getEmail().equals(email)) {
		
			session.setAttribute("password", person.getPassword());
			session.setAttribute("firstName", person.getFirstName());
			session.setAttribute("lastName", person.getLastName());
			session.setAttribute("userType", person.getUserType());				
			
                        List<Address> addresses = getAddressesByPerson(person.getId());
                        session.setAttribute("addresses", addresses);

			}
		}

		RequestDispatcher rd = request
				.getRequestDispatcher("/profile.jsp");
		rd.forward(request, response);
		
		System.out.println("ProfileServlet init completed");
    }// </editor-fold>

}
