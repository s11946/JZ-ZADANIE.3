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
public interface IUnitOfWork {
    
    	public void commit();
	public void rollback();
	public void markAsNew(Entity entity, IUnitOfWorkRepository repository);
	public void markAsDirty(Entity entity, IUnitOfWorkRepository repository);
	public void markAsDelete(Entity entity, IUnitOfWorkRepository repository);
    
}
