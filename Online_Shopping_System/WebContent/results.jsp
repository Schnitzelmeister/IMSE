<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="imse.SS2017.team1.searchengine.FoundResult" %>
<%@ page import="imse.SS2017.team1.searchengine.FoundProduct" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="defaultsIncludes.jsp" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.js" type="text/javascript"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js" type="text/javascript"></script>
<title>Results</title>
</head>
<body>

<jsp:include page="header.jsp" /> 

<%
	FoundResult results = (FoundResult)request.getAttribute("results");
%>

<p>&nbsp;</p>
<form method="get" action="results">
        <table>
            <tr><td>Search your Product</td>
            <td><select name="cat" id="cat"><option value="0"<% if (results.getCategoryId() == 0) out.write(" selected"); %>>In all Categories</option>

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
else if ( results.getCategoryId() == 0 )
{
	out.write("Found in Categories: ");
	for ( Map.Entry<Integer, Integer> me : results.getFoundCategoriesStat().entrySet() ) {
		out.write("<a href=\"results?search=" + java.net.URLEncoder.encode(results.getSearchText(), "UTF-8") + "&cat=" + me.getKey() + "\">" + results.getCategoryNameById(me.getKey()) + " (" + me.getValue() + " items)</a> ");
	}
}
%>
</p>

<p>&nbsp;</p>

<p>Sort by:<select onchange="var s=document.getElementById('sort');location.href='results?search=<%= java.net.URLEncoder.encode(results.getSearchText(), "UTF-8") %>&cat=<%= results.getCategoryId() %>&sort='+s.options[s.selectedIndex].value;" id="sort">
<option value="0"<% if (results.getSortMode() == 0) { out.write(" selected"); } %>>Price ASC</option>
<option value="1"<% if (results.getSortMode() == 1) { out.write(" selected"); } %>>Price DESC</option>
<option value="2"<% if (results.getSortMode() == 2) { out.write(" selected"); } %>>Product Name</option>
</select>
</p>

<p>&nbsp;</p>

<table width="100%">

<% 
int pos = results.getPageNumber() * results.getPageSize();
for (FoundProduct prod : results.getFoundProducts()) { %>
<tr>
<td width="0"><%= ++pos%>.</td><td width="0" style="padding: 10px 10px 10px 10px;">
<%
	if (prod.getImages().length == 0) {
		out.write("</td>");
	}
	else if (prod.getImages().length == 1) {
		out.write("<img src=\"data:image/jpeg;base64," + prod.getImages()[0] + "\" height=\"200\" width=\"200\"/></td>");
	}
	else if (prod.getImages().length > 1) {
		out.write("<script type=\"text/javascript\">imgs"+ prod.getId() + "=new Array(");
		for (int i = 0; i < prod.getImages().length; ++i) {
			out.write("\"data:image/jpeg;base64," + prod.getImages()[i] + "\"");
			if (i != prod.getImages().length-1)
				out.write(",");
		}
		out.write(");</script>");
		%>
<table style="width:0">
<tr align="center"><td colspan="2"><img id="ctlimg<%= prod.getId() %>" height="200" width="200" /></td></tr>
<tr>
	<td align="right"><input type="hidden" id="start<%= prod.getId() %>" onclick="javascript:chgImg(<%= prod.getId() %>,imgs<%= prod.getId() %>,0);" /><a href="javascript:void(0)" onclick="javascript:chgImg(<%= prod.getId() %>,imgs<%= prod.getId() %>,-1);">&lt;</a></td>
 	<td align="left"><a href="javascript:void(0)" onclick="javascript:chgImg(<%= prod.getId() %>,imgs<%= prod.getId() %>,1);">&gt;</a></td>
</tr>
</table></td>
<%
	}
%>

<td width="100%" align="left" valign="top" style="padding: 10px 10px 10px 10px;">
	<table style="width:100%">
		<tr><td><b><%= prod.getName() %></b></td></tr>
		<tr><td><table style="width:100%">
			<tr><td style="width:100%">EUR <%= prod.getPrice() %></td>
                 <td style="width:0; align:right"><table style="width:0; align:right"><tr><td>Quantity</td><td><form id="ajax<%= prod.getId() %>"><input type="hidden" name="prod" value="<%= prod.getId() %>">
                 		<select id="qty<%= prod.getId() %>" name="qnty" >
                 			<option selected value="1">1</option>
                 			<option value="2">2</option>
                 			<option value="3">3</option>
                 			<option value="4">4</option>
                 			<option value="5">5</option>
                 		</select></form></td>
						<td><a href="javascript:void(0)" onclick="javascript:add2cart(<%= prod.getId() %>,<%= prod.getAvailableQuantity() %>)" style="white-space: nowrap">Add To Bin</a>
					</td></tr></table>
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
//System.out.println("pos="+pos);
if (pos == (results.getPageNumber() + 1) * results.getPageSize()) {
	for ( int i = 0; i < results.getPageNumber(); ++i ) {
		out.write("<a href=\"results?search=" + java.net.URLEncoder.encode(results.getSearchText(), "UTF-8") + "&cat="+ results.getCategoryId() +"&pnum=" + i + "&sort=" + results.getSortMode() + "\">" + (i+1) + "</a>  ");
	}
	out.write("<a href=\"results?search=" + java.net.URLEncoder.encode(results.getSearchText(), "UTF-8") + "&cat="+ results.getCategoryId() +"&pnum=" + (results.getPageNumber() + 1) + "&sort=" + results.getSortMode() + "\">next >></a>  ");
}
%>
</p>

</body>
</html>
