<%-- 
    Document   : login
    Created on : Oct 27, 2025, 1:08:37 PM
    Author     : trant
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <br/><h5 style="color: red">${requestScope.LOGIN_ERROR}</h5><br/>
        <form action="MainController" method="post">
        Username: <input type="text" name="txtUsername" value="" required><br/>
        Password: <input type="text" name="txtPassword" value="" required><br/>
        <input type="submit" name="action" value="Login">
        </form>
    </body>
</html>
