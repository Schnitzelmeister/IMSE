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

		if (sessionCustomer.getShippingAddress() != null) {
			Address address = new Dao().getobject(Address.class, sessionCustomer.getShippingAddress());
	%>
	<form action="checkBillingAddress.jsp">
		<pre>
			<br>Strassenname:		 <%=address.getStreetName()%>
			<br>Strassennummer: 	 <%=address.getStreetNumber()%>
			<br>Zusatzinfo: 		 <%=address.getAdditionalInfo()%>
			<br>Stadt: 				 <%=address.getCity()%> 
			<br>Postleitzahl:		 <%=address.getPostCode()%> 
			<br>Land: 				 <%=address.getCountry()%>
			<br><a type="button" href="updateShippingAddress.jsp">Lieferadresse ändern</a>
	  	 	<br>
			<button type="submit" class="btn btn-primary btn-lg btn-block">Bestellung fortsetzen</button>
			<br>
			<br>
		</pre>

	</form>









	<%
		} else if (sessionCustomer.getShippingAddress() == null) {
	%>

	<form action="saveShippingAddress" method="post">
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