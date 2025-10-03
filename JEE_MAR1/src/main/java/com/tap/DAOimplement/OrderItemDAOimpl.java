package com.tap.DAOimplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAOInterface.OrderItemDao;
import com.tap.models.PojoClass.OrderItem;
import com.tap.util.DBconnection;

public class OrderItemDAOimpl  implements OrderItemDao{

	private static String Insert="INSERT into `orderitem`(`order_id`,`menu_id`,`quantity`,`total_price`) values(?,?,?,?)";
	private static String update="UPDATE `orderitem` SET `order_id`=? ,`menu_id`=?,`quantity`=?, `total_price`=? where `order_item_id`=?";
	private static String Delete="DELETE FROM `orderitem` where `order_item_id`= ?";
	private static  String GET_ORDERITEM="SELECT * FROM orderitem WHERE order_item_id=?";
	private static String getAll="SELECT * FROM orderitem";
	OrderItem orderItem;
	

	@Override
	public void addOrderItem(OrderItem orderItem) {
		
		try {
			Connection con=DBconnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement(Insert);

			pstmt.setInt(1,orderItem.getOrderId());
			pstmt.setInt(2,orderItem.getMenuId());
			pstmt.setInt(3,orderItem.getQuantity());
			pstmt.setInt(4,orderItem.getTotalprize());
		
			int res=pstmt.executeUpdate();
			System.out.println(res);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}	
	}
	@Override
	public void updateOrderItem(OrderItem orderItem) {
		
		
		Connection con =DBconnection.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(update);
			pstmt.setInt(1,orderItem.getOrderId());
			pstmt.setInt(2,orderItem.getMenuId());
			pstmt.setInt(3,orderItem.getQuantity());
			pstmt.setInt(4,orderItem.getTotalprize());
			pstmt.setInt(5,orderItem.getOrderItemid());
			int res=pstmt.executeUpdate();
			System.out.println(res);
			
		} catch (SQLException e) {
		e.printStackTrace();
		}
	
		
	}

	@Override
	
	public void deleteOrderItem(int id) {
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
	public OrderItem getOrderItem(int id) {
		// TODO Auto-generated method stub
		Connection con = DBconnection.getConnection();
		OrderItem orderItem=new OrderItem();
		
		try {
			PreparedStatement pstmt = con.prepareStatement(GET_ORDERITEM);
			pstmt.setInt(1, id);
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				int orderItemid=res.getInt(1);
				int orderId=res.getInt(2);
				int menuId=res.getInt(3);
				int quantity=res.getInt(4);
				int totalprize=res.getInt(5);
				
				orderItem=new OrderItem(orderItemid, orderId, menuId, quantity, totalprize);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			}
		return orderItem;
	}
	
	@Override
	public List<OrderItem> getAllOrderItem() {
		Connection con = DBconnection.getConnection();
		ArrayList<OrderItem> list = new ArrayList<OrderItem>();
		OrderItem orderItem;
		try {
			PreparedStatement pstmt = con.prepareStatement(getAll);
			
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				int orderItemid=res.getInt(1);
				int orderId=res.getInt(2);
				int menuId=res.getInt(3);
				int quantity=res.getInt(4);
				int totalprize=res.getInt(5);
				
				orderItem=new OrderItem(orderItemid, orderId, menuId, quantity, totalprize);
				list.add(orderItem);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}

}
