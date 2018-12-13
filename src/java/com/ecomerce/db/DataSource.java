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
    public static final String DBURL="jdbc:oracle:thin:@localhost:1521:XE";
    public static final String USER="hr";
    public static final String PASSWORD="hr";

    public Connection getCon() {
        return con;
    }

    public void setCon() throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        this.con = DriverManager.getConnection(DBURL, USER, PASSWORD);
    }

    public PreparedStatement getPs() {
        return ps;
    }

    public void setPs(String Query) throws SQLException {
        this.ps = con.prepareStatement(Query);
    }
    
    
}
