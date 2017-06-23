<%@page import="imse.SS2017.team1.model.Address"%>
<%@page import="imse.SS2017.team1.dao.Dao"%>
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

<% Customer sessionCustomer=(Customer)request.getSession().getAttribute("customer");
Address address=sessionCustomer.getBillingAdr();%>
<form action="saveBillingAddress" method="post">
		<pre>
			<br>Strassenname:		<input type="text" name="streetName" value=<%=address.getStreetName() %> />
			<br>Strassennummer: 	<input type="text" name="streetNumber" value=<%=address.getStreetNumber() %> /> 
			<br>Zusatzinfo:			<input type="text" name="additionalInfo" value=<%=address.getAdditionalInfo() %> /> 
			<br>Stadt:				<input type="text" name="city" value=<%=address.getCity()%> /> 
			<br>Postleitzahl:		<input type="text" name="postCode" value=<%=address.getPostCode()%> />
			<br>Land:				<input type="text" name="country" value=<%=address.getCountry() %> />
			<br> <button type="submit" class="btn btn-primary btn-lg btn-block">Daten speichern</button>
			<br>
			<br>
		</pre>
</form>
</body>
</html>
