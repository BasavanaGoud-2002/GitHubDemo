package com.launch;

import java.util.List;
import java.util.Scanner;

import com.tap.DAOInterface.OrderItemDao;
import com.tap.DAOimplement.OrderItemDAOimpl;
import com.tap.models.PojoClass.OrderItem;

public class OrderItemLaunch {

	public static void main(String[] args) {
		
		//addOderItem();
//		Scanner scan = new Scanner(System.in);
//		System.out.println("enter the Orderid");
//		int OrderId=scan.nextInt();
//		System.out.println("enter the menuId");
//		int MenuId=scan.nextInt();
//		System.out.println("enter the quantity");
//		int quantity=scan.nextInt();
//		System.out.println("enter the totalPrize");
//		int totalPrize=scan.nextInt();
//		OrderItem orderItem = new OrderItem(OrderId, MenuId, quantity, totalPrize);
//		OrderItemDao impl=new OrderItemDAOimpl();
//		impl.addOrderItem(orderItem);
		
		//getOrderItem();
//		Scanner scan = new Scanner(System.in);
//		System.out.println("enter the Orderid");
//		int OrderId=scan.nextInt();
//		OrderItemDAOimpl impl = new OrderItemDAOimpl();
//		OrderItem orderItem = impl.getOrderItem(OrderId);
//		System.out.println(orderItem);
		
		//updateOrderItem();
//		Scanner scan = new Scanner(System.in);
//		System.out.println("enter the Orderid");
//		int OrderId=scan.nextInt();
//		OrderItemDAOimpl impl = new OrderItemDAOimpl();
//		OrderItem orderItem = impl.getOrderItem(OrderId);
//		System.out.println("Enter the quantity");
//		int quantity=scan.nextInt();
//		orderItem.setQuantity(quantity);
//		impl.updateOrderItem(orderItem);
		
		
		//DeleteOrderItem();
//		Scanner scan = new Scanner(System.in);
//		System.out.println("enter the Orderid");
//		int OrderId=scan.nextInt();
//		OrderItemDAOimpl impl = new OrderItemDAOimpl();
//		impl.deleteOrderItem(OrderId);


		OrderItemDAOimpl orderItemimpl = new OrderItemDAOimpl();
		List<OrderItem> list = orderItemimpl.getAllOrderItem();
		for(OrderItem items:list) {
			System.out.println(items);
		}
	
		

	}

}
