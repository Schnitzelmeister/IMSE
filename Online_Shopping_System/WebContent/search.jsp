<%@page import="imse.SS2017.team1.model.Category"%>
<%@page import="imse.SS2017.team1.controller.CategoryController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="defaultsIncludes.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp" /> 
	<form method="get" action="${pageContext.request.contextPath}/results">

		<table>

			<th><select name="cat" id="cat"><option value="0"
						selected>In all Categories</option>
					<%
						CategoryController cc = new CategoryController();

						for (Category c : cc.getAllCategories()) {
					%><option
						value=<%=c.getCategoryId()%>><%=c.getCategoryName()%></option>

					<%
						}
					%>

			</select></th>

			<th><input name="search" class="form-control" size="50"
				placeholder="Produktname" autocomplete="on"></th>

			<th><input type="submit" value="Suchen"></th>

		</table>

	</form>

</body>
</html>
