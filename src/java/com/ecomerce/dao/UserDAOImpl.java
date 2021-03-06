/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecomerce.dao;

import com.ecomerce.db.DataSource;
import com.ecomerce.model.User;
import com.ecomerce.service.UserDAOService;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iamsu
 */
public class UserDAOImpl implements UserDAOService{

    DataSource ds=new DataSource();
    SimpleDateFormat sdf =new SimpleDateFormat("YYYY-MM-dd");
    @Override
    public int createUser(User u) {
        try {
            ds.setCon();
            ds.setPs("insert into Users(Id,firstName,lastName,gender,dob,mobileNumber,mailId,password) values (user_seq.NEXTVAL,?,?,?,?,?,?,?)");
            ds.getPs().setString(1, u.getFirstName());
            ds.getPs().setString(2, u.getLastName());
            ds.getPs().setString(3, u.getGender()+"");
            ds.getPs().setDate(4, new java.sql.Date(u.getDob().getYear(), u.getDob().getMonth(), u.getDob().getDay()));
            ds.getPs().setString(5, u.getMobileNumber());
            ds.getPs().setString(6, u.getMailId());
            ds.getPs().setString(7, u.getPassword());
            return ds.getPs().executeUpdate();
        } catch (SQLException|ClassNotFoundException ex) {
            System.err.println(ex);
        }
        return 0;
    }

    @Override
    public User readUser(User u) {
        try {
            ds.setCon();
            ds.setPs("select * from users where mailId=?");
            ds.getPs().setString(1,u.getMailId());
            ResultSet rs=ds.getPs().executeQuery();
            if(rs.next()){
                u=new User(rs.getString("firstName"), rs.getString("lastName"), rs.getString("gender").charAt(0), sdf.parse(rs.getString("dob")), rs.getString("mailId"), rs.getString("mobileNumber"), rs.getString("password"));
                u.setId(rs.getInt("Id"));
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
        return u;
    }

    @Override
    public List<User> readUsers() {
        List<User> users=new ArrayList<>();
         try {
            ds.setCon();
            ds.setPs("select * from users");
            ResultSet rs=ds.getPs().executeQuery();
            users.add(new User(rs.getInt("Id"),rs.getString("firstName"), rs.getString("lastName"), rs.getString("gender").charAt(0), sdf.parse(rs.getString("dob")), rs.getString("mailId"), rs.getString("mobileNumber"), rs.getString("password")));
        } catch (Exception ex) {
            System.err.println(ex);
        }
        return users;
    }

    @Override
    public int updateUser(User u) {
        try {
            ds.setCon();
            ds.setPs("update Users set password=? where id=?");
            ds.getPs().setString(1, u.getPassword());
            ds.getPs().setInt(2, u.getId());
            return ds.getPs().executeUpdate();
        } catch (SQLException|ClassNotFoundException ex) {
            System.err.println(ex);
        }
        return 0;
    }

    @Override
    public int deleteUser(User u) {
        try {
            ds.setCon();
            ds.setPs("delete from Users where id=?");
            ds.getPs().setInt(1, u.getId());
            return ds.getPs().executeUpdate();
        } catch (SQLException|ClassNotFoundException ex) {
            System.err.println(ex);
        }
        return 0;
    }
    
    public static void main(String[] arg){
        UserDAOService ud=new UserDAOImpl();
        ud.readUser(new User("virat@Mail.com","123456"));   
    }
}
