<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <%@include file="header.jsp"%>
        <div>
            <%
                session.setAttribute("User", null);
                session.invalidate();
            %>
            <form action="User" method="POST">
                <table>
                    <tr>
                            <td>
                                <input type="email" name="mailId" placeholder="Email Id" required/>
                            </td>
                         </tr>
                        <tr>
                            <td>
                                <input type="password" name="password" placeholder="Password" pattern="[a-zA-Z0-9]{6,10}" required/>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="reset" value="Cancel" />
                            </td>
                            <td>
                                <input type="submit" value="Login" />
                            </td>
                        </tr>
                </table>
            </form>
        </div>
        <%@include file="footer.jsp"%>
    </body>
</html>
