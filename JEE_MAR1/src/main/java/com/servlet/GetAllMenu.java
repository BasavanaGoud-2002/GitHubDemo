package com.servlet;

import java.io.IOException;
import java.util.List;

import com.tap.DAOimplement.MenuDAOimpl;
import com.tap.models.PojoClass.Menu;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/GetAllMenu")
public class GetAllMenu  extends  HttpServlet{ 
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Menu Servlet  is Called ");
		
		int rid = Integer.parseInt(req.getParameter("restaurantId"));
		System.out.println("Restaurant Id "+rid);
		
		
		try {
			MenuDAOimpl impl = new MenuDAOimpl();
			List<Menu> allMenu = impl.getAllMenu();
			req.setAttribute("menuList", allMenu);
			RequestDispatcher rd = req.getRequestDispatcher("menu.jsp");
			rd.forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
