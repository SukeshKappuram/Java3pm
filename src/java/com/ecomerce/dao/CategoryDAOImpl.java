/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecomerce.dao;

import com.ecomerce.db.DataSource;
import com.ecomerce.model.Category;
import com.ecomerce.service.CategoryDAOService;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iamsu
 */
public class CategoryDAOImpl implements CategoryDAOService{

    DataSource ds=new DataSource();
    
    @Override
    public int create(Category c) {
        try {
            ds.setCon();
            ds.setPs("insert into Categories(id,name) values(categories_seq.NEXTVAL,?)");
            ds.getPs().setString(1, c.getName());
            return ds.getPs().executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CategoryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    @Override
    public Category read(Category c) {
        try {
            ds.setCon();
            ds.setPs("select * from categories where id=?");
            ds.getPs().setInt(1, c.getId());
            ResultSet rs= ds.getPs().executeQuery();
            if(rs.next()){
            c=new Category(rs.getInt("Id"),rs.getString("name"));
                return c;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CategoryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Category> read() {
        List<Category> categories=new ArrayList<>();
        try {
            ds.setCon();
            ds.setPs("select * from categories");
            ResultSet rs= ds.getPs().executeQuery();
            while(rs.next()){
                categories.add(new Category(rs.getInt("Id"),rs.getString("name")));
            }
        } catch (SQLException |ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return categories;
    }

    @Override
    public int update(Category c) {
        try {
            ds.setCon();
            ds.setPs("update categories set name=? where id=?");
            ds.getPs().setString(1, c.getName());
            ds.getPs().setInt(2, c.getId());
            return ds.getPs().executeUpdate();
        } catch (SQLException|ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return 0;

    }

    @Override
    public int delete(Category c) {
        try {
            ds.setCon();
            ds.setPs("delete from categories where id=?");
            ds.getPs().setInt(1, c.getId());
            return ds.getPs().executeUpdate();
        } catch (SQLException|ClassNotFoundException ex) {
            System.out.println(ex);
        }
        return 0;

    }
    
    public static void main(String[] arg){
        Category c=new Category(1006,"New Category");
        CategoryDAOService cd=new CategoryDAOImpl();
        c=cd.read(c);
        System.out.println(c.getName());
    }
}
