<%@page import="com.s11946.jaz.zadanie_2.web.DefaultServlet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page language="java" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %>

<jsp:useBean id="user" class="com.s11946.jaz.zadanie_2.domain.Person"></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Profile</title>
</head>
<body>

	<h1>Users</h1>
	<table>
	<c:forEach items="${users}" var="user">
		<tr>
		<td>
			<c:out value="${user.email}" /></td><td>
			<c:out value="${user.userType}" /></td><td>
				
			<c:if test="${user.userType != 'ADMIN'}">
					<a href="/ShowUsersServlet?premium=activate&email=${user.email}" />Aktywuj Premium</a></td><td><a href="/ShowUsersServlet?premium=deactivate&email=${user.email}">Deaktywuj Premium</a>
			</c:if>
			</td>
		</tr>
	</c:forEach>
	</table>

	<br />
	<a href='/index.jsp'>Powrót</a>
	<br />
</body>
</html>