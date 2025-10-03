package com.tap.DAOimplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAOInterface.RestaurantDao;
import com.tap.models.PojoClass.Restaurant;
import com.tap.util.DBconnection;

public  class RestaurantDAOimpl implements RestaurantDao {

	private static String Insert = "INSERT INTO `Restaurant`(`name`,`address`,`phone`,`rating`,`cuisine_type`,`is_active`,`eta`,`user_id`,`image_path`) VALUES (?,?,?,?,?,?,?,?,?)";
	private static String update="UPDATE `Restaurant` SET `name`=?,`address`=? , `phone`=?,`rating`=?,`cuisine_type`=?, `is_active`=? ,`eta`=? ,`user_id`=? WHERE `restaurant_id`=?";
	private static String getRestaurant="SELECT * FROM Restaurant WHERE restaurant_id=? ";
	private static String Delete="DELETE FROM Restaurant WHERE restaurant_id=?  ";
	private static String getAllRestaurants="SELECT * FROM Restaurant";

	@Override
	public void addRestaurant(Restaurant rest) {
		try {
			Connection con =DBconnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement(Insert);
			pstmt.setString(1, rest.getName());
			pstmt.setString(2, rest.getAddress());
			pstmt.setString(3, rest.getPhone());
			pstmt.setString(4, rest.getRating());
			pstmt.setString(5, rest.getCusineType());
			pstmt.setBoolean(6, rest.isActive());
			pstmt.setString(7, rest.getEta());
			pstmt.setInt(8, rest.getId()); 
			pstmt.setString(9, rest.getImagePath());
			
			int res=pstmt.executeUpdate();
			System.out.println(res);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateRestaurant(Restaurant rest) {
		try {
			Connection con = DBconnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement(update);
			pstmt.setString(1, rest.getName());
			pstmt.setString(2, rest.getAddress());
			pstmt.setString(3,rest.getPhone());
			pstmt.setString(4, rest.getRating());
			pstmt.setString(5,rest.getCusineType());
			pstmt.setBoolean(6,rest.isActive());
			pstmt.setString(7, rest.getEta());
			pstmt.setInt(8, rest.getId());
			pstmt.setInt(9,rest.getRestaurantId());
			
			int res=pstmt.executeUpdate();
			System.out.println(res);
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteRestaurant(int id) {
		Connection con=DBconnection.getConnection();
		try {
			PreparedStatement pstmt=con.prepareStatement(Delete);
			pstmt.setInt(1, id);
			int res=pstmt.executeUpdate();
			System.out.println(res);
		}
		catch(SQLException e) {
			e.printStackTrace();	
		}	
	}

	@Override
	public Restaurant getRestaurant(int id) {
		
		Connection con =DBconnection.getConnection();
		Restaurant rest= new Restaurant();
		try {
			PreparedStatement pstmt=  con.prepareStatement(getRestaurant);
			pstmt.setInt(1, id);
			ResultSet res =pstmt.executeQuery();
			
			while(res.next()) {
				int restaurant_id=res.getInt(1);
				String name=res.getString(2);
				String address=res.getString(3);
				String phone=res.getString(4);
				String rating=res.getString(5);
				String CusineType=res.getString(6);
				boolean isActive=res.getBoolean(7);
				String eta=res.getString(8);
				int admin_id=res.getInt(9);
				String imagepath=res.getString(10);
				
				rest= new Restaurant(restaurant_id, name, address, phone, rating, CusineType, isActive, eta, admin_id, imagepath);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rest;
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		
		Connection con=DBconnection.getConnection();
		List<Restaurant> list= new ArrayList<Restaurant>();
		Restaurant rest;
		try {
		PreparedStatement pstmt =con.prepareStatement(getAllRestaurants);
		ResultSet res =pstmt.executeQuery();
		
		while(res.next()) {
			int restaurant_id=res.getInt(1);
			String name=res.getString(2);
			String address=res.getString(3);
			String phone=res.getString(4);
			String rating=res.getString(5);
			String CusineType=res.getString(6);
			boolean isActive=res.getBoolean(7);
			String eta=res.getString(8);
			int admin_id=res.getInt(9);
			String imagepath=res.getString(10);
			
			rest= new Restaurant(restaurant_id, name, address, phone, rating, CusineType, isActive, eta, admin_id, imagepath);
			list.add(rest);
		}
		
		} catch(SQLException e) {
			e.printStackTrace();
			
		}
		return list;
	}

}
