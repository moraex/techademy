package dao;

import java.util.List;

import model.Cart;
import model.MenuItem;

public interface CartDao {
	public void addCartItem(long userId, long menuItemId);
	public List<MenuItem> getAllCartItems(long userId) throws CartEmptyException;
	public void removeCartItem(long userId, long menuItemId);
	public Cart getCart(long userId);
}
