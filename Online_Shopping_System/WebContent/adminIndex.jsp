<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Online_Shopping_System</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>  -->
<jsp:include page="adminDefaultIncludes.jsp" />
</head>
<body class="w3-content" style="max-width: 1200px">

	<c:choose>
		<c:when test="${IsAdminTyp==true}">

			<jsp:include page="adminHeader.jsp" />

		</c:when>
		<c:otherwise>
			<div>
				<p>Sie besitzen keine Zugriffsrechte!</p>
			</div>
		</c:otherwise>
	</c:choose>
</body>
</html>