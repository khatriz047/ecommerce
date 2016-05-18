package com.ecommerce.framework.domain;

import com.ecommerce.framework.calculator.IVisitor;
import com.ecommerce.framework.cart.IProduct;
import com.ecommerce.framework.cart.IShoppingCartItem;


/**
 * Created by Sandip on 5/17/16.
 */
public class Dvd extends IProduct  implements IShoppingCartItem {

    public Dvd(int id,double price){
        super(id,price);
    }
    @Override
    public double accept(IVisitor visitor) {

        return  visitor.visit(this);
    }
}
