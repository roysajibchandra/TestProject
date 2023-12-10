
<%@page import="in.timtim.DAO.OrderDao"%>
<%@page import="java.util.*"%>
<%@page import="in.timtim.DB.DBConnect"%>
<%@page import="in.timtim.model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
User auth = (User) request.getSession().getAttribute("auth");
List<Order> orders = null;
if (auth != null) {
	request.setAttribute("auth", auth);
	orders = new OrderDao(DBConnect.getcon()).userOrders(auth.getId());
} else {
	response.sendRedirect("login.jsp");
}

ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");

if (cart_list != null) {

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

	<div class="container">
		<div class="card-header my-3">
			<table class="table table-light">
				<thead>
					<tr>
						<th scope="col">Date</th>
						<th scope="col">Name</th>
						<th scope="col">Category</th>
						<th scope="col">Quantity</th>
						<th scope="col">Price</th>
						<th scope="col">Cancel</th>
					</tr>
				</thead>
				<tbody>
					<%
					if (orders != null) {
						for (Order o : orders) {
					%>
					<tr>
						<td><%= o.getDate() %></td>
						<td><%=o.getName()%></td>
						<td><%=o.getCategory()%></td>
						<td><%=o.getQuantity()%></td>
						<td><%=o.getPrice()%></td>
						<td><a class="btn btn-sm btn-danger"
							href="cancel-order?id=<%=o.getOrderId()%>">Cancel</a></td>
					</tr>
					<%
					}

					}
					%>
				</tbody>
			</table>
		</div>
	</div>

	<%@include file="includes/footer.jsp"%>
</body>
</html>


