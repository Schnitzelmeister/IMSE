<%@page import="imse.SS2017.team1.model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="defaultsIncludes.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp" />
<%Product product=(Product)session.getAttribute("product"); %>
Sie wollen das Product <%=(String)product.getProductName() %> kaufen
<br><h1>Bitte geben Sie Ihre Kreditkartendaten ein</h1>
	<form method="post" action="NewCreditCard">
	<br>	Kreditkartennummer:<input type="text" name="cardNumber"/>
		<br>Vorname: <input type="text" name="vorname"/> 
		<br>Nachname:<input type="text"	name="nachname"/> 
		<br>Kartentyp:<select name="type"><option
				value="mastercard">MasterCard</option>
			<option value="visacard"/>VisaCard</option></select> 
			<br>CVV:<input type="text" name="cvv"/> 
			<br>Ablaufmonat:<input type="text" name="monat"/>
		<br>Ablaufjahr<input type="text" name="jahr"/>
		<input type="submit" value="bestätigen"/>
	</form>
</body>
</html>