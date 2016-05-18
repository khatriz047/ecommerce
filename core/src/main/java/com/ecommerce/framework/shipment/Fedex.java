package com.ecommerce.framework.shipment;

import com.ecommerce.framework.cart.Order;

/**
 * Created by Admin on 5/18/2016.
 */
public class Fedex implements IShipOrder {
    @Override
    public void shipOrder(Order order) {
        System.out.println("************ ORDER DELIVERY THROUGH FEDEX ************");
        System.out.println(order.getUser().getShippingAddress());
    }
}
