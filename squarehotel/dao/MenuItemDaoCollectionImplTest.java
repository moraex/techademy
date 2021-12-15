package dao;

import java.text.ParseException;
import java.util.List;
import model.MenuItem;

public class MenuItemDaoCollectionImplTest implements MenuItemDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();
		
	}
	
	public static void testGetMenuItemListAdmin() {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		System.out.println("\ntestGetMenuItemListAdmin");
		// iterate through menuItemList and display all att for each menu item
		for (MenuItem item: menuItemDao.getMenuItemListAdmin())
		{
			System.out.println(item.toString());
		}
	}
	
	public static void testGetMenuItemListCustomer() {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		System.out.println("\ntestGetMenuItemListCustomer");
		for (MenuItem item: menuItemDao.getMenuItemListCostumer())
		{
			System.out.println(item.toString());
		}
	}
	
	public static void testModifyMenuItem() {
		MenuItem item = null;
		
		try {
			// updating itemId 108
			item = new MenuItem("108,Burger,7.00,true,09/12/2021,Main Course,true");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		
		// here item must be modified
		menuItemDao.modifyMenuItem(item);
		System.out.println("\ntestModifyMenuItem");
		System.out.println(menuItemDao.getMenuItem(108).toString());
	}
	
	@Override
	public void addMenuItem(MenuItem menuItem) {
		
	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MenuItem> getMenuItemListCostumer() {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public void deleteItem(long itemId) {
		// TODO Auto-generated method stub
		
	}

}
