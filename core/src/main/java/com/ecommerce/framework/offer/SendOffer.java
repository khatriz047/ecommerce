package com.ecommerce.framework.offer;

/*
@Author Anup Khatri
 */

import com.ecommerce.framework.userconfig.IUser;

/*Subject Interface*/
public interface SendOffer {
	public String getOffererName();
	public void setOffererName(String name);

	public void registerCustomer(IUser customer);

	public void removeCustomer(IUser customer);

	public void notifyCustomers(String name);
}
