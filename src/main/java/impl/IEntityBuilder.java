/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

import com.s11946.jaz.zadanie_2.domain.Entity;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Bartek
 */
public interface IEntityBuilder<TEntity extends Entity> {
    
    public TEntity build(ResultSet rs) throws SQLException;
    
}
