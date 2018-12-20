/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecomerce.controller;

import com.ecomerce.dao.CategoryDAOImpl;
import com.ecomerce.model.Category;
import com.ecomerce.service.CategoryDAOService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author iamsu
 */
@WebServlet(name = "CategoryController", urlPatterns = {"/Category"})
public class CategoryController extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String referer=request.getHeader("referer");
        String mode=request.getParameter("m");
        HttpSession session=request.getSession();
        PrintWriter out=response.getWriter();
        CategoryDAOService cd=new CategoryDAOImpl();
        if(mode.equals("d")){
            int id=Integer.parseInt(request.getParameter("id"));
            Category c =new Category(id,null);
            cd.delete(c);
        }else if(mode.equals("e")){
            int id=Integer.parseInt(request.getParameter("id"));
            Category c =new Category(id,null);
            session.setAttribute("category",cd.read(c));
        }else if(mode.equals("u")){
            int id=Integer.parseInt(request.getParameter("id"));
            String name=request.getParameter("name");
            Category c =new Category(id, name);
            cd.update(c);
        }
        else if(mode.equals("c")){
            String name=request.getParameter("name");
            Category c =new Category(name);
            cd.create(c);
        }
        session.setAttribute("categories", cd.read());
        response.sendRedirect("Category.jsp");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
