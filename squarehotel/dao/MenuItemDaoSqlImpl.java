package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.MenuItem;

public class MenuItemDaoSqlImpl implements MenuItemDao {
	private Statement stmt;
	private Connection connection;
	private PreparedStatement prepStmt;
	private ResultSet rs;
	
	public MenuItemDaoSqlImpl() {
		
	}
	
	public void connectDataBase() {
		String dbUrl = "";
		String user = "";
		String password = "admin";
		
		try {
			Class.forName("");
			connection = DriverManager.getConnection(dbUrl, user, password);
			this.stmt = connection.createStatement();
			
		} catch (SQLException | ClassNotFoundException e) {
			
		}
	}
	
	public void closeConnectionDataBase() {
		try {
			stmt.close();
			prepStmt.close();
			connection.close();
		} catch (SQLException e) {
			e.getMessage();
		}
	}

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
