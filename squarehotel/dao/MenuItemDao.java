package dao;

import java.util.List;
import model.MenuItem;

/**
 * 
 * @author luanvind
 * 
 * dentro das interfaces existem somente assinaturas
 *
 */

public interface MenuItemDao {
	public List<MenuItem> getMenuItemListAdmin();
	public List<MenuItem> getMenuItemListCostumer();
	public void modifyMenuItem(MenuItem menuitem);
	public MenuItem getMenuItem(long menuItemId);
	public void addMenuItem(MenuItem menuItem);
	public void deleteItem(long itemId);
}
