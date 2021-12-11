package model;

import java.util.List;

public class Cart {
	private List<MenuItem> menuItemList;
	private double total;
	
	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}
	
	public void setMenuItemList(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}
	
	public double getTotal() {
		return total;
	}
	
	public void setTotal(double total) {
		this.total = total;
	}
	
	// this method did not exist, but I created to make the insertion easier
	public void addItem(MenuItem item) {
		this.menuItemList.add(item);
	}
	
	public void removeItem(int itemIndex) {
		this.menuItemList.remove(itemIndex);
	}
}
