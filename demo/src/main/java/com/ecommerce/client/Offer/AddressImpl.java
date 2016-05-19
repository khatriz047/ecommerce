package com.ecommerce.client.offer;

import com.ecommerce.framework.userconfig.IAddress;

/**
 * Created by anup on 5/18/2016.
 */
public class AddressImpl extends IAddress {
    public AddressImpl(String street, String city, String state, String zip) {
        super(street, city, state, zip);
    }
}
