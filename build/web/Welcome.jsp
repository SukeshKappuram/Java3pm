<%-- 
    Document   : Welcome
    Created on : Dec 13, 2018, 4:12:34 PM
    Author     : iamsu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            Hello <%=request.getParameter("userName")%>!
           
        </h1>
    </body>
</html>
