package com.tap.DAOInterface;

import java.util.List;

import com.tap.models.PojoClass.OrderItem;

public interface OrderItemDao {

	void addOrderItem(OrderItem  orderItem);
	
	void updateOrderItem(OrderItem  orderItem);
	
	void deleteOrderItem(int id);
	
	OrderItem getOrderItem(int id);
	
	List<OrderItem>getAllOrderItem();
}
