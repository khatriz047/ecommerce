package com.ecommerce.framework.payment;

/**
 * Created by Admin on 5/18/2016.
 */
public interface IPaymentMethodFactory {
    public PaymentMethod getPaymentMethod(String paymentType);
}
