<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Order Success</title>
<style>
body, html {
	margin: 0;
	padding: 0;
	height: 100%;
	font-family: 'Poppins', sans-serif;
	display: flex;
	justify-content: center;
	align-items: center;
	background: linear-gradient(rgba(0, 0, 0, 0.5), rgba(0, 0, 0, 0.5)),
		url('https://images.unsplash.com/photo-1565299624946-b28f40a0ae38?auto=format&fit=crop&w=1600&q=80');
	background-size: cover;
	background-position: center;
}

.success-box {
	text-align: center;
	background: rgba(255, 255, 255, 0.1);
	padding: 40px 60px;
	border-radius: 18px;
	backdrop-filter: blur(8px);
	box-shadow: 0px 8px 20px rgba(0, 0, 0, 0.3);
	animation: fadeIn 1.5s ease-in-out;
}

.success-box h1 {
	font-size: 36px;
	color: #fff;
	margin: 0;
	padding: 20px;
	background: linear-gradient(135deg, #28a745, #34d058);
	border-radius: 12px;
	text-shadow: 2px 2px 8px rgba(0, 0, 0, 0.5);
}

.success-box p {
	margin-top: 20px;
	font-size: 18px;
	color: #f1f1f1;
}

@
keyframes fadeIn {from { opacity:0;
	transform: translateY(40px);
}

to {
	opacity: 1;
	transform: translateY(0);
}
}
</style>
</head>
<body>
	<div class="success-box">
		<h1>🎉 Order Successfully Placed!</h1>
		<p>Thank you for ordering with FoodieExpress.</p>
	</div>
</body>
</html>
