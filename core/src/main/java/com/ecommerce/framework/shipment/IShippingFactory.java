package com.ecommerce.framework.shipment;

/**
 * Created by Admin on 5/18/2016.
 */
public interface IShippingFactory {
        public IShipOrder getShippingAddress(String shippingType);
}
