package com.tap.models.PojoClass;

public class Restaurant {
	
	private int restaurantId;
	private String name;
	private	 String address;
	private String phone;
	private String rating;
	private String CusineType;
	private boolean isActive;
	private String eta;
	private int id;
	private String imagePath;
	
	public Restaurant() {
		
	}

	public Restaurant(int restaurantId, String name, String address, String phone, String rating, String cusineType,
			boolean isActive, String eta, int id, String imagePath) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.rating = rating;
		this.CusineType = cusineType;
		this.isActive = isActive;
		this.eta = eta;
		this.id = id;
		this.imagePath = imagePath;
	}
	public Restaurant(String name, String address, String phone, String rating, String cusineType,
			boolean isActive, String eta, int id, String imagePath) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.rating = rating;
		this.CusineType = cusineType;
		this.isActive = isActive;
		this.eta = eta;
		this.id = id;
		this.imagePath = imagePath;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getCusineType() {
		return CusineType;
	}

	public void setCusineType(String cusineType) {
		CusineType = cusineType;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getEta() {
		return eta;
	}

	public void setEta(String eta) {
		this.eta = eta;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", name=" + name + ", address=" + address + ", phone="
				+ phone + ", rating=" + rating + ", CusineType=" + CusineType + ", isActive=" + isActive + ", eta="
				+ eta + ", id=" + id + ", imagePath=" + imagePath + "]";
	}
}
