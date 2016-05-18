package com.ecommerce.framework.payment;

/**
 * Created by Admin on 5/18/2016.
 */
public interface IPaymentMethod {
    public PaymentMethod getPaymentMethod(String paymentType);
}
