package com.ecommerce.framework.cart;

import java.util.List;

/**
 * Created by Sandip on 5/17/16.
 */
public interface IShoppingCart {
    void removeItem(IProduct product);
    void addItem(IProduct product);
    List<ShoppingCartItem> getItems();
    double calculateTotal();
    void clear();
    int getNoOfItems();
}
