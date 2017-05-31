<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="defaultsIncludes.jsp" />
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<link rel="stylesheet" href="style.css">

<!-- Website Font style -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">

<!-- Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Passion+One'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Oxygen'
	rel='stylesheet' type='text/css'>
<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kundenkonto anlegen</title>
</head>
<body>
<jsp:include page="header.jsp"/>
	<div class="container">
		<div class="row main">
			<div class="main-login main-center">
				<h5>Erstellen eines privaten Kundenkontos</h5>
				<form method="POST" action="../register">


					<div class="form-group">
						<label for="email" class="cols-sm-2 control-label">Email:</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-envelope fa" aria-hidden="true"></i></span> <input
									type="text" class="form-control" name="email"
									placeholder="Geben Sie die Email an" />
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="vorname" class="cols-sm-2 control-label">Vorname:</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user fa"
									aria-hidden="true"></i></span> <input type="text" class="form-control"
									name="vorname" id="vorname"
									placeholder="Geben Sie Ihren Vornamen an" />
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="nachname" class="cols-sm-2 control-label">Nachname:</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user fa"
									aria-hidden="true"></i></span> <input type="text" class="form-control"
									name="nachname" id="nachname"
									placeholder="Geben Sie Ihren Nachnamen an" />
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="telefonnummer" class="cols-sm-2 control-label">Telefonnummer:</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-mobile fa" aria-hidden="true"></i></span> <input
									type="text" class="form-control" name="telefonnummer"
									id="telefonnummer"
									placeholder="Geben Sie Ihre Telefonnummer an" />
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="passwort" class="cols-sm-2 control-label">Passwort:</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-key fa"
									aria-hidden="true"></i></span> <input type="password"
									class="form-control" name="passwort" id="passwort"
									placeholder="Geben Sie Ihr Passwort an" />
							</div>
						</div>
					</div>

					<div class="form-group ">
						<input type="submit" value="Konto erstellen" />
					</div>

				</form>

				<%
					if (request.getParameter("errorMessage") != null) {
						request.setAttribute("errorMessage", request.getParameter("errorMessage"));
				%>
				<div class="alert alert-warning">
					<strong>${errorMessage}</strong>
				</div>
				<%
					}
				%>

				<%
					if (request.getParameter("infoMessage") != null) {
						request.setAttribute("infoMessage", request.getParameter("infoMessage"));
				%>

				<div class="alert alert-info">
					<strong>${infoMessage}</strong>
				</div>

				<%
					}
				%>

			</div>
		</div>
	</div>
</body>
</html>