package dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import model.MenuItem;
import util.DateUtil;

public class MenuItemDaoSqlImplTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//try {
            // ConnectionHandler.migrateDB();
        //} catch (ClassNotFoundException | SQLException e) {
        //    e.printStackTrace();
        //    System.out.println(e);
        //    return;
        //}
        //testGetMenuAddItem();
        testGetMenuItemListAdmin();
        testGetMenuItemListCustomer();
        testModifyMenuItem();
        try {
            ConnectionHandler.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
	}
	
	
	public static void testGetMenuAddItem() {
        MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
        
        try {
			menuItemDao.addMenuItem(new MenuItem("108,Burger,5.00,true,06/12/2021,Main Course,true"));
			menuItemDao.addMenuItem(new MenuItem("1,Burger,5.00,true,06/12/2021,Main Course,true"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        MenuItemDaoSqlImplTest.testGetMenuItem(1);
        MenuItemDaoSqlImplTest.testGetMenuItem(108);
        
    }

    public static void testGetMenuItemListAdmin() {
        MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
        List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();
        for (MenuItem item: menuItemList) {
            System.out.println(item);
        }
    }

    public static void testGetMenuItemListCustomer() {
        MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
        List<MenuItem> menuItemList = menuItemDao.getMenuItemListCostumer();
        for (MenuItem item: menuItemList) {
            System.out.println(item);
        }
    }

    public static void testModifyMenuItem() {
        MenuItem menuItem = null;
		try {
			menuItem = new MenuItem("1,Burger,7.00,true,06/12/2021,Main Course,true");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
        menuItemDao.modifyMenuItem(menuItem);
        System.out.println(menuItemDao.getMenuItem(1));
    }

    public static void testGetMenuItem(long id) {
        MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
        System.out.println(menuItemDao.getMenuItem(id));
    }

}
