
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="com.tap.models.PojoClass.Menu,java.util.List"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu Card Preview</title>
<style>
body {
    font-family: 'Poppins', sans-serif;
    margin: 0;
    background: linear-gradient(to right, #fff5e6, #ffe0cc);
    padding: 20px;
}

h2 {
    text-align: center;
    color: #e67e22;
    font-size: 2rem;
    margin-bottom: 30px;
    font-weight: bold;
    letter-spacing: 1px;
}

.menu-grid {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(260px, 1fr));
    gap: 25px;
    padding: 0 30px;
}

.menu-card {
    background: #fff;
    border-radius: 15px;
    overflow: hidden;
    box-shadow: 0 6px 20px rgba(0, 0, 0, 0.08);
    transition: transform 0.25s ease, box-shadow 0.25s ease;
    text-align: center;
}

.menu-card:hover {
    transform: translateY(-5px);
    box-shadow: 0 12px 28px rgba(0, 0, 0, 0.12);
}

.image-wrapper {
    padding: 25px;
}

.menu-card img {
    width: 100%;
    height: 250px;
    object-fit: cover;
    border-radius: 10px;
    transition: transform 0.4s ease;
}

.menu-card:hover img {
    transform: scale(1.08);
}

.itemName {
    font-size: 1.3rem;
    font-weight: bold;
    margin: 12px 0 5px;
    color: #2c3e50;
}

.description {
    font-size: 0.95rem;
    color: #666;
    margin: 0 15px 10px;
    min-height: 45px;
}

.price {
    font-size: 1.1rem;
    color: #27ae60;
    font-weight: bold;
    margin-bottom: 6px;
}

.rating {
    color: #f39c12;
    font-weight: 600;
    font-size: 0.95rem;
    margin-bottom: 10px;
}

.add-to-cart-btn {
    display: inline-flex;
    align-items: center;
    gap: 6px;
    padding: 8px 16px;
    background: linear-gradient(to right, #ff7e5f, #ff4b2b);
    color: #fff;
    text-decoration: none;
    border: none;
    border-radius: 6px;
    font-weight: bold;
    cursor: pointer;
    margin-bottom: 15px;
    transition: background 0.3s ease;
}

.add-to-cart-btn:hover {
    background: linear-gradient(to right, #ff4b2b, #c02425);
}
</style>
</head>

<body>
<h2>All Menu</h2>
<div class="menu-grid">
<%
    List<Menu> menuList = (List<Menu>) request.getAttribute("menuList");
    if (menuList != null && !menuList.isEmpty()) {
        for (Menu m : menuList) {
%>
    <div class="menu-card">
        <div class="image-wrapper">
            <img alt="Image not found" src="<%= m.getImagePath() %>">
        </div>
        <div class="itemName"><%= m.getItemName() %></div>
        <div class="description"><%= m.getDescription() %></div>
        <div class="price">₹<%= m.getPrice() %></div>
        <div class="rating">Rating: <%= m.getRating() %></div>


			<form action="cart" method="post">
				<input type="hidden" name="restaurantId"
					value="<%=request.getParameter("restaurantId")%>"> <input
					type="hidden" name="itemId" value="<%=m.getMenuId()%>"> <input
					type="hidden" name="quantity" value="1" min="1"> <input
					type="hidden" name="action" value="add">
				<button type="submit" class="add-to-cart-btn">Add to cart</button>
			</form>


		</div>
<%
        }
    } else {
%>
    <p>No Menu Items found for this restaurant.</p>
<%
    }
%>
		
	</div>
</body>
</html>