/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s11946.jaz.zadanie_2.web.filter;

import com.s11946.jaz.zadanie_2.domain.Person;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sun.text.normalizer.ICUBinary;

/**
 *
 * @author Bartek
 */
@WebFilter("/LoginServlet")
public class LoginFilter extends DefaultFilter implements Filter { 
 
    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        
        String email = (String) request.getParameter("email");
        String password = (String) request.getParameter("password");
        
        ServletContext context = request.getServletContext();
        
        if (email != null && !email.equals("") && password != null && !password.equals("")) {
                
            Person person = new Person();
            person.setEmail(email);
            person.setPassword(password);
            boolean authenticated = authenticate(person);
            
            if (!authenticated) {
                
                System.out.println("LoginFilter - NOT authenticated: " +request.getParameter("email"));
                
                RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
                rd.forward(request, response);
            } else {
                System.out.println("LoginFilter - authenticated: " + request.getParameter("email"));
                
                chain.doFilter(req, res);
                
            }
        } else {
            System.out.println("LoginFilter - NOT valid and NOT authenticated: " + request.getParameter("email"));
            
            RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
            rd.forward(request, response);
                    
        }
        
    }


    /**
     * Destroy method for this filter
     */
    public void destroy() {        
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig config) throws ServletException {
        super.init(config);
        
        System.out.println("LoginFilter init completed");
    }


    private boolean authenticate(Person person) {
        List<Person> persons = personRepository.getAll();
        System.out.println("Persons size: " + persons.size());
        for ( Person personTmp : persons) {
            
            System.out.println("PersonTmp: " + personTmp.toString());
            System.out.println("Person: " + person.toString());
            
            if (personTmp.getEmail().equals(person.getEmail()) && personTmp.getPassword().equals(person.getPassword())) {
                return true;
            }
        }
        return false;
    }
    
}
