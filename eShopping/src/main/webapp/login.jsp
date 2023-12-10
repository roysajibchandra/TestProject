<%@page import="in.timtim.DB.DBConnect"%>
<%@page import="in.timtim.model.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%
	User auth = (User)  request.getSession().getAttribute("auth");

		if (auth != null) {
			
			response.sendRedirect("index.jsp");
		}
		
		ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");

		if(cart_list != null){
			
			request.setAttribute("cart_list", cart_list);
		}
	%>

<!DOCTYPE html>
<html>
<head>

<title>Login Page</title>

<%@include file="includes/head.jsp"%>
</head>
<body>

	<%@include file="includes/navbar.jsp"%>

	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">User Login</div>
			<div class="card-body">
			
				<div class="form-group">
					<form action="user-login" method="post">
					
						<label>Email Account</label> <input type="email"
							class="form-control" name="email" placeholder="Enter your Email"
							required>
							
							 <label>Password</label> <input type="password"
							class="form-control" name="password"
							placeholder="Enter your Password" required>



						<button type="submit" class="btn btn-primary my-2">Login</button>
					</form>
				</div>




			</div>
		</div>
	</div>

	<%@include file="includes/footer.jsp"%>
</body>
</html>


