package dao;

import model.MenuItem;

public class CartDaoCollectionImplTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testAddCartItem();
		//testGetAllCartItems();
		testRemoveCartItem();
	}
	
	public static void testAddCartItem() {
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.addCartItem(1, 001);
		System.out.println("\ntestAddCartItem");
		try {
			for (MenuItem item: cartDao.getAllCartItems(1)) {
				System.out.println(item.toString());
			}
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void testGetAllCartItems() {
		CartDao cartDao = new CartDaoCollectionImpl();
		System.out.println("\ntestGetAllCartItems");
		try {
			for (MenuItem item: cartDao.getAllCartItems(1)) {
				System.out.println(item.toString());
			}
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void testRemoveCartItem() {
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.addCartItem(1, 001);
		
		cartDao.removeCartItem(1, 001);
		try {
			for (MenuItem item: cartDao.getAllCartItems(1)) {
				System.out.println(item.toString());
			}
		} catch (CartEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
