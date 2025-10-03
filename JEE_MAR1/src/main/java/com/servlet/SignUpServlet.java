package com.servlet;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Year;

import com.tap.DAOimplement.UserDAOimpl;
import com.tap.models.PojoClass.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// 1. Get form data
			String name = req.getParameter("name");
			String username = req.getParameter("username");
			String password=req.getParameter("password");
			String email = req.getParameter("email");
			String phoneNumber = req.getParameter("phoneNumber");
			String address = req.getParameter("address");
			String role = req.getParameter("role");

			// 2. Create User object 
			User user=new User();
			
			user.setName(name);
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			user.setPhoneNumber(phoneNumber);
			user.setAddress(address);
			user.setRole(role);
			user.setCreatedDate(new Timestamp(System.currentTimeMillis()));
			user.setLastLoginDate(new Timestamp(System.currentTimeMillis()));
			

			// 3. Add user using DAO

			UserDAOimpl impl = new UserDAOimpl();
			
			impl.addUser(user);

			// 4. Redirect or show message
			RequestDispatcher rd = req.getRequestDispatcher("register.jsp");
			rd.forward(req, resp);

			System.out.println("new user is added Sucessfully!!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void setName(String name) {
		// TODO Auto-generated method stub
		
	}

}
