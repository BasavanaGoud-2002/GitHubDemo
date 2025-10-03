<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List ,com.tap.models.PojoClass.Restaurant"%>

<%
List<Restaurant> restaurants =(List<Restaurant>)request.getAttribute("HomeallRestaurants");
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.logo {
	color: white;
	font-size: 24px;
	font-weight: bold;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}

nav ul {
	list-style: none;
	margin: 0;
	padding: 0;
	display: flex;
}

nav ul li {
	margin-left: 25px;
}

nav ul li a {
	text-decoration: none;
	color: white;
	font-size: 16px;
	font-weight: 500;
	transition: all 0.3s ease;
}

nav ul li a:hover {
	color: #000;
	text-shadow: 0 0 3px #fff;
}

body {
	font-family: Arial, sans-serif;
	margin: 0;
	background: linear-gradient(to right, #f8f9fa, #e9ecef);
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
	background: linear-gradient(to rights, #0056b3, #003f7f);
}
</style>

</head>
<body>
	<h1>Home All Restaurant</h1>
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
				<div class="name"><%=r.getName()%></div>
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