<%@page import="imse.SS2017.team1.dao.DaoInterface"%>
<%@page import="imse.SS2017.team1.dao.Dao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="imse.SS2017.team1.model.CreditCard"%>
<%@page import="java.util.List"%>
<%@page import="imse.SS2017.team1.model.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</style>
<jsp:include page="defaultsIncludes.jsp" />
</head>
<body>
<jsp:include page="header.jsp" />
	<%
		Customer customer = (Customer) request.getSession().getAttribute("customer");

		CreditCard card = new Dao().getobject(CreditCard.class, customer.getCreditCardInfo());
	%>
	<h1>Bitte kontrollieren Sie Ihre Kreditkartendaten!</h1>
	<table>
	
		<tr>
			<th>Kartennummer</th>

			<th>Vorname</th>
			<th>Nachname</th>
			<th>Kartentyp</th>
			<th>CVV-Nummer</th>
			<th>Ablaufmonat</th>
			<th>Ablaufjahr</th>
		</tr>
		<tr>
			<td><%=card.getCardNumber()%></td>
			<td><%=card.getFirstName()%></td>
			<td><%=card.getLastName()%></td>
			<td><%=card.getType()%></td>
			<td><%=card.getCvv()%></td>
			<td><%=card.getExpiryMonth().toString()%></td>
			<td><%=card.getExpiryYear().toString()%></td>
</tr></table>
<br><br>
<a href="newCreditCard.jsp">Daten ändern</a>
<a href="/Online_Shopping_System/CheckAddress">weiter</a>
</body>
</html>