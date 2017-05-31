<!DOCTYPE html>
<html lang="en">

<head>
<jsp:include page="defaultsIncludes.jsp" />

<style>
form {
	text-align: center;
}
</style>
</head>

<body>
	<jsp:include page="header.jsp" />

<<<<<<< HEAD

=======
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
>>>>>>> fef6e9d381e83e623a091a103ceb70c249bb5ef3

	<form class="login-form" method="post" action="login">
		<input type="text" name="email" placeholder="e-mail adresse" /> <input
			type="password" name="passwort" placeholder="password" /> <input type="submit"
			value="Login" />
		<p class="message">
			Not registered? <a
				href="newaccount.jsp">Create
				an account</a>
		</p>
	</form>

<<<<<<< HEAD
=======
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
      
>>>>>>> fef6e9d381e83e623a091a103ceb70c249bb5ef3

</body>
</html>