<%@page import="imse.SS2017.team1.model.Category"%>
<%@page import="imse.SS2017.team1.controller.CategoryController"%>
<div class="jumbotron">
  <div class="container text-center">
    <h1>The Best Online Store </h1>      
    <p>Hier findet man alles!</p>
  </div>
</div>

<form method="get" action="${pageContext.request.contextPath}/results">
<table>
<th>
       
            <select name="cat" id="cat"><%CategoryController cc = new CategoryController();
            for (Category c : cc.getAllCategories() ) {%><option value=<%=c.getCategoryId()%>><%=c.getCategoryName() %></option>
            <%} %>
            </select>


</th>
<th>
   <input name="search" class="form-control" size="50" placeholder="Produktname" autocomplete="on">
 
  </th>
  <th>
    <input type="submit" value="Suchen">
 
  </th>
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
        <li><a class="active" href="index.jsp"><span class="glyphicon glyphicon-user"></span> Your Account</a></li>
        <li id="cart"><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span> Cart</a></li>
      </ul>
    </div>
  </div>
</nav>
<h1>${infomessage} </h1>