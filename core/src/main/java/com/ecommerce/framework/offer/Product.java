package com.ecommerce.framework.offer;
/*
  @author Anup Khatri
 */

import com.ecommerce.framework.product.CatalogComponent;
import com.ecommerce.framework.userconfig.IUser;

import java.util.ArrayList;
import java.util.List;

public class Product implements SendOffer {
	private ArrayList<IUser> users = new ArrayList<IUser>();
	private List<CatalogComponent> products;
	//private String productType;
	String availability;

	public Product(List<CatalogComponent> products, String availability) {
		super();
		this.products=products;
		this.availability = availability;
	}



	public ArrayList<IUser> getUsers() {
		return users;
	}

	public void setUsers(ArrayList<IUser> users) {
		this.users = users;
	}

	public List<CatalogComponent> getProducts() {
		return products;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
		notifyCustomers();
	}

	
	public void registerCustomer(IUser observer) {
		users.add(observer);
	}

	public void removeCustomer(IUser observer) {
		users.remove(observer);
	}

	@Override
	public void notifyCustomers() {
		// TODO Auto-generated method stub
		System.out.println("Notifying to all the subscribers when product became available");
		for (IUser user : users) {
			user.update(this.availability);
		}
		
	}
}
