package com.servlet;

import java.io.IOException;
import java.net.ResponseCache;
import java.sql.Timestamp;
import java.util.Date;

import com.tap.DAOInterface.OrderDao;
import com.tap.DAOimplement.Cart;
import com.tap.DAOimplement.OrderDAOimpl;
import com.tap.DAOimplement.OrderItemDAOimpl;
import com.tap.models.PojoClass.CartItem;
import com.tap.models.PojoClass.Order;
import com.tap.models.PojoClass.OrderItem;
import com.tap.models.PojoClass.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {

    private OrderDao orderDao;
    private OrderItemDAOimpl orderItemDAOimpl = new OrderItemDAOimpl();

    @Override
    public void init() throws ServletException {
        try {
            orderDao = new OrderDAOimpl();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to start Order DAO Impl", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Checkout servlet is called");

        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        User user = (User) session.getAttribute("user");

        if (cart != null && user != null && !cart.getItems().isEmpty()) {

            String paymentMethod = req.getParameter("paymentMethod");
            String address = req.getParameter("address");

            Order order = new Order();
            order.setUserId(user.getId());
            order.setRestaurantId((int) session.getAttribute("restaurantId"));
            order.setOrderDate(new Timestamp(new Date().getTime()));
            order.setAddress(address);
            order.setStatus("Pending");
            order.setPaymentmode(paymentMethod);

            int totalAmount = 0;
            for (CartItem item : cart.getItems().values()) {
                totalAmount += item.getPrice() * item.getQuantity();
            }
            order.setTotalAmount(totalAmount);

            int orderId = orderDao.addOrder(order);

            for (CartItem item : cart.getItems().values()) {
                int itemId = item.getItemId();
                String name = item.getName();
                int price = item.getPrice();
                int quantity = item.getQuantity();
                int totalPrice = price * quantity;

                OrderItem orderItem = new OrderItem(orderId, itemId,quantity, totalPrice);
                orderItemDAOimpl.addOrderItem(orderItem);
            }

            session.setAttribute("order", order);
            RequestDispatcher rd = req.getRequestDispatcher("orderconfirmation.jsp");
            rd.forward(req, resp);

        } else {
            if (user == null) {
                resp.sendRedirect("login.jsp");
                return;
            }
            resp.sendRedirect("cart.jsp");
        }
    }
}

