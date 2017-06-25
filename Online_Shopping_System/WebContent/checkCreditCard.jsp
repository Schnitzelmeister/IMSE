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
Customer sessionCustomer=(Customer)request.getSession().getAttribute("customer");

if(sessionCustomer.getCreditCard()!=null){
CreditCard creditCard=sessionCustomer.getCreditCard();

//out.println("Update="+request.getParameter("update"));
//out.println("CreditCardOK:"+request.getSession().getAttribute("isCardOK"));
 %>
	<form action="checkShippingAddress.jsp" >
			
	<table id="tarik" style="width:50%" align="center">
	<h2>Kreditkartendaten</h2>
	
	
	<tr> 
		<td>Kreditkartennummer
		<td><%=creditCard.getCardNumber() %>
		
	</tr>

	<tr> 
		<td>Vorname
		<td><%=creditCard.getFirstName() %>
	</tr>
	
	<tr> 
		<td>Nachname
		<td><%=creditCard.getLastName() %>
	</tr>
	
	<tr> 
		<td>Kartentyp
		<td><%=creditCard.getType() %>
	</tr>
	
	<tr> 
		<td>CVV
		<td><%=creditCard.getCvv() %>
	</tr>
	
	<tr> 
		<td>Ablaufmonat
		<td><%=creditCard.getExpiryMonth() %>
	</tr>
	
	<tr> 
		<td>Ablaufjahr
		<td><%=creditCard.getExpiryYear() %>
	</tr>
</table>
			<br><a type="button" href="updateCreditCard.jsp">Kreditkartendaten ändern</a><br>
	  	 	<br><button type="submit" class="btn btn-primary btn-lg btn-block">Bestellung fortsetzen</button>
			<br>
			<br>
			
			
	</form>









	<%}else if(sessionCustomer.getCreditCard()==null){ %>
	<!-- Kreditkarte existiert nicht, hier müssen Kreditkartendaten eingegeben werden 
und in Servlet saveCreditCard überprüft und gespeichert werden -->
	<form action="saveCreditCard" method="post">
		<pre>
	<br>	Kreditkartennummer:<input type="text" name="cardNumber" />
		<br>Vorname: <input type="text" name="vorname" /> 
		<br>Nachname:<input type="text" name="nachname" /> 
		<br>Kartentyp:<select name="type"><option
					value="MasterCard">MasterCard</option>
			<option value="VisaCard" />VisaCard</option></select> 
			<br>CVV:<input type="text" name="cvv" /> 
			<br>Ablaufmonat:<input type="text" name="monat" />
		<br>Ablaufjahr<input type="text" name="jahr" />
		 <br>
		 
	
  	 <button type="submit" class="btn btn-primary btn-lg btn-block">Daten speichern</button>
			<br><br>
		</pre>



	</form>


	<%} %>
</body>
</html>
