package com.ecommerce.framework.cart;

import com.ecommerce.framework.product.Product;
import com.ecommerce.framework.userconfig.IUser;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sandip on 5/17/16.
 */
public class ShoppingCart extends AShoppingCart implements IShoppingCart {


    private int noOfItems;
    private IUser user;

    public ShoppingCart(IUser user) {
        this.user = user;
        cart = new ArrayList<ShoppingCartItem>();
        noOfItems = 0;
    }

    @Override
    public void removeItem(Product product) {
        for (ShoppingCartItem cartItem : cart) {
            if (cartItem.hasProduct(product)) {
                cart.remove(cartItem);
                break;
            }
        }
    }

    @Override
    public void addItem(Product product) {
        boolean isNewItem = true;
        for (ShoppingCartItem cartItem : cart) {
            if (cartItem.hasProduct(product)) {
                cartItem.increaseQuantity();
                isNewItem = false;
                break;
            }
        }
        if (isNewItem) {
            ShoppingCartItem item = new ShoppingCartItem(product);
            cart.add(item);
        }
    }
    public int getNoOfItems(){
        noOfItems=0;
        for (ShoppingCartItem cartItem : cart) {
            noOfItems+= cartItem.getQuantity();
        }
        return noOfItems;
    }

    @Override
    public List<ShoppingCartItem> getItems() {
        return  this.cart;
    }

    @Override
    public double calculateTotal() {
        double total=0.0;
        for (ShoppingCartItem shoppingCartItem : cart) {
          int quantity = shoppingCartItem.getQuantity();
          total += quantity *shoppingCartItem.getProduct().getPrice();
        }

        return total;
    }

    public Order createOrder(){
        double total=0.0;
        List<Product> productList = new ArrayList<Product>();
        for (ShoppingCartItem shoppingCartItem : cart) {
            int quantity = shoppingCartItem.getQuantity();
            Product product = shoppingCartItem.getProduct();
            product.setQuantity(quantity);
            productList.add(product);
            total += quantity *shoppingCartItem.getProduct().getPrice();
        }
     return  new Order(user,total,productList);
    }

    @Override
    public void clear() {
        cart.clear();
        noOfItems = 0;
    }


}
