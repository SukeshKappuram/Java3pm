<%-- 
    Document   : Category
    Created on : Dec 20, 2018, 3:16:11 PM
    Author     : iamsu
--%>

<%@page import="java.util.List"%>
<%@page import="com.ecomerce.model.Category"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <%
            try{
            Category category=(Category)session.getAttribute("category");
            %>
                <form action="Category?m=u&&id=<%=category.getId()%>" method="POST">
            <fieldset>
                <legend>Update Category</legend>
                <table border="1">
                    <tbody>
                        <tr>
                            <td>
                                <input type="text" name="name" placeholder="Category Name" value="<%=category.getName()%>"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="submit" value="Update Category" />
                            </td>
                            <td>
                                <input type="reset" value="Cancel" />
                            </td>
                        </tr>
                    </tbody>
                </table>

            </fieldset>
        </form>
            <%
            }catch(Exception e){
                %>
                <form action="Category?m=c" method="POST">
            <fieldset>
                <legend>Category</legend>
                <table border="1">
                    <tbody>
                        <tr>
                            <td>
                                <input type="text" name="name" placeholder="Category Name"/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="submit" value="Add Category" />
                            </td>
                            <td>
                                <input type="reset" value="Cancel" />
                            </td>
                        </tr>
                    </tbody>
                </table>

            </fieldset>
        </form>
                <%
            }
        %>
        
        <ul>
        <%
            List<Category> categories=(List<Category>)session.getAttribute("categories");
            for(Category c:categories){
                %>
                <li><%=c.getName()%> | <a href="Category?m=e&&id=<%=c.getId()%>">edit</a> | <a href="Category?m=d&&id=<%=c.getId()%>">X</a></li>
                <%
            }
        %>
        </ul>
        <%@include file="footer.jsp" %>
    </body>
</html>
