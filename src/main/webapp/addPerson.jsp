<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dodaj</title>
</head>
<body>
<jsp:useBean id="person" class="com.s11946.jaz.zadanie_2.domain.Person" scope="session" />

<jsp:setProperty name="person" property="*" /> 

<jsp:useBean id="storage" class="com.s11946.jaz.zadanie_2.service.StorageService" scope="application" />

<% 
  storage.add(person);
%>

<p>Następująca osoba została dodana: </p>
<p>Imię: ${person.firstName} </p>
<p>Rok urodzenia: <jsp:getProperty name="person" property="yob"></jsp:getProperty></p>
<p>
  <a href="showAllPersons.jsp">Pokaż wszystkich</a>
</p>
</body>
</html>