package dao;

import java.util.ArrayList;
import java.util.HashMap;
import model.Cart;
import model.MenuItem;

public class CartDaoCollectionImpl implements CartDao {
	private HashMap<Long, Cart> userCarts;
	
	public CartDaoCollectionImpl() {
		if (userCarts == null)
		{
			userCarts = new HashMap<Long, Cart>();
		}
	}
	
	public void addCartItem(long userId, long menuItemId) {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem item = null;
		
		item = menuItemDao.getMenuItem(menuItemId);
		
		if (userCarts.containsKey(userId))
		{
			this.userCarts.get(userId).addItem(item);
		}
		else
		{
			Cart newCart = new Cart();
			newCart.setMenuItemList(new ArrayList<MenuItem>());
			newCart.addItem(item);
			this.userCarts.put(userId, newCart);
		}
	}
}
