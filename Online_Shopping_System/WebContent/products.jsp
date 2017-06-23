<!DOCTYPE html>
<%@page import="java.io.FileOutputStream"%>
<%@page import="imse.SS2017.team1.database.PictureUtility"%>
<%@page import="imse.SS2017.team1.dao.Dao"%>
<%@page import="imse.SS2017.team1.model.Image"%>
<%@page import="imse.SS2017.team1.controller.ProductController"%>
<%@page import="java.util.ArrayList"%>
<%@page import="imse.SS2017.team1.model.Product"%>
<%@page import="java.util.List"%>
<html lang="en">
<head>
<jsp:include page="defaultsIncludes.jsp" />
</head>




<body>

	<jsp:include page="header.jsp" />
	<%
		ProductController pc = new ProductController();
		List<Product> products = pc.getAllProducts();

		for (int i = 0, size = products.size(); i < products.size(); i += 3, size -= 3) {
	%>
	<div class="container">

		<div class="row">
			<%
				if (size >= 3) {
			%>
			<div class="col-sm-4">
				<div class="panel panel-primary">
					<div class="panel-heading"><%=products.get(i + 2).getProductName()%><span
							style="float: right;"><%=products.get(i + 2).getPrice()%>
							Euro</span>
					</div>
					 <%--Statt "pictures" muss man das entsprechende Bild einfgen --%>
        <div class="panel-body"><img src="data:image/jpeg;base64,<%=pc.getProductpictures(products.get(i+2).getProductId())%>" style="width:100%" alt="Image"></div>

					<div class="panel-footer"><%=products.get(i + 2).getDescription()%></div>

					<%
						if (session.getAttribute("productId_" + products.get(i + 2).getProductId()) == null
										&& session.getAttribute("customer") != null) {
									if (products.get(i + 2).getQuantity() == 0 || products.get(i + 2).getQuantity() == null) {
					%>
					<div style="text-align: center;">

						<label style="color: red">Produkt bald wieder Verfuegbar</label>
					</div>
					<%
						} else {
					%>

					<div style="text-align: center;">

						<a
							href="/Online_Shopping_System/saveInShoppingCart?productId=productId_<%=products.get(i + 2).getProductId()%>">
							in den Warenkorb einlegen</a>
					</div>
					<%
						}
					%>
					<%
						} else if (session.getAttribute("customer") != null
										&& session.getAttribute("productId_" + products.get(i + 2).getProductId()) != null) {
					%>
					<div style="text-align: center;">
						<a style="color: rgb(0, 255, 0)" href="#">Produkt bereits im
							Warenkorb</a>
					</div>
					<%
						} else if (session.getAttribute("customer") == null) {
					%>
					<div style="text-align: center;">
						<a href="products.jsp">Produkt ansehen</a>
					</div>
					<%
						}
					%>

				</div>
			</div>

			<%
				}
					if (size >= 2) {
			%>
			<div class="col-sm-4">
				<div class="panel panel-primary">
					<div class="panel-heading"><%=products.get(i + 1).getProductName()%><span
							style="float: right;"><%=products.get(i + 1).getPrice()%>
							Euro</span>
					</div>
					 <%--Statt "pictures" muss man das entsprechende Bild einfgen --%>
        <div class="panel-body"><img src="data:image/jpeg;base64,<%=pc.getProductpictures(products.get(i+1).getProductId())%>" style="width:100%" alt="Image"></div>

					<div class="panel-footer"><%=products.get(i + 1).getDescription()%></div>

					<%
						if (session.getAttribute("productId_" + products.get(i + 1).getProductId()) == null
										&& session.getAttribute("customer") != null) {
							if (products.get(i + 1).getQuantity() == 0 || products.get(i + 1).getQuantity() == null) {
			%>
					<div style="text-align: center;">

						<label style="color: red">Produkt bald wieder Verfuegbar</label>
					</div>
					<%
						} else {
					%>

					<div style="text-align: center;">

						<a
							href="/Online_Shopping_System/saveInShoppingCart?productId=productId_<%=products.get(i+1 ).getProductId()%>">
							in den Warenkorb einlegen</a>
					</div>
					<%
						}
					%>
					<%
						} else if (session.getAttribute("customer") != null
										&& session.getAttribute("productId_" + products.get(i + 1).getProductId()) != null) {
					%>
					<div style="text-align: center;">
						<a style="color: rgb(0, 255, 0)" href="#">Produkt bereits im
							Warenkorb</a>
					</div>
					<%
						} else {
					%>
					<div style="text-align: center;">
						<a href="products.jsp">Produkt ansehen</a>
					</div>
					<%
						}
					%>
				</div>
			</div>

			<%
				}
					if (size >= 1) {
			%>
			<div class="col-sm-4">
				<div class="panel panel-primary">
					<div class="panel-heading"><%=products.get(i).getProductName()%><span
							style="float: right;"><%=products.get(i).getPrice()%>
							Euro</span>
					</div>
				 <%--Statt "pictures" muss man das entsprechende Bild einfgen --%>
        <div class="panel-body"><img src="data:image/jpeg;base64,<%=pc.getProductpictures(products.get(i).getProductId())%>" style="width:100%" alt="Image"></div>

					<div class="panel-footer"><%=products.get(i).getDescription()%></div>

					<%
						if (session.getAttribute("productId_" + products.get(i).getProductId()) == null
										&& session.getAttribute("customer") != null) {
							if (products.get(i).getQuantity() == 0 || products.get(i).getQuantity() == null) {
			%>
					<div style="text-align: center;">

						<label style="color: red">Produkt bald wieder Verfuegbar</label>
					</div>
					<%
						} else {
					%>

					<div style="text-align: center;">

						<a
							href="/Online_Shopping_System/saveInShoppingCart?productId=productId_<%=products.get(i).getProductId()%>">
							in den Warenkorb einlegen</a>
					</div>
					<%
						}
					%>
					<%
						} else if (session.getAttribute("customer") != null
										&& session.getAttribute("productId_" + (Integer) products.get(i).getProductId()) != null) {
					%>
					<div style="text-align: center;">
						<a style="color: rgb(0, 255, 0)" href="#">Produkt bereits im
							Warenkorb</a>
					</div>
					<%
						} else {
					%>
					<div style="text-align: center;">
						<a href="products.jsp">Produkt ansehen</a>
					</div>
					<%
						}
					%>
				</div>
			</div>
			<%
				}
			%>
		</div>
	</div>
	<br>
	<br>

	<%
		}
	%>




</body>
</html>



        