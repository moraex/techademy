package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
	
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException
	{
		
		if (userCarts.get(userId) == null) {
			Cart newCart = new Cart();
			newCart.setMenuItemList(new ArrayList<MenuItem>());
			this.userCarts.put(userId, newCart);
		}
		
		Cart cart = userCarts.get(userId);
		
		
		List<MenuItem> list = cart.getMenuItemList();
		
		double total = 0;
		
		for (MenuItem item: list) {
			total += item.getPrice();
		}
		cart.setTotal(total);
		this.userCarts.replace(userId, cart);
		
		return list;
	}
	
	public Cart getCart(long userId) {
		return userCarts.get(userId);
	}
	
	public void removeCartItem(long userId, long menuItemId) {
		List<MenuItem> list = userCarts.get(userId).getMenuItemList();
		for (MenuItem item: list) {
			if(item.getId() == menuItemId) {
				this.userCarts.get(userId).removeItem(list.indexOf(item));
				break;
			}
		}
		
	}
}
