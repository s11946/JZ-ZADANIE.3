/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitofwork;

import com.s11946.jaz.zadanie_2.domain.Entity;

/**
 *
 * @author Bartek
 */
public interface IUnitOfWorkRepository {
    
        public void persistAdd(Entity entity);
	public void persistUpdate(Entity entity);
	public void persistDelete(Entity entity);
    
}
