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

Persönliche Daten
<form method="POST" action="../../editinfo">
        <label>Email: <input type="text" name="email" value="${email}" readonly/></label></br>
        <label>Vorname: <input type="text" name="vorname" value="${vorname}" /></label></br>
        <label>Nachname: <input type="text" name="nachname" value="${nachname}" /></label></br>
        <label>TelefonNr: <input type="text" name="telefonnummer" value="${telefonnummer}"/></label></br>
        <label>Passwort: <input type="password" name="passwort" value="${passwort}"/></label></br>
        <br/>
        <label><input type="submit" value="Kontodaten aktualisieren" /></label></br>
</form>

Kreditkarteninformationen
<form method="POST" action="../../updatecreditcard">
        <label>Kreditkartennummer: <input type="text" name="kreditkartennr" value="${kreditkartennr}"/></label></br>
        <label>Vorname: <input type="text" name="vornamekreditkarte" value="${vornamekreditkarte}" /></label></br>
        <label>Nachname: <input type="text" name="nachnamekreditkarte" value="${nachnamekreditkarte}" /></label></br>
        <label>Typ: <input type="text" name="typ" value="${typ}"/></label></br>
        <label>CVV: <input type="text" name="cvv" value="${cvv}"/></label></br>
        <label>Gültig bis (Monat): <input type="text" name="gueltigbismonat" value="${gueltigbismonat}"/></label></br>
        <label>Gültig bis (Jahr): <input type="text" name="gueltigbisjahr" value="${gueltigbisjahr}"/></label></br>
        <br/>
        <label><input type="submit" value="Kreditkartendaten aktualisieren" /></label></br>
</form>

Rechnungsadresse
<form method="POST" action="../../updatebilling">

        <label>Stadt: <input type="text" name="stadtr" value="${stadtr}"/></label></br>
        <label>Straßenname: <input type="text" name="strassennamer" value="${strassennamer}" /></label></br>
        <label>Hausnummer: <input type="text" name="hausnummerr" value="${hausnummerr}" /></label></br>
        <label>PLZ: <input type="text" name="plzr" value="${plzr}"/></label></br>
        <label>Land: <input type="text" name="landr" value="${landr}"/></label></br>        
        <label>Zusätzliche Informationen: <input type="text" name="infor" value="${infor}" /></label></br>
        
        <br/>
        <label><input type="submit" value="Rechnungsadresse aktualisieren" /></label></br>
</form>

Sendungsadresse
<form method="POST" action="../../updateshipping">

        <label>Stadt: <input type="text" name="stadts" value="${stadts}"/></label></br>
        <label>Straßenname: <input type="text" name="strassennames" value="${strassennames}" /></label></br>
        <label>Hausnummer: <input type="text" name="hausnummers" value="${hausnummers}" /></label></br>
        <label>PLZ: <input type="text" name="plzs" value="${plzs}"/></label></br>
        <label>Land: <input type="text" name="lands" value="${lands}"/></label></br>        
        <label>Zusätzliche Informationen: <input type="text" name="infos" value="${infos}" /></label></br>
        <br/>
        <label><input type="submit" value="Sendungsadresse aktualisieren" /></label></br>
        
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