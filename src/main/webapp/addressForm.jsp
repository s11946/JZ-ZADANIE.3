<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Address Form</title>
</head>
<body>

			<c:choose>
				<c:when test="${editMode=='true'}">
					<form action="/servletjspdemo/AddressServlet?editMode=true&addressId=${addressId} " method="post">
				</c:when>
				<c:otherwise>
					<form action="/servletjspdemo/AddressServlet" method="post">
				</c:otherwise>
			</c:choose>


		Address Type: <select name="addressType">

			<c:choose>
				<c:when test="${addressType=='address'}">
					<option value="address" selected>Address</option>
				</c:when>
				<c:otherwise>
					<option value="address">Address</option>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${addressType=='mail address'}">
					<option value="mail address" selected>Mail Address</option>
				</c:when>
				<c:otherwise>
					<option value="mail address">Mail Address</option>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${addressType=='work address'}">
					<option value="work address" selected>Work Address</option>
				</c:when>
				<c:otherwise>
					<option value="work address">Work Address</option>
				</c:otherwise>
			</c:choose>

		</select></br> Province: <select name="province">

			<c:choose>
				<c:when test="${province=='zachodnio-pomorskie'}">
					<option value="zachodnio-pomorskie" selected>Zachodnio-Pomorskie</option>
				</c:when>
				<c:otherwise>
					<option value="zachodnio-pomorskie">Zachodnio-Pomorskie</option>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${province=='kujawsko-pomorskie'}">
					<option value="kujawsko-pomorskie" selected>Kujawsko-Pomorskie</option>
				</c:when>
				<c:otherwise>
					<option value="kujawsko-pomorskie">Kujawsko-Pomorskie</option>
				</c:otherwise>
			</c:choose>

			<c:choose>
				<c:when test="${province=='mazowieckie'}">
					<option value="mazowieckie" selected>Mazowieckie</option>
				</c:when>
				<c:otherwise>
					<option value="mazowieckie">Mazowieckie</option>
				</c:otherwise>
			</c:choose>


		</select></br> City:<input type="text" name="city" value="<c:out value="${city}" />"><br> Post Code:<input type="text"
			name="postCode" value="<c:out value="${postalCode}" />"><br> Street:<input type="text" name="street"
			value="<c:out value="${street}" />"><br> House No.:<input type="text" name="houseNo"
			value="<c:out value="${houseNo}" />"><br> <input type="submit" value=" Save Address " />
	</form>
</body>
</html>