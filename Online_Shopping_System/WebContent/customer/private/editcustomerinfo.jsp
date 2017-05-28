<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="/Online_Shopping_System/WebContent/loaddata/" />
<title>Kundendaten verwalten</title>
</head>
<body>

<form method="POST" action="../editinfo">
        <label>Email: <input type="text" name="email" value="${email}" /></label></br>
        <label>Vorname: <input type="text" name="vorname" value="${vorname}" /></label></br>
        <label>Nachname: <input type="text" name="nachname" value="${nachname}" /></label></br>
        <label>TelefonNr: <input type="text" name="telefonnummer" value="${telefonnummer}"/></label></br>
        <label>Passwort: <input type="password" name="passwort" value="${passwort}"/></label></br>
        <label>KretikartenNr: <input type="text" name="kreditkartennummer" value="${kreditkartennummer}"/></label></br>
        <br/>
        <label><input type="submit" value="Kontodaten updaten" /></label></br>
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