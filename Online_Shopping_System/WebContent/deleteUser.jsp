<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Online_Shopping_System</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="adminDefaultIncludes.jsp" />
</head>
<body class="w3-content" style="max-width: 1200px">

	<c:choose>
		<c:when test="${IsAdminTyp==true}">

			<jsp:include page="adminHeader.jsp" />

			<!-- !PAGE CONTENT! -->
			<div class="w3-main" style="margin-left: 250px">

				<c:choose>
					<c:when test="${isUserAvailable==true}">

						<form name="deletekun" action="DeleteUser" method="POST">
							<!-- list header -->
							<div class="w3-display-container w3-container">
								<ul class="w3-ul w3-card-4">
									<c:forEach var="i" begin="0" end="${anzahl1}" step="1">
										<li>
											<div>
												<input type="submit"
													value="Lösche Kunden: ${emails1.get(i)}"
													name="deletedCustomerEmail"
													class="w3-button w3-red w3-small w3-right" />
											</div>
											<span class="w3-large">Nachname: ${names1.get(i)}</span><br>
											<span>Vorname: ${surNames1.get(i)}</span>
										</li>
									</c:forEach>
								</ul>
								<div class="w3-black w3-center w3-padding-24"></div>
							</div>
						</form>

					</c:when>
					<c:otherwise>
						<div>
							<p>Es sind keine User vorhanden!</p>
						</div>
					</c:otherwise>
				</c:choose>
			</div>

		</c:when>
		<c:otherwise>
			<div>
				<p>Sie besitzen keine Zugriffsrechte!</p>
			</div>
		</c:otherwise>
	</c:choose>

	<!-- End page content -->

</body>
</html>