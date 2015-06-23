/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

import com.s11946.jaz.zadanie_2.domain.Person;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Bartek
 */
public class PersonBuilder implements IEntityBuilder<Person>{

    @Override
    public Person build(ResultSet rs) throws SQLException {
        Person person = new Person();
       	person.setFirstName(rs.getString("firstName"));
		person.setLastName(rs.getString("lastName"));
		person.setId(rs.getInt("id"));
		person.setEmail(rs.getString("email"));
		person.setPassword(rs.getString("password"));
		person.setUserType(rs.getString("userType"));
		person.setCompany(rs.getString("company"));
		person.setJob("job");
                
                return person;
    }
    
}
