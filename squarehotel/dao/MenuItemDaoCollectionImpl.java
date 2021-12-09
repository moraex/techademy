package dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import model.MenuItem;

public class MenuItemDaoCollectionImpl implements MenuItemDao {
	
	public List<MenuItem> menuItemList;
	
	public MenuItemDaoCollectionImpl() {
		if(menuItemList == null)
		{
			menuItemList = new ArrayList<MenuItem>();
		}
		// "id,name,price,active,dateOfLaunch,category,freeDelivery"
		
		try {
			menuItemList.add(new MenuItem("188,Sandwich,3.00,true,06/12/2021,Main Course,true"));
			menuItemList.add(new MenuItem("108,Burger,5.00,true,06/12/2021,Main Course,true"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		// TODO Auto-generated method stub
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCostumer() {
		// TODO Auto-generated method stub
		// this method returns the list of menu items that will be displayed
		// in the Menu Item listing
		List<MenuItem> local = new ArrayList<MenuItem>();
		
		for(MenuItem item: menuItemList)
		{
			
		}
		
		return local;
	}

	@Override
	public void modifyMenuItem(MenuItem menuitem) {
		// TODO Auto-generated method stub

	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		// TODO Auto-generated method stub
		return null;
	}

}
