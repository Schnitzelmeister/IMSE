-<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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

			<!-- Sidebar/menu -->
			<nav class="w3-sidebar w3-bar-block w3-white w3-collapse w3-top"
				style="z-index:3;width:250px" id="mySidebar">

			<div class="w3-container w3-display-container w3-padding-16">
				<h3 class="w3-wide">
					<b>Adminmode</b>
				</h3>
			</div>

			<div class="w3-padding-64 w3-large w3-text-grey"
				style="font-weight: bold">

				<a onclick="myAccFunc()" href="javascript:void(0)"
					class="w3-button w3-block w3-white w3-left-align w3-text-blue"
					id="myBtn"> Edit Categories <i class="fa fa-caret-down"></i>
				</a>
				<div id="demoAcc"
					class="w3-bar-block w3-hide w3-padding-large w3-medium">
					<a href="createNewProductCategory"
						class="w3-bar-item w3-button w3-text-blue">Add</a> <a
						href="deleteProductCategory"
						class="w3-bar-item w3-button w3-text-blue">Delete</a>
				</div>

				<a onclick="myAccFunc1()" href="javascript:void(0)"
					class="w3-button w3-block w3-white w3-left-align w3-text-blue"
					id="myBtn1"> Edit Products <i class="fa fa-caret-down"></i>
				</a>
				<div id="demoAcc1"
					class="w3-bar-block w3-hide w3-padding-large w3-medium">
					<a href="createProduct" class="w3-bar-item w3-button w3-text-blue">Add</a>
					<a href="deleteProduct" class="w3-bar-item w3-button w3-text-blue">Delete</a>
					<a href="updateProduct" class="w3-bar-item w3-button w3-text-blue">Update</a>
				</div>

				<a onclick="myAccFunc2()" href="javascript:void(0)"
					class="w3-button w3-block w3-white w3-left-align w3-text-blue"
					id="myBtn2"> Edit Admin <i class="fa fa-caret-down"></i>
				</a>

				<c:choose>
					<c:when test="${IsAdminChief==true}">

						<div id="demoAcc2"
							class="w3-bar-block w3-hide w3-padding-large w3-medium">
							<a href="deleteAdmin" class="w3-bar-item w3-button w3-text-blue">Delete</a>
							<a href="verifyAdmin" class="w3-bar-item w3-button w3-text-blue">Verify</a>
						</div>

					</c:when>
				</c:choose>

				<a href="deleteUser" class="w3-bar-item w3-button w3-text-blue">Edit
					User</a>

			</div>

			<a href="./logout" class="w3-bar-item w3-button w3-text-grey"><b>LOGOUT</b></a>

			</nav>

			<!-- !PAGE CONTENT! -->
			<div class="w3-main" style="margin-left: 250px">

				<c:choose>
					<c:when test="${isProductAvailable==true}">

						<form name="deleteprod" action="DeleteProduct" method="POST">
							<!-- list header -->
							<div class="w3-display-container w3-container">
								<ul class="w3-ul w3-card-4">
									<c:forEach var="i" begin="0" end="${anzahl}" step="1">
										<li>
											<div>
												<input type="submit"
													value="L�sche Produkt: ${products.get(i).getProductId()}"
													name="deletedProductId"
													class="w3-button w3-red w3-small w3-right" />
											</div> <span class="w3-large">ProduktName:
												${products.get(i).getProductName()}</span><br> <span>Preis:
												${products.get(i).getPrice()}</span>
										</li>
									</c:forEach>
								</ul>
								<div class="w3-black w3-center w3-padding-24"></div>
							</div>
						</form>

					</c:when>
					<c:otherwise>
						<div>
							<p>Es sind keine Produkte vorhanden!</p>
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