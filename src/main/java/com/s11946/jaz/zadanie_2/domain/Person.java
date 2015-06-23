/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.s11946.jaz.zadanie_2.domain;

/**
 *
 * @author Bartek
 */
public class Person extends Entity {
    
    private String firstName = "unknown";
    private String lastName = "unknown";
    private String email;
    private String password;
    private String userType;
    private String company;
    private String job;
    
    public Person() {
        super();
    }

    public Person(String firstName, String lastName){
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

   
    public void setPassword(String password) {
        this.password = password;
    }


    public String getUserType() {
        return userType;
    }


    public void setUserType(String userType) {
        this.userType = userType;
    }


    public String getCompany() {
        return company;
    }

 
    public void setCompany(String company) {
        this.company = company;
    }

  
    public String getJob() {
        return job;
    }


    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Person{" + "firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password + ", userType=" + userType + ", company=" + company + ", job=" + job + '}';
    }
    
    
    
    
}
