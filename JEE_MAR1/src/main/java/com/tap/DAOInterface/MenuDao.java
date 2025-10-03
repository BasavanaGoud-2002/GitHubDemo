package com.tap.DAOInterface;

import java.util.List;

import com.tap.models.PojoClass.Menu;
import com.tap.models.PojoClass.Restaurant;


public interface MenuDao {
	
	void addMenu(Menu menu);
	
	void updateMenu(Menu menu);
	
	void deleteMenu(int id);
	
	Menu getMenu(int id);
	
	List<Menu> getAllMenu();
	

	
}
