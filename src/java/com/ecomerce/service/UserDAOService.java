/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecomerce.service;
import com.ecomerce.model.User;
import java.util.List;
/**
 *
 * @author iamsu
 */
public interface UserDAOService {
       int createUser(User u);
       User readUser(User u);
       List<User> readUsers();
       int updateUser(User u);
       int deleteUser(User u);
}
