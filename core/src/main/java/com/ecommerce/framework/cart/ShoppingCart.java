package com.ecommerce.framework.cart;

import com.ecommerce.framework.calculator.OrderPriceVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sandip on 5/17/16.
 */
public class ShoppingCart extends AShoppingCart implements IShoppingCart {


    private int noOfItems;

    public ShoppingCart() {
        cart = new ArrayList<>();
        noOfItems = 0;
    }

    @Override
    public void removeItem(IProduct product) {
        for (ShoppingCartItem cartItem : cart) {
            if (cartItem.hasProduct(product)) {
                cart.remove(cartItem);
                break;
            }
        }
    }

    @Override
    public void addItem(IProduct product) {
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
        OrderPriceVisitor priceVisitor = new OrderPriceVisitor();
        double total=0.0;
        for (ShoppingCartItem shoppingCartItem : cart) {
          System.out.println("item");
          int quantity = shoppingCartItem.getQuantity();
            System.out.println("quantity = " + quantity);
          total += quantity *shoppingCartItem.getProduct().accept(priceVisitor);
        }
        System.out.println("total = " + total);
        return total;
    }

    @Override
    public void clear() {
        cart.clear();
        noOfItems = 0;
    }
}
