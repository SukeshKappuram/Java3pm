/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecomerce.controller;

import com.ecomerce.dao.UserDAOImpl;
import com.ecomerce.model.User;
import com.ecomerce.service.UserDAOService;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author iamsu
 */
@WebServlet(name = "UserController", urlPatterns = {"/User"})
public class UserController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException,ParseException {
        response.setContentType("text/html;charset=UTF-8");
        SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/YYYY");
        PrintWriter out = response.getWriter();
        String firstName=request.getParameter("firstName");
        String lastName=request.getParameter("lastName");
        String gender=request.getParameter("gender");
        String dob=request.getParameter("dob");
        String mobileNumber=request.getParameter("mobileNumber");
        String mailId=request.getParameter("mailId");
        String password=request.getParameter("password");
        String cpassword=request.getParameter("cpassword");
        
        User u=new User(firstName, lastName, gender.charAt(0), sdf.parse(dob), mailId, mobileNumber, password);
        UserDAOService ud=new UserDAOImpl();
        if(ud.createUser(u)>0){
            out.print("Registration Successfull");
        }else{
            out.print("Unable to Register");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(UserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
