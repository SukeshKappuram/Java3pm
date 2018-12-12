/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecomerce.db;
import java.sql.*;
/**
 *
 * @author iamsu
 */
public class DataSource {
    private Connection con;
    private PreparedStatement ps;
    public static final String DBURL="";
    public static final String USER="";
    public static final String PASSWORD="";

    public Connection getCon() {
        return con;
    }

    public void setCon() throws SQLException {
        this.con = DriverManager.getConnection(DBURL, USER, PASSWORD);
    }

    public PreparedStatement getPs() {
        return ps;
    }

    public void setPs(String Query) throws SQLException {
        this.ps = con.prepareStatement(Query);
    }
    
    
}
