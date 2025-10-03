z<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login - FoodieExpress</title>
<style>
body {
	font-family: 'Poppins', sans-serif;
	margin: 0;
	padding: 0;
	height: 100vh;
	display: flex;
	justify-content: center;
	align-items: center;
	background:
		url('https://images.unsplash.com/photo-1552566626-52f8b828add9?auto=format&fit=crop&w=1350&q=80')
		no-repeat center center/cover;
	position: relative;
}

body::before {
	content: "";
	position: absolute;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background-color: rgba(0, 0, 0, 0.5);
	/* Dark overlay for readability */
}

.login-box {
	position: relative;
	background: rgba(255, 255, 255, 0.95);
	padding: 30px;
	border-radius: 15px;
	box-shadow: 0 4px 20px rgba(0, 0, 0, 0.3);
	width: 350px;
	text-align: center;
}

.login-box h2 {
	color: #d35400;
	margin-bottom: 20px;
}

.login-box input {
	width: 100%;
	padding: 10px;
	margin: 8px 0;
	border-radius: 8px;
	border: 1px solid #ccc;
	font-size: 1rem;
}

.login-btn, .signup-btn {
	width: 100%;
	padding: 10px;
	border: none;
	border-radius: 8px;
	margin-top: 10px;
	cursor: pointer;
	font-size: 1rem;
}

.login-btn {
	background-color: #27ae60;
	color: #fff;
}

.signup-btn {
	background-color: #d35400;
}

.signup-btn a {
	color: white;
	text-decoration: none;
	display: block;
}
</style>
</head>
<body>

	<div class="login-box">
		<h2>Welcome to FoodHub</h2>
		<% String error=(String) request.getAttribute("error"); %>
		<%
     if(error!=null){ 
    %>
		<p style="color: red;"><%= error %></p>
		<%} %>
		<form action="LoginServlet" method="post" autocomplete="off">
			<input type="text" name="username" placeholder="Enter Username" required autocomplete="new-username">
			<input type="password" name="password" placeholder=" Enter Password"
				required autocomplete="new-password">
			<button type="submit" class="login-btn">Login</button>
			<button type="button" class="signup-btn">
				<a href="register.jsp">Sign Up</a>
			</button>
		</form>
</body>
</html>
