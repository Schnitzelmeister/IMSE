<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="imse.SS2017.team1.model.Product"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
</head>
<body>

	<h1>Hallo
	<%=(String) session.getAttribute("customerName")%></h1>

	<%
		List<Product> products = (List<Product>) session.getAttribute("products");
	%>
	<table>
		<tr>
			<th>Produktname</th>
			<th>Produktbeschreibung</th>
			<th>Einheitspreis</th>
			<th>LagerMenge</th>
			<th>Kaufen!</th>
		</tr>
		<%
			for (int i = 0; i < products.size(); i++) {
				String produktname = products.get(i).getProductName();
		%>
		

			<tr>
				<td><%=products.get(i).getProductName()%></td>
				<td><%=products.get(i).getDescription()%></td>
				<td><%=products.get(i).getPrice()%></td>
				<td><%=products.get(i).getQuantity()%></td>
				<td><form action="BuyProduct">
				<input type="text" style ="display: none;" name="auswahl" value=<%=products.get(i).getProductId()%> />
				<input type="submit"  value="kaufen" />
				</form></td>
			</tr>

			
		

		
	
	



	<%
		}
	%>
	</table>

</body>
</html>