package com.ecommerce.client.userconfig;

import com.ecommerce.framework.userconfig.IUser;

/**
 * Created by Admin on 5/18/2016.
 */
public interface ILoginController {
    public boolean login(IUser user) throws Exception;
}
