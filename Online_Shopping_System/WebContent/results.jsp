<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="imse.SS2017.team1.controller.FoundResult" %>
<%@ page import="imse.SS2017.team1.controller.FoundProduct" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Results</title>
</head>
<body>

<%
	FoundResult results = (FoundResult)request.getAttribute("results");
%>

<p>&nbsp;</p>
<form method="get" action="results">
        <table>
            <tr><td>Search your Product</td>
            <td><select name="cat" id="cat"><option value="0"<% if (results.getCategoryId() == 0) { out.write(" selected"); } %>>In all Categories</option>

<%
for ( Map.Entry<Integer, String> me : results.getCategories().entrySet() ) {
	out.write("<option value=\"" + me.getKey() + "\"");
	if (me.getKey().equals( results.getCategoryId() )) out.write(" selected");
	out.write(">" + me.getValue() + "</option>");
}
%>
            </select></td>
            <td><input name="search" type="text" value="<%= results.getSearchText() %>" /></td>
            <td><input type="submit" value="Search" /></td></tr>
        </table>
</form>

<p>&nbsp;</p>

<p>
<%
if ( results.getFoundCategoriesStat().size() == 0 ) {
	out.write("No results");
}
else
{
	out.write("Found in Categories: ");
	for ( Map.Entry<Integer, Integer> me : results.getFoundCategoriesStat().entrySet() ) {
		out.write("<a href=\"results?search=" + java.net.URLEncoder.encode(results.getSearchText(), "UTF-8") + "&cat=" + me.getKey() + "\">" + results.getCategoryNameById(me.getKey()) + " (" + me.getValue() + " items)</a> ");
	}
}
%>
</p>

<p>&nbsp;</p>

<p>Sort by:<select name="sort">
<option value="0"<% if (results.getSortMode() == 0) { out.write(" selected"); } %>>Price DESC</option>
<option value="1"<% if (results.getSortMode() == 1) { out.write(" selected"); } %>>Price ASC</option>
<option value="2"<% if (results.getSortMode() == 2) { out.write(" selected"); } %>>NAME</option>
</select>
</p>

<p>&nbsp;</p>

<table>

<% 
int pos = results.getPageNumber() * results.getPageSize();
for (FoundProduct prod : results.getFoundProducts()) { %>
<tr>
<td><%= ++pos%></td>
<td><img src="https://images-eu.ssl-images-amazon.com/images/I/31q6ZxsV5lL._AC_US218_.jpg" style="box-sizing: border-box; max-width: 100%; border: 0px; vertical-align: top;" width="218" /></td>
<td style="width:100%">
	<table style="width:100%">
		<tr><td><b><%= prod.getName() %></b></td></tr>
		<tr><td><table style="width:100%">
			<tr><td style="width:100%">EUR <%= prod.getPrice() %></td>
                 <td><table><tr><td>Quantity</td><td>
                 		<select id="quantity" >
                 			<option selected value="1">1</option>
                 			<option value="2">2</option>
                 			<option value="3">3</option>
                 			<option value="4">4</option>
                 			<option value="5">5</option>
                 		</select></td>
						<td><a href="doit()" style="white-space: nowrap">Add To Bin</a></td></tr></table>
                  </td>
			</tr></table>
		</td></tr>
		<tr><td><%= prod.getDescription() %></td></tr>
		<tr><td>Categories: 
<%
for ( int catId : prod.getCategoryIds() ) {
	out.write(results.getCategoryNameById(catId) + "  ");
}
%>
		</td></tr>
	</table>
</td>
</tr>
<% } %>
</table>

<p>&nbsp;</p>

<p>
<%
if ((pos + 1) == (results.getPageNumber() + 1) * results.getPageSize()) {
	for ( int i = 0; i < results.getPageNumber(); ++i ) {
		out.write("<a href=\"results?search=" + java.net.URLEncoder.encode(results.getSearchText(), "UTF-8") + "&cat="+ results.getCategoryId() +"&pnum=" + i + "\">" + i + "</a>  ");
	}
	out.write("<a href=\"results?search=" + java.net.URLEncoder.encode(results.getSearchText(), "UTF-8") + "&cat="+ results.getCategoryId() +"&pnum=" + results.getPageNumber() + "\">next >></a>  ");
}
%>
</p>

</body>
</html>