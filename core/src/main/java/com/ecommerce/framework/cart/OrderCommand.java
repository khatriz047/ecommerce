package com.ecommerce.framework.cart;

/**
 * Created by Sandip on 5/17/16.
 */
public class OrderCommand implements ICommand {

    @Override
    public boolean execute() {
        return false;
    }

    @Override
    public boolean undo() {
        return false;
    }
}
