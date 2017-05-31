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


</body>
</html>