package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import model.MenuItem;

public class MenuItemDaoSqlImpl implements MenuItemDao {
	private Statement stmt;
	private Connection connection;
	private PreparedStatement prepStmt;
	private ResultSet rs;
	
	public MenuItemDaoSqlImpl() {
		
	}
	
	public void addMenuItem(MenuItem menuItem) {
        String sqlStatement = "INSERT INTO MenuItems(id, name, price, active, dateOfLaunch, category, freeDelivery) " + 
                                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection con = null;
        PreparedStatement pstm = null;
        System.out.println("vuco vuco");
        try {
            con = ConnectionHandler.getConnection();
            pstm = con.prepareStatement(sqlStatement);
            pstm.setLong(1, menuItem.getId());
            pstm.setString(2, menuItem.getName());
            pstm.setFloat(3, menuItem.getPrice());
            pstm.setBoolean(4, menuItem.isActive());
            pstm.setDate(5, new Date(menuItem.getDateOfLaunch().getTime()));
            pstm.setString(6, menuItem.getCategory());
            pstm.setBoolean(7, menuItem.isFreeDelivery());
            pstm.execute();
            pstm.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		// TODO Auto-generated method stub
		String sqlStatement = "SELECT * FROM MenuItems";
        List<MenuItem> menuItemList = null;
        try {
            ResultSet result = ConnectionHandler.executeQueryStatement(sqlStatement);
            menuItemList = this.populateListWithResult(result);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCostumer() {
		// TODO Auto-generated method stub
		String sqlStatement = "SELECT * FROM MenuItems WHERE active=true AND dateOfLaunch <= CURDATE()";
        List<MenuItem> menuItemList = null;
        try {
            ResultSet result = ConnectionHandler.executeQueryStatement(sqlStatement);
            menuItemList = this.populateListWithResult(result);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return menuItemList;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		String sqlStatement = "UPDATE MenuItems SET name=?, price=?, active=?, dateOfLaunch=?, category=?, freeDelivery=? " + 
                "WHERE id=?";
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = ConnectionHandler.getConnection();
			pstm = con.prepareStatement(sqlStatement);
			pstm.setString(1, menuItem.getName());
			pstm.setFloat(2, menuItem.getPrice());
			pstm.setBoolean(3, menuItem.isActive());
			pstm.setDate(4, new Date(menuItem.getDateOfLaunch().getTime()));
			pstm.setString(5, menuItem.getCategory());
			pstm.setBoolean(6, menuItem.isFreeDelivery());
			pstm.setLong(7, menuItem.getId());
			pstm.execute();
			pstm.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		// TODO Auto-generated method stub
		String sqlStatement = "SELECT * FROM MenuItems WHERE id=" + menuItemId;
        List<MenuItem> menuItemList = null;
        try {
            ResultSet result = ConnectionHandler.executeQueryStatement(sqlStatement);
            menuItemList = this.populateListWithResult(result);
            if (!menuItemList.isEmpty()) return menuItemList.get(0);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return null;
	}
	
	private List<MenuItem> populateListWithResult(ResultSet result) {
        List<MenuItem> menuItemList = new ArrayList<MenuItem>();
        MenuItem menuItem = null;
        try {
            while(result.next()) {
            	String insert = result.getInt(1) + "," +
            			result.getString(2) + "," +
            			result.getFloat(3) + "," +
            			result.getBoolean(4) + "," +
            			result.getDate(5) + "," +
            			result.getString(6) + "," +
            			result.getBoolean(7);
                menuItemList.add(new MenuItem(insert));
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
            System.out.println(e);
        }
        return menuItemList;
    }

	@Override
	public void deleteItem(long itemId) {
		// TODO Auto-generated method stub
		
	}

}
