package com.ecommerce.client.sample;

import com.ecommerce.framework.exception.AuthorizationException;
import com.ecommerce.framework.exception.UserNotFoundException;
import com.ecommerce.framework.userconfig.ILoginService;
import com.ecommerce.framework.userconfig.IUser;

/**
 * Created by Chandra Prakash Panday on 5/18/2016.
 */
public class LoginController implements ILoginController {
    private ILoginService loginService;

    public LoginController(ILoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public boolean login(IUser user) {
        try {
            loginService.loginUser(user);
            return true;
        } catch (UserNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (AuthorizationException ex) {
            System.err.println(ex.getMessage());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }
}
