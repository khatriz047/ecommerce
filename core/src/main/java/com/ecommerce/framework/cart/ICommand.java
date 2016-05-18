package com.ecommerce.framework.cart;

/**
 * Created by Sandip on 5/17/16.
 */
public interface ICommand {

    boolean execute();
    boolean undo();

}
