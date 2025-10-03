package com.tap.DAOimplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAOInterface.MenuDao;
import com.tap.models.PojoClass.Menu;
import com.tap.models.PojoClass.Restaurant;
import com.tap.models.PojoClass.User;
import com.tap.util.DBconnection;

public class MenuDAOimpl implements MenuDao {
	

	private static String Insert = "INSERT INTO `menu`(`restaurant_id`,`item_name`,`description`,`price`,`ratings`,`isAvailable`,`imagepath`) VALUES (?, ?, ?, ?, ?, ?, ?)";
	private static String Get_Menu="SELECT * FROM `menu`  WHERE `menu_id`=?";
	private static  String update="UPDATE `menu` SET `restaurant_id`=?,`item_name`= ?,`description`= ?,`price`=?,`ratings`= ?,`isAvailable`=?,`imagePath`=? WHERE `menu_id`= ?";
	private static String Delete="DELETE FROM `menu` WHERE `menu_id`=?";
	private static String getAllMenu="SELECT * FROM `menu`";

	@Override
	public void addMenu(Menu m) {
		Connection con = DBconnection.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(Insert);

			pstmt.setInt(1, m.getRestaurantId());
			pstmt.setString(2, m.getItemName());
			pstmt.setString(3, m.getDescription());
			pstmt.setInt(4, m.getPrice());
			pstmt.setString(5, m.getRating());
			pstmt.setBoolean(6, m.isAvailable());
			pstmt.setString(7, m.getImagePath());

			int res = pstmt.executeUpdate();
			System.out.println(res + " row(s) inserted.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateMenu(Menu m) {
		Connection con =DBconnection.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(update);
			pstmt.setInt(1,m.getRestaurantId());
			pstmt.setString(2,m.getItemName());
			pstmt.setString(3,m.getDescription());
			pstmt.setInt(4,m.getPrice());
			pstmt.setString(5,m.getRating());
			pstmt.setBoolean(7, m.isAvailable());
			pstmt.setString(7,m.getImagePath());
			pstmt.setInt(8, m.getMenuId());
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}

	@Override
	public void deleteMenu(int id) {
		Connection con=DBconnection.getConnection();
		try {
			PreparedStatement pstmt=con.prepareStatement(Delete);
			pstmt.setInt(1, id);
			int res =pstmt.executeUpdate();
			System.out.println(res);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}

	@Override
	public Menu getMenu(int id) {
		Connection con = DBconnection.getConnection();
		Menu menu=new Menu();
		try {
			PreparedStatement pstmt = con.prepareStatement(Get_Menu);
			pstmt.setInt(1, id);
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				int menuId=res.getInt(1);
				int restaurantId=res.getInt(2);
				String itemName=res.getString(3);
				String description=res.getString(4);
				int price=res.getInt(5);
				String rating=res.getString(6);
				Boolean isAvaliable=res.getBoolean(7);
				String imagePath=res.getString(8);
				menu = new Menu(menuId, restaurantId, itemName, description, price, rating, isAvaliable, imagePath);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return menu;
	}

	@Override
	public List<Menu> getAllMenu() {
		Connection con =DBconnection.getConnection();
		List<Menu> list= new ArrayList<Menu>();
		Menu menu;
		try {
			PreparedStatement pstmt=con.prepareStatement(getAllMenu);
			ResultSet res =pstmt.executeQuery();
			while(res.next()) {
				int menuId=res.getInt(1);
				int restaurantId=res.getInt(2);
				String itemName=res.getString(3);
				String description=res.getString(4);
				int  price=res.getInt(5);
				String rating=res.getString(6);
				Boolean isAvaliable=res.getBoolean(7);
				String imagePath=res.getString(8);
				menu = new Menu(menuId, restaurantId, itemName, description, price, rating, isAvaliable, imagePath);
				list.add(menu);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	


}
