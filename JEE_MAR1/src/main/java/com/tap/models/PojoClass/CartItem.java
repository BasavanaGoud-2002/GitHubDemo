package com.tap.models.PojoClass;

public class CartItem {
	
	private int  itemId;
	private String name;
	private int  price;
	private int quantity;
	private int restaurantId;
	private int totalprize;
	
	public CartItem() {
		
	}

	public CartItem(int itemId, String name, int price, int quantity, int restaurantId, int totalprize) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.restaurantId = restaurantId;
		this.totalprize = totalprize;
	}

	public CartItem(int itemId, int restaurantId, String name, int quantity,int price ) {
		super();
		this.itemId = itemId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.restaurantId = restaurantId;
		
	}
	public int getTotalprize() {
		return quantity*price;
	}

	public void setTotalprize(int totalprize) {
		this.totalprize = totalprize;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	

	@Override
	public String toString() {
		return "CartItem [itemId=" + itemId + ", name=" + name + ", price=" + price + ", quantity=" + quantity
				+ ", restaurantId=" + restaurantId + ", totalprize=" + totalprize + "]";
	}
	
	

	
}
