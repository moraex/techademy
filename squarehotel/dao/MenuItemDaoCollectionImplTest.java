package dao;

import java.util.List;
import model.MenuItem;

public class MenuItemDaoCollectionImplTest implements MenuItemDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testGetMenuItemListAdmin();
	}
	
	public static void testGetMenuItemListAdmin() {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		
		// iterate through menuItemList and display all att for each menu item
		for (MenuItem item: menuItemDao.getMenuItemListAdmin())
		{
			System.out.println(item.toString());
		}
	}
	
	public static void testGetMenuItemListCustomer() {}

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
