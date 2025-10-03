<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register - FoodieExpress</title>
<style>
body {
	margin: 0;
	padding: 0;
	font-family: 'Segoe UI', sans-serif;
	background:
		url('https://images.unsplash.com/photo-1550547660-d9450f859349?auto=format&fit=crop&w=1350&q=80')
		no-repeat center center/cover;
	height: 100vh;
	display: flex;
	align-items: center;
	justify-content: center;
}

.register-container {
	background-color: rgba(255, 255, 255, 0.95);
	padding: 40px;
	border-radius: 15px;
	box-shadow: 0 8px 30px rgba(0, 0, 0, 0.2);
	width: 400px;
	text-align: center;
}

.register-container h2 {
	margin-bottom: 25px;
	color: #ff4e50;
}

input[type="text"], input[type="email"], input[type="password"], input[type="tel"],
	select {
	width: 100%;
	padding: 12px;
	margin: 10px 0 20px;
	border: 1px solid #ccc;
	border-radius: 8px;
	font-size: 16px;
	box-sizing: border-box;
}

select {
	background-color: white;
	color: #333;
}

.btn-register {
	background: linear-gradient(90deg, #ff5858, #f857a6);
	border: none;
	color: white;
	padding: 12px;
	width: 100%;
	font-size: 16px;
	border-radius: 8px;
	cursor: pointer;
	transition: background 0.3s ease;
}

.btn-register:hover {
	background: linear-gradient(90deg, #f857a6, #ff5858);
}

.link {
	margin-top: 15px;
	font-size: 14px;
}

.link a {
	color: #f857a6;
	text-decoration: none;
}

.link a:hover {
	text-decoration: underline;
}
</style>
</head>
<body>
	<form action="RegisterServlet" method="post" autocomplete="off">
		<div class="register-container">
			<h2>Create Your Account</h2>

			<input type="text" name="name" placeholder="Full Name" required>
			<input type="text" name="username" placeholder="Enter Username"
				required autocomplete="new-username"> 
			<input type="password" name="password" placeholder="Enter Password" required
				autocomplete="new-password"> 
			<input type="email" name="email" placeholder="Email Address" required> 
			<input type="tel" name="phoneNumber" placeholder="Phone Number" required>
			<input type="text" name="address" placeholder="Address" required>

			<select name="role" required>
				<option value="" disabled selected>Select Role</option>
				<option value="customer">Customer</option>
				<option value="Restaurantadmin">Restaurant Admin</option>
				<option value="deliveryAgent">Delivery Agent</option>
			</select>



			<button type="submit" class="btn-register">Sign Up</button>
			<div class="link">
				Already have an account? <a href="login.jsp">Login</a>
			</div>
		</div>
	</form>
</body>
</html>
