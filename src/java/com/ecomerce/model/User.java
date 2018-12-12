/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecomerce.model;

import java.util.Date;

/**
 *
 * @author iamsu
 */
public class User {
    private int Id;
    private String firstName;
    private String lastName;
    private char gender;
    private Date dob;
    private String mailId;
    private String mobileNumber;
    private String password;

    public User(int Id, String firstName, String lastName, char gender, Date dob, String mailId, String mobileNumber, String password) {
        this.Id = Id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dob = dob;
        this.mailId = mailId;
        this.mobileNumber = mobileNumber;
        this.password = password;
    }
    
    public User(String firstName, String lastName, char gender, Date dob, String mailId, String mobileNumber, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dob = dob;
        this.mailId = mailId;
        this.mobileNumber = mobileNumber;
        this.password = password;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getId() {
        return Id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public char getGender() {
        return gender;
    }

    public String getMailId() {
        return mailId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public Date getDob() {
        return dob;
    }
}
