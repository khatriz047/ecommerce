package com.ecommerce.client.sample;

import com.ecommerce.framework.userconfig.IAddress;

/**
 * Created by anup on 5/18/2016.
 */
public class Address extends IAddress {
    public Address(String street, String city, String state, String zip) {
        super(street, city, state, zip);
    }
}
