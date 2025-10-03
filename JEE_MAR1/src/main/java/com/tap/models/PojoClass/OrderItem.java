
package com.tap.models.PojoClass;

public class OrderItem {
	
	private int orderItemid;
	private int orderId;
	private int menuId;
	private int quantity;
	private int totalprize;
	
	public OrderItem() {
		
	}

	public OrderItem(int orderItemid, int orderId, int menuId, int quantity, int totalprize) {
		super();
		this.orderItemid = orderItemid;
		this.orderId = orderId;
		this.menuId = menuId;
		this.quantity = quantity;
		this.totalprize = totalprize;
	}
	public OrderItem(int orderId, int menuId, int quantity, int totalprize) {
		super();
		this.orderId = orderId;
		this.menuId = menuId;
		this.quantity = quantity;
		this.totalprize = totalprize;
	}

	public int getOrderItemid() {
		return orderItemid;
	}

	public void setOrderItemid(int orderItemid) {
		this.orderItemid = orderItemid;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotalprize() {
		return totalprize;
	}

	public void setTotalprize(int totalprize) {
		this.totalprize = totalprize;
	}

	@Override
	public String toString() {
		return "OrderItem [orderItemid=" + orderItemid + ", orderId=" + orderId + ", menuId=" + menuId + ", quantity="
				+ quantity + ", totalprize=" + totalprize + "]";
	}
}
