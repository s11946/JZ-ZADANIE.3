/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s11946.jaz.zadanie_2.web.filter;

import com.s11946.jaz.zadanie_2.domain.Person;
import impl.PersonBuilder;
import impl.PersonRepository;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import unitofwork.IUnitOfWork;
import unitofwork.UnitOfWork;

/**
 *
 * @author Bartek
 */

public class DefaultFilter implements Filter {
    
    public static final String ADMIN = "ADMIN";
    public static final String ANONYMOUS = "ANONYMOUS";
    public static final String NORMAL = "NORMAL";
    public static final String PREMIUM = "PREMIUM";
    
    public static final String URL = "jdbc:mysql://localhost/app";
    public static final String USER = "root";
    public static final String PASSWORD = "";
    
    protected Connection connection;
    protected PersonRepository personRepository;
    protected IUnitOfWork uow;
    
	public DefaultFilter() {
		super();
	}

	@Override
	public void init(FilterConfig config) throws ServletException {


		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			uow = new UnitOfWork(connection);

			personRepository = new PersonRepository(connection,
					new PersonBuilder(), uow);



		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		System.out.println("DefaultFilter init completed");
	}

	protected void savePerson(Person person) {
		
		System.out.println("Saving: " + person.toString());
		
		personRepository.add(person);
		uow.commit();
	}

	@Override
	public void destroy() {

		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
	
		
	}
}
