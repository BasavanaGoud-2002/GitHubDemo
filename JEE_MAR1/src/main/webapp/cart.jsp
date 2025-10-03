<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.tap.DAOimplement.Cart"%>
<%@ page import="com.tap.models.PojoClass.CartItem"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Your Cart</title>
<link rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">

<style type="text/css">
body {
    font-family: "Segoe UI", sans-serif;
    background: linear-gradient(rgba(0, 0, 0, 0.6), rgba(0, 0, 0, 0.6)),
        url('https://images.unsplash.com/photo-1504674900247-0877df9cc836?auto=format&fit=crop&w=1600&q=80'); /* Modern food background */
    background-size: cover;
    background-position: center;
    background-attachment: fixed;
    margin: 0;
    padding: 20px;
    color: #fff;
}

h1 {
    text-align: center;
    background: linear-gradient(90deg, #ff416c, #ff4b2b); 
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
}

.cart-container {
    max-width: 800px;
    margin: auto;
}

.cart-item {
    display: flex;
    justify-content: space-between;
    align-items: center;
    background: rgba(255, 255, 255, 0.95);
    color: #222;
    padding: 20px;
    margin-bottom: 15px;
    border-radius: 16px;
    box-shadow: 0 6px 18px rgba(0, 0, 0, 0.2);
    transition: transform 0.3s;
}

.cart-item:hover {
    transform: scale(1.02);
}

.cart-item-details h3 {
    margin: 0;
    color: #333;
}

.cart-item-details p {
    margin: 4px 0;
    color: #555;
}


.quantity-btn {
    width: 40px;
    height: 40px;
    border-radius: 50%;
    border: none;
    background: linear-gradient(145deg, #36d1dc, #5b86e5); 
    color: white;
    font-size: 18px;
    cursor: pointer;
    transition: all 0.3s ease-in-out;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.2);
}

.quantity-btn i {
    font-size: 16px;
}

.quantity-btn:hover {
    transform: scale(1.2) rotate(5deg);
    background: linear-gradient(145deg, #5b86e5, #36d1dc);
}

/* Different colors for Minus & Plus */
.quantity-controls button:first-of-type {
    background: linear-gradient(145deg, #ff6a00, #ee0979); 
}

.quantity-controls button:last-of-type {
    background: linear-gradient(145deg, #00c6ff, #0072ff); 
}

.remove-btn {
    background: linear-gradient(90deg, #f857a6, #ff5858);
    color: white;
    padding: 8px 14px;
    border: none;
    border-radius: 8px;
    cursor: pointer;
    transition: 0.3s;
    box-shadow: 0 3px 10px rgba(0, 0, 0, 0.2);
}

.remove-btn:hover {
    transform: scale(1.1);
}

.total {
    text-align: right;
    font-size: 1.3rem;
    font-weight: bold;
    margin-top: 20px;
    color: #fff;
}

.add-more-item {
    text-align: center;
    margin-top: 20px;
}

.add-more-item a {
    display: inline-block;
    padding: 12px 24px;
    background: linear-gradient(90deg, #00b09b, #96c93d); 
    color: white;
    border-radius: 12px;
    text-decoration: none;
    font-weight: bold;
    transition: 0.3s;
    box-shadow: 0 4px 14px rgba(0, 0, 0, 0.25);
}

.add-more-item a:hover {
    transform: scale(1.1);
}

.btn-proceed-to-checkout {
    padding: 14px 28px;
    background: linear-gradient(90deg, #fc6076, #ff9a44); 
    color: white;
    font-size: 1.1rem;
    border: none;
    border-radius: 12px;
    cursor: pointer;
    margin-top: 30px;
    display: block;
    margin-left: auto;
    margin-right: auto;
    transition: 0.3s;
    box-shadow: 0 5px 16px rgba(0, 0, 0, 0.25);
}

.btn-proceed-to-checkout:hover {
    transform: scale(1.15);
}

.empty-cart {
    text-align: center;
    color: #ddd;
    font-size: 1.2rem;
}
</style>
</head>
<body>
    <h1>Your Cart</h1>

    <div class="cart-container">
        <%
            Cart cart = (Cart) session.getAttribute("cart");
            Integer restaurantId = (Integer) session.getAttribute("restaurantId");

            if (cart != null && !cart.getItems().isEmpty()) {
                int grandTotal = 0;
                for (CartItem item : cart.getItems().values()) {
                    grandTotal = grandTotal + item.getTotalprize();
        %>
        <div class="cart-item">
            <div class="cart-item-details">
                <h3><%= item.getName() %></h3>
                <p>Price: ₹ <%= item.getPrice() %></p>
                <p>Total: ₹ <%= item.getPrice() * item.getQuantity() %></p>

                <div class="quantity-controls">
                    <!-- Minus Button -->
                    <form action="cart" method="post" style="display: inline">
                        <input type="hidden" name="restaurantId" value="<%= restaurantId %>">
                        <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                        <input type="hidden" name="action" value="update">
                        <input type="hidden" name="quantity" value="<%= item.getQuantity() - 1 %>">
                        <button type="submit" class="quantity-btn" <%= item.getQuantity() <= 1 ? "disabled" : "" %>>
                            <i class="fa-solid fa-minus"></i>
                        </button>
                    </form>

                    <span><%= item.getQuantity() %></span>

                    <!-- Plus Button -->
                    <form action="cart" method="post" style="display: inline">
                        <input type="hidden" name="restaurantId" value="<%= restaurantId %>">
                        <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                        <input type="hidden" name="action" value="update">
                        <input type="hidden" name="quantity" value="<%= item.getQuantity() + 1 %>">
                        <button type="submit" class="quantity-btn">
                            <i class="fa-solid fa-plus"></i>
                        </button>
                    </form>
                </div>
            </div>

            <form action="cart" method="post">
                <input type="hidden" name="restaurantId" value="<%= restaurantId %>">
                <input type="hidden" name="itemId" value="<%= item.getItemId() %>">
                <input type="hidden" name="action" value="remove">
                <button type="submit" class="remove-btn">Remove</button>
            </form>
        </div>
        <%
                } // End for loop
        %>
        <div class="total">
            Grand Total: ₹<%= grandTotal %>
        </div>

        <div class="add-more-item">
            <a href="GetAllMenu?restaurantId=<%= restaurantId %>">Add More Items</a>
        </div>

        
        <form action="checkout.jsp" method="post">
            <input type="submit" value="Proceed to Checkout" class="btn-proceed-to-checkout" />
        </form>

        <%
            } else {
        %>
        <p class="empty-cart">Your cart is empty.</p>
        <%
            }
        %>
    </div>
</body>
</html>
