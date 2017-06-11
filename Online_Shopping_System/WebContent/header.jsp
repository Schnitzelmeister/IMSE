<%@page import="imse.SS2017.team1.model.Category"%>
<%@page import="javax.servlet.http.HttpSession"%>
<%@page import="imse.SS2017.team1.controller.CategoryController"%>
<html lang="en">

<%@page import="imse.SS2017.team1.controller.CategoryController"%>

<div class="jumbotron">
	<div class="container text-center">
		<h1>The Best Online Store</h1>
		<p>Hier findet man alles!</p>
	</div>
</div>



<nav class="navbar navbar-inverse">
  <div class="container-fluid">
   
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="products.jsp"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span> Produkte</a></li>
        <li><a href="search.jsp"><span class="glyphicon glyphicon-search" aria-hidden="true"></span> Suchen</a></li>
    
      </ul>
      <ul class="nav navbar-nav navbar-right">
      <li><a href="GetShoppingCart"><span class="glyphicon glyphicon-shopping-cart"></span> Warenkorb</a></li>
      <%if(session.getAttribute("customer")!=null){ %>
       <li><a href="#"><span class="glyphicon glyphicon-cog"></span> Konto ansehen</a></li>
         <li><a href="logout"><span class="glyphicon glyphicon-off"></span> Ausloggen</a></li>
                 <%} else{%>
         <li><a href="index.jsp" ><span class="glyphicon glyphicon-user"></span> Einloggen</a></li><%} %>
        
      </ul>
    </div>
  </div>
</nav>

<h1>${infomessage} </h1>

<form method="get" action="${pageContext.request.contextPath}/results">
	<table>
		<th><select name="cat" id="cat"><option value="0"
					selected>In all Categories</option>
				<%
					CategoryController cc = new CategoryController();
					for (Category c : cc.getAllCategories()) {
				%><option value=<%=c.getCategoryId()%>><%=c.getCategoryName()%></option>
				<%
					}
				%>
		</select></th>
		<th><input name="search" class="form-control" size="50"
			placeholder="Produktname" autocomplete="on"></th>
		<th><input type="submit" value="Suchen"></th>
	</table>
</form>
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li><a class="active" href="products.jsp">Produkte</a></li>
				<li><a href="contacts.jsp">Kontakt</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li id="cart"><a href="#"><span
						class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
				<%
					HttpSession newsession = request.getSession(false);
					if (newsession.getAttribute("email") != null) {
				%>

				<li><a class="active"
					href="./customer/private/editcustomerinfo.jsp"><span
						class="glyphicon glyphicon-user"></span>Your Account</a></li>

				<li><a href="./logout">Abmelden</a></li>

				<%
					}
				%>
			</ul>
		</div>
	</div>
</nav>
<h1>${infomessage}</h1>

