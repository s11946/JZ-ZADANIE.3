/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s11946.jaz.zadanie_2.web;

import com.s11946.jaz.zadanie_2.domain.Person;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Bartek
 */
@WebServlet(name = "InitServlet", urlPatterns = {"/InitServlet"})
public class InitServlet extends DefaultServlet {
    
    public InitServlet() {
        super();
    }
    @Override
    public void init() throws ServletException {
        super.init();
        
        String createTableAddress = "CREATE TABLE IF NOT EXISTS Address ("
				+ "id int(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,"
				+ "province VARCHAR (255)," + "city VARCHAR (255),"
				+ "postalCode VARCHAR (255)," + "street VARCHAR (255),"
				+ "houseNo VARCHAR (255)," + "personId int(6), "
				+ "addressType VARCHAR(255) )";

	String createTablePerson = "CREATE TABLE IF NOT EXISTS Persons ("
				+ "id int(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,"
				+ "firstName VARCHAR (255)," + "lastName VARCHAR (255),"
				+ "email VARCHAR (255)," + "password VARCHAR (255),"
				+ "userType VARCHAR (255)," + "company VARCHAR (255),"
				+ "job VARCHAR (255)" + ")";

	Statement stmt;
        
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate(createTableAddress);
            
            stmt = connection.createStatement();
            stmt.executeUpdate(createTablePerson);
            
            Person personAdmin = getPersonByEmail("admin@admin.pl");
            if (personAdmin.getLastName().equals("admin")) {
                System.out.println("ADMIN juz istnieje!");
                } else {
                
                Person person = new Person();
                person.setFirstName("admin");
                person.setLastName("admin");
                person.setEmail("admin@admin.pl");
                person.setPassword("a");
                person.setUserType(RegistrationServlet.ADMIN);
                savePerson(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        System.out.println("InitServlet init completed");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }
}
