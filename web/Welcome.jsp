<%-- 
    Document   : Welcome
    Created on : Dec 13, 2018, 4:12:34 PM
    Author     : iamsu
--%>

<%@page import="com.ecomerce.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <h1>
            Hello <%=request.getParameter("userName")%>!
            
            <%
                Cookie[] cookies=request.getCookies();
                for(Cookie c:cookies){
                    if(c.getName().equals("UserPhone")){
                        %>
                        <br/>User Mobile Number <%=c.getValue()%>
                        <%
                    }
                }

                display();
            %>
            <br/>
            <%
             out.println("User Logged in as "+u.getMailId());
            %>
            <%!
                void display(){

                }
            %>
            
            <%-- --%>
 
        
        
        
        
        
        </h1>
        <%@include file="footer.jsp" %>
    </body>
</html>
