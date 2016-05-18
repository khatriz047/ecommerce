package com.ecommerce.framework.offer;

/*
@Author Anup Khatri
 */

import com.ecommerce.framework.userconfig.IUser;

public interface SendOffer {
	public void registerCustomer(IUser customer);

	public void removeCustomer(IUser customer);

	public void notifyCustomers();
}
