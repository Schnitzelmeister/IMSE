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
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.w3-sidebar a {
	font-family: "Roboto", sans-serif
}

body, h1, h2, h3, h4, h5, h6, .w3-wide {
	font-family: "Montserrat", sans-serif;
}

table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: align;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body class="w3-content" style="max-width: 1200px">

	<!-- Sidebar/menu -->
	<nav class="w3-sidebar w3-bar-block w3-white w3-collapse w3-top"
		style="z-index:3;width:250px" id="mySidebar">

	<div class="w3-container w3-display-container w3-padding-16">
		<h3 class="w3-wide">
			<b>Adminmode</b>
		</h3>
	</div>

	<c:choose>
		<c:when test="${IsAdminTyp==true}">

			<div class="w3-padding-64 w3-large w3-text-grey"
				style="font-weight: bold">

				<a onclick="myAccFunc()" href="javascript:void(0)"
					class="w3-button w3-block w3-white w3-left-align w3-text-grey"
					id="myBtn"> Edit Categories <i class="fa fa-caret-down"></i>
				</a>
				<div id="demoAcc"
					class="w3-bar-block w3-hide w3-padding-large w3-medium">
					<a href="createNewProductCategory" class="w3-bar-item w3-button">Add</a>
					<a href="deleteProductCategory" class="w3-bar-item w3-button">Delete</a>
				</div>

				<a onclick="myAccFunc1()" href="javascript:void(0)"
					class="w3-button w3-block w3-white w3-left-align w3-text-grey"
					id="myBtn1"> Edit Products <i class="fa fa-caret-down"></i>
				</a>
				<div id="demoAcc1"
					class="w3-bar-block w3-hide w3-padding-large w3-medium">
					<a href="createProduct" class="w3-bar-item w3-button">Add</a> <a
						href="deleteProduct" class="w3-bar-item w3-button">Delete</a> <a
						href="updateProduct" class="w3-bar-item w3-button">Update</a>
				</div>

				<a onclick="myAccFunc2()" href="javascript:void(0)"
					class="w3-button w3-block w3-white w3-left-align w3-text-grey"
					id="myBtn2"> Edit Admin <i class="fa fa-caret-down"></i>
				</a>

				<c:choose>
					<c:when test="${IsAdminChief==true}">

						<div id="demoAcc2"
							class="w3-bar-block w3-hide w3-padding-large w3-medium">
							<a href="deleteAdmin" class="w3-bar-item w3-button">Delete</a> <a
								href="verifyAdmin" class="w3-bar-item w3-button">Verify</a>
						</div>


					</c:when>
				</c:choose>

				<a href="deleteUser" class="w3-bar-item w3-button">Edit User</a>

			</div></nav>

	<!-- !PAGE CONTENT! -->
	<div class="w3-main" style="margin-left: 250px">

		<!-- Top header -->
		<header class="w3-container w3-xlarge">
		<p class="w3-left">Online_Shopping_System</p>
		</header>

		<form name="editProd" action="EditProduct" method="POST">
			<!-- list header -->
			<div class="w3-display-container w3-container">
				<table>
					<th><select name="productId" style="width: 100%">
							<c:forEach var="i" begin="0" end="${anzahl5}" step="1">
								<option value="${products3.get(i).getProductId()}">${products3.get(i).getProductName()}
									${products3.get(i).getProductId()}</option>
							</c:forEach>
					</select></th>
					<tr>
						<th><input type="text" name="productName" value="Produktname"
							style="width: 100%"></th>
					</tr>
					<tr>
						<th><select style="width: 100%">
								<c:forEach var="i" begin="0" end="${anzahl4}" step="1">
									<option value="${categories3.get(i).getCategoryId()}">${categories3.get(i).getCategoryName()}</option>
								</c:forEach>
						</select></th>
					</tr>
					<tr>
						<th><input type="text" name="productQuantity" value="Anzahl"
							style="width: 45%"></th>
					</tr>
					<tr>
						<th><input type="text" name="productPrice" value="Preis"
							style="width: 45%"></th>
					</tr>
					<tr>
						<th><label for="picture">1.Bild</label> <input type="file"
							id="picture1"> <input type="text" hidden name="image1"
							id="pictureValue1"></th>
					</tr>
					<tr>
						<th><label for="picture">2.Bild</label> <input type="file"
							id="picture2"> <input type="text" hidden name="image2"
							id="pictureValue2"></th>
					</tr>
					<tr>
						<th><label for="picture">3.Bild</label> <input type="file"
							id="picture3"> <input type="text" hidden name="image3"
							id="pictureValue3"></th>
					</tr>
					<tr>
						<th><label for="picture">4.Bild</label> <input type="file"
							id="picture4"> <input type="text" hidden name="image4"
							id="pictureValue4"></th>
					</tr>
					<tr>
						<th><label for="picture">5.Bild</label> <input type="file"
							id="picture5"> <input type="text" hidden name="image5"
							id="pictureValue5"></th>
					</tr>
					<tr>
						<th><TEXTAREA ROWS=10 COLS=110% name="productDescription">Beschreibung....</TEXTAREA></th>
					</tr>
					<tr>
						<th><input type="submit" value="Aktualisiere"
							style="width: 45%; height: 50px; background-color: green; color: white"></th>
					</tr>
				</table>

			</div>
		</form>

		<!-- End page content -->
	</div>

	</c:when>
	<c:otherwise>
		<div>
			<p>Sie besitzen keine Zugriffsrechte!</p>
		</div>
	</c:otherwise>
	</c:choose>

	<script>
		// Accordion 
		function myAccFunc() {
			var x = document.getElementById("demoAcc");
			if (x.className.indexOf("w3-show") == -1) {
				x.className += " w3-show";
			} else {
				x.className = x.className.replace(" w3-show", "");
			}
		}

		function myAccFunc1() {
			var x = document.getElementById("demoAcc1");
			if (x.className.indexOf("w3-show") == -1) {
				x.className += " w3-show";
			} else {
				x.className = x.className.replace(" w3-show", "");
			}
		}

		function myAccFunc2() {
			var x = document.getElementById("demoAcc2");
			if (x.className.indexOf("w3-show") == -1) {
				x.className += " w3-show";
			} else {
				x.className = x.className.replace(" w3-show", "");
			}
		}
	</script>
</body>
</html>