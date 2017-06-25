<%@page import="imse.SS2017.team1.model.CreditCard"%>
<%@page import="imse.SS2017.team1.model.Address"%>
<%@page import="imse.SS2017.team1.model.Product"%>
<%@page import="imse.SS2017.team1.model.OrderDetail"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="imse.SS2017.team1.model.CustomerOrder"%>
<%@page import="java.util.List"%>
<%@page import="imse.SS2017.team1.model.Customer"%>
<%@page import="imse.SS2017.team1.dao.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<jsp:include page="defaultsIncludes.jsp" />
</head>
<body>
<jsp:include page="header.jsp" />
<% Dao dao=new Dao(); 
  Customer customer=dao.getobject(Customer.class, (String)request.getSession().getAttribute("email"));
	List<Product> products=dao.getobjects(Product.class);
  List<CustomerOrder> orders=dao.getobjects(CustomerOrder.class);
  List<CustomerOrder> customerOrders=new ArrayList<CustomerOrder>();
	String customerMail=(String)request.getSession().getAttribute("email");
	//out.write(customerMail);
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
	LocalDate localDate = LocalDate.now();
	String aktuelleDatum=dtf.format(localDate);
	 
	//out.write(aktuelleDatum);
	for(int i=0;i<orders.size();i++){
		if((orders.get(i).getCustomerEmail().equals(customerMail)) ){
			//out.write("CustomerOrder created: "+orders.get(i).getDateCreated());
			customerOrders.add(orders.get(i));//somit bleiben nur aktuelle Auftraege von dem Sessioncustomer in der Liste orders
		}
		
		
		
	}
	
	Float gesamtpreis=0f;

%>


<div class="container">
 	
 

  <div class="panel-group" id="accordion">
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">Person</a>
        </h4>
      </div>
      <div id="collapse1" class="panel-collapse collapse">
        <div class="panel-body">
        			
	<table id="tarik" style="width:50%" align="center">
	<h2 align="center">Person</h2>
	
	
	<tr> 
		<td>Vorname
		<td><%=customer.getFirstName() %>
		
	</tr>

	<tr> 
		<td>Nachname
		<td><%=customer.getLastName() %>
	</tr>
	
	<tr> 
		<td>E-mail Adresse
		<td><%=customer.getEmailAddress() %>
	</tr>
	<tr> 
		<td>Telefonnummer
		<td><%=customer.getPhoneNumber() %>
	</tr>
	
	<tr> 
		<td>Password
		<td><%=customer.getPassword() %>
	</tr>

</table>
        </div>
      </div>
    </div>
   
   
   
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">Kreditkartendaten</a>
        </h4>
      </div>
      <div id="collapse2" class="panel-collapse collapse">
        <div class="panel-body"><% CreditCard creditCard=customer.getCreditCard();

 %>
	
			
	<table id="tarik" style="width:50%" align="center">
	<h2 align="center">Kreditkartendaten</h2>
	
	
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
</table></div>
      </div>
    </div>
   
   
    <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">Lieferungsadresse</a>
        </h4>
      </div>
      <div id="collapse3" class="panel-collapse collapse">
        <div class="panel-body"><%
	

		
			Address address1 = customer.getShippingAdr();
	%>
	
		
		<table id="tarik" align="center" style="width: 50%">
		<h2 align="center">Lieferadresse</h2>
			<tr>
				<td>Strassenname
				<td><%=address1.getStreetName()%>
			</tr>
		
			<tr>
				<td>Strassennummer
				<td> <%=address1.getStreetNumber()%>
			</tr>
			
			<tr>
				<td>ZusatzInfo
				<td> <%=address1.getAdditionalInfo()%>
			</tr>
			
			<tr>
				<td>Stadt
				<td><%=address1.getCity()%> 
			</tr>
			
			<tr>
				<td>Postleitzahl
				<td> <%=address1.getPostCode()%> 
			</tr>
			
			<tr>
				<td>Land
				<td> <%=address1.getCountry()%>
			</tr>
		
		</table></div>
      </div>
    </div>
     
     
       <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse4">Rechnungsadresse</a>
        </h4>
      </div>
      <div id="collapse4" class="panel-collapse collapse">
        <div class="panel-body"><%
	

		
			Address address = customer.getBillingAdr();
	%>
	
		
		<table id="tarik" align="center" style="width: 50%">
		<h2 align="center">Rechnungsadresse</h2>
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
		
		</table></div>
      </div>
    </div>
    
    
    
    
       <div class="panel panel-default">
      <div class="panel-heading">
        <h4 class="panel-title">
          <a data-toggle="collapse" data-parent="#accordion" href="#collapse5">Aufträge</a>
        </h4>
      </div>
      <div id="collapse5" class="panel-collapse collapse">
        <div class="panel-body">	<% 	for(int i=0;i<customerOrders.size();i++){
		
			List<OrderDetail> orderDetails=customerOrders.get(i).getOrderDetails();
		%>
		
	<table id="tarik" style="width:75%" align="">
	<br><br><h4>Auftragsnummer:<%=customerOrders.get(i).getOrderId() %>,
	<span>Auftragsdatum:<%=customerOrders.get(i).getDateCreated() %></span></h4>
	
	
	<tr> 
		<th>Positionsnummer
		<th>Produktname
		<th>Menge
		<th>Einzelpreis
		<th>MengenPreis
		
	</tr> 
		
		<% for(int j=0;j<orderDetails.size();j++){ 
			
				for(int k=0;k<products.size();k++){
					
					if(products.get(k).getProductId().equals(orderDetails.get(j).getProductId())){
						gesamtpreis+=products.get(k).getPrice()*orderDetails.get(j).getQuantity();	
			%>
			
			<tr>
				<td><%=j+1 %>
				<td><%=products.get(k).getProductName() %>
				<td><%=orderDetails.get(j).getQuantity() %>
				<td><%=products.get(k).getPrice() %>
				<td><%=products.get(k).getPrice()*orderDetails.get(j).getQuantity() %>
			
			
			</tr>
			
		
		<%} } }  %>
		
	<tr class="success" style="background:lime;">
      <td></td>
      <td></td>
      <td></td>
      <td>GesamtPreis:</td>
      <td><%=gesamtpreis %> &euro;</td>
      </tr>
		 <% } %>
		
	
	
	</table></div>
      </div>
    </div>
  </div> 
</div>
</body>
</html>