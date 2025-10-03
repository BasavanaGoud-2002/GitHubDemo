package com.tap.DAOInterface;

import java.util.List;

import com.tap.models.PojoClass.User;

public interface UsersDao {
	
	void addUser(User user);
	
	void updateUser(User user);
	
	void deleteUser(int id);
	
	User getUser(int id);
	
	List<User> getAllUsers();
	
	User checkLogin(String username,String password);
}
