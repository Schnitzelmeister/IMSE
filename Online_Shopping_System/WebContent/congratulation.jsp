<%@page import="java.text.DecimalFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="imse.SS2017.team1.model.Product"%>
<%@page import="imse.SS2017.team1.model.OrderDetail"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatterBuilder"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="imse.SS2017.team1.model.CustomerOrder"%>
<%@page import="java.util.List"%>
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


	<h3 align="center">Danke für Ihren Einkauf! </h3><br>
	
	
	<% 
		Dao dao=new Dao();
	   	List<CustomerOrder> orders=dao.getobjects(CustomerOrder.class);
	   	List<Product> products=dao.getobjects(Product.class);
	   	List<CustomerOrder> customerOrders=new ArrayList<CustomerOrder>();
		String customerMail=(String)request.getSession().getAttribute("email");
		//out.write(customerMail);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
		LocalDate localDate = LocalDate.now();
		String aktuelleDatum=dtf.format(localDate);
		 DecimalFormat format = new DecimalFormat("###000.##"); 
		//out.write(aktuelleDatum);
		for(int i=0;i<orders.size();i++){
			if((orders.get(i).getCustomerEmail().equals(customerMail)) && orders.get(i).getDateCreated().equals(aktuelleDatum)){
				//out.write("CustomerOrder created: "+orders.get(i).getDateCreated());
				customerOrders.add(orders.get(i));//somit bleiben nur aktuelle Auftraege von dem Sessioncustomer in der Liste orders
			}
			
			
			
		}
		
		Float gesamtpreis=0f;
	
		for(int i=customerOrders.size()-1;i<customerOrders.size();i++){
		
			List<OrderDetail> orderDetail2=dao.getobjects(OrderDetail.class);
			List<OrderDetail> orderDetails=new ArrayList<OrderDetail>();
			
			for(int j=0; j<orderDetail2.size();j++){
				if(customerOrders.get(i).getOrderId().equals(orderDetail2.get(j).getOrderId())){
					orderDetails.add(orderDetail2.get(j));
					
				}
				
			}
			
			//out.write("Anzahl Positionen"+orderDetails.size());
		%>
		
	<table id="tarik" style="width:75%" align="">
	<h4>Auftragsnummer:<%=customerOrders.get(i).getOrderId() %>,
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
			
		
		<%} } }} %>
		
		<tr class="success" style="background:lime;">
      <td></td>
      <td></td>
      <td></td>
      <td>GesamtPreis:</td>
      <td><%=gesamtpreis %> &euro;</td>
      </tr>
	
	</table>
	
	
	
	
	
	
	
	
	
	
	
</body>
</html>
