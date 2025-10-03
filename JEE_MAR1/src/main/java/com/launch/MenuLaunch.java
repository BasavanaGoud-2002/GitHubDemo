package com.launch;

import java.util.List;
import java.util.Scanner;

import com.tap.DAOimplement.MenuDAOimpl;
import com.tap.models.PojoClass.Menu;

public class MenuLaunch {

	public static void main(String[] args) {
		
		//addMenu();
//		Scanner scan = new Scanner(System.in);
//		System.out.println("Enter the RestaurantId");
//		int restaurant_id = scan.nextInt();
//		System.out.println("Enter the ItemName");
//		String itemName = scan.next();
//		System.out.println("Enter the Description");
//		String description = scan.next();
//		System.out.println("Enter the Price");
//		int price = scan.nextInt();
//		System.out.println("Enter the Ratings");
//		String rating = scan.next();
//		System.out.println("Is Available (true/false)");
//		boolean isAvaliable = scan.nextBoolean();
//		System.out.println("Enter the ImagePath");
//		String imagePath = scan.next();
//		Menu menu = new Menu(restaurant_id, itemName, description, price, rating, isAvaliable, imagePath);
//		MenuDAOimpl impl = new MenuDAOimpl();
//		impl.addMenu(menu);
		
		//getMenu();
//		Scanner scan = new Scanner(System.in);
//		System.out.println("Enter the Menu_id"); 
//		int menu_id = scan.nextInt();
//		MenuDAOimpl impl = new MenuDAOimpl();
//		Menu menu = impl.getMenu(menu_id);
//		System.out.println(menu);
		
		//updateMenu()
//		Scanner scan = new Scanner(System.in);
//		System.out.println("Enter the Menu_id"); 
//		int menu_id = scan.nextInt();
//		MenuDAOimpl impl = new MenuDAOimpl();
//		Menu menu = impl.getMenu(menu_id);
//		System.out.println("Enter the ItemName");
//		String itemName = scan.next();
//		menu.setItemName(itemName);
//		System.out.println(menu);
		
		//deleteMenu();
//		Scanner scan = new Scanner(System.in);
//		System.out.println("Enter the Menu_id"); 
//		int menu_id = scan.nextInt();
//		MenuDAOimpl impl = new MenuDAOimpl();
//		impl.deleteMenu(menu_id);
		
		//GetAllMenu();
		MenuDAOimpl impl = new MenuDAOimpl();
		List<Menu> allMenu = impl.getAllMenu();
		for (Menu menu : allMenu) {
			System.out.println(menu);
		}
	}
}
