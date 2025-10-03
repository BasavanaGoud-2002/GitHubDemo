package com.launch;

import java.sql.Timestamp;
import java.util.List;
import java.util.Scanner;

import com.tap.DAOInterface.RestaurantDao;
import com.tap.DAOimplement.MenuDAOimpl;
import com.tap.DAOimplement.OrderDAOimpl;
import com.tap.DAOimplement.RestaurantDAOimpl;
import com.tap.DAOimplement.UserDAOimpl;
import com.tap.models.PojoClass.Menu;
import com.tap.models.PojoClass.Order;
import com.tap.models.PojoClass.Restaurant;
import com.tap.models.PojoClass.User;

public class UserLaunch {


	public static void main(String[] args) {
		
		
		//Delivery_Agent
		//addUser();
		Scanner scan= new Scanner(System.in);
		System.out.println("Enter the name");
		String name=scan.next();
		System.out.println("Enter the username");
		String username=scan.next();
		System.out.println("Enter the password");
		String password=scan.next();
		System.out.println("Enter the email");
		String email=scan.next();
		System.out.println("Enter the phone number");
		String phoneNumber=scan.next();
		System.out.println("Enter the address");
		String address=scan.next();
		System.out.println("Enter the role");
		String role=scan.next();

		User u = new User(name, username, password, email, phoneNumber, address, role);
		UserDAOimpl impl = new UserDAOimpl();
		impl.addUser(u);

		
		//updateUser();;
//		Scanner scan= new Scanner(System.in);
//		System.out.println("Enter the id");
//		int id=scan.nextInt();
//		UserDAOimpl impl = new UserDAOimpl();
//		User user=impl.getUser(id);
//		System.out.println("Enter the password");
//		String password=scan.next();
//		user.setPassword(password);
//		impl.updateUser(user);
//		System.out.println(user);
		

		//getUser();
//		Scanner scan=new Scanner(System.in);
//		System.out.println("Enter the id");
//		int id=scan.nextInt();
//		UserDAOimpl impl = new UserDAOimpl();
//		User user=impl.getUser(id);
//		System.out.println(user);

		
		//deleteUser(); 
//		Scanner scan = new Scanner(System.in);
//		System.out.println("Enter the id");
//		int id=scan.nextInt();
//		UserDAOimpl impl = new UserDAOimpl();
//		impl.deleteUser(id);
		
		//getAllUsers();
//		UserDAOimpl impl = new UserDAOimpl();
//		List<User> allUsers=impl.getAllUsers();
//		for(User users: allUsers) {
//			System.out.println(users);
//		}
		
	}
}
