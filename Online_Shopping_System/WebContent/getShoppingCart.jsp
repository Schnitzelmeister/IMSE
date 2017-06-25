<%@page import="java.util.ArrayList"%>
<%@page import="imse.SS2017.team1.controller.ProductController"%>
<%@page import="imse.SS2017.team1.model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<jsp:include page="defaultsIncludes.jsp" />
</head>
<body>
	<form action="GetOrderView">
		<jsp:include page="header.jsp" />
		<% List<Product> products = (List<Product>) request.getSession().getAttribute("productsInCart");
		if(products.size()==0){
		%>
		
		<br>Keine Produkte im Warenkorb <%}else{ %>
		
	 <button type="submit"  class="btn btn-primary btn-lg btn-block">Bestellung fortsetzen</button><br><br>
		<%
			

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
						<div class="panel-body">
							<img src="https://placehold.it/150x80?text=IMAGE"
								class="img-responsive" style="width: 100%" alt="Image">
						</div>
						<div class="panel-footer"><%=products.get(i + 2).getDescription()%></div>

						 
					<div>
					<label>	Menge auswählen (verfügbar:<%=products.get(i + 2).getQuantity()%>)</label><br>
					

							<input type="range" name="quantityInputName<%=products.get(i + 2).getProductId().toString()%>" 
									id="quantityInputId<%=products.get(i + 2).getProductId().toString()%>"
									value="1" min="1" max="<%=products.get(i + 2).getQuantity()%>"
									oninput="quantityOutputId<%=products.get(i+2).getProductId().toString() %>.value = quantityInputId<%=products.get(i + 2).getProductId().toString()%>.value">
							<output style="text-align: center" name="quantityOutput" id="quantityOutputId<%=products.get(i+2).getProductId().toString() %>">1</output>

						
					</div>


						<div style="text-align: center;">
							<a style="color: rgb(255, 0, 0)"
								href="/Online_Shopping_System/DeleteFromShoppingCart?productId=<%=products.get(i + 2).getProductId()%>">
								entfernen</a>
						</div>



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
						<div class="panel-body">
							<img src="https://placehold.it/150x80?text=IMAGE"
								class="img-responsive" style="width: 100%" alt="Image">
						</div>
						<div class="panel-footer"><%=products.get(i + 1).getDescription()%></div>



						<div>
							<label> Menge auswählen (verfügbar:<%=products.get(i + 1).getQuantity()%>)
							</label><br> <input type="range"
								name="quantityInputName<%=products.get(i + 1).getProductId().toString()%>"
								id="quantityInputId<%=products.get(i + 1).getProductId().toString()%>"
								value="1" min="1" max="<%=products.get(i + 1).getQuantity()%>"
								oninput="quantityOutputId<%=products.get(i+1).getProductId().toString() %>.value = quantityInputId<%=products.get(i + 1).getProductId().toString()%>.value">
							<output style="text-align: center" name="quantityOutput"
								id="quantityOutputId<%=products.get(i+1).getProductId().toString() %>">1</output>


						</div>







						<div style="text-align: center;">
							<a style="color: rgb(255, 0, 0)"
								href="/Online_Shopping_System/DeleteFromShoppingCart?productId=<%=products.get(i + 1).getProductId()%>">
								entfernen</a>
						</div>

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
						<div class="panel-body">
							<img src="https://placehold.it/150x80?text=IMAGE"
								class="img-responsive" style="width: 100%" alt="Image">
						</div>
						<div class="panel-footer"><%=products.get(i).getDescription()%></div>

						<div>
							<label> Menge auswählen (verfügbar:<%=products.get(i).getQuantity()%>)
							</label><br> <input type="range"
								name="quantityInputName<%=products.get(i).getProductId().toString()%>"
								id="quantityInputId<%=products.get(i).getProductId().toString()%>"
								value="1" min="1" max="<%=products.get(i).getQuantity()%>"
								oninput="quantityOutputId<%=products.get(i).getProductId().toString() %>.value = quantityInputId<%=products.get(i).getProductId().toString()%>.value">
							<output style="text-align: center" name="quantityOutput"
								id="quantityOutputId<%=products.get(i).getProductId().toString() %>">1</output>

						</div>




						<div style="text-align: center;">
							<a style="color: rgb(255, 0, 0)"
								href="/Online_Shopping_System/DeleteFromShoppingCart?productId=<%=products.get(i).getProductId()%>">
								entfernen</a>
						</div>

					</div>
				</div>
				<%
					}
				%>
			</div>

		</div>
		<br> <br>

		<%
			}
		%><% }%>
	</form>
</body>
</html>

