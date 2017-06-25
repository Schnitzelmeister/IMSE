<%@page import="java.util.Comparator"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.TreeMap"%>
<%@page import="imse.SS2017.team1.model.Product"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
<jsp:include page="defaultsIncludes.jsp" />
</head>
<body>
<jsp:include page="header.jsp" />
<%! @SuppressWarnings("unchecked") %>
<% Map<Product, Integer> quantityByProduct=(HashMap<Product, Integer>) request.getAttribute("quantityByProduct");
	List<Product> productsInCart=(ArrayList<Product>)request.getSession().getAttribute("productsInCart");
	Collections.sort(productsInCart, new Comparator<Product>() {
        @Override
        public int compare(Product p2, Product p1)
        {

            return  p2.getProductId().compareTo(p1.getProductId());
        }
    });
	
	request.getSession().setAttribute("quantityByProduct", quantityByProduct);
%>
<form action="checkCreditCard.jsp">
<div class="container">
     
  <table class="table table-striped">
    <thead>
      <tr>
      	<th>ProduktId</th>
        <th>Produktname</th>
        <th>Einzelpreis</th>
        <th>Menge</th>
        <th>Gesamtpreis</th>
      </tr>
    </thead>
    <%Float gesamtpreis=0.0f; %>
    <tbody>
    <%for(int i=0;i<quantityByProduct.size();i++) {%>
      <tr>
      	<td><%=productsInCart.get(i).getProductId() %></td>
        <td><%=productsInCart.get(i).getProductName() %></td>
        <td><%=productsInCart.get(i).getPrice() %> &euro;</td>
        <td><%=quantityByProduct.get(productsInCart.get(i))%></td>
        <td><%=productsInCart.get(i).getPrice()* quantityByProduct.get(productsInCart.get(i))%> &euro; </td>
        <%gesamtpreis+=productsInCart.get(i).getPrice()* quantityByProduct.get(productsInCart.get(i)); %>
      </tr>
     
      <%} %>
      <tr class="success">
      <td></td>
      <td></td>
      <td></td>
      <td>GesamtPreis:</td>
      <td><%=gesamtpreis %> &euro;</td>
      </tr>
  	
    </tbody>
    
  </table>
  <%request.getSession().setAttribute("gesamtPreis", gesamtpreis); %>
  <br>
  	 <button type="submit"  class="btn btn-primary btn-lg btn-block">Bestellung fortsetzen</button><br><br>
</div>




</form>

</body>
</html>

