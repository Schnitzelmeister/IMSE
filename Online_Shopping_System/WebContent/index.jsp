<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="imse.SS2017.team1.controller.CategoryController" %>
<%@ page import="imse.SS2017.team1.model.Category" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome!!!</title>
</head>
<body>
<form method="POST" action="${pageContext.request.contextPath}/jakub">
        <table>
            <tr>
                <td><a href="${pageContext.request.contextPath}/customer/newaccount.jsp">Register New User</a></td>
                <td>Login:</td><td><input name="login" type="text" /></td>
                <td>Password:</td><td><input name="psw" type="password" /></td>
                <td><input type="submit" value="Login" /></td>
            </tr>
        </table>
</form>
        <table>
            <tr>
                <td><a id="warenkorb" href="${pageContext.request.contextPath}/tarik">Warenkorb (2 items)</a></td>
                <td><a href="${pageContext.request.contextPath}/jakub">Logout</a></td>
            </tr>
        </table>

<p>&nbsp;</p>

<form method="get" action="${pageContext.request.contextPath}/results">
        <table>
            <tr><td>Search your Product</td>
            <td><select name="cat" id="cat"><option value="0">In all Categories</option>

<%
CategoryController cc = new CategoryController();
for (Category c : cc.getAllCategories() )
	out.write("<option value=\"" + c.getCategoryId() + "\">" + c.getCategoryName() + "</option>");
%>

            </select></td>
            <td><input name="search" type="text" /></td>
            <td><input type="submit" value="Search" /></td></tr>
        </table>
</form>

<c:if test="${not empty errorMessage}">
   <c:out value="${errorMessage}"/>
</c:if>
 		
        
       
       ${infoMessage}
      

</body>
</html>