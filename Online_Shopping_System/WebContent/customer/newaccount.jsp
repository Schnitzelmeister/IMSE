<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kundenkonto anlegen</title>
</head>
<body>

<form method="post" action="register">
        <label>Email: <input type="text" name="email" /></label></br>
        <label>Vorname: <input type="text" name="vorname" /></label></br>
        <label>Nachname: <input type="text" name="nachname" /></label></br>
        <label>TelefonNr: <input type="text" name="telefonnummer" /></label></br>
        <label>Passwort: <input type="password" name="passwort" /></label></br>
        <input type="hidden" name="usertype" value="private" />
        <input type="hidden" name="formtype" value="publicform" />
        <br/>
        <label><input type="submit" value="Konto erstellen" /></label></br>
</form>

 		<%
        if(!(request.getAttribute("errorMessage")==null)) {
        %>
        <strong>${errorMessage}</strong>
        </div>
        <%        	
        }
        %>
        
        <%
        if(!(request.getAttribute("infoMessage")==null)) {
        %>
        <strong>${infoMessage}</strong>
        </div>
        <%        	
        }
        %>

</body>
</html>