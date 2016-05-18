package com.ecommerce.client.userconfig;

import com.ecommerce.framework.userconfig.IAddress;
import com.ecommerce.framework.userconfig.IUser;

/**
 * Created by Admin on 5/17/2016.
 */
public class User extends IUser {
    private RoleType roleType;

    public User(String username, String password, String name, String emailAddress, IAddress billingAddress, IAddress shippingAddress, RoleType roleType) {
        super(username, password, name, emailAddress, billingAddress, shippingAddress);
        this.roleType = roleType;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public void update(String availability){

    }
}
