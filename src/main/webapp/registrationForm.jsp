<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rejestracja</title>
</head>
<body>
<form action="/RegistrationServlet" method="post">

  	Imie: <input type="text" name="firstName"/><br />
  	Nazwisko: <input type="text" name="lastName" /><br />
  	Email: <input type="text" name="email" /><br /> 
  	Haslo: <input type="password" name="password" /><br />  
	<span>Prosze powtorz swoje haslo</span><br />
  	Haslo:<input type="text" name="repassword" /><br />
	<b>Konto premium?</b><br>
 		
	<input type="checkbox" name="premium">Premium<br>
 	<input type="submit" value="Register" >
</form>
       
</body>
</html>