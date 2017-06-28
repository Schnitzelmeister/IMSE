<!DOCTYPE html>
<%@page import="java.util.Enumeration"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="imse.SS2017.team1.model.Category"%>
<%@page import="imse.SS2017.team1.controller.CategoryController"%>
<html lang="en">

<head>
	<jsp:include page="defaultsIncludes.jsp" />
</head>

<body>
	<jsp:include page="header.jsp" />
	<% 
	Enumeration<String> sessionAttributes=request.getSession().getAttributeNames();
	   for (Enumeration<String> e = sessionAttributes; e.hasMoreElements();)
	       System.out.println(e.nextElement());
	
	  System.out.println(request.getSession().getAttribute("email"));
	%>

	<%
		HttpSession newsession2 = request.getSession(false);
		if (newsession2.getAttribute("email") == null) {
	%>

	<form class="login-form" method="post" action="login">
		<input type="text" name="email" placeholder="e-mail adresse" /> <input
			type="password" name="passwort" placeholder="password" /> <input
			type="submit" value="Login" />
		<p class="message">
			Not registered? <a href="newaccount.jsp">Create an account</a>
		</p>
	</form>

	<%
		}
	%>
		
	<%
		if (request.getParameter("errorMessage") != null) {
			request.setAttribute("errorMessage", request.getParameter("errorMessage"));
	%>
	${errorMessage}
	<%
		}
	%>

	<%
		if (request.getParameter("infoMessage") != null) {
			request.setAttribute("infoMessage", request.getParameter("infoMessage"));
	%>
	${infoMessage}
	<%
		}
	%>

</body>
</html>