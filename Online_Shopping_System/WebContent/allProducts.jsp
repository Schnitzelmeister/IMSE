<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="java.util.List" %>
   <%@ page import="imse.SS2017.team1.model.Product" %>
    <%@ page import="java.util.ArrayList" %>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

Hallo <%=(String)session.getAttribute("customerName")%>

<% List<Product> products=(List<Product>)session.getAttribute("products"); %>

<%for(int i=0; i< products.size();i++){ %>


<br>Produkte <%=products.get(i).getProductName() %>
<form>

</form>

<%} %>

</body>
</html>