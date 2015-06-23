<%-- 
    Document   : login
    Created on : 2015-06-23, 21:37:50
    Author     : Bartek
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page language="java" session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
       
		<form action="LoginServlet" method="post">
			Email: <input type="text" name="email" /><br /><br />  Password: <input
				type="password" name="password" /><br /><br /> <input
				type="submit" value="Login">
		</form>
    </body>
</html>
