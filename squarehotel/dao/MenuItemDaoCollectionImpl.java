package dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

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
			menuItemList.add(new MenuItem("001,Sandwich,3.00,true,06/12/2021,Main Course,true"));
			menuItemList.add(new MenuItem("002,Burger,5.00,true,06/12/2021,Main Course,true"));
			menuItemList.add(new MenuItem("003,Orange Juice,2.50,true,01/12/2021,Drinks,false"));
			menuItemList.add(new MenuItem("004,Apple Pie,12.00,true,01/11/2021,Eats,false"));
			menuItemList.add(new MenuItem("005,X-cake,13.00,true,22/10/2021,Dessert,true"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void addMenuItem(MenuItem menuItem) {
		menuItemList.add(menuItem);
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
			if(
					item.isActive() && (
					item.getDateOfLaunch().before(new java.util.Date())
					|| item.getDateOfLaunch().equals(new java.util.Date())
					)
			)
			{
				local.add(item);
			}
		}
		
		return local;
	}

	@Override
	public void modifyMenuItem(MenuItem menuitem) {
		// TODO Auto-generated method stub
		for(MenuItem item: menuItemList)
		{
			if(menuitem.getId() == item.getId())
			{
				menuItemList.set(menuItemList.indexOf(item), menuitem);
				break;
			}
		}
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		// TODO Auto-generated method stub
		for(MenuItem item: menuItemList)
		{
			if(menuItemId == item.getId())
				return item;
		}
		return null;
	}

	@Override
	public void deleteItem(long itemId) {
		// TODO Auto-generated method stub
		for(MenuItem item: menuItemList)
		{
			if(itemId == item.getId())
			{
				this.menuItemList.remove(menuItemList.indexOf(item));
				break;
			}
		}
		
	}

}
