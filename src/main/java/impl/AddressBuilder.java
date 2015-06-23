/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

import com.s11946.jaz.zadanie_2.domain.Address;
import com.s11946.jaz.zadanie_2.domain.Person;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Bartek
 */
public class AddressBuilder implements IEntityBuilder<Address> {

    @Override
    public Address build(ResultSet rs) throws SQLException {
        
        Address address = new Address();
                address.setProvince(rs.getString("province"));
		address.setCity(rs.getString("city"));
		address.setStreet(rs.getString("street"));
		address.setPostalCode(rs.getString("postalCode"));
		address.setHouseNumber(rs.getString("houseNo"));
		address.setId(rs.getInt("id"));       
        
        
         Person p = new Person();
                p.setId(rs.getInt("personId"));
                address.setPerson(p);
                address.setAddressType(rs.getString("addresType"));
                
                return address;
    }
    
    
    
}
