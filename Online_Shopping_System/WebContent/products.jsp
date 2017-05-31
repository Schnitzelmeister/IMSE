<!DOCTYPE html>
<%@page import="imse.SS2017.team1.controller.ProductController"%>
<%@page import="java.util.ArrayList"%>
<%@page import="imse.SS2017.team1.model.Product"%>
<%@page import="java.util.List"%>
<html lang="en">
<head>
  <jsp:include page="defaultsIncludes.jsp"/>
</head>




<body>

<jsp:include page="header.jsp"/>
 <% 
	ProductController pc=new ProductController();
	List<Product> products=pc.GetAllProducts();
	
for(int i=0,size=products.size(); i<products.size();i++,size-=3){
	
%>
<div class="container"> 
 
  <div class="row">
  <%if(size>=3){ %> 
    <div class="col-sm-4">
      <div class="panel panel-primary">
        <div class="panel-heading"><%=products.get(i+2).getProductName() %></div>
        <div class="panel-body"><img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer"><%=products.get(i+2).getDescription() %></div>
        <a href="BuyProduct?product=<%=products.get(i+2).getProductId() %>">Kaufen</a>
      </div>
    </div>
    <%}  if(size>=2){ %>
    <div class="col-sm-4"> 
      <div class="panel panel-primary">
        <div class="panel-heading"><%=products.get(i+1).getProductName() %></div>
        <div class="panel-body"><img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer"><%=products.get(i+1).getDescription() %></div>
         <a href="BuyProduct?product=<%=products.get(i+1).getProductId() %>">Kaufen</a>
      </div>
    </div>
    <%} if(size>=1){ %>
    <div class="col-sm-4"> 
      <div class="panel panel-primary">
        <div class="panel-heading"><%=products.get(i).getProductName() %></div>
        <div class="panel-body"><img src="https://placehold.it/150x80?text=IMAGE" class="img-responsive" style="width:100%" alt="Image"></div>
        <div class="panel-footer"><%=products.get(i).getDescription() %></div>
         <a href="BuyProduct?product=<%=products.get(i).getProductId() %>">Kaufen</a>
      </div>
    </div>
    <%} %>
  </div>
</div><br><br>

<%} %>




</body>
</html>