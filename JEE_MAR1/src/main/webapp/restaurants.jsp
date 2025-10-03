<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.tap.models.PojoClass.Restaurant,java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restaurant</title>
<style>
.navbar {
	display: flex;
	justify-content: space-between;
	align-items: center;
	background: linear-gradient(135deg, #ff416c, #ff4b2b);
	padding: 12px 40px;
	position: sticky;
	top: 0;
	z-index: 1000;
}

.navbar .logo {
	font-size: 22px;
	font-weight: bold;
	color: #fff;
	letter-spacing: 1px;
}

.navbar .nav-links {
	list-style: none;
	display: flex;
	gap: 20px;
	margin: 0;
	padding: 0;
}

.navbar .nav-links li a {
	text-decoration: none;
	padding: 8px 16px;
	border-radius: 25px;
	font-size: 15px;
	font-weight: 600;
	color: #fff;
	transition: all 0.3s ease-in-out;
}

.navbar .nav-links li a:hover, .navbar .nav-links li a.active {
	background: #fff;
	color: #ff416c;
	box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.2);
}

body {
	font-family: Arial, sans-serif;
	margin: 0;
	background: linear-gradient(rgba(255, 255, 255, 0.85),
		rgba(255, 255, 255, 0.85)),
		url("https://images.unsplash.com/photo-1504674900247-0877df9cc836")
		no-repeat center center fixed;
	background-size: cover;
	padding: 20px;
}

h1 {
	text-align: center;
	color: #333;
	margin-bottom: 30px;
}

.restaurant-grid {
	display: grid;
	grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
	gap: 25px;
	padding: 0 30px;
}

.card-content {
	background: linear-gradient(to bottom right, #ffffff, #f1f1f1);
	border-radius: 12px;
	padding: 15px;
	box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
	transition: transform 0.3s;
	text-align: center;
}

.card-content:hover {
	transform: scale(1.03);
}

.card-content img {
	width: 100%;
	height: 220px;
	object-fit: cover;
	border-radius: 10px;
	margin-bottom: 10px;
}

.title {
	font-size: 20px;
	font-weight: bold;
	margin: 8px 0;
	color: #2c3e50;
}

.card-content div {
	margin: 4px 0;
	color: #555;
}

a {
	display: inline-block;
	margin-top: 10px;
	padding: 8px 16px;
	background: linear-gradient(to right, #007bff, #0056b3);
	color: #fff;
	text-decoration: none;
	border-radius: 6px;
	font-weight: bold;
}

a:hover {
	background: linear-gradient(to right, #0056b3, #003f7f);
}
</style>
</head>
<body>
	<nav class="navbar">
		<div class="logo">🍴 FoodieExpress</div>
		<ul class="nav-links">
			<li><a href="GetAllRestaurant" class="active">Home</a></li>
			<li><a href="cart.jsp">Cart</a></li>
			<li><a href="login.jsp">Login</a></li>
			<li><a href="register.jsp">Sign Up</a></li>
		</ul>
	</nav>
	
	
	
	<h1>All Restaurant</h1>
	<div class="restaurant-grid">
		<%
		List<Restaurant> all = (List<Restaurant>) (request.getAttribute("restaurants"));
		if (all != null) {
			for (Restaurant r : all) {
		%>
		<a href="GetAllMenu?restaurantId=<%=r.getRestaurantId()%>"> View
			Menu
			<div class="card-content">
				<img src="<%=r.getImagePath()%>" alt="Image">
				<div class="name"><%=r.getName()%>

				</div>
				<div>
					<%=r.getAddress()%></div>
				<div>
					<%=r.getRating()%></div>
				<div>
					<%=r.getCusineType()%></div>
				<div>
					<%=r.getPhone()%></div>
				<div>
					<%=r.getEta()%></div>
				<%=r.getRestaurantId()%>
			</div> <%
 }
 }
 %>
		</a>
</body>
</html>

