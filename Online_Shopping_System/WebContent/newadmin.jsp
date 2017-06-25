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
<link rel="stylesheet" href="/Online_Shopping_System/customer/style.css">

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

 <nav class="navbar navbar-default" role="navigation">
    	  <div class="container">
		
		    <div class="collapse navbar-collapse" id="navbar-brand-centered">
		      <ul class="nav navbar-nav">
		        <li><a href="/Online_Shopping_System/index.jsp">< Zurück zur Hauptseite</a></li>
		        
                  </ul>
                </li>
		      </ul>
		      
		    </div><!-- /.navbar-collapse -->
		  </div><!-- /.container-fluid -->
		</nav>

	<div class="container">
		<div class="row main">
			<div class="main-login main-center">
				<h5>Erstellen eines Administratoraccounts</h5>
				<form method="POST" action="registeradmin">


					<div class="form-group">
						<label for="email" class="cols-sm-2 control-label">Email:</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-envelope fa" aria-hidden="true"></i></span> <input
									type="text" class="form-control" name="email"
									placeholder="Geben Sie die Email des Administrators an" />
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="manageremail" class="cols-sm-2 control-label">Email von Manager:</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-envelope fa" aria-hidden="true"></i></span> <input
									type="text" class="form-control" name="manageremail"
									placeholder="Geben Sie die Email des Vorgesetzten an" />
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
									placeholder="Geben Sie den Vornamen des Administrators an" />
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
									placeholder="Geben Sie den Nachnamen des Administrators an" />
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
									placeholder="Geben Sie ein Passwort an" />
							</div>
						</div>
					</div>

					<div class="form-group ">
						<input type="submit" value="Administrator erstellen" />
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