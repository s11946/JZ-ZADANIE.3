/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

import com.s11946.jaz.zadanie_2.domain.Address;
import java.sql.Connection;
import java.sql.SQLException;
import unitofwork.IUnitOfWork;

/**
 *
 * @author Bartek
 */
public class AddressRepository extends Repository<Address> {
    
    public AddressRepository(Connection connection, IEntityBuilder<Address> builder, IUnitOfWork uow) {
        super(connection, builder, uow);
    }

  	@Override
	protected void setUpUpdateQuery(Address entity) throws SQLException {
		update.setString(1, entity.getProvince());
		update.setString(2, entity.getCity());
		update.setString(3, entity.getPostalCode());
		update.setString(4, entity.getStreet());
		update.setString(5, entity.getHouseNumber());
		update.setString(6, entity.getAddressType());
		update.setInt(7, entity.getId());		
	}

	@Override
	protected void setUpInsertQuery(Address entity) throws SQLException {
		insert.setInt(1, entity.getId());
		insert.setString(2, entity.getProvince());
		insert.setString(3, entity.getCity());
		insert.setString(4, entity.getPostalCode());		
		insert.setString(5, entity.getStreet());
		insert.setString(6, entity.getHouseNumber());
		insert.setInt(7, entity.getPerson().getId());
		insert.setString(8, entity.getAddressType());
	}

	@Override
	protected String getTableName() {
		return "address";
	}

	@Override
	protected String getUpdateQuery() {
		return "update Address set province=?,city=?,postalCode=?, street=?, houseNo=?, addressType=?"
		+ "where id=?";		
	}

	@Override
	protected String getInsertQuery() {
		return createPreInsertQuery()
				+ "  (id, province, city, postalCode, street, houseNo, personId, addressType) values (?,?,?,?,?,?,?,?)";
	}
}
