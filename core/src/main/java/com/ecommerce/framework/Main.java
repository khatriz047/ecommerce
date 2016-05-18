package com.ecommerce.framework;

import com.ecommerce.framework.cart.*;
import com.ecommerce.framework.product.Product;

/**
 * Created by Sandip on 5/17/16.
 */
public class Main  {

    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product product = new Product("1",  "book",  10,  5,  true);
        Product product2 = new Product("3",  "shoe",  20,  5,  true);

        ICommand command = new AddToCart(shoppingCart,product);
        ICommand anotherCommand = new AddToCart(shoppingCart,product2);
        ShoppingCartOperator operator = new ShoppingCartOperator(command);
        operator.addToCart();
        ShoppingCartOperator anotherOperator = new ShoppingCartOperator(anotherCommand);
        anotherOperator.addToCart();
        anotherOperator.addToCart();
        shoppingCart.calculateTotal();
    }
}
