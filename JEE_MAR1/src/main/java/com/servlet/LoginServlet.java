package com.servlet;

import java.io.IOException;

import com.tap.DAOimplement.UserDAOimpl;
import com.tap.models.PojoClass.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet { 
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		UserDAOimpl impl = new UserDAOimpl();
		User user=impl.checkLogin(userName,password);
		HttpSession session = req.getSession();
		
		if(user!=null) {
			System.out.println("Login Succesfully");
			session.setAttribute("user", user);
			resp.sendRedirect("GetAllRestaurant");
		}
		else {
			System.out.println("Invalid User Name or Password");
			req.setAttribute("error", "Invalid username or password");
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}
	}
	
	
	
	
}

