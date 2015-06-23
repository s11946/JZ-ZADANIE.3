<%@page import="com.s11946.jaz.zadanie_2.domain.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><strong>FORM</strong></title>
</head>
<body>

<jsp:useBean id="storage" class="com.s11946.jaz.zadanie_2.service.StorageService" scope="application" />
<%
  for (Person person : storage.getAllPersons()) {
	  out.println("<p>First name: " + person.getFirstName() + "; Surname: " + person.getLastName() + "</p>");
	  
  }
%>
<p>
  <a href="getPersonData.jsp">Dodaj kolejna osobe</a>
</p>

</body>
</html>