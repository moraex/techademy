package dao;

import java.sql.SQLException;

public class CartDaoSqlImplTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            ConnectionHandler.migrateDB();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println(e);
            return;
        }
		
        testAddCartItem();
        testRemoveCartItem();
        
        try {
            ConnectionHandler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
	}
	
	public static void testAddCartItem() {
		CartDao cartDao = new CartDaoSqlImpl();
        cartDao.addCartItem(1, 1);
        try {
			System.out.println(cartDao.getAllCartItems(1));
		} catch (CartEmptyException e) {
			e.printStackTrace();
            System.out.println("Empty Cart");
		}
	}
	
	public static void testGetAllCartItem() {
		CartDao cartDao = new CartDaoSqlImpl();
        try {
			System.out.println(cartDao.getAllCartItems(1));
		} catch (CartEmptyException e) {
			e.printStackTrace();
            System.out.println("Empty Cart");
		}
	}
	
	public static void testRemoveCartItem() {
		CartDao cartDao = new CartDaoSqlImpl();
        cartDao.removeCartItem(1, 1);
        try {
			System.out.println(cartDao.getAllCartItems(1));
		} catch (CartEmptyException e) {
			e.printStackTrace();
            System.out.println("Empty Cart");
		}
	}

}
