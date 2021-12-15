package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import util.DateUtil;

public class MenuItem {
	private long id;
	private String name;
	private float price;
	private boolean active;
	private Date dateOfLaunch;
	private String category;
	private boolean freeDelivery;
	
	public MenuItem() {}
	
	// constructor with option to set all instance variables
	public MenuItem(String arg0) throws ParseException {
		String[] inputs = arg0.split(",");
		// "id,name,price,active,dateOfLaunch,category,freeDelivery"
		
		setId(Long.parseLong(inputs[0]));
		setName(inputs[1]);
		setPrice(Float.parseFloat(inputs[2]));
		setActive(Boolean.parseBoolean(inputs[3]));
		setDateOfLaunch(DateUtil.convertToDate(inputs[4]));
		setCategory(inputs[5]);
		setFreeDelivery(Boolean.parseBoolean(inputs[6]));
	}
	
	private Object DateUtil() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return String.format("%s\t%s\t%s\t\t%s\t%s    %s\t%s", id, name, price, active, new SimpleDateFormat("dd/MM/yyyy").format(dateOfLaunch), category,freeDelivery ? "free":"not free");
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuItem other = (MenuItem) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getDateOfLaunch() {
		return dateOfLaunch;
	}

	public void setDateOfLaunch(Date dateOfLaunch) {
		this.dateOfLaunch = dateOfLaunch;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isFreeDelivery() {
		return freeDelivery;
	}

	public void setFreeDelivery(boolean freeDelivery) {
		this.freeDelivery = freeDelivery;
	}
	
	
}
