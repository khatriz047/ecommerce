package com.ecommerce.framework.payment;

import java.util.Date;

/*
 * created by Anup
 */

/* Concrete Strategy Class*/
public class MobilePayment implements PaymentMethod {
    private final String serviceProvider;
    private final String mobileNumber;
    private final Date expires;

    public String getServiceProvider() {
        return serviceProvider;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public Date getExpires() {
        return expires;
    }

    public MobilePayment(String serviceProvider, String mobileNumber,
                         Date expires) {
        super();
        this.serviceProvider = serviceProvider;
        this.mobileNumber = mobileNumber;
        this.expires = expires;
    }

    @Override
    public void pay(double amount) {
        System.out.println("This amount " + amount + " is paid from " + mobileNumber + " via mobile payment");
    }
}