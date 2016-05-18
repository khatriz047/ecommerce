package com.ecommerce.framework.cart;

import com.ecommerce.framework.product.Product;

import java.util.Stack;

/**
 * Created by Sandip on 5/17/16.
 *
 * invoker class
 */
public class ShoppingCartOperator {
    Stack<ICommand> commadStack = new Stack<ICommand>();
    ICommand command;

      public ShoppingCartOperator(ICommand command){
           this.command = command;
      }

    public void addToCart(){
         if (command.execute()==true) {
             commadStack.add(command);
             System.out.println("Successfully Added to the Cart");
         }
    }
    public void removeFromCart(AddToCart commad,Product product){
         if (commad.undo()== true){
             commadStack.add(commad);
             System.out.println("Successfully Removed from the cart");
         }
    }

}
