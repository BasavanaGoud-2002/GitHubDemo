package com.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.tap.DAOimplement.RestaurantDAOimpl;
import com.tap.models.PojoClass.Restaurant;


@WebServlet("/GetAllRestaurant")
public class GetAllRestaurant extends HttpServlet {

       
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		try {
			RestaurantDAOimpl impl = new RestaurantDAOimpl();
			List<Restaurant> allRestaurants = impl.getAllRestaurants();
			
			request.setAttribute("restaurants", allRestaurants);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("restaurants.jsp");
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
