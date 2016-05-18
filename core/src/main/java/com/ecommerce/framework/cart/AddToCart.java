package com.ecommerce.framework.cart;

import com.ecommerce.framework.product.Product;

/**
 * Created by Sandip on 5/17/16.
 */
public class AddToCart implements ICommand {

     private IShoppingCart shoppingCart;
     private Product product;

    public AddToCart(IShoppingCart shoppingCart, Product product){
        this.shoppingCart = shoppingCart;
        this.product = product;
    }

    @Override
    public boolean execute() {
        boolean status= true;
        try {
            shoppingCart.addItem(product);
        }catch (Exception exception){
            status =false;
        }
        return status;
    }

    @Override
    public boolean undo() {
        boolean status= true;
        try {
            shoppingCart.removeItem(product);
        }catch (Exception exception){
            status =false;
        }
        return status;
    }
}
