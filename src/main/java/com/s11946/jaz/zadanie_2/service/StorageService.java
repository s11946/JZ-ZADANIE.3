/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s11946.jaz.zadanie_2.service;

import com.s11946.jaz.zadanie_2.domain.Person;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bartek
 */
public class StorageService {
    
    private List<Person> db = new ArrayList<Person>();
    
    public void add(Person person) {
        Person newPerson = new Person(person.getFirstName(), person.getLastName());
        db.add(newPerson);
    }
    
    public List<Person> getAllPersons() {
        return db;
    }
}
