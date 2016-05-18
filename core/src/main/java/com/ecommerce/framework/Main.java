package com.ecommerce.framework;

import com.ecommerce.framework.cart.*;
import com.ecommerce.framework.domain.Book;
import com.ecommerce.framework.domain.Dvd;

/**
 * Created by Sandip on 5/17/16.
 */
public class Main  {

    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();
        IProduct product = new Book(1,25.0);
        IProduct product2 = new Dvd(2,26.0);
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
