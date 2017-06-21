
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
					<a href="createNewProductCategory" class="w3-bar-item w3-button w3-text-blue">Add</a>
					<a href="deleteProductCategory" class="w3-bar-item w3-button w3-text-blue">Delete</a>
				</div>

				<a onclick="myAccFunc1()" href="javascript:void(0)"
					class="w3-button w3-block w3-white w3-left-align w3-text-blue"
					id="myBtn1"> Edit Products <i class="fa fa-caret-down"></i>
				</a>
				<div id="demoAcc1"
					class="w3-bar-block w3-hide w3-padding-large w3-medium">
					<a href="createProduct" class="w3-bar-item w3-button w3-text-blue">Add</a> <a
						href="deleteProduct" class="w3-bar-item w3-button w3-text-blue">Delete</a> <a
						href="updateProduct" class="w3-bar-item w3-button w3-text-blue">Update</a>
				</div>

				<a onclick="myAccFunc2()" href="javascript:void(0)"
					class="w3-button w3-block w3-white w3-left-align w3-text-blue"
					id="myBtn2"> Edit Admin <i class="fa fa-caret-down"></i>
				</a>
				
				<c:choose>
				<c:when test="${IsAdminChief==true}">
				
				<div id="demoAcc2"
					class="w3-bar-block w3-hide w3-padding-large w3-medium">
					<a href="deleteAdmin" class="w3-bar-item w3-button w3-text-blue">Delete</a> <a
						href="verifyAdmin" class="w3-bar-item w3-button w3-text-blue">Verify</a>
				</div>
				
				</c:when>
				</c:choose>

				<a href="deleteUser" class="w3-bar-item w3-button w3-text-blue">Edit User</a>

			</div>
			
			<a href="./logout" class="w3-bar-item w3-button w3-text-grey"><b>LOGOUT</b></a>
			
			</nav>

	<!-- !PAGE CONTENT! -->
	<div class="w3-main" style="margin-left: 250px">

		<!-- Top header -->
		<header class="w3-container w3-xlarge">
		<p class="w3-left w3-text-white" >Online_Shopping_System</p>
		</header>

		<!-- End page content -->
	</div>

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