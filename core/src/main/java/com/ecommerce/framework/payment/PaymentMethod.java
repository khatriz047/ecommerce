package com.ecommerce.framework.payment;

/**
 * created by Anup
 */

/*Strategy Interface*/
public interface PaymentMethod {
    public void pay(double amount);
}