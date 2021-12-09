package dao;

import java.util.HashMap;
import model.Cart;

public class CartDaoCollectionImpl implements CartDao {
	private HashMap<Long, Cart> userCarts;
	
	public CartDaoCollectionImpl() {}
	
	public void addCartItem(long id, long menuItemId) {}
}
