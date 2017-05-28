<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kundenkonto anlegen</title>
</head>
<body>



<form method="POST" action="../login">
        <label>Email: <input type="text" name="email" /></label></br>
        <label>Passwort: <input type="password" name="passwort" /></label></br>
        <br/>
        <label><input type="submit" value="Anmelden" /></label></br>
</form>


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