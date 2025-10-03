<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout</title>

<style>
/* Global Styling */
body {
    font-family: 'Poppins', sans-serif;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    position: relative;
    overflow: hidden;

    /* Correct Image Path */
    background: url("<%=request.getContextPath()%>/images/bg.jpg") no-repeat center center/cover;
}


/* Overlay for readability */
body::before {
	content: "";
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background: rgba(0, 0, 0, 0.4);
	z-index: -1;
}

/* Checkout Container */
.checkout-form {
	background: #ffffffcc; /* semi-transparent */
	padding: 25px 35px;
	border-radius: 16px;
	box-shadow: 0px 8px 20px rgba(0, 0, 0, 0.15);
	max-width: 450px;
	width: 100%;
	display: flex;
	flex-direction: column;
	gap: 18px;
	z-index: 1;
}

/* Title */
.checkout-title {
	text-align: center;
	font-size: 26px;
	font-weight: bold;
	color: #333333;
	margin-bottom: 20px;
}

/* Labels */
.checkout-form label {
	font-size: 15px;
	font-weight: 600;
	color: #444;
	margin-bottom: 6px;
	display: block;
}

/* Input Fields */
.checkout-form textarea, .checkout-form select {
	width: 100%;
	padding: 12px;
	font-size: 14px;
	border: 1px solid #ddd;
	border-radius: 10px;
	outline: none;
	transition: all 0.3s ease-in-out;
}

.checkout-form textarea:focus, .checkout-form select:focus {
	border-color: #ff7b54;
	box-shadow: 0px 0px 6px rgba(255, 123, 84, 0.5);
}

/* Button */
.place-order-btn {
	padding: 14px;
	background: linear-gradient(135deg, #ff7b54, #ff4f81);
	color: #fff;
	font-size: 16px;
	font-weight: bold;
	border: none;
	border-radius: 12px;
	cursor: pointer;
	transition: 0.3s ease-in-out;
}

.place-order-btn:hover {
	background: linear-gradient(135deg, #ff4f81, #ff7b54);
	transform: scale(1.03);
	box-shadow: 0px 6px 16px rgba(255, 123, 84, 0.4);
}
</style>
</head>
<body>
	<!-- Checkout Form -->
	<form action="checkout" method="post" class="checkout-form">
		<h2 class="checkout-title">Checkout</h2>
		
		<label for="address">Delivery Address:</label>
		<textarea id="address" name="address" required></textarea>

		<label for="paymentMethod">Payment Mode:</label> 
		<select name="paymentMethod" id="paymentMethod">
			<option value="Credit Card">Credit Card</option>
			<option value="Debit Card">Debit Card</option>
			<option value="Cash">Cash</option>
			<option value="UPI">UPI</option>
		</select>

		<button type="submit" class="place-order-btn">Place Order</button>
	</form>
</body>
</html>
