<%-- 
    Document   : index
    Created on : 2015-06-23, 21:26:42
    Author     : Bartek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JAVA</title>
    </head>
    <body>
        <% 
            if (session != null && session.getAttribute("email") != null) {
        %>
        
        Jesteś zalogowany jako
        <%=session.getAttribute("email")%>
        <br />
        <%
            }
        %>
        
        <p>
            <a href="registrationForm.jsp">Registration</a>
            
        </p>
        
        <p>
            <a href="login.jsp">Login</a>
        </p>
        
        <%
            if (session != null && session.getAttribute("email") != null) {
                %>
                
        <p>
		<a href="/servletjspdemo/ProfileServlet">Profile</a>
	</p>
	<p>
		<a href="addressForm.jsp">Add Address</a>
	</p>
	<p>
		<a href="/servletjspdemo/LogoutServlet">Logout</a>
	</p>
        <%
            }
        %>
    </body>
</html>
