package com.ecommerce.framework.domain;

import com.ecommerce.framework.calculator.IVisitor;
import com.ecommerce.framework.cart.IProduct;

/**
 * Created by Sandip on 5/17/16.
 */
public class Book extends IProduct {


     public  Book(int id, double price){
         super(id, price);
     }

    @Override
    public double accept(IVisitor visitor) {
        return visitor.visit(this);
    }
}
