package com.ecommerce.framework.calculator;

import com.ecommerce.framework.domain.Book;
import com.ecommerce.framework.domain.Dvd;

/**
 * Created by Sandip on 5/17/16.
 */
public class OrderPriceVisitor implements IVisitor {

    @Override
    public double visit(Book book) {
        double cost=0;
        //apply 5$ discount if book price is greater than 50
        if(book.getPrice() > 50){
            cost = book.getPrice()-5;
        }else cost = book.getPrice();
        System.out.println("Book:" + " cost ="+cost);
        return cost;
    }

    @Override
    public double visit(Dvd dvd) {
        double cost=0;
        //apply 5$ discount if book price is greater than 50
        if(dvd.getPrice() > 50){
            cost = dvd.getPrice()-5;
        }else cost = dvd.getPrice();
        System.out.println("DVD:" + " cost ="+cost);
        return cost;
    }
}
