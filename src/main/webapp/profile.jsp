<%-- 
    Document   : profile
    Created on : 2015-06-23, 21:40:48
    Author     : Bartek
--%>
<%@page import="com.s11946.jaz.zadanie_2.web.DefaultServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page language="java" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
    </head>
    <body>

	<h1>Profile</h1>
	Email:
	<b><%=session.getAttribute("email")%></b>
	<br /> Password:
	<b><%=session.getAttribute("password")%></b>
	<br /> First Name:
	<b><%=session.getAttribute("firstName")%></b>
	<br /> Last Name:
	<b><%=session.getAttribute("lastName")%></b>
	<br /> User Type:
	<b><%=session.getAttribute("userType")%></b>
	<br />

	<h2>Address</h2>

	<table width="1000px">
		<tr>
		<th align="left">Address</th>
		<th align="left">Province</th>
		<th align="left">City</th>
		<th align="left">Postal Code</th>
		<th align="left">Street</th>
		<th align="left">House No.</th>
		<th align="left"></th>
		<th align="left"></th></tr>	
	<c:forEach items="${addresses}" var="address">
		<tr>
		<td><c:out value="${address.addressType}" /></td>
		<td><c:out value="${address.province}" /></td>
		<td><c:out value="${address.city}" /></td>
		<td><c:out value="${address.postalCode}" /></td>
		<td><c:out value="${address.street}" /></td>
		<td><c:out value="${address.houseNumber}" /></td>
		<td><a href="/servletjspdemo/AddressServlet?address=${address.id}">Edytuj</a></td>
		<td><a href="/servletjspdemo/AddressServlet?deleteMode=true&address=${address.id}">Usun</a></td></tr>
	</c:forEach>
	</table>

	<p>
		<a href="addressForm.jsp">Dodaj Adres</a>
	</p>

	<%
		if (session != null
				&& (session.getAttribute("userType").equals("ADMIN"))) {
	%>
	<p>
		<a href="/ShowUsersServlet">Pokaż użytkwników</a>
	</p>
	<br />
	<%
		}
	%>

	<a href='/index.jsp'>Powrót</a>
	<br />
    </body>
</html>
