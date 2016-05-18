package com.ecommerce.framework.payment;

import com.ecommerce.framework.cart.ShoppingCart;

/**
 * Created by Admin on 5/18/2016.
 */
public class PaymentContext {
    private PaymentMethod paymentMethod;

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    /* For changing runtime strategy for payment */
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void makePayment(double payableAmount) {
        paymentMethod.pay(payableAmount);
    }
}
