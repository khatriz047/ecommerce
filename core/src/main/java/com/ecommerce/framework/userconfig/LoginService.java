package com.ecommerce.framework.userconfig;

import com.ecommerce.framework.exception.AuthorizationException;
import com.ecommerce.framework.exception.UserNotFoundException;
import com.ecommerce.framework.repository.IRepository;

/**
 * Created by Chandra Prakash Panday on 5/18/2016.
 */
public class LoginService implements ILoginService {
    private IRepository repository;

    public LoginService(IRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean loginUser(IUser user) throws Exception {
        IUser usr = repository.getUserFromUserName(user.getUsername());
        if(usr == null){
            throw new UserNotFoundException("User doesn't exist");
        }else{
            if(usr.getPassword().equals(user.getPassword())){
                return true;
            }else{
                throw new AuthorizationException("Invalid username and password");
            }
        }
    }
}
