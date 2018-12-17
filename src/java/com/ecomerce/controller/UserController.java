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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        String referer=request.getHeader("referer");
        String mailId=request.getParameter("mailId");
        String password=request.getParameter("password");
        UserDAOService ud=new UserDAOImpl();
        User u;
        RequestDispatcher rd=request.getRequestDispatcher(referer.substring(referer.lastIndexOf("/")+1));
        if(referer.contains("Login")){
            //Login
            u=ud.readUser(new User(mailId, password));
            if(u.getFirstName()==null){
                out.println("User Name Incorrect<br/>");
                rd.include(request, response);
            }
            else if(u.getPassword().equals(password)){
                out.println("Login Successfull");
                Cookie c=new Cookie("UserPhone",u.getMobileNumber());
                response.addCookie(c);
                HttpSession session=request.getSession();
                session.setAttribute("User", u);
                response.sendRedirect("Welcome.jsp?userName="+u.getFirstName()+" "+u.getLastName());
            }else{
                out.println("Password Missmatch");
                rd.include(request, response);
            }
            
        }else{
        String firstName=request.getParameter("firstName");
        String lastName=request.getParameter("lastName");
        String gender=request.getParameter("gender");
        String dob=request.getParameter("dob");
        String mobileNumber=request.getParameter("mobileNumber");
        String cpassword=request.getParameter("cpassword");
        if(password.equals(cpassword)){
        u=new User(firstName, lastName, gender.charAt(0), sdf.parse(dob), mailId, mobileNumber, password);
        if(ud.createUser(u)>0){
            out.print("Registration Successfull");
        }else{
            out.print("Unable to Register");
        }
        }else{
        out.print("Confirm Password Missmatch");
        }
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
