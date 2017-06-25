<%@page import="imse.SS2017.team1.model.Address"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="imse.SS2017.team1.dao.Dao"%>
<%@page import="imse.SS2017.team1.controller.UserController"%>
<%@page import="imse.SS2017.team1.model.CreditCard"%>
<%@page import="imse.SS2017.team1.model.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="defaultsIncludes.jsp" />
</head>
<body>
	<jsp:include page="header.jsp" />
	<%
		Customer sessionCustomer = (Customer) request.getSession().getAttribute("customer");

		if (sessionCustomer.getBillingAdr() != null) {
			Address address = sessionCustomer.getBillingAdr();
	%>
	<form action="planOrder">
		
		<table id="tarik" align="center" style="width: 50%">
		<h2>Rechnungsadresse</h2>
			<tr>
				<td>Strassenname
				<td><%=address.getStreetName()%>
			</tr>
		
			<tr>
				<td>Strassennummer
				<td> <%=address.getStreetNumber()%>
			</tr>
			
			<tr>
				<td>ZusatzInfo
				<td> <%=address.getAdditionalInfo()%>
			</tr>
			
			<tr>
				<td>Stadt
				<td><%=address.getCity()%> 
			</tr>
			
			<tr>
				<td>Postleitzahl
				<td> <%=address.getPostCode()%> 
			</tr>
			
			<tr>
				<td>Land
				<td> <%=address.getCountry()%>
			</tr>
		
		</table><br>
			<br><a type="button" href="updateBillingAddress.jsp">Rechnungsadresse ändern</a>
	  	 	<br><br>
			<button type="submit" class="btn btn-primary btn-lg btn-block">Bestellung fortsetzen</button>
			<br>
			<br>
	

	</form>









	<%
		} else if (sessionCustomer.getBillingAdr() == null) {
	%>

	<form action="saveBillingAddress" method="post">
		<pre>
			<br>Strassenname:<input type="text" name="streetName" />
			<br>Strassennummer: <input type="text" name="streetNumber" /> 
			<br>Zusatzinfo:<input type="text" name="additionalInfo" /> 
			<br>Stadt:<input type="text" name="city" /> 
			<br>Postleitzahl<input type="text" name="postCode" />
			<br>Land<input type="text" name="country" />
			<br>
			<button type="submit" class="btn btn-primary btn-lg btn-block">Daten speichern</button>
			<br>
			<br>
		</pre>
	</form>
	<%
		}
	%>
</body>
</html>
