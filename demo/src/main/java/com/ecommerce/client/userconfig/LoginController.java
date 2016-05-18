package com.ecommerce.client.userconfig;

import com.ecommerce.framework.userconfig.ILoginService;

/**
 * Created by Chandra Prakash Panday on 5/18/2016.
 */
public class LoginController implements ILoginController {
    private ILoginService loginService;

    public LoginController(ILoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public void login(User user) throws Exception {
        loginService.loginUser(user);
    }
}
