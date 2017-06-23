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
CreditCard creditCard=sessionCustomer.getCreditCard();%>
<form action="saveCreditCard" method="post">
		<pre>
	<br>	Kreditkartennummer:<input type="text" name="cardNumber" value=<%=creditCard.getCardNumber() %> />
		<br>Vorname: <input type="text" name="vorname" value=<%=creditCard.getFirstName() %> /> 
		<br>Nachname:<input type="text" name="nachname" value=<%=creditCard.getLastName() %> /> 
		<br>Kartentyp:<select name="type"><option
					value="MasterCard" <%if(creditCard.getType().equals("MasterCard")){ %>selected<%} %>>MasterCard</option>
			<option value="VisaCard" <%if(creditCard.getType().equals("VisaCard")){ %>selected<%} %>/>VisaCard</option></select> 
			<br>CVV:<input type="text" name="cvv" value=<%=creditCard.getCvv()%> /> 
			<br>Ablaufmonat:<input type="text" name="monat" value=<%=creditCard.getExpiryMonth().toString()%> />
		<br>Ablaufjahr<input type="text" name="jahr" value=<%=creditCard.getExpiryYear().toString() %> />
		 <br>
		 
	
  	 <button type="submit" class="btn btn-primary btn-lg btn-block">Daten speichern</button>
			<br><br>
		</pre>



	</form>
</body>
</html>
