/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s11946.jaz.zadanie_2.domain;

import java.io.Serializable;

/**
 *
 * @author Bartek
 */
public class Entity implements Serializable {
    
    protected int id;
    
    protected EntityState state;
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public EntityState getState() {
        return state;
    }
    
    public void setState(EntityState state) {
        this.state = state;
    }
    
}
