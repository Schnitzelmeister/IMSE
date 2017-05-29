<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hauptseite</title>
</head>
<body>


<a href="/Online_Shopping_System/customer/customerlogin.jsp">Customer login</a></br>
<a href="/Online_Shopping_System/customer/newaccount.jsp">New customer account</a></br>
<a href="/Online_Shopping_System/logout">Logout</a></br>
<a href="/Online_Shopping_System/customer/private/editcustomerinfo.jsp">Edit customer info</a></br>


<% 
if(request.getParameter("errorMessage")!=null){
	request.setAttribute("errorMessage", request.getParameter("errorMessage"));
%>
${errorMessage}    
<% 
}       
%>

<% 
if(request.getParameter("infoMessage")!=null){
	request.setAttribute("infoMessage", request.getParameter("infoMessage"));
%>
${infoMessage}    
<% 
}       
%>


</body>
</html>