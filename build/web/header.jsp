<%-- 
    Document   : header.jsp
    Created on : Dec 17, 2018, 3:28:32 PM
    Author     : iamsu
--%>

<%@page import="com.ecomerce.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            header{
                max-width: 100%;
                text-align: center;
                background-color: #3300cc;
                color: #fff;
            }
            nav a{
                color: white;
                text-decoration: none;
                padding: 0 20px;
            }
            nav a:hover{
                color:#3300cc;
                background-color: #fff;
            }
        </style>
    </head>
    <body>
        <header>
            <h1>FlipKart</h1>
            <%
                User u=(User)session.getAttribute("User");
                try{
            %>
            <nav>
                <a href="index.html">Home</a>
                <a href="Aboutus.html">About Us</a>
                <%
                    if(u.getId()==0){
                %>
                    <a href="Signup.jsp">Sign Up</a>
                    <a href="Login.jsp">Login</a>
                <%
                    }else{
                %>
                <a href="Login.jsp">Logout</a>
                <%
                    }
                }
                catch(Exception e){
                %>
                <a href="Signup.jsp">Sign Up</a>
                <a href="Login.jsp">Login</a>
                <%
                }   
                %>
            </nav>
        </header>
    </body>
</html>
