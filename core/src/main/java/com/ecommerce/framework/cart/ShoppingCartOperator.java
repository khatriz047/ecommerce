package com.ecommerce.framework.cart;

import java.util.Stack;

/**
 * Created by Sandip on 5/17/16.
 *
 * invoker class
 */
public class ShoppingCartOperator {
    Stack<ICommad> commadStack = new Stack<ICommad>();
    ICommad command;

      public ShoppingCartOperator(ICommad command){
           this.command = command;
      }

    public void addTocart(){
       // command.setRequestParam(product);
         if (command.execute()==true) {
             commadStack.add(command);
             System.out.println("Successfully Added to the Cart");
         }
    }
    public void removeFromCart(AddToCart commad,IProduct product){
         if (commad.undo()== true){
             commadStack.add(commad);
             System.out.println("Successfully Removed from the cart");
         }
    }

}
