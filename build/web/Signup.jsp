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
            <form action="User" method="POST">
                <fieldset>
                    <legend>Sign Up</legend>
                    <table border="1">
                    <tbody>
                        <tr>
                            <td>
                                <input type="text" name="firstName" placeholder="First Name" />
                            </td>
                            <td><input type="text" name="lastName" placeholder="Last Name" /></td>
                        </tr>
                        <tr>
                            <td>
                                <input type="date" name="dob" placeholder="dd/MM/YYYY"/>
                            </td>
                            <td>
                                <label>Gender</label>
                                <input type="radio" name="gender" value="m" checked="checked" />Male
                                <input type="radio" name="gender" value="f" />Female
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="email" name="mailId" placeholder="Email Id" />
                            </td>
                            <td>
                                <input type="text" name="mobileNumber" placeholder="Mobile Number" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="password" name="password" placeholder="Password" />
                            </td>
                            <td>
                                <input type="password" name="cpassword" placeholder="Confirm Password" />
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="reset" value="Cancel" />
                            </td>
                            <td>
                                <input type="submit" value="Register" />
                            </td>
                        </tr>
                    </tbody>
                </table>
                </fieldset>
            </form>
        </div>
        <%@include file="footer.jsp"%>
    </body> 
</html>
