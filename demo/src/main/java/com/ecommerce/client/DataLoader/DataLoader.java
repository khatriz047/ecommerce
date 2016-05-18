package com.ecommerce.client.DataLoader;

import com.ecommerce.framework.repository.IRepository;

/**
 * Created by Admin on 5/18/2016.
 */
public class DataLoader {
    IRepository repository;

    public DataLoader(IRepository repository) {
        this.repository = repository;
    }

    public void saveDefaultUsers(){

    }
}
