package dao;

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
		System.out.println("testGetMenuItemListAdmin\n");
		// iterate through menuItemList and display all att for each menu item
		for (MenuItem item: menuItemDao.getMenuItemListAdmin())
		{
			System.out.println(item.toString());
		}
	}
	
	public static void testGetMenuItemListCustomer() {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		System.out.println("testGetMenuItemListCustomer\n");
		for (MenuItem item: menuItemDao.getMenuItemListCostumer())
		{
			System.out.println(item.toString());
		}
	}
	
	public static void testModifyMenuItem() {
		
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

}
