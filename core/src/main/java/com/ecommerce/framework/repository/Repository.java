package com.ecommerce.framework.repository;

import com.ecommerce.framework.product.Product;
import com.ecommerce.framework.userconfig.IUser;
import com.ecommerce.framework.userconfig.User;
import com.ecommerce.framework.product.Product;

import java.util.*;

public class Repository implements
        IRepository {
    Map<String, IUser> users;
    Map<String, Product> products;

    //private User user;
    private static Repository INSTANCE;

    private Repository() {
        users = new Hashtable<>();
        products = new HashMap<>();
    }

    public static Repository getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Repository();
        }
        return INSTANCE;
    }

    public void saveUser(IUser user) throws Exception {
        if (users.containsKey(user.getUsername())) throw new Exception("User Already Exist");
        users.put(user.getUsername(), user);
    }

    public IUser getUserFromUserName(String username) {
        return users.get(username);
    }

    public List<IUser> getListOfUser() {
        List<IUser> list = new ArrayList<>();
        for (Map.Entry<String, IUser> user : users.entrySet()) {
            list.add(user.getValue());
        }
        return list;
    }

  public void saveProduct(Product product) throws Exception {
        if (products.containsKey(product.getProductId())) throw new Exception("illegal Argument");
        products.put(product.getProductId(), product);
    }

    public List<Product> getListOfProduct() {
        List<Product> list = new ArrayList<>();
        for (Map.Entry<String, Product> product : products.entrySet()) {
            list.add(product.getValue());
        }
        return list;
    }

    @Override
    public Product getProduct(String productId) {
        return products.get(productId);
    }


}
