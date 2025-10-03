package com.tap.DAOInterface;

import java.util.List;

import com.tap.models.PojoClass.Order;

public interface OrderDao {
	
	int addOrder(Order order);
	
	void updateOrder(Order order);
	
	void deleteOrder(int id);
	
	Order getOrder(int id);
	
	List<Order> getAllOrder();

}
