package com.servlet;

import java.io.IOException;
import java.util.HashMap;

import com.tap.DAOimplement.Cart;
import com.tap.DAOimplement.MenuDAOimpl;
import com.tap.models.PojoClass.CartItem;
import com.tap.models.PojoClass.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/cart")
public class CartServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		HttpSession session = req.getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		
		int  newResturantId =Integer.parseInt(req.getParameter("restaurantId")) ;
		
		Integer currentRestaurantId=(Integer)session.getAttribute("restaurantId");
		
		
		if(cart==null || newResturantId !=currentRestaurantId) {
			cart= new Cart();
			session.setAttribute("cart",cart);
			session.setAttribute("restaurantId", newResturantId);
			
		}
		
		
		String action=req.getParameter("action");
		
		if(action.equals("add")) {
			addItemCart(req,cart);
		}
		else if(action.equals("update")) {
			updateCartItem(req, cart);
			
		}
		else if(action.equals("remove")) {
			remove(req, cart);
		}
		resp.sendRedirect("cart.jsp");
			
	}
		
	
	private void addItemCart(HttpServletRequest req ,Cart cart) {
		int itemId=Integer.parseInt(req.getParameter("itemId"));
		int quantity=Integer.parseInt(req.getParameter("quantity"));
		
		System.out.println("itemId: " + req.getParameter("itemId"));
		System.out.println("quantity: " + req.getParameter("quantity"));

		
		
		MenuDAOimpl impl = new MenuDAOimpl();
		Menu menuItem=impl.getMenu(itemId);
		
		System.out.println("The Menu is calling the cart Servlet and Add "+menuItem);
		
		if(menuItem!=null) {
		
				
			CartItem item = new CartItem(menuItem.getMenuId(),
					menuItem.getRestaurantId(),
					menuItem.getItemName(),
					quantity,
					menuItem.getPrice()
					);
			
		cart.addItem(item);
	}
	}
	public void updateCartItem(HttpServletRequest req,Cart cart) { 
		int  itemId= Integer.parseInt(req.getParameter("itemId"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		cart.updateItem(itemId, quantity);

	}
	public void remove(HttpServletRequest req,Cart cart) {
		int itemId = Integer.parseInt(req.getParameter("itemId"));
		cart.remove(itemId);
	}

}
