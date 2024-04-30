<%-- 
    Document   : employee_details
    Created on : Mar 26, 2024, 11:54:41 AM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee Page</title>
    </head>
    <body>
        <h1>Employee Details!</h1>
        <form  action="TemperatureServlet.do" method="POST">
            <table>
                <tr>
                    <td>Enter your name :</td>
                    <td><input type="text" name="name" required=""></td>
                </tr>
                <table>
                <tr>
                    <td>Enter your temperature :</td>
                    <td><input type="text" name="temperature" required=""></td>
                </tr>
                <table>
                <tr>
                    <td></td>
                    <td><input type="submit" value="SUBMIT"></td>
                </tr>
            </table>
        </form>
        
    </body>
</html>
