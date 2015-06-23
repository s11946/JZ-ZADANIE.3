/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s11946.jaz.zadanie_2.web;

import com.s11946.jaz.zadanie_2.domain.Person;
import impl.PersonBuilder;
import impl.PersonRepository;
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
import unitofwork.UnitOfWork;

/**
 *
 * @author Bartek
 */
@WebServlet(name = "ShowUsersServlet", urlPatterns = {"/ShowUsersServlet"})
public class ShowUsersServlet extends DefaultServlet {

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        uow = new UnitOfWork(connection);
        personRepository = new PersonRepository(connection, new PersonBuilder(), uow);
        
        String premium = (String) request.getParameter("premium");
        
        if (premium != null && premium.equals("activate")) {
            
            Person person = getPersonByEmail((String) request.getParameter("email"));
            person.setUserType(DefaultServlet.PREMIUM);
            personRepository.update(person);
            uow.commit();
            System.out.println("PREMIUM Activated");
        }
        
        if(premium!= null && premium.equals("deactivate")) {

			Person person = getPersonByEmail((String) request.getParameter("email"));
			person.setUserType(DefaultServlet.NORMAL);			
			personRepository.update(person);
			uow.commit();
			System.out.println("PREMIUM Deactivated");
        }
        
        HttpSession session = request.getSession(false);
        String email = (String) session.getAttribute("email");
        
        uow = new UnitOfWork(connection);
        personRepository = new PersonRepository(connection, new PersonBuilder(), uow);
        
        List<Person> persons = personRepository.getAll();
        
        System.out.println("Persons: " + persons.size());
        System.out.println("Email: " + email);
        
        request.setAttribute("users", persons);
        
        RequestDispatcher rd = request.getRequestDispatcher("/showAllUsers.jsp");
        rd.forward(request, response);
        
        System.out.println("ShowUsersServlet init completed");
    }


}

