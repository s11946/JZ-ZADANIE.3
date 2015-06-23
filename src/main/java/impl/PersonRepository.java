/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

import com.s11946.jaz.zadanie_2.domain.Person;
import java.sql.Connection;
import java.sql.SQLException;
import unitofwork.IUnitOfWork;

/**
 *
 * @author Bartek
 */
public class PersonRepository extends Repository<Person> {
    
    public PersonRepository(Connection connection, IEntityBuilder<Person> builder, IUnitOfWork uow) {
        super(connection, builder, uow);
        
    }

    @Override
    protected void setUpUpdateQuery(Person entity) throws SQLException {
                update.setString(1, entity.getFirstName());
		update.setString(2, entity.getLastName());
		update.setString(3, entity.getEmail());
		update.setString(4, entity.getCompany());
		update.setString(5, entity.getJob());
		update.setString(6, entity.getPassword());
		update.setString(7, entity.getUserType());
		update.setInt(8, entity.getId());
    }

    @Override
    protected void setUpInsertQuery(Person entity) throws SQLException {
                insert.setInt(1, entity.getId());
		insert.setString(2, entity.getFirstName());
		insert.setString(3, entity.getLastName());
		insert.setString(4, entity.getEmail());
		insert.setString(5, entity.getCompany());
		insert.setString(6, entity.getJob());
		insert.setString(7, entity.getPassword());
		insert.setString(8, entity.getUserType());
    }
    

    @Override
    protected String getTableName() {

        return "Persons";
    }

    @Override
    protected String getUpdateQuery() {
    
        return "update Persons set firstName=?,lastName=?,email=?, company=?, job=?, password=?, userType=?"
				+ "where id=?";
    }

    @Override
    protected String getInsertQuery() {
        return createPreInsertQuery()
				+ "  (id, firstName, lastName, email, company, job, password, userType) values (?,?,?,?,?,?,?,?)";
    }
    
    
    
}
