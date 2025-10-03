package com.launch;

import java.util.List;
import java.util.Scanner;

import com.tap.DAOimplement.OrderDAOimpl;
import com.tap.models.PojoClass.Order;

public class OrderLaunch {

	public static void main(String[] args) {
		
		
		//addOrder();
//		Scanner scan= new Scanner(System.in);
//		System.out.println("Enter the userId");
//		int userId=scan.nextInt();
//		System.out.println("Enter the RestaurantId");
//		int RestaurantId=scan.nextInt();
//		System.out.println("Enter the totalAmount");
//		int totalAmount=scan.nextInt();
//		System.out.println("Enter the status");
//		String status=scan.next();
//		System.out.println("Enter the paymentMode");
//		String paymentMode=scan.next();
//		Order order = new Order(userId, RestaurantId,totalAmount, status, paymentMode);
//		OrderDAOimpl  impl=new OrderDAOimpl();
//		impl.addOrder(order);
		
		
		//update()
//		Scanner scan= new Scanner(System.in);
//		System.out.println("Enter the orderId");
//		int orderId=scan.nextInt();
//		OrderDAOimpl  impl=new OrderDAOimpl();
//		Order order=impl.getOrder(orderId);
//		System.out.println("Enter the totalAmount");
//		int totalAmount=scan.nextInt();
//		order.setTotalAmount(totalAmount);
//		impl.updateOrder(order);
//		System.out.println(order);
		
		
		//getOrder();
//		Scanner scan= new Scanner(System.in);
//		System.out.println("Enter the orderId");
//		int orderId=scan.nextInt();
//		OrderDAOimpl  impl=new OrderDAOimpl();
//		Order order=impl.getOrder(orderId);
//		System.out.println(order);
		
		//deleteOrder()
//		Scanner scan= new Scanner(System.in);
//		System.out.println("Enter the orderId");
//		int orderId=scan.nextInt();
//		OrderDAOimpl  impl=new OrderDAOimpl();
//		impl.deleteOrder(orderId);

		
		//getAllOrders()
		OrderDAOimpl  impl=new OrderDAOimpl();
		List<Order> allOrder = impl.getAllOrder();
		for (Order order : allOrder) {
			System.out.println(order);
		}
	}
}
