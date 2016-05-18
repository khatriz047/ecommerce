package com.ecommerce.framework.shipment;

/**
 * Created by Admin on 5/18/2016.
 */
public class ShippingFactory implements IShippingFactory {
    @Override
    public IShipOrder getShippingAddress(String shippingType) {
        if(shippingType.equalsIgnoreCase("fedex")){
            return new Fedex();
        }else{
            return new UPS();
        }
    }
}
