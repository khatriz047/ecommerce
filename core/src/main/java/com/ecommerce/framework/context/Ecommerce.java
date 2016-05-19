package com.ecommerce.framework.context;

import com.ecommerce.framework.logger.AbstractLogger;
import com.ecommerce.framework.logger.LoggerBuilder;
import com.ecommerce.framework.product.Product;
import com.ecommerce.framework.repository.IRepository;
import com.ecommerce.framework.repository.Repository;
import com.ecommerce.framework.userconfig.ILoginService;
import com.ecommerce.framework.userconfig.LoginService;

/**
 * Created by Admin on 5/18/2016.
 */
public abstract class Ecommerce {
    protected String name = "ECommerce APP";
    protected final String VERSION = "1.0";
    protected  static AbstractLogger logger =  LoggerBuilder.getLogger();
    protected IRepository repository;
    protected ILoginService loginService;
    protected Product product;

    public Ecommerce() {

        logger.logMessage(AbstractLogger.INFO, "ECommerce App: Started");
        this.repository = Repository.getInstance();
        loginService = new LoginService(repository);
        start();
    }


    protected abstract void start();


}
