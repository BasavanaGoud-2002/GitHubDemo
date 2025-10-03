package com.tap.DAOInterface;

import java.util.List;

import com.tap.models.PojoClass.Restaurant;




public interface RestaurantDao {
	
	void addRestaurant(Restaurant rest);
	
	void updateRestaurant(Restaurant rest);
	
	void deleteRestaurant(int id);
	
	Restaurant getRestaurant(int id);
	
	List<Restaurant> getAllRestaurants();

	

}
