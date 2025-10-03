package com.tap.DAOimplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAOInterface.OrderDao;
import com.tap.models.PojoClass.Order;
import com.tap.util.DBconnection;

public class OrderDAOimpl implements OrderDao {
	
	private static String Insert = "INSERT INTO `orders`(`user_id`,`restaurant_id`,`order_date`,`total_amount`,`status`,`payment_mode`,`address`) values(?,?,?,?,?,?,?)";
	private static String update="UPDATE `orders` SET `user_id` = ?, `restaurant_id` = ?, `order_date` = ?, `total_amount` = ?, `status` = ?, `payment_mode` = ?,`address`= ? WHERE `order_id` = ?";
	private String Delete="DELETE FROM orders WHERE order_id = ?";
	private String GET_ORDER="SELECT * FROM `orders`  WHERE `order_id`=?";
	private String getAllOrder="SELECT * FROM `orders`";
	int orderId=0;
	@Override
	public int addOrder(Order order) {
		
		
		Connection con = DBconnection.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(Insert,java.sql.Statement.RETURN_GENERATED_KEYS);

			pstmt.setInt(1, order.getUserId());
			pstmt.setInt(2, order.getRestaurantId());
			pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
			pstmt.setInt(4, order.getTotalAmount());
			pstmt.setString(5,order.getStatus());
			pstmt.setString(6,order.getPaymentmode());
			pstmt.setString(7, order.getAddress());
			int res=pstmt.executeUpdate();
			System.out.println(res);
			
			ResultSet res1= pstmt.getGeneratedKeys();
			
			while(res1.next()) {
				orderId	= res1.getInt(1);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return orderId;
	}
	@Override
	public void updateOrder(Order order) {
	    try {
	        Connection con = DBconnection.getConnection();
	        PreparedStatement pstmt = con.prepareStatement(update);

	        pstmt.setInt(1, order.getUserId());
	        pstmt.setInt(2, order.getRestaurantId());
	        pstmt.setTimestamp(3, new Timestamp(System.currentTimeMillis()));
	        pstmt.setInt(4, order.getTotalAmount());
	        pstmt.setString(5, order.getStatus());
	        pstmt.setString(6, order.getPaymentmode());
	        pstmt.setString(7, order.getAddress());
	        pstmt.setInt(8, order.getOrderId());

	        int res = pstmt.executeUpdate();
	        System.out.println(res + " row(s) updated.");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	@Override
	public void deleteOrder(int id) {
		Connection con=DBconnection.getConnection();
		try {
			PreparedStatement pstmt=con.prepareStatement(Delete);
			pstmt.setInt(1, id);
			int res =pstmt.executeUpdate();
			System.out.println(res);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Order getOrder(int id) {
		Connection con = DBconnection.getConnection();
		Order order = new Order();
		
		
		try {
			PreparedStatement pstmt = con.prepareStatement(GET_ORDER);
			pstmt.setInt(1, id);
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				int orderId=res.getInt(1);
				int userId=res.getInt(2);
				int restaurantId=res.getInt(3);
				Timestamp orderDate=res.getTimestamp(4);
				int totalAmount=res.getInt(5);
				String status=res.getString(6);
				String paymentMode=res.getString(7);
				String address=  res.getString(8);
				order=new Order(orderId, userId, restaurantId,orderDate, totalAmount, status, paymentMode,address);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return order;
	}

	@Override
	public List<Order> getAllOrder() {
		
		Connection con = DBconnection.getConnection();
		List<Order> list=new ArrayList<Order>();
		Order order;
		try {
			PreparedStatement pstmt=con.prepareStatement(getAllOrder);
			ResultSet res =pstmt.executeQuery();
			
			while(res.next()) {
				int orderId=res.getInt(1);
				int userId=res.getInt(2);
				int restaurantId=res.getInt(3);
				Timestamp orderDate=res.getTimestamp(4);
				int totalAmount=res.getInt(5);
				String status=res.getString(6);
				String paymentMode=res.getString(7);
				String address=  res.getString(8);
				order= new Order(orderId, userId, restaurantId,orderDate, totalAmount, status, paymentMode,address);
				list.add(order);	
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
