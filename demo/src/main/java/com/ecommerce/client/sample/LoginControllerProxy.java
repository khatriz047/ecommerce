package com.ecommerce.client.sample;

import com.ecommerce.framework.repository.IRepository;
import com.ecommerce.framework.repository.Repository;
import com.ecommerce.framework.userconfig.ILoginService;
import com.ecommerce.framework.userconfig.IUser;

/**
 * Created by Chandra Prakash Panday on 5/18/2016.
 */
public class LoginControllerProxy implements ILoginController {
    private LoginController loginController;
    private IRepository repository;


    public LoginControllerProxy(ILoginService loginService) {
        loginController = new LoginController(loginService);
        repository = Repository.getInstance();
    }

    @Override
    public boolean login(IUser user) {
        boolean isLoggedIn = loginController.login(user);
        if (isLoggedIn) {
            sendToLandingPage(user);
        }
        return isLoggedIn;
    }

    private void sendToLandingPage(IUser user) {
        User loadedUser = (User) repository.getUserFromUserName(user.getUsername());
        if (loadedUser.getRoleType().equals(RoleType.CUSTOMER)) {
            CustomerSection customerSection = new CustomerSection(repository);
            customerSection.proceedForClientOperation(loadedUser);
        } else {
            AdminSection adminSection = new AdminSection(repository);
            adminSection.proceedForAdminOperation(loadedUser);
        }
    }
}
