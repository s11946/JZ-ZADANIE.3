/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.util.List;

/**
 *
 * @author Bartek
 */
public interface IRepository<TEntity> {
    public TEntity get(int id);
    
    public void add(TEntity entity);
    
    public void update(TEntity entity);
    
    public void delete(TEntity entity);
    
    public List<TEntity> getAll();
    
}
