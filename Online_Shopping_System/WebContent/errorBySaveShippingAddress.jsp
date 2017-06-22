<%@page import="java.util.Iterator"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="imse.SS2017.team1.dao.Dao"%>
<%@page import="imse.SS2017.team1.model.CreditCard"%>
<%@page import="imse.SS2017.team1.model.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="defaultsIncludes.jsp" />
</head>
<body>
<jsp:include page="header.jsp" />
<%	
Map<String, Boolean> addressMap=(LinkedHashMap<String,Boolean>)request.getAttribute("addressMap");
Iterator<Map.Entry<String, Boolean>> it = addressMap.entrySet().iterator();
for (Entry<String, Boolean> entry : addressMap.entrySet())
{
    if(entry.getValue()==false){
    	request.getSession().setAttribute("addressMap",addressMap);
    	out.write("FalscherWert:"+entry.getKey());
    	
        
    }
}%>


	<form action="saveShippingAddress" method="post">
		<pre>
			<br>Strassenname:		<input type="text" name="streetName" value=<%=it.next().getKey() %> />
			<br>Strassennummer:		<input type="text" name="streetNumber" value=<%=it.next().getKey() %> /> 
			<br>ZusatzInfo:			<input type="text" name="additionalInfo" value=<%=it.next().getKey() %> /> 
			<br>Stadt:				<input type="text" name="city" value=<%=it.next().getKey() %> /> 
			<br>Postleitzahl:		<input type="text" name="postCode" value=<%=it.next().getKey() %> />
			<br>Land:				<input type="text" name="country" value=<%=it.next().getKey() %> />
			<br> <button type="submit" class="btn btn-primary btn-lg btn-block">Daten speichern</button>
			<br><br>
		</pre>
</form>
</body>
</html>