package com.launch;

import java.util.List;
import java.util.Scanner;

import com.tap.DAOimplement.RestaurantDAOimpl;
import com.tap.models.PojoClass.Restaurant;

public class RestaurantsLaunch {

	public static void main(String[] args) {
		

			//addRestaurant();
//		Scanner scan = new Scanner(System.in);
//		System.out.println("Enter the name");
//		String name = scan.nextLine();
//		System.out.println("Enter the address");
//		String address = scan.nextLine();
//		System.out.println("Enter the phone");
//		String phone = scan.next();
//		System.out.println("Enter the rating");
//		String rating = scan.next();
//		System.out.println("Enter the Cuisine Type");
//		String cuisineType = scan.next();
//		System.out.println("Enter isActive (true/false)");
//		boolean isActive = scan.nextBoolean();
//		System.out.println("Enter the ETA");
//		String eta = scan.next();
//		System.out.println("Enter the user ID");
//		int user_id = scan.nextInt();
//		System.out.println("Enter the Image Path");
//		String imagePath = scan.next();
//		Restaurant rest = new Restaurant(name,address,phone,rating,cuisineType,isActive,eta,user_id,imagePath);
//		RestaurantDAOimpl impl = new RestaurantDAOimpl();
//		impl.addRestaurant(rest);
		
		//updateRestaurant();
//		Scanner scan = new Scanner(System.in);
//		System.out.println("Enter the restraurant id");
//		int restaurant_id=scan.nextInt();
//		RestaurantDAOimpl impl= new RestaurantDAOimpl();
//		Restaurant rest = impl.getRestaurant(restaurant_id);
//		System.out.println("Entre the adderss");
//		String address=scan.next();
//		rest.setAddress(address);
//		impl.updateRestaurant(rest);
//		System.out.println(rest);
		
		
		//getRestaurant();
//		Scanner scan = new Scanner(System.in);
//		System.out.println("Enter the restraurant id");
//		int restaurant_id=scan.nextInt();
//		RestaurantDAOimpl impl= new RestaurantDAOimpl();
//		Restaurant rest= impl.getRestaurant(restaurant_id);
//		System.out.println(rest);
		
		//DeleteRestaurant();
//		Scanner scan = new Scanner(System.in);
//		System.out.println("Enter the restraurant id");
//		int restaurant_id=scan.nextInt();
//		RestaurantDAOimpl impl= new RestaurantDAOimpl();
//		impl.deleteRestaurant(restaurant_id);
		
		//getAllRestaurant();
		RestaurantDAOimpl impl= new RestaurantDAOimpl();
		List<Restaurant> getRestaurant=impl.getAllRestaurants();
		for (Restaurant restaurant : getRestaurant) {
			System.out.println(restaurant);
		}
	}

}
