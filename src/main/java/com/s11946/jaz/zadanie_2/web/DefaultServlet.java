/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s11946.jaz.zadanie_2.web;

import com.s11946.jaz.zadanie_2.domain.Address;
import com.s11946.jaz.zadanie_2.domain.Person;
import impl.AddressBuilder;
import impl.AddressRepository;
import impl.PersonBuilder;
import impl.PersonRepository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import unitofwork.IUnitOfWork;
import unitofwork.UnitOfWork;

/**
 *
 * @author Bartek
 */
public class DefaultServlet extends HttpServlet {
    public static final String ADMIN = "ADMIN";
    public static final String ANONYMOUS = "ANONYMOUS";
    public static final String NORMAL = "NORMAL";
    public static final String PREMIUM = "PREMIUM";
    
    public static final String URL = "jdbc:mysql://localhost/app";
    public static final String USER = "root";
    public static final String PASSWORD = "";
    
    protected Connection connection;
    protected PersonRepository personRepository;
    protected AddressRepository addressRepository;
    protected IUnitOfWork uow;
    
    public DefaultServlet () {
        super();
    }
    
    

    	@Override
	public void init() throws ServletException {
		super.init();

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			uow = new UnitOfWork(connection);

			personRepository = new PersonRepository(connection,
					new PersonBuilder(), uow);
			addressRepository = new AddressRepository(connection,
					new AddressBuilder(), uow);

		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("DefaultServlet init completed");
	}

	protected void initDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			uow = new UnitOfWork(connection);

			personRepository = new PersonRepository(connection,
					new PersonBuilder(), uow);
			addressRepository = new AddressRepository(connection,
					new AddressBuilder(), uow);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void savePerson(Person person) {

		System.out.println("Saving: " + person.toString());

		personRepository.add(person);
		uow.commit();
	}

	protected void saveAddress(Address address) {

		System.out.println("Saving: " + address.toString());

		addressRepository.add(address);
		uow.commit();
	}

	protected Person getPersonByEmail(String email) {

		initDB();

		List<Person> persons = personRepository.getAll();

		System.out.println("Persons: " + persons.size());
		System.out.println("Email: " + email);

		for (Person person : persons) {
			System.out.println("Person finder: " + person.toString());
			if (person.getEmail().equals(email)) {
				return person;
			}
		}

		return null;
	}

	protected List<Address> getAddressesByPerson(int personId) {

		try {
			init();
		} catch (ServletException e) {
			e.printStackTrace();
		}

		List<Address> addresses = addressRepository.getAll();

		System.out.println("Addresses: " + addresses.size());
		System.out.println("PersonId: " + personId);

		List<Address> addressesByPerson = new ArrayList<Address>();
		for (Address address : addresses) {
			if (address.getPerson().getId() == personId) {
				addressesByPerson.add(address);
			}
		}

		return addressesByPerson;
	}

	protected Address getAddressesById(int addressId) {
		List<Address> addresses = addressRepository.getAll();

		System.out.println("AddressId: " + addressId);

		for (Address address : addresses) {
			if (address.getId() == addressId) {
				return address;
			}
		}

		return null;
	}
}
