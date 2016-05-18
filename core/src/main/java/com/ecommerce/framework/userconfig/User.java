package com.ecommerce.framework.userconfig;

import com.ecommerce.framework.userconfig.IUser;

public class User extends IUser {

	String username;



	String password;
	String name;
	String emailAddress;
	IAddress billingAddress;
	IAddress shippingAddress;

	public User(String username, String password, String name, String emailAddress, IAddress billingAddress, IAddress shippingAddress) {
		super(username,password,name,emailAddress,billingAddress,shippingAddress);

	}

	@Override
	public String getName() {
		return name;
	}
	@Override
	public String getUsername() {
		return username;
	}



	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getEmailAddress() {
		return emailAddress;
	}

	@Override
	public IAddress getBillingAddress() {
		return billingAddress;
	}

	@Override
	public IAddress getShippingAddress() {
		return shippingAddress;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public void setBillingAddress(IAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	@Override
	public void setShippingAddress(IAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public void update(String availabiliy) {
		System.out.println("This will update all the users");
	}
}
