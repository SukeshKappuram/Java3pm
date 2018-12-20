/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecomerce.model;

/**
 *
 * @author iamsu
 */
public class Category {
    private int Id;
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public Category(int Id, String name) {
        this.Id = Id;
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public String getName() {
        return name;
    }
    
    
}
