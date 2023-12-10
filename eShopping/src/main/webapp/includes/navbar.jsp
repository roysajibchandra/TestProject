<nav class="navbar navbar-expand-lg navbar-light bg-light">


	<div class="container">
		<a class="navbar-brand" href="index.jsp">Timtim</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="index.jsp">Home</a></li>

				<li class="nav-item"><a class="nav-link" href="cart.jsp">Cart<span class="badge badge-primary" style="color:red">${cart_list.size() }</span></a>
				</li>

				<%
				if (auth != null) {
				%>
				<li class="nav-item"><a class="nav-link" href="orders.jsp">Orders</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="logOut">LogOut</a>
				</li>
				<%
				} else {
				%>
				<li class="nav-item"><a class="nav-link" href="login.jsp">Login</a>
				</li>
				<%
				}
				%>

			</ul>
			<form class="d-flex">
				<input class="form-control me-2" type="search" placeholder="Search"
					aria-label="Search">
				<button class="btn btn-outline-success" type="submit">Search</button>
			</form>
		</div>
	</div>

</nav>