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
Map<String, Boolean> creditcard=(LinkedHashMap<String,Boolean>)request.getAttribute("creditCard");
Iterator<Map.Entry<String, Boolean>> it = creditcard.entrySet().iterator();
for (Entry<String, Boolean> entry : creditcard.entrySet())
{
    if(entry.getValue()==false){
    	request.getSession().setAttribute("creditCard",creditcard);
    	out.write("FalscherWert:"+entry.getKey());
    	
        
    }
}%>


	<form action="saveCreditCard" method="post">
		<pre>
	<br>	Kreditkartennummer:<input type="text" name="cardNumber" value=<%=it.next().getKey() %> />
		<br>Vorname: <input type="text" name="vorname" value=<%=it.next().getKey() %> /> 
		<br>Nachname:<input type="text" name="nachname" value=<%=it.next().getKey() %> /> 
		<br>Kartentyp:<select name="type"><option
					value="MasterCard" <% if(it.next().getKey().equals("MasterCard")){ %>selected>MasterCard  </option>
			<option value="VisaCard" <%}else {%>selected <%}%>/>VisaCard </option></select> 
			<br>CVV:<input type="text" name="cvv" value=<%=it.next().getKey() %> /> 
			<br>Ablaufmonat:<input type="text" name="monat" value=<%=it.next().getKey() %> />
		<br>Ablaufjahr<input type="text" name="jahr" value=<%=it.next().getKey() %> />
		 <br>
		 
	
  	 <button type="submit" class="btn btn-primary btn-lg btn-block">Daten speichern</button>
			<br><br>
		</pre>



	</form>



</body>
</html>