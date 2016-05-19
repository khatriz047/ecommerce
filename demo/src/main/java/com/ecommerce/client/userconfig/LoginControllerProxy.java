package com.ecommerce.client.userconfig;

import com.ecommerce.framework.userconfig.IUser;

/**
 * Created by Chandra Prakash Panday on 5/18/2016.
 */
public class LoginControllerProxy implements ILoginController {
    private LoginController loginController;


    @Override
    public boolean login(IUser user) throws Exception {
        return false;
    }
}
