
<%@page import="java.util.*"%>
<%@page import="in.timtim.DAO.ProductDao"%>
<%@page import="in.timtim.DB.DBConnect"%>
<%@page import="in.timtim.model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
User auth = (User) request.getSession().getAttribute("auth");

if (auth != null) {
	request.setAttribute("auth", auth);
}

ProductDao pd = new ProductDao(DBConnect.getcon());

List<Product> products = pd.getAllProducts();

ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");

if(cart_list != null){
	
	request.setAttribute("cart_list", cart_list);
}

%>

<!DOCTYPE html>
<html>
<head>

<title>Shopping</title>

<%@include file="includes/head.jsp"%>
</head>
<body>
	<%@include file="includes/navbar.jsp"%>

	<%-- <% out.println(DBConnect.getcon()); %> --%>
	<div class="container">
		<div class="card-header my-3 text-center">All Products</div>
		<div class="row">
		<%
			if( !products.isEmpty() ){
				for(Product p:products){%>
					<div class="col-md-3 my-3">

					<div class="card" style="width: 18rem;">
						<img src="Book/<%= p.getImage() %>" class="card-img-top text-center" alt="Card image cap">
						<div class="card-body">
							<h5 class="card-title text-center"><%= p.getName() %></h5>
							<h6 class="price text-center">Price: $<%= p.getPrice() %></h6>
							<h6 class="Category text-center">Category: <%= p.getCategory() %></h6>
							<div class="mt-3 d-flex justify-content-between">
							<a href="addToCart?id=<%= p.getId() %>" class="btn btn-danger">Add to Cart</a>
							<a href="order-now?quantity=1&id=<%= p.getId() %>" class="btn btn-primary">Buy Now</a>
							</div>
							
						</div>
					</div>

				</div>
				<% } 
			}
		%>
			
		</div>
	</div>

	<%@include file="includes/footer.jsp"%>
</body>
</html>


