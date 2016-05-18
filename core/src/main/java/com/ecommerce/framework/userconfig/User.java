package com.ecommerce.framework.userconfig;

import com.ecommerce.framework.userconfig.IUser;

public class User extends IUser {
    public User(String username, String password, String name, String emailAddress, IAddress billingAddress, IAddress shippingAddress) {
        super(username, password, name, emailAddress, billingAddress, shippingAddress);
    }

    /*Concrete observer*/
    public void update(String message)
    {
        System.out.println("Message received by "+getName()+" " + message);
    }
}
