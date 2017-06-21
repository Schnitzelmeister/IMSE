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

if(sessionCustomer.getCreditCardInfo()!=null){
CreditCard creditCard=new Dao().getobject(CreditCard.class, sessionCustomer.getCreditCardInfo());

//out.println("Update="+request.getParameter("update"));
//out.println("CreditCardOK:"+request.getSession().getAttribute("isCardOK"));
 %>
	<form action="checkAddress.jsp" method="post">
		<pre>
			<br>Kreditkartennummer: <%=creditCard.getCardNumber() %>
			<br>Vorname: <%=creditCard.getFirstName() %>
			<br>Nachname: <%=creditCard.getLastName() %>
			<br>Kartentyp: <%=creditCard.getType() %> 
			<br>CVV: <%=creditCard.getCvv() %> 
			<br>Ablaufmonat: <%=creditCard.getExpiryMonth() %>
			<br>Ablaufjahr: <%=creditCard.getExpiryYear() %>
			<br><a type="button" href="updateCreditCard.jsp">Kreditkartendaten ändern</a>
	  	 	<br><button type="submit" class="btn btn-primary btn-lg btn-block">Bestellung fortsetzen</button>
			<br>
			<br>
		</pre>

	</form>









	<%}else if(sessionCustomer.getCreditCardInfo()==null){ %>
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