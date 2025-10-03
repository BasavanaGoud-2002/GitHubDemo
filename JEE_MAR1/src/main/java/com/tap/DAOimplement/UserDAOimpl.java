


package com.tap.DAOimplement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.tap.DAOInterface.UsersDao;
import com.tap.models.PojoClass.User;
import com.tap.util.DBconnection;

public class UserDAOimpl implements UsersDao {
	

	private static String Insert ="INSERT INTO `user` (`name`,`username`,`password`,`email`,`phone_number`,`address`,`role`,`created_date`,`last_login`) VALUES (?,?,?,?,?,?,?,?,?)";	
	private static String GET_USER="SELECT * FROM user WHERE user_id=?";
	private static String update="UPDATE `user` SET `name`= ?,`username`= ?,`password`= ?,`email`= ?,`phone_number`= ?,`address`= ?,`role`= ? WHERE `user_id`= ?";
	private static String Delete="DELETE FROM `user` WHERE `user_id`= ?";
	private static String getAll="SELECT * FROM `user`";
	private static String CHECK_LOGIN="SELECT * FROM `user` WHERE `username`=? AND `password`=?";
	
	User user = new User();
	
//adduser method is started 
	@Override
	public void addUser(User user) {
		try {
			
			Connection con=DBconnection.getConnection();
			
			PreparedStatement pstmt = con.prepareStatement(Insert);

			pstmt.setString(1,user.getName());
			pstmt.setString(2,user.getUsername());
			pstmt.setString(3,user.getPassword());
			pstmt.setString(4,user.getEmail());
			pstmt.setString(5,user.getPhoneNumber());
			pstmt.setString(6,user.getAddress());
			pstmt.setString(7,user.getRole());
			pstmt.setTimestamp(8, new Timestamp(System.currentTimeMillis()));
			pstmt.setTimestamp(9, new Timestamp(System.currentTimeMillis()));
			
			int res=pstmt.executeUpdate();
			System.out.println(res);

		}
		catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	//Updateuser method is started 
	@Override
	public void updateUser(User user) {
		Connection con =DBconnection.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(update);
			pstmt.setString(1,user.getName());
			pstmt.setString(2, user.getUsername());
			pstmt.setString(3,user.getPassword());
			pstmt.setString(4,user.getEmail());
			pstmt.setString(5,user.getPhoneNumber());
			pstmt.setString(6,user.getAddress());
			pstmt.setString(7,user.getRole());
			pstmt.setInt(8,user.getId());
			int res=pstmt.executeUpdate();
			System.out.println(res);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}	
	}

	@Override
	public void  deleteUser(int id) {
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
	public User getUser(int id) {
		Connection con = DBconnection.getConnection();
		User user=new User();
		try {
			PreparedStatement pstmt = con.prepareStatement(GET_USER);
			pstmt.setInt(1, id);
			ResultSet res = pstmt.executeQuery();
			while(res.next()) {
				int uid=res.getInt(1);
				String name=res.getString(2);
				String username=res.getString(3);
				String password=res.getString(4);
				String email=res.getString(5);
				String phone=res.getString(6);
				String address=res.getString(7);
				String role=res.getString(8);
				Timestamp createdDate=res.getTimestamp(9);
				Timestamp lastLoginDate=res.getTimestamp(10);
				user= new User(uid, name, username, password, email, phone, address, role, createdDate, lastLoginDate);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		Connection con =DBconnection.getConnection();
		List<User> list= new ArrayList<User>();
		User  user;
		try {
			PreparedStatement pstmt=con.prepareStatement(getAll);
			ResultSet res =pstmt.executeQuery();
			
			while(res.next())  {
				int uid=res.getInt(1);
				String name=res.getString(2);
				String username=res.getString(3);
				String password=res.getString(4);
				String email=res.getString(5);
				String phone=res.getString(6);
				String address=res.getString(7);
				String role=res.getString(8);
				Timestamp createdDate=res.getTimestamp(9);
				Timestamp lastLoginDate=res.getTimestamp(10);
				user= new User(uid, name, username, password, email, phone, address, role, createdDate, lastLoginDate);
				
				

				list.add(user);
			}

		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	return list;
	}

	@Override
	public User checkLogin(String username, String password) {
		
		 user = null;
		
		Connection con = DBconnection.getConnection();
		
		try {
			PreparedStatement pstmt = con.prepareStatement(CHECK_LOGIN);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			ResultSet res = pstmt.executeQuery();
			
			if(res.next()) {
				user= new User();
				user.setId(res.getInt(1));
				user.setName(res.getString(2));
				user.setUsername(res.getString(3));
				user.setPassword(res.getString(4));
				user.setEmail(res.getString(5));
				user.setPhoneNumber(res.getString(6));
				user.setAddress(res.getString(7));
				user.setRole(res.getString(8));
				user.setCreatedDate(res.getTimestamp(9));
				user.setLastLoginDate(res.getTimestamp(10));
			}

			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return user;
		
	}

	
}
