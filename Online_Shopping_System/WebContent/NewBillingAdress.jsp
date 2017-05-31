<%@page import="imse.SS2017.team1.model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="defaultsIncludes.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp" />
<%Product product=(Product)session.getAttribute("product"); %>
Sie wollen das Product <%=(String)product.getProductName() %> kaufen
<br><h1>Bitte geben Sie Ihre Rechnungsadresse ein</h1>
	<form method="post" action="CheckAddress">
	<pre>
	<br>	Strassenname:<input type="text" name="strassenname"/>
		<br>Strassennummer: <input type="text" name="strassennummer"/> 
		<br>Zusatzadresse:<input type="text"	name="zusatzadresse"/> 
		
			<br>PLZ:<input type="text" name="plz"/> 
			<br>Stadt:<input type="text" name="stadt"/>
		<br>Land:<input type="text" name="land"/>
		<br><input type="submit" value="bestätigen"/>
		</pre>
	</form>
</body>
</html>